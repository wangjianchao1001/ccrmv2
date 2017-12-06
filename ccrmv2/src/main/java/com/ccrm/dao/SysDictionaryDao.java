package com.ccrm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccrm.entity.SysDictionary;

/**
 * SysDictionaryDao
 */
public interface SysDictionaryDao extends BaseDao<SysDictionary, Long> {

	List<SysDictionary> getAuthByUserID(@Param("idxid") String idxid, @Param("pkid") String pkid);

	List<SysDictionary> getDicListByIdxids(@Param("idxids")String idxids);

}
