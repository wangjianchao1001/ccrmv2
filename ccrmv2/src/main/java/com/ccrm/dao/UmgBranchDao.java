package com.ccrm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccrm.entity.UmgBranch;

/**
 * UmgBranchDao
 */
public interface UmgBranchDao extends BaseDao<UmgBranch, Long> {

	List<UmgBranch> getBranchTree(@Param("kindid")String kindid,@Param("ppkid") String ppkid);

}
