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
import com.ccrm.entity.HsrTriInstitution;
import com.ccrm.entity.HsrTrinsStudent;
import com.ccrm.entity.UmgBranch;
import com.ccrm.entity.UmgOperator;
import com.ccrm.service.HsrTriInstitutionService;
import com.ccrm.service.HsrTrinsStudentService;
import com.ccrm.service.RegOrganinfoService;
import com.ccrm.service.UmgBranchService;

@Controller
@RequestMapping("/hktirInst/*")
public class HKTirInstController {
	private static final Logger log = LoggerFactory.getLogger(HKTirInstController.class);
	
	@Autowired
	RegOrganinfoService regOrgService;
	@Autowired
	UmgBranchService umgBranchService;
	@Autowired
	HsrTriInstitutionService hkTriService;
	@Autowired
	HsrTrinsStudentService studentService;
	
	@RequestMapping("hktirInstList.html")
	public String famCopList(HsrTriInstitution hkTirInst, Pager page, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		
		//从session 取用户
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		String branchId = 100l ==user.getBranchid() ? "398" : String.valueOf(user.getBranchid());
		if(StringUtils.isBlank(hkTirInst.getBranchid())){
			hkTirInst.setBranchid(branchId);
		}
		
		Pager pager = hkTriService.findPageList(hkTirInst, page.getPageNumber(), page.getPageSize());
		
		List<UmgBranch> branchList = umgBranchService.getBranchTree("2200",branchId); 
		String branchTree = umgBranchService.umgBranchTree(branchList);  
		
		model.put("pager", pager);
		model.put("branchTree", branchTree);
		model.put("hkTirInst",hkTirInst);
		return "hktirInst/hktirInstList";
	}
	
	
	/**
	 * 跳转新增页面
	 */
	@RequestMapping("edit.html")
	public String update(String id, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		log.info("跳转页面，参数 id ："+id);
		
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		List<UmgBranch> branchList = umgBranchService.getBranchTree("2200",String.valueOf(user.getBranchid())); 
		String branchTree = umgBranchService.umgBranchTree(branchList); 
		
		if(StringUtils.isNotBlank(id)){
			HsrTriInstitution hkTirInst = hkTriService.getById(Long.valueOf(id));
			model.put("hkTirInst", hkTirInst);
		}
		
		model.put("branchList", branchList);
		model.put("branchTree", branchTree);
		
		return "hktirInst/hktirInstEdit";
	}
	
	
	/**
	 * 保存
	 */
	@RequestMapping("save")
	public String save(HsrTriInstitution hkTirInst, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes){
		String msg = "操作成功";
		if(hkTirInst.getPkid() == null ){
			hkTriService.save(hkTirInst);
		}else{
			hkTriService.update(hkTirInst);
		}
		
		redirectAttributes.addFlashAttribute("message", msg);
		return "redirect:/hktirInst/hktirInstList.html";
	}
	
	
	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public @ResponseBody String delete(String id, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		int msg = 0;
		if(StringUtils.isNotBlank(id)){
			msg = hkTriService.delete(Long.valueOf(id));
			
			HsrTrinsStudent student = new HsrTrinsStudent();
			student.setBranchid(id);
			List<HsrTrinsStudent> studentList = studentService.findList(student);
			for(HsrTrinsStudent hstudent : studentList){
				studentService.delete(hstudent.getPkid());
			}
		}
		return msg+"";
	}
}
