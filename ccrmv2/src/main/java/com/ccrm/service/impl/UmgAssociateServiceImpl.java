package com.ccrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccrm.dao.UmgAssociateDao;
import com.ccrm.entity.UmgAssociate;
import com.ccrm.service.UmgAssociateService;

/**
 * 基本CURD操作在MybatisBaseServiceImpl中实现 否则自行声明接口，实现方法
 */
@Service
public class UmgAssociateServiceImpl extends MybatisBaseServiceImpl<UmgAssociate, Long> implements UmgAssociateService {

	@Autowired
	UmgAssociateDao assDao;
	
	@Override
	public void deleteBySubId(String userId) {
		assDao.deleteBySubId(userId);
	}

}
