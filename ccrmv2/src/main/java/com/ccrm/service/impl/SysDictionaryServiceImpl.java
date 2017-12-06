package com.ccrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccrm.dao.SysDictionaryDao;
import com.ccrm.entity.SysDictionary;
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

}
