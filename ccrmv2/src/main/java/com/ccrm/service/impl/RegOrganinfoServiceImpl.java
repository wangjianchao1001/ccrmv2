package com.ccrm.service.impl;

import com.ccrm.service.RegOrganinfoService;
import org.springframework.stereotype.Service;
import com.ccrm.entity.RegOrganinfo;

/**
 * 基本CURD操作在MybatisBaseServiceImpl中实现 否则自行声明接口，实现方法
 */
@Service
public class RegOrganinfoServiceImpl extends MybatisBaseServiceImpl<RegOrganinfo, Long> implements RegOrganinfoService {

}
