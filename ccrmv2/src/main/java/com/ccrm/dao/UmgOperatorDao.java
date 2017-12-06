package com.ccrm.dao;

import org.apache.ibatis.annotations.Param;

import com.ccrm.entity.UmgOperator;

/**
 * UmgOperatorDao
 */
public interface UmgOperatorDao extends BaseDao<UmgOperator, Long> {

	UmgOperator getUserByCid(@Param("loginName") String loginName);

}
