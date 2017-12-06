package com.ccrm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONArray;
import com.ccrm.dto.Pager;
import com.ccrm.entity.RegOrganinfo;
import com.ccrm.entity.SysDictionary;
import com.ccrm.entity.TirClass;
import com.ccrm.entity.UmgBranch;
import com.ccrm.entity.UmgOperator;
import com.ccrm.service.RegOrganinfoService;
import com.ccrm.service.SysDictionaryService;
import com.ccrm.service.TirClassService;
import com.ccrm.service.UmgBranchService;
import com.ccrm.util.excelExport.ExcelUtil;

@Controller
@RequestMapping("/tirClass/*")
public class TirClassController {
	private static final Logger log = LoggerFactory.getLogger(TirClassController.class);
	
	@Autowired
	TirClassService classService;
	@Autowired
	UmgBranchService umgBranchService;
	@Autowired
	SysDictionaryService dicService;
	@Autowired
	RegOrganinfoService organService;
	
	/**
	 * 跳转培训班页面
	 */
	@RequestMapping("tirClassList.html")
	public String regOrgList(TirClass tirClass, String orgid, HttpServletRequest req, HttpServletResponse res, ModelMap model,Pager page){
		
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		
		if(tirClass.getStatus() == null){
			tirClass.setStatus(-1l);
		}
		if(StringUtils.isNotBlank(orgid)) tirClass.setOrgid(Long.valueOf(orgid));
		Pager pager = classService.findPageList(tirClass, page.getPageNumber(), page.getPageSize());

		List<UmgBranch> branchList = umgBranchService.getBranchTree("1200",String.valueOf(user.getBranchid())); 
		String branchTree = umgBranchTree(branchList); 
		
		RegOrganinfo organInfo = new RegOrganinfo();
		organInfo.setStatus(-1);
		organInfo.setBranchid(user.getBranchid());
		List<RegOrganinfo> organList = organService.findList(organInfo);
		
		String idxids = "'62','63','65','66'";
		List<SysDictionary> dicList = dicService.getDicListByIdxids(idxids);
		
		model.put("branchTree",branchTree);
		model.put("dicList", dicList);
		model.put("pager", pager);
		model.put("organList", organList);
		
		return "class/classList";
	}
	
	/**
	 * 跳转新增页面
	 */
	@RequestMapping("edit.html")
	public String update(String id, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		log.info("跳转页面，参数 studentId ："+id);
		if(StringUtils.isNotBlank(id)){
			TirClass tirClass = classService.getById(Long.valueOf(id));
			model.put("tirClass", tirClass);
		}
		return "class/classEdit"; 
	}
		
	/**
	 * 保存
	 */
	@RequestMapping("save")
	public String save(TirClass tirClass, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes){
		String msg = "操作成功";
		classService.save(tirClass);
		redirectAttributes.addFlashAttribute("message", msg);
		return "redirect:/class/classList.html";
	}
	
	/**
	 * 提交/删除/结课/
	 */
	@RequestMapping("update")
	public @ResponseBody String update(String id, String status, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes){
		String msg = "操作成功";
		TirClass tirClass = classService.getById(Long.valueOf(id));
		tirClass.setStatus(Long.valueOf(status));
		classService.update(tirClass);
		//TODO 删除培训班时，同时删除学员
		/*if(){
			studentService.updateStudentByIdxid(tClass.getPkid());
		}*/
		
		redirectAttributes.addFlashAttribute("message", msg);
		return "redirect:/class/classList.html";
	}
	
	/**
	 * 导出excel
	 */
	@RequestMapping("export")
	public @ResponseBody String export(TirClass tirClass, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes){
		String msg = "操作成功";
		
		String sDate=req.getParameter("searchDate");
		List<TirClass> list = classService.findList(tirClass);
		String title = "培训班管理("+sDate+")";
		Map<String, String> map = new HashMap<String, String>(); 
		map.put("title",title);
		
		res.setContentType("application/vnd.ms-excel");
		String name = "培训班";
		
		try {
			res.setHeader("Content-Disposition","attachment;filename = "+new String(name.getBytes("GBK"),"ISO8859-1")+"_"+sDate+".xlsx");
			ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "/template/培训班管理导出模版.xlsx", res.getOutputStream(), list, TirClass.class, true);
			return null;
		} catch (IOException e) {
			msg = "导出培训班失败";
			e.printStackTrace();
		}
		
		redirectAttributes.addFlashAttribute("message", msg);
		return "redirect:/class/classList.html";
	}

	/**
	 * 跳转登记页面
	 * @param req
	 * @param res
	 * @param model
	 * @return
	 */
	@RequestMapping(value="registerModal.html")
	public String importModal(String ids, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		TirClass tirClass = new TirClass();
		if(user!=null){
			tirClass.setOrgid(user.getOrganid());
		}
		tirClass.setStatus(-1l);
		List<TirClass> classList = classService.findList(tirClass);
		
		model.put("ids",ids);
		model.put("classList",classList);
		
		return "student/register";
	}
	
	/**
	 * 拼接机构树
	 */
	public String umgBranchTree(List<UmgBranch> branchList){
		
		JSONArray branchJson = new JSONArray();
		
		for(UmgBranch branch : branchList){
			JSONObject tree = new JSONObject();
			tree.put("id", branch.getPkid());
			tree.put("pId",branch.getPpkid());
			tree.put("name",branch.getName());
			tree.put("open",false);
			if(Integer.valueOf(branch.getCid()) < 1001){
				tree.put("isParent",true);
			}
			branchJson.add(tree);
		}
		return branchJson.toJSONString();
	}
}
