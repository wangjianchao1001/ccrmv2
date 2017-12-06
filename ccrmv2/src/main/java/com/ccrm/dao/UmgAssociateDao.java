package com.ccrm.dao;

import org.apache.ibatis.annotations.Param;

import com.ccrm.entity.UmgAssociate;

/**
 * UmgAssociateDao
 */
public interface UmgAssociateDao extends BaseDao<UmgAssociate, Long> {

	void deleteBySubId(@Param("subId")String subId);

}
