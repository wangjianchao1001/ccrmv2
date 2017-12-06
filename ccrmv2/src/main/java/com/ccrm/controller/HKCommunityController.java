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
import com.ccrm.entity.HsrGeneralsurvey;
import com.ccrm.entity.RegOrganinfo;
import com.ccrm.entity.TirClass;
import com.ccrm.entity.UmgBranch;
import com.ccrm.entity.UmgOperator;
import com.ccrm.service.HsrGeneralsurveyService;
import com.ccrm.service.RegOrganinfoService;
import com.ccrm.service.UmgBranchService;

@Controller
@RequestMapping("/community/*")
public class HKCommunityController {
	private static final Logger log = LoggerFactory.getLogger(HKCommunityController.class);
	
	@Autowired
	RegOrganinfoService regOrgService;
	@Autowired
	UmgBranchService umgBranchService;
	@Autowired
	HsrGeneralsurveyService comService;
	
	@RequestMapping("communityList.html")
	public String famCopList(HsrGeneralsurvey com, HttpServletRequest req, HttpServletResponse res, ModelMap model,Pager page){
		
		//从session 取用户
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		com.setStatus(-1l);
		Pager pager = comService.findPageList(com, page.getPageNumber(), page.getPageSize());
		
		List<UmgBranch> branchList = umgBranchService.getBranchTree("2200",String.valueOf(user.getBranchid())); 
		String branchTree = umgBranchService.umgBranchTree(branchList); 
		
		model.put("pager", pager);
		model.put("branchTree", branchTree);
		return "community/communityList";
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
			HsrGeneralsurvey com = comService.getById(Long.valueOf(id));
			model.put("community", com);
		}
		
		model.put("branchList", branchList);
		model.put("branchTree", branchTree);
		
		return "community/communityEdit";
	}
	
	
	/**
	 * 保存
	 */
	@RequestMapping("save")
	public String save(HsrGeneralsurvey com, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes){
		String msg = "操作成功";
		if(com.getPkid() == null ){
			comService.save(com);
		}else{
			comService.update(com);
		}
		
		redirectAttributes.addFlashAttribute("message", msg);
		return "redirect:/community/communityList.html";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public @ResponseBody String delete(String id, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		int msg = 0;
		if(StringUtils.isNotBlank(id)){
			HsrGeneralsurvey com = comService.getById(Long.valueOf(id));
			com.setStatus(-1l);
			msg = comService.update(com);
			
		}
		return msg+"";
	}
	
}
