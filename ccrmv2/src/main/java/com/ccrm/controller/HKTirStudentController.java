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
import com.ccrm.entity.HsrTrinsStudent;
import com.ccrm.entity.UmgBranch;
import com.ccrm.entity.UmgOperator;
import com.ccrm.service.HsrTrinsStudentService;
import com.ccrm.service.RegOrganinfoService;
import com.ccrm.service.UmgBranchService;

@Controller
@RequestMapping("/hktirStudent/*")
public class HKTirStudentController {
	private static final Logger log = LoggerFactory.getLogger(HKTirStudentController.class);
	
	@Autowired
	RegOrganinfoService regOrgService;
	@Autowired
	UmgBranchService umgBranchService;
	@Autowired
	HsrTrinsStudentService studentSevice;
	
	@RequestMapping("hkStudentList.html")
	public String famCopList(HsrTrinsStudent student, HttpServletRequest req, HttpServletResponse res, ModelMap model,Pager page){
		
		//从session 取用户
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		if(user != null){
			student.setBranchid(user.getBranchid()+"");
		}
		
		Pager pager = studentSevice.findPageList(student, page.getPageNumber(), page.getPageSize());
		
		List<UmgBranch> branchList = umgBranchService.getBranchTree("2200",String.valueOf(user.getBranchid())); 
		String branchTree = umgBranchService.umgBranchTree(branchList); 
		
		model.put("pager", pager);
		model.put("branchTree", branchTree);
		model.put("student",student);
		
		return "hkStudent/hkStudentList";
	}
	
	
	/**
	 * 跳转新增页面
	 */
	@RequestMapping("edit.html")
	public String update(String id, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		log.info("跳转页面，参数 studentId ："+id);
		
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		List<UmgBranch> branchList = umgBranchService.getBranchTree("1200",String.valueOf(user.getBranchid())); 
		String branchTree = umgBranchService.umgBranchTree(branchList); 
		
		if(StringUtils.isNotBlank(id)){
			HsrTrinsStudent student = studentSevice.getById(Long.valueOf(id));
			model.put("student", student);
		}
		
		model.put("branchList", branchList);
		model.put("branchTree", branchTree);
		
		return "hkStudent/hkStudentEdit";
	}
	
	
	/**
	 * 保存
	 */
	@RequestMapping("save")
	public String save(HsrTrinsStudent student, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes){
		String msg = "操作成功";
		if(student.getPkid() == null ){
			studentSevice.save(student);
		}else{
			studentSevice.update(student);
		}
		
		redirectAttributes.addFlashAttribute("message", msg);
		return "redirect:/hkStudent/hkStudentList.html";
	}
	
	
	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public @ResponseBody String delete(String id, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		int msg = 0;
		if(StringUtils.isNotBlank(id)){
			msg = studentSevice.delete(Long.valueOf(id));
		}
		return msg+"";
	}
	
	
}
