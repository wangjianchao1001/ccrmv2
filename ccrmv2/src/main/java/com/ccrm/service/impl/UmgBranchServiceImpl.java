package com.ccrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccrm.dao.UmgBranchDao;
import com.ccrm.entity.UmgBranch;
import com.ccrm.service.UmgBranchService;

/**
 * 基本CURD操作在MybatisBaseServiceImpl中实现 否则自行声明接口，实现方法
 */
@Service
public class UmgBranchServiceImpl extends MybatisBaseServiceImpl<UmgBranch, Long> implements UmgBranchService {

	@Autowired
	UmgBranchDao umgBranchDao;
	
	@Override
	public List<UmgBranch> getBranchTree(String kindid, String ppkid) {
		return umgBranchDao.getBranchTree(kindid, ppkid);
	}

	@Override
	public String umgBranchTree(List<UmgBranch> branchList) {
		
		JSONArray branchJson = new JSONArray();
		
		for(UmgBranch branch : branchList){
			JSONObject tree = new JSONObject();
			tree.put("id", branch.getPkid());
			tree.put("pId",branch.getPpkid());
			tree.put("name",branch.getName());
			if(branch.getPpkid()==0){
				tree.put("open",true);
			}else{
				tree.put("open",false);
			}
			if(Integer.valueOf(branch.getCid()) < 1001){
				tree.put("isParent",true);
			}
			branchJson.add(tree);
		}
		return branchJson.toJSONString();
	}
		

}
