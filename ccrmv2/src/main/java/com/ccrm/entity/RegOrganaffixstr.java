package com.ccrm.entity;

import com.ccrm.entity.BaseEntity;

public class RegOrganaffixstr extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:PKID     
     * @字段:PKID NUMBER(22)  
     */	
	private Long pkid;

	/**
     * @备注:登记企业机构pkid     
     * @字段:IDXID NUMBER(22)  
     */	
	private Long idxid;

	/**
     * @备注:附加信息索引     
     * @字段:KINDID NUMBER(22)  
     */	
	private Long kindid;

	/**
     * @备注:     
     * @字段:STATUS NUMBER(22)  
     */	
	private Long status;

	/**
     * @备注:     
     * @字段:DATENEW TIMESTAMP(6)(11)  
     */	
	private java.util.Date datenew;

	/**
     * @备注:     
     * @字段:DATEEDIT TIMESTAMP(6)(11)  
     */	
	private java.util.Date dateedit;

	/**
     * @备注:附加字符串值     
     * @字段:VALUE VARCHAR2(4000)  
     */	
	private java.lang.String value;

	/**
     * @备注:     
     * @字段:MEMO VARCHAR2(4000)  
     */	
	private java.lang.String memo;
	public RegOrganaffixstr(){
	}

	public RegOrganaffixstr(
		Long pkid
	){
		this.pkid = pkid;
	}

	public void setPkid(Long pkid) {
		this.pkid = pkid;
	}
	 
	public Long getPkid() {
		return this.pkid;
	}
	public void setIdxid(Long idxid) {
		this.idxid = idxid;
	}
	 
	public Long getIdxid() {
		return this.idxid;
	}
	public void setKindid(Long kindid) {
		this.kindid = kindid;
	}
	 
	public Long getKindid() {
		return this.kindid;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	 
	public Long getStatus() {
		return this.status;
	}
	public void setDatenew(java.util.Date datenew) {
		this.datenew = datenew;
	}
	 
	public java.util.Date getDatenew() {
		return this.datenew;
	}
	 
	public void setDateedit(java.util.Date dateedit) {
		this.dateedit = dateedit;
	}
	 
	public java.util.Date getDateedit() {
		return this.dateedit;
	}
	 
	public void setValue(java.lang.String value) {
		this.value = value;
	}
	 
	public java.lang.String getValue() {
		return this.value;
	}
	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}
	 
	public java.lang.String getMemo() {
		return this.memo;
	}
}
