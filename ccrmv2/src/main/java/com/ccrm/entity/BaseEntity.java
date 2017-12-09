package com.ccrm.entity;

import java.io.Serializable;

/**
 * Entity基类
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 排序字段 */
	private String sortColumns;
	
	/** 打开页面是新增还是修改 */
	private String openType;

	public String getSortColumns() {
		return sortColumns;
	}

	public void setSortColumns(String sortColumns) {
		this.sortColumns = sortColumns;
	}

	public String getOpenType() {
		return openType;
	}

	public void setOpenType(String openType) {
		this.openType = openType;
	}

}
