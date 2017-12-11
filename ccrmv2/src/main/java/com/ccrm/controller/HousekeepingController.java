package com.ccrm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ccrm.entity.HsrDispatchflow;
import com.ccrm.entity.HsrEmployees;
import com.ccrm.entity.RegOrganinfo;
import com.ccrm.entity.UmgBranch;
import com.ccrm.entity.UmgOperator;
import com.ccrm.service.HsrDispatchflowService;
import com.ccrm.service.HsrEmployeesService;
import com.ccrm.service.RegOrganinfoService;
import com.ccrm.service.UmgBranchService;
import com.ccrm.util.DateTimeUtils;

@Controller
@RequestMapping("/housekeeping/*")
public class HousekeepingController {
	private static final Logger log = LoggerFactory.getLogger(HousekeepingController.class);
	
	@Autowired
	RegOrganinfoService regOrgService;
	@Autowired
	UmgBranchService umgBranchService;
	@Autowired
	HsrEmployeesService employeeService;
	@Autowired
	HsrDispatchflowService dispatchService;
	
	@RequestMapping("housekeepingList.html")
	public String famCopList(RegOrganinfo regOrgan, HttpServletRequest req, HttpServletResponse res, ModelMap model,Pager page){
		
		//从session 取用户
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		Long branchId = user.getBranchid() == 100l ? 398l : user.getBranchid(); 
		
		if(regOrgan == null ) regOrgan = new RegOrganinfo();
		if(regOrgan.getBranchid() == null ) regOrgan.setBranchid(branchId);
		regOrgan.setStatus(-1);
		regOrgan.setType("HK");
		regOrgan.setSortColumns("o.status asc");
		
		Pager pager = regOrgService.findPageList(regOrgan, page.getPageNumber(), page.getPageSize());
		
		List<UmgBranch> branchList = umgBranchService.getBranchTree("2200",String.valueOf(regOrgan.getBranchid())); 
		String branchTree = umgBranchService.umgBranchTree(branchList);  
		
		model.put("pager", pager);
		model.put("branchTree", branchTree);
		model.put("regOrgan",regOrgan);
		return "housekeeping/housekeepingList";
	}
	
	
	/**
	 * 跳转新增页面
	 */
	@RequestMapping("edit.html")
	public String update(String id, String type, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		log.info("跳转页面，参数 id ："+id);
		
		//从session 取用户
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		Long branchId = user.getBranchid() == 100l ? 398l : user.getBranchid(); 
		
		List<UmgBranch> branchList = umgBranchService.getBranchTree("2200",String.valueOf(user.getBranchid())); 
		String branchTree = umgBranchService.umgBranchTree(branchList);  
		
		if(StringUtils.isNotBlank(id)){
			RegOrganinfo regOrgan = regOrgService.getById(Long.valueOf(id));
			model.put("regOrgan", regOrgan);
		}
		
		model.put("branchList", branchList);
		model.put("branchTree", branchTree);
		model.put("type", type);
		
		return "housekeeping/housekeepingEdit";
	}
	
	
	/**
	 * 保存
	 */
	@RequestMapping("save")
	public String save(RegOrganinfo regOrgan, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes){
		String msg = "操作成功";
		if(regOrgan.getPkid() == null ){
			UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
			regOrgan.setPkid(Long.valueOf(DateTimeUtils.getDateTimeStr(new Date(), "yyyyMMddHHmmssms")));
			regOrgan.setKindid(2l);
			regOrgan.setCroperid(user.getPkid());
			regOrgan.setDatenew(new Date());
			regOrgService.save(regOrgan);
		}else{
			regOrgan.setDateedit(new Date());
			regOrgService.update(regOrgan);
		}
		
		redirectAttributes.addFlashAttribute("message", msg);
		return "redirect:/housekeeping/housekeepingList.html";
	}
	
	/**
	 * 提交
	 */
	@RequestMapping("commit")
	public String commit(String id, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes){
		String msg = "操作成功";
		RegOrganinfo regOrgan = regOrgService.getById(Long.valueOf(id));
		regOrgan.setStatus(1);
		regOrgService.update(regOrgan);
		
		redirectAttributes.addFlashAttribute("message", msg);
		return "redirect:/housekeeping/housekeepingList.html";
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
			
			HsrEmployees em = new HsrEmployees();
			em.setOrganid(Long.valueOf(id));
			
			List<HsrEmployees> emList = employeeService.findList(em);
			for(HsrEmployees employee : emList){
				employee.setStatus(-1l);
				employeeService.update(employee);
			}
			
			HsrDispatchflow dp = new HsrDispatchflow();
			dp.setOrganid(Long.valueOf(id));
			List<HsrDispatchflow> dpList = dispatchService.findList(dp);
			for(HsrDispatchflow dispatch : dpList){
				dispatch.setStatus(-1l);
				dispatchService.update(dispatch);
			}
		}
		return msg+"";
	}
	/**
	 * 根据机构id 获取企业
	 */
	@RequestMapping("getByBranchId")
	public @ResponseBody Map<String, Object> getByBranchId(String branchId, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		Map<String , Object> map = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(branchId)){
			RegOrganinfo regOrgan =new RegOrganinfo();  
			regOrgan.setStatus(-1);
			regOrgan.setType("HK");
			regOrgan.setBranchid(Long.valueOf(branchId));
			List<RegOrganinfo> oList = regOrgService.findList(regOrgan);
			map.put("organList", oList);
		}
		return map;
	}
	
}
