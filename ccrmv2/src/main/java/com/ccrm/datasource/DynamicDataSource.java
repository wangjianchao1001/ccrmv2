package com.ccrm.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源类</br>
 * 参考 cnblogs.com/lzrabbit/p/3750803.html
 * 参考 leoyy.iteye.com/blog/1624704
 * 
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceSwitch.getDataSource();
	}
}
