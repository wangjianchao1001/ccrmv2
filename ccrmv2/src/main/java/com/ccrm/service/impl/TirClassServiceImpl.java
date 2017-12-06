package com.ccrm.service.impl;

import com.ccrm.service.TirClassService;
import org.springframework.stereotype.Service;
import com.ccrm.entity.TirClass;

/**
 * 基本CURD操作在MybatisBaseServiceImpl中实现 否则自行声明接口，实现方法
 */
@Service
public class TirClassServiceImpl extends MybatisBaseServiceImpl<TirClass, Long> implements TirClassService {

}
