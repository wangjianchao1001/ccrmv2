package com.ccrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccrm.dao.TirStudentDao;
import com.ccrm.entity.TirStudent;
import com.ccrm.service.TirStudentService;

/**
 * 基本CURD操作在MybatisBaseServiceImpl中实现 否则自行声明接口，实现方法
 */
@Service
public class TirStudentServiceImpl extends MybatisBaseServiceImpl<TirStudent, Long> implements TirStudentService {

	@Autowired
	TirStudentDao studentDao;
	
	@Override
	public void updateStudentByIdxid(Long idxid) {
		studentDao.updateStudentByIdxid(idxid); 
	}

	@Override
	public List<TirStudent> findListForExport(TirStudent student) {
		return studentDao.findListForExport(student);
	}

}
