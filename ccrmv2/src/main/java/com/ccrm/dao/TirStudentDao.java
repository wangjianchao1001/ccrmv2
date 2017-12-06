package com.ccrm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccrm.entity.TirStudent;

/**
 * TirStudentDao
 */
public interface TirStudentDao extends BaseDao<TirStudent, Long> {

	void updateStudentByIdxid(@Param("idxid")Long idxid);

	List<TirStudent> findListForExport(TirStudent student);

}
