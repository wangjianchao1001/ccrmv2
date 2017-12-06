package com.ccrm.service;

import java.util.List;

import com.ccrm.entity.SysDictionary;

/**
 * SysDictionaryService接口
 */
public interface SysDictionaryService extends BaseService<SysDictionary, Long> {

	List<SysDictionary> getDicListByIdxids(String idxids);

}
