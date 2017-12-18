package com.ccrm.controller;

import java.util.Date;
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
import com.ccrm.entity.SysDictionary;
import com.ccrm.entity.UmgOperator;
import com.ccrm.service.HsrDispatchflowService;
import com.ccrm.service.RegOrganinfoService;
import com.ccrm.service.SysDictionaryService;
import com.ccrm.service.UmgBranchService;
import com.ccrm.util.DateTimeUtils;

@Controller
@RequestMapping("/dispatch/*")
public class HKDispatchController {
	private static final Logger log = LoggerFactory.getLogger(HKDispatchController.class);
	
	@Autowired
	RegOrganinfoService organService;
	@Autowired
	UmgBranchService umgBranchService;
	@Autowired
	HsrDispatchflowService dispatchService;
	@Autowired
	RegOrganinfoService regOrgService;
	@Autowired
	SysDictionaryService sysService;
	
	
	@RequestMapping("dispatchList.html") 
	public String famCopList(HsrDispatchflow dis, String branchId, HttpServletRequest req, HttpServletResponse res, ModelMap model,Pager page){
		
		//从session 取用户
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		if(StringUtils.isBlank(branchId)){
			branchId = user.getBranchid() == 100l ? "398" : String.valueOf(user.getBranchid());
		}
		if(dis == null) dis = new HsrDispatchflow();
		if(dis.getOrganid() == null){
			dis.setOrganid(user.getOrganid());
		}
		dis.setStatus(-1L);
		Pager pager = dispatchService.findPageList(dis, page.getPageNumber(), page.getPageSize());
		
		RegOrganinfo regOrgan =new RegOrganinfo();  
		regOrgan.setStatus(-1);
		regOrgan.setType("HK");
		regOrgan.setBranchid(Long.valueOf(branchId));
		List<RegOrganinfo> oList = regOrgService.findList(regOrgan);

		model.put("organList", oList);
		model.put("pager", pager);
		model.put("dispatch",dis);
		return "dispatch/dispatchList";
	}
	
	
	/**
	 * 跳转新增页面
	 */
	@RequestMapping("edit.html")
	public String update(String id, String openType, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		log.info("跳转页面，参数 studentId ："+id);
		
		UmgOperator user = (UmgOperator) req.getSession().getAttribute("umgOperator");
		Long branchId = user.getBranchid() == 100l ? 398l : user.getBranchid();
		
		if(StringUtils.isNotBlank(id)){
			HsrDispatchflow dis  = dispatchService.getById(Long.valueOf(id));
			
			SysDictionary sys = sysService.getById(dis.getSvritemid());
			dis.setSvritemName(sys.getName());
			
			model.put("dispatch", dis);
		}
		
		if(!"view".equals(openType) && (branchId != null && branchId != 0)){
			RegOrganinfo regOrgan =new RegOrganinfo();  
			regOrgan.setStatus(-1);
			regOrgan.setType("HK");
			regOrgan.setBranchid(branchId);
			List<RegOrganinfo> oList = regOrgService.findList(regOrgan);

			model.put("organList", oList);
		}
		SysDictionary sys = new SysDictionary();
		sys.setIdxid(80l);
		List<SysDictionary> sysList = sysService.findList(sys);
		String hkTypeTree = sysService.hkTypeTree(sysList);
		
		model.put("hktypeTree", hkTypeTree);
		model.put("openType", openType);
		
		return "dispatch/dispatchEdit";
	}
	
	
	/**
	 * 保存
	 */
	@RequestMapping("save")
	public String save(HsrDispatchflow dis, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes){
		String msg = "操作成功";
		if(dis.getPkid() == null ){
			dis.setPkid(Long.valueOf(DateTimeUtils.getDateTimeStr(new Date(), "yyyyMMddHHmmssms")));
			dispatchService.save(dis);
		}else{
			dispatchService.update(dis);
		}
		
		redirectAttributes.addAttribute("organid", dis.getOrganid());
		redirectAttributes.addAttribute("name", dis.getName());
		redirectAttributes.addAttribute("idno", dis.getIdno());
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
			HsrDispatchflow dis = dispatchService.getById(Long.valueOf(id));
			dis.setStatus(-1L);
			msg = dispatchService.update(dis);
		}
		return msg+"";
	}
	
}
