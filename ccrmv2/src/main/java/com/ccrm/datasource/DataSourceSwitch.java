package com.ccrm.datasource;

public class DataSourceSwitch {
	private static final ThreadLocal<String> contextHolder = new InheritableThreadLocal<String>();

	public static void setDataSource(String dataSource) {
		contextHolder.set(dataSource);
	}
	
	public static String getDataSource() {
		return contextHolder.get();
	}
	
	public static void clearDataSource() {
		contextHolder.remove();
	}
}
