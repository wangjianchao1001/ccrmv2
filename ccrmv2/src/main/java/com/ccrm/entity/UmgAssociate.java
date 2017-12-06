package com.ccrm.entity;

import java.util.Date;

public class UmgAssociate extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:分类ID     
     * @字段:CLASID NUMBER(22)  
     */	
	private Long clasid;

	/**
     * @备注:关联子项ID（eg:权限）     
     * @字段:ASSID NUMBER(22)  
     */	
	private Long assid;

	/**
     * @备注:记录新建时间     
     * @字段:DATENEW TIMESTAMP(6) WITH TIME ZONE(13)  
     */	
	private Date datenew;

	/**
     * @备注:记录修改时间     
     * @字段:DATEEDIT TIMESTAMP(6) WITH TIME ZONE(13)  
     */	
	private Date dateedit;

	/**
     * @备注:     
     * @字段:OPERATOR BLOB(4000)  
     */	
	private String operator;

	/**
     * @备注:     
     * @字段:UMGBRANCH BLOB(4000)  
     */	
	private String umgbranch;

	/**
     * @备注:     
     * @字段:PKID NUMBER(20)  
     */	
	private Long pkid;

	/**
     * @备注:eg：人员id     
     * @字段:SUBID VARCHAR2(40)  
     */	
	private java.lang.String subid;
	public UmgAssociate(){
	}

	public UmgAssociate(
		Long pkid
	){
		this.pkid = pkid;
	}

	public void setClasid(Long clasid) {
		this.clasid = clasid;
	}
	 
	public Long getClasid() {
		return this.clasid;
	}
	public void setAssid(Long assid) {
		this.assid = assid;
	}
	 
	public Long getAssid() {
		return this.assid;
	}

	public Date getDatenew() {
		return datenew;
	}

	public void setDatenew(Date datenew) {
		this.datenew = datenew;
	}

	public Date getDateedit() {
		return dateedit;
	}

	public void setDateedit(Date dateedit) {
		this.dateedit = dateedit;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	 
	public String getOperator() {
		return this.operator;
	}
	public void setUmgbranch(String umgbranch) {
		this.umgbranch = umgbranch;
	}
	 
	public String getUmgbranch() {
		return this.umgbranch;
	}
	public void setPkid(Long pkid) {
		this.pkid = pkid;
	}
	 
	public Long getPkid() {
		return this.pkid;
	}
	public void setSubid(java.lang.String subid) {
		this.subid = subid;
	}
	 
	public java.lang.String getSubid() {
		return this.subid;
	}
}
