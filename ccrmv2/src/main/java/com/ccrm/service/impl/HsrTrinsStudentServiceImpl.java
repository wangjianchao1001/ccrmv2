package com.ccrm.service.impl;

import org.springframework.stereotype.Service;

import com.ccrm.entity.HsrTrinsStudent;
import com.ccrm.service.HsrTrinsStudentService;

/**
 * 基本CURD操作在MybatisBaseServiceImpl中实现 否则自行声明接口，实现方法
 */
@Service
public class HsrTrinsStudentServiceImpl extends MybatisBaseServiceImpl<HsrTrinsStudent, Long> implements HsrTrinsStudentService {

}
