package com.ccrm.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccrm.dto.Pager;
import com.ccrm.entity.SysDictionary;
import com.ccrm.entity.UmgAssociate;
import com.ccrm.entity.UmgOperator;
import com.ccrm.service.SysDictionaryService;
import com.ccrm.service.UmgAssociateService;
import com.ccrm.service.UmgOperatorService;
import com.ccrm.util.AppConfig;
import com.ccrm.util.DateTimeUtils;
import com.ccrm.util.PkidGenerator;

@Controller
@RequestMapping("/user/*")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UmgOperatorService userService;
	@Autowired
	private SysDictionaryService sysService;
	@Autowired
	private UmgAssociateService assService;
	
	/**
	 * 分页查询页面
	 * 
	 * @param req
	 * @param res
	 * @param model
	 * @param user
	 * @param page
	 * @return
	 */
	@RequestMapping("findPageList")
	public String findPageList(HttpServletRequest req, HttpServletResponse res, ModelMap model, UmgOperator user, Pager page) {

		user.setSortColumns(" idxid DESC");
		Pager pager = userService.findPageList(user, page.getPageNumber(), page.getPageSize());
		//获取当前登录用户的userId，用以判断当前操作员不能删除自己
		String currentUserId = (String) req.getSession().getAttribute("mgtUserId");
		model.put("currentUser", currentUserId);
		model.put("pager", pager);
		return "user/userList";
	}

	/**
	 * 删除
	 * 
	 * @param req
	 * @param res
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String delete(HttpServletRequest req, HttpServletResponse res, ModelMap model, String userId) {
		int result = 0;
		try {
			result = userService.delete(Long.valueOf(userId));
		} catch (Exception e) {
			log.error("delete ERROR", e);
		}
		return result + "";
	}

	/**
	 * 
	 * 跳转到修改页面
	 * 
	 * @param req
	 * @param res
	 * @param model
	 * @param userId
	 * @return
	 */
	
	@RequestMapping("editUI.html")
	public String editUI(HttpServletRequest req, HttpServletResponse res, ModelMap model, String userId) {
		if (StringUtils.isNotBlank(userId)) {
			UmgOperator user = userService.getById(Long.valueOf(userId));
			model.put("user", user);
		}
		return "user/userEdit";
	} 
	
	/**
	 * 添加
	 */
	@RequestMapping("add")
	public String add(HttpServletRequest req, HttpServletResponse res, ModelMap model, UmgOperator user, final RedirectAttributes redirectAttributes) {
		String msg = "操作成功";
		try {
//				user.setUserId(UUID.randomUUID().toString());
				user.setPassword(new Sha1Hash(user.getPassword()).toString());
//				user.setAddTime(new Date());
//				user.setStatus(1);
				userService.save(user);
		} catch (Exception e) {
			msg = "操作失败";
			log.error(e.toString(), e);
		}
		redirectAttributes.addFlashAttribute("message", msg);
		return "redirect:/user/findPageList";
	}
	

	/**
	 * 编辑
	 * @param req
	 * @param res
	 * @param model
	 * @param user
	 * @param redirectAttributes
	 * @return
	 */
	
	@RequestMapping("update")
	public String update(HttpServletRequest req, HttpServletResponse res, ModelMap model, UmgOperator user, final RedirectAttributes redirectAttributes) {
		String msg = "操作成功";
		try {
			userService.update(user);
		} catch (Exception e) {
			msg = "操作失败";
			log.error(e.toString(), e);
		}
		redirectAttributes.addFlashAttribute("message", msg);
		return "redirect:/user/findPageList";
	} 
	
	
	/**
	 * 登录名唯一性验证
	 */
	@RequestMapping("userExist")
	@ResponseBody
	public boolean userExist(HttpServletRequest req, HttpServletResponse res, ModelMap model, UmgOperator user) {
		UmgOperator aUser=userService.getByCid(user.getCid());
		if(aUser==null){//新增
			return true;
		}
		if(aUser!=null && user.getPkid() == aUser.getPkid()){//修改
			return true;
		}
		return false;
	}
	
	/**
	 * 停用/启用
	*/
	@RequestMapping("disableOrEnabble")
	@ResponseBody
	public String disableOrEnabble(HttpServletRequest req, HttpServletResponse res, ModelMap model, UmgOperator user) {
		int result = 0;
		try {
			result = userService.update(user);
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
		return result+"";
	} 
	
	/**
	 * 密码初始化
	 * @return
	 */
	@RequestMapping("password/reset")
	public @ResponseBody
	String resetPassword(HttpServletRequest req, HttpServletResponse res, ModelMap model, UmgOperator user, final RedirectAttributes redirectAttributes) {
		int result = 0;
		try {
			String initPass = AppConfig.getParameter("initPass");
			if(user.getPkid() != null&&!StringUtils.isNotBlank("888888")){
				user.setPassword(new Sha1Hash(initPass).toString());
				result = userService.update(user);
			}
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
		return result+"";
	}
	
	/**
	 * 个人中心
	 */
	@RequestMapping("personalCenter.html")
	public String personalCenter (HttpServletRequest req, HttpServletResponse res, ModelMap model, UmgOperator user){
		//查询个人信息
		UmgOperator currentUser = new UmgOperator();
		currentUser = userService.getByCid(user.getCid());
		model.put("user", currentUser);
		return "user/personalCenter";
	}
	
	/**
	 * 修改密码
	 */
	@RequestMapping("password/update")
	@ResponseBody
	public String resetPassword (HttpServletRequest req, HttpServletResponse res, ModelMap model, UmgOperator user){
		String msg = "修改成功";
		try {
			UmgOperator user1 = (UmgOperator) req.getSession().getAttribute("umgOperator");
			UmgOperator user2 = userService.getByCid(user1.getCid());
			if(user2 != null &&StringUtils.isNotBlank(user.getPassword())){
				user2.setPassword(new Sha1Hash(user.getPassword().toLowerCase()).toString());
				userService.update(user2);
			}
		} catch (Exception e) {
			msg = "修改失败";
			log.error(e.toString(), e);
		}
		return msg;
	}
	
	/**
	 * 验证原密码
	 */
	@RequestMapping("checkPassword")
	public @ResponseBody boolean checkPassword (HttpServletRequest req, HttpServletResponse res, ModelMap model, UmgOperator user){
		String a = new Sha1Hash(user.getPassword()).toString();
		UmgOperator user1 = (UmgOperator) req.getSession().getAttribute("umgOperator");
		UmgOperator operator = userService.getById(user1.getPkid());
		return a.equals(operator.getPassword());
	}
	
	/**
	 * 跳转到设置权限页面
	 * 
	 * @return
	
	@RequestMapping("setAuth.html")
	public String goSetAuth(MgtAuthority mgtAuthority,MgtUserAuthority mgtua, @RequestParam String userId, @RequestParam String loginName,HttpServletRequest req, HttpServletResponse res, ModelMap model) {

		//全部权限
		mgtAuthority.setSortColumns("sort ASC");
		List<MgtAuthority> authList = mgtAuthorityService.findList(mgtAuthority);
		//操作员权限
		mgtua.setUserId(userId);
		List<MgtUserAuthority> uaList = mgtUAService.findList(mgtua); 
		
		String permissionTree = permissionTree(authList,uaList);
		
		model.put("permissionTree", permissionTree);
		model.put("loginName", loginName);
		model.put("userId", userId);
		return "user/setAuth";
	} */
	
	/**
	 *  拼接权限树
	 *  
	 * @return
	 */
	public String permissionTree(){
		
		SysDictionary sys = new SysDictionary();
		sys.setIdxid(10l);
		
		List<SysDictionary> listModuleAll = sysService.findList(sys);
		
		JSONArray authJson = new JSONArray();
		for(SysDictionary auth : listModuleAll){
			JSONObject au = new JSONObject();
			au.put("id", auth.getPkid());
			au.put("pId", auth.getPpkid());
			au.put("name", auth.getName());
			au.put("open", false);
			authJson.add(au);
		}
		return authJson.toJSONString();
	} 
	
	/**
	 * 保存权限
	 * 
	 * @param userId
	 * @param authIdList
	 * @param req
	 * @param res
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("saveMgtUserAuth")
	@ResponseBody
	public String saveMgtUserRule(String userId, String authIdList, HttpServletRequest req, HttpServletResponse res, ModelMap model, final RedirectAttributes redirectAttributes) {
		String msg = "操作成功";
		try {
			String[] authId = {};
			authId = StringUtils.isBlank(authIdList) ? authId : authIdList.split(",");
			// 先删除在新增
			assService.deleteBySubId(userId);
			for (int i = 0; i < authId.length; i++) {
				
				UmgAssociate mgtUA = new UmgAssociate();
				mgtUA.setPkid(Long.valueOf(PkidGenerator.radomNumber(2)));
				mgtUA.setAssid(Long.valueOf(userId));
				mgtUA.setDatenew(DateTimeUtils.getNowDate());
				mgtUA.setSubid(authId[i]);
				mgtUA.setClasid(20l);
				
				assService.save(mgtUA);
			}
		} catch (Exception e) {
			msg = "操作失败";
			log.error(e.toString(), e);
		}
		return msg;
	}
	
	
}
