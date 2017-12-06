package com.ccrm.service.impl;

import com.ccrm.service.PmpMessgeService;
import org.springframework.stereotype.Service;
import com.ccrm.entity.PmpMessge;

/**
 * 基本CURD操作在MybatisBaseServiceImpl中实现 否则自行声明接口，实现方法
 */
@Service
public class PmpMessgeServiceImpl extends MybatisBaseServiceImpl<PmpMessge, Long> implements PmpMessgeService {

}
