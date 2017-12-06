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
import com.ccrm.entity.HsrDispatchflow;
import com.ccrm.entity.RegOrganinfo;
import com.ccrm.entity.TirClass;
import com.ccrm.entity.UmgBranch;
import com.ccrm.entity.UmgOperator;
import com.ccrm.service.HsrDispatchflowService;
import com.ccrm.service.RegOrganinfoService;
import com.ccrm.service.TirStudentService;
import com.ccrm.service.UmgBranchService;

@Controller
@RequestMapping("/dispatch/*")
public class HKDispatchController {
	private static final Logger log = LoggerFactory.getLogger(HKDispatchController.class);
	
	@Autowired
	RegOrganinfoService regOrgService;
	@Autowired
	UmgBranchService umgBranchService;
	@Autowired
	HsrDispatchflowService dispatchService;
	
	@RequestMapping("dispatchList.html")
	public String famCopList(HsrDispatchflow dispatch, HttpServletRequest req, HttpServletResponse res, ModelMap model,Pager page){
		
		//从session 取用户
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		Long branchId = dispatch.getOrganid();
		dispatch.setStatus(-1l);
		
		Pager pager = dispatchService.findPageList(dispatch, page.getPageNumber(), page.getPageSize());
		
		List<UmgBranch> branchList = umgBranchService.getBranchTree("2200",String.valueOf(user.getBranchid())); 
		
		model.put("branchList", branchList);
		model.put("pager", pager);
		model.put("dispatch",dispatch);
		return "dispatch/dispatchList";
	}
	
	
	/**
	 * 跳转新增页面
	 */
	@RequestMapping("edit.html")
	public String update(String id, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		log.info("跳转页面，参数 Id ："+id);
		
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		List<UmgBranch> branchList = umgBranchService.getBranchTree("2200",String.valueOf(user.getBranchid())); 
		
		if(StringUtils.isNotBlank(id)){
			HsrDispatchflow dispatch = dispatchService.getById(Long.valueOf(id));
			model.put("dispatch", dispatch);
		}
		
		model.put("branchList", branchList);
		
		return "dispatch/dispatchEdit";
	}
	
	
	/**
	 * 保存
	 */
	@RequestMapping("save")
	public String save(HsrDispatchflow dispatch, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes){
		String msg = "操作成功";
		if(dispatch.getPkid() == null ){
			dispatchService.save(dispatch);
		}else{
			dispatchService.update(dispatch);
		}
		
		redirectAttributes.addFlashAttribute("message", msg);
		return "redirect:/dispatch/dispatchList.html";
	}
	
	
	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public @ResponseBody String delete(String id, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		int msg = 0;
		if(StringUtils.isNotBlank(id)){
			HsrDispatchflow dispatch = dispatchService.getById(Long.valueOf(id));
			dispatch.setStatus(-1l);
			msg = dispatchService.update(dispatch);
			
		}
		return msg+"";
	}
	
}
