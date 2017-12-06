package com.ccrm.service;

import java.util.List;

import com.ccrm.entity.TirStudent;

/**
 * TirStudentService接口
 */
public interface TirStudentService extends BaseService<TirStudent, Long> {

	void updateStudentByIdxid(Long idxid);

	List<TirStudent> findListForExport(TirStudent student);

}
