package com.ccrm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ccrm.dto.Pager;
import com.ccrm.entity.RegOrganinfo;
import com.ccrm.entity.TirClass;
import com.ccrm.entity.UmgBranch;
import com.ccrm.entity.UmgOperator;
import com.ccrm.service.RegOrganinfoService;
import com.ccrm.service.TirClassService;
import com.ccrm.service.TirStudentService;
import com.ccrm.service.UmgBranchService;

@Controller
@RequestMapping("/tirOrgan/*")
public class RegOrganinfoController {
	private static final Logger log = LoggerFactory.getLogger(RegOrganinfoController.class);
	
	@Autowired
	RegOrganinfoService regOrgService;
	@Autowired
	UmgBranchService umgBranchService;
	@Autowired
	TirClassService tirClassService;
	@Autowired
	TirStudentService studentService;
	
	@RequestMapping("tirOrganList.html")
	public String regOrgList(RegOrganinfo regOrgan, HttpServletRequest req, HttpServletResponse res, ModelMap model,Pager page){
		//从session 取用户
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		regOrgan.setStatus(-1);
		if(user != null && regOrgan.getBranchid() == null && (user.getKindid() == 1 || user.getKindid() == 0)){
			regOrgan.setBranchid(user.getBranchid());
		}else if(user != null && regOrgan.getBranchid() == null && user.getKindid() == 2){
			regOrgan.setBranchid(user.getOrganid());
		}
		
		Pager pager = regOrgService.findPageList(regOrgan, page.getPageNumber(), page.getPageSize());
		
		List<UmgBranch> branchList = umgBranchService.getBranchTree("1200",String.valueOf(user.getBranchid())); 
		String branchTree = umgBranchService.umgBranchTree(branchList); 
		
		model.put("pager", pager);
		model.put("branchTree", branchTree);
		model.put("regOrgan",regOrgan);
		
		return "regOrgan/tirOrganList";
	}
	
	/**
	 * 跳转新增页面
	 */
	@RequestMapping("edit.html")
	public String update(String id, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		log.info("跳转页面，参数 studentId ："+id);
		
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		List<UmgBranch> branchList = umgBranchService.getBranchTree("1200",String.valueOf(user.getBranchid())); 
		
		if(StringUtils.isNotBlank(id)){
			RegOrganinfo regOrgan = regOrgService.getById(Long.valueOf(id));
			model.put("regOrgan", regOrgan);
		}else{
			String branchTree = umgBranchService.umgBranchTree(branchList);
			model.put("branchTree", branchTree);
		}
		
		model.put("branchList", branchList);
		
		return "regOrgan/tirOrganEdit";
	}
	
	
	/**
	 * 保存
	 */
	@RequestMapping("save")
	public String save(RegOrganinfo regOrgan, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes){
		String msg = "操作成功";
		if(regOrgan.getPkid() == null ){
			regOrgService.save(regOrgan);
		}else{
			regOrgService.update(regOrgan);
		}
		
		redirectAttributes.addFlashAttribute("message", msg);
		return "redirect:/tirOrgan/tirOrganList.html";
	}
	
	/**
	 * 提交
	 */
	@RequestMapping("commit")
	public @ResponseBody String commit(String id, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes){
		int msg = 0;
		RegOrganinfo regOrgan = regOrgService.getById(Long.valueOf(id));
		regOrgan.setStatus(1);
		msg = regOrgService.update(regOrgan);
		
		return msg+"";
	}
	
	
	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public @ResponseBody String delete(String id, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		int msg = 0;
		if(StringUtils.isNotBlank(id)){
			RegOrganinfo regOrgan = regOrgService.getById(Long.valueOf(id));
			regOrgan.setStatus(-1);
			msg = regOrgService.update(regOrgan);
			
			TirClass tirClass = new TirClass();
			tirClass.setOrgid(regOrgan.getPkid());
			List<TirClass> classList = tirClassService.findList(tirClass);
			for(TirClass tClass : classList){
				tClass.setStatus(-1l);
				tirClassService.update(tClass);
				studentService.updateStudentByIdxid(tClass.getPkid());
			}
		}
		return msg+"";
	}
	
}
