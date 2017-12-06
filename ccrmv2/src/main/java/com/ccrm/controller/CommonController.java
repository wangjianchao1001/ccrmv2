package com.ccrm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ccrm.entity.SysDictionary;
import com.ccrm.entity.UmgOperator;
import com.ccrm.service.SysDictionaryService;
import com.ccrm.service.UmgOperatorService;


@Controller
@RequestMapping("/*")
public class CommonController {
    
	@Autowired
	private UmgOperatorService userService;
	
	@Autowired
	private SysDictionaryService mgtAuthService;
	
	@RequestMapping("/index.html")
	public String goIndex(HttpServletRequest req, HttpServletResponse res, ModelMap model) {
		Subject currentUser = SecurityUtils.getSubject();
		UmgOperator user = (UmgOperator)currentUser.getPrincipal();
		model.put("user", user);
		return "index";
	}
	
	@RequestMapping("/home.html")
	public String goHome(HttpServletRequest req, HttpServletResponse res, ModelMap model) {
		Subject currentUser = SecurityUtils.getSubject();
		UmgOperator user = (UmgOperator)currentUser.getPrincipal();
		model.put("user", user);
		return "home";
	}
	
	@RequestMapping("/login.html")
	public String goLogin(HttpServletRequest req, HttpServletResponse res, ModelMap model){
		return "login";
	}
	@RequestMapping("/error404.html")
	public String error404(HttpServletRequest req, HttpServletResponse res, ModelMap model){
		return "error404";
	}
	@RequestMapping("/error500.html")
	public String error500(HttpServletRequest req, HttpServletResponse res, ModelMap model){ 
		return "error500";
	}
	@RequestMapping("/error403.html")
	public String error401(HttpServletRequest req, HttpServletResponse res, ModelMap model){
		return "error403";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req, HttpServletResponse res, ModelMap model){
		Subject currentUser = SecurityUtils.getSubject();
		UmgOperator user = (UmgOperator)req.getSession().getAttribute("umgOperator");
		String login = "redirect:login.html";
		if("3".equals(user.getKindid())){
			login = "redirect:housekeeping/login.html";
		}
		currentUser.logout();
		req.getSession().removeAttribute("authMenuList");
		req.getSession().removeAttribute("umgOperator");
		return login;
	}
	
	@RequestMapping("/login")
	public String login(String loginName, String password, final RedirectAttributes redirectAttributes, HttpServletRequest req, HttpServletResponse res, ModelMap model){
		if(StringUtils.isBlank(loginName)&&StringUtils.isBlank(password)){
			return "redirect:login.html";
		}
		String passwordSHA = new Sha1Hash(password).toString();
		UsernamePasswordToken token = new UsernamePasswordToken(loginName, passwordSHA);
		Subject currentUser = SecurityUtils.getSubject();
		String errorMessage = "";
		try {
			currentUser.login(token);
			UmgOperator user = userService.getByCid(loginName);
			List<SysDictionary> authMenuList = new ArrayList<SysDictionary>();
			if(user.getCid().equals("admin")){
				SysDictionary sysDic = new SysDictionary();
				sysDic.setIdxid(10L);
				sysDic.setCodeid("0000");
				authMenuList=mgtAuthService.findList(sysDic);
			}else{
				authMenuList = userService.getAuthorityMenuByUser("10",user);
			}
			
			req.getSession().setAttribute("authMenuList", authMenuList);
			req.getSession().setAttribute("umgOperator",user);
			return "redirect:index.html";
		} catch (UnknownAccountException e) {
			errorMessage = "用户不存在";
		} catch (IncorrectCredentialsException e) {
			errorMessage = "密码错误";
		} catch (LockedAccountException e) {
			errorMessage = "用户锁定";
		} catch (DisabledAccountException e) {
			errorMessage = "用户已停用";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			errorMessage = "未知错误";
		}
		
		model.addAttribute("errorMessage", errorMessage);
		return "login";
	}
	
	public static void main(String[] args) {
		System.out.println(new Sha1Hash("admin").toString());
		System.out.println(new Sha1Hash("888888").toString());
	}
}
