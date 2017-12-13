package com.ccrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccrm.dao.SysDictionaryDao;
import com.ccrm.entity.SysDictionary;
import com.ccrm.entity.UmgBranch;
import com.ccrm.service.SysDictionaryService;

/**
 * 基本CURD操作在MybatisBaseServiceImpl中实现 否则自行声明接口，实现方法
 */
@Service
public class SysDictionaryServiceImpl extends MybatisBaseServiceImpl<SysDictionary, Long> implements SysDictionaryService {

	@Autowired
	SysDictionaryDao dicDao;
	
	@Override
	public List<SysDictionary> getDicListByIdxids(String idxids) {
		return dicDao.getDicListByIdxids(idxids) ;
	}

	@Override
	public String hkTypeTree(List<SysDictionary> list) {
		
		JSONArray branchJson = new JSONArray();
		
		for(SysDictionary sys : list){
			JSONObject tree = new JSONObject();
			tree.put("id", sys.getPkid());
			tree.put("pId",sys.getPpkid());
			tree.put("name",sys.getName());
			if("0".equals(sys.getPpkid())){
				tree.put("open",true);
				tree.put("isParent",true);
			}else{
				tree.put("open",false);
			}
			branchJson.add(tree);
		}
		return branchJson.toJSONString();
	}

}
