package com.ccrm.service;

import com.ccrm.entity.UmgAssociate;

/**
 * UmgAssociateService接口
 */
public interface UmgAssociateService extends BaseService<UmgAssociate, Long> {

	void deleteBySubId(String userId);

}
