package com.ccrm.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.ccrm.entity.SysDictionary;
import com.ccrm.entity.UmgOperator;
import com.ccrm.service.SysDictionaryService;
import com.ccrm.service.UmgOperatorService;

public class AuthenticationRealm extends AuthorizingRealm {

	@Autowired
	private UmgOperatorService userService;

	@Autowired
	private SysDictionaryService mgtAuthService;
	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String userName = token.getUsername();
		String password = new String(token.getPassword());
		if (userName != null && !"".equals(userName)) {
			// 从数据库或 接口通过userName获取用户信息
			UmgOperator account = userService.getByCid(userName);
			if (account == null) {
				throw new UnknownAccountException();
			}
			if (account.getStatus()!=1) {
				throw new DisabledAccountException();
			}
			if (!account.getPassword().equals(password)) {
				throw new IncorrectCredentialsException();
			}
			return new SimpleAuthenticationInfo(account, account.getPassword(), getName());
		} else {
			return null;
		}
	
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@SuppressWarnings("unused")
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		UmgOperator account = (UmgOperator) principals.getPrimaryPrincipal();
		SysDictionary authority = new SysDictionary();
		authority.setIdxid(Long.valueOf(10));
		List<SysDictionary> authList = new ArrayList<SysDictionary>();
			SysDictionary sysDic = new SysDictionary();
			sysDic.setIdxid(10L);
			authList=mgtAuthService.findList(sysDic);
		if (account != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			for(SysDictionary auth : authList){
				info.addStringPermission(auth.getCodeid());
			}
			return info;
		}
		return null;
	}

}
