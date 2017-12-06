package com.ccrm.service;

import java.util.List;

import com.ccrm.entity.SysDictionary;
import com.ccrm.entity.UmgOperator;

/**
 * UmgOperatorService接口
 */
public interface UmgOperatorService extends BaseService<UmgOperator, Long> {

	List<SysDictionary> getAuthorityMenuByUser(String idxid, UmgOperator user);

	UmgOperator getByCid(String loginName);

}
