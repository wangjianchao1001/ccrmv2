package com.ccrm.entity;

import com.ccrm.entity.BaseEntity;

public class RegOrganaffixblb extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

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
     * @字段:FILEAME VARCHAR2(500)  
     */	
	private java.lang.String fileame;

	/**
     * @备注:     
     * @字段:FILEEXP VARCHAR2(500)  
     */	
	private java.lang.String fileexp;

	/**
     * @备注:附加大对象值（二进制）     
     * @字段:VALUE BLOB(4000)  
     */	
	private String value;

	/**
     * @备注:     
     * @字段:STATUS NUMBER(22)  
     */	
	private Long status;

	/**
     * @备注:图片存放位置和名称     
     * @字段:BIGPICTRUE VARCHAR2(500)  
     */	
	private java.lang.String bigpictrue;

	/**
     * @备注:缩略图存放位置和名称     
     * @字段:SMALLPICTRUE VARCHAR2(500)  
     */	
	private java.lang.String smallpictrue;

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
     * @备注:     
     * @字段:MEMO VARCHAR2(4000)  
     */	
	private java.lang.String memo;

	/**
     * @备注:     
     * @字段:PKID NUMBER(20)  
     */	
	private Long pkid;
	public RegOrganaffixblb(){
	}

	public RegOrganaffixblb(
		Long pkid
	){
		this.pkid = pkid;
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
	public void setFileame(java.lang.String fileame) {
		this.fileame = fileame;
	}
	 
	public java.lang.String getFileame() {
		return this.fileame;
	}
	public void setFileexp(java.lang.String fileexp) {
		this.fileexp = fileexp;
	}
	 
	public java.lang.String getFileexp() {
		return this.fileexp;
	}
	public void setValue(String value) {
		this.value = value;
	}
	 
	public String getValue() {
		return this.value;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	 
	public Long getStatus() {
		return this.status;
	}
	public void setBigpictrue(java.lang.String bigpictrue) {
		this.bigpictrue = bigpictrue;
	}
	 
	public java.lang.String getBigpictrue() {
		return this.bigpictrue;
	}
	public void setSmallpictrue(java.lang.String smallpictrue) {
		this.smallpictrue = smallpictrue;
	}
	 
	public java.lang.String getSmallpictrue() {
		return this.smallpictrue;
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
	 
	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}
	 
	public java.lang.String getMemo() {
		return this.memo;
	}
	public void setPkid(Long pkid) {
		this.pkid = pkid;
	}
	 
	public Long getPkid() {
		return this.pkid;
	}
}
