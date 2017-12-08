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
import com.ccrm.entity.HsrEmployees;
import com.ccrm.entity.UmgBranch;
import com.ccrm.entity.UmgOperator;
import com.ccrm.service.HsrEmployeesService;
import com.ccrm.service.RegOrganinfoService;
import com.ccrm.service.UmgBranchService;

@Controller
@RequestMapping("/employee/*")
public class HKEmployeeController {
	private static final Logger log = LoggerFactory.getLogger(HKEmployeeController.class);
	
	@Autowired
	RegOrganinfoService organService;
	@Autowired
	UmgBranchService umgBranchService;
	@Autowired
	HsrEmployeesService employeeService;
	
	@RequestMapping("employeeList.html") 
	public String famCopList(HsrEmployees em, HttpServletRequest req, HttpServletResponse res, ModelMap model,Pager page){
		
		//从session 取用户
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		if(em.getOrganid() == 0){
			em.setOrganid(user.getOrganid());
		}
		em.setStatus(-1L);
		
		Pager pager = employeeService.findPageList(em, page.getPageNumber(), page.getPageSize());
		
		model.put("pager", pager);
		model.put("employee",em);
		return "employee/employeeList";
	}
	
	
	/**
	 * 跳转新增页面
	 */
	@RequestMapping("edit.html")
	public String update(String id, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		log.info("跳转页面，参数 studentId ："+id);
		
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		List<UmgBranch> branchList = umgBranchService.getBranchTree("2200",String.valueOf(user.getBranchid())); 
		
		if(StringUtils.isNotBlank(id)){
			HsrEmployees em  = employeeService.getById(Long.valueOf(id));
			model.put("employee", em);
		}
		
		model.put("branchList", branchList);
		
		return "employee/employeeEdit";
	}
	
	
	/**
	 * 保存
	 */
	@RequestMapping("save")
	public String save(HsrEmployees em, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes){
		String msg = "操作成功";
		if(em.getPkid() == null ){
			employeeService.save(em);
		}else{
			employeeService.update(em);
		}
		
		redirectAttributes.addFlashAttribute("message", msg);
		return "redirect:/employee/employeeList.html";
	}
	
	
	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public @ResponseBody String delete(String id, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		int msg = 0;
		if(StringUtils.isNotBlank(id)){
			HsrEmployees em = employeeService.getById(Long.valueOf(id));
			em.setStatus(-1L);
			msg = employeeService.update(em);
		}
		return msg+"";
	}
	
}
