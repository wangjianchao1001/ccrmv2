package com.ccrm.service;

import java.util.List;

import com.ccrm.entity.UmgBranch;

/**
 * UmgBranchService接口
 */
public interface UmgBranchService extends BaseService<UmgBranch, Long> {

	List<UmgBranch> getBranchTree(String kindid, String ppkid);

	
	String umgBranchTree(List<UmgBranch> list);

	
	
}
