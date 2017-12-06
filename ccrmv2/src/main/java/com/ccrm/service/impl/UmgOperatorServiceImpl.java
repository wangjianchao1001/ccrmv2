package com.ccrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccrm.dao.SysDictionaryDao;
import com.ccrm.dao.UmgOperatorDao;
import com.ccrm.entity.SysDictionary;
import com.ccrm.entity.UmgOperator;
import com.ccrm.service.UmgOperatorService;

/**
 * 基本CURD操作在MybatisBaseServiceImpl中实现 否则自行声明接口，实现方法
 */
@Service
public class UmgOperatorServiceImpl extends MybatisBaseServiceImpl<UmgOperator, Long> implements UmgOperatorService {

	@Autowired
	SysDictionaryDao sysDao;
	@Autowired
	UmgOperatorDao userDao;
	
	
	/**
	 * 根据pkid 查询权限
	 */
	@Override
	public List<SysDictionary> getAuthorityMenuByUser(String idxid, UmgOperator user) {
		return sysDao.getAuthByUserID(idxid,String.valueOf(user.getPkid()));
	}


	/**
	 * 通过登录名查找
	 */
	@Override
	public UmgOperator getByCid(String loginName) {
		return userDao.getUserByCid(loginName);
	}

}
