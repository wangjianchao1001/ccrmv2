package com.ccrm.service.impl;

import com.ccrm.service.HsrEmployeesService;
import org.springframework.stereotype.Service;
import com.ccrm.entity.HsrEmployees;

/**
 * 基本CURD操作在MybatisBaseServiceImpl中实现 否则自行声明接口，实现方法
 */
@Service
public class HsrEmployeesServiceImpl extends MybatisBaseServiceImpl<HsrEmployees, Long> implements HsrEmployeesService {

}
