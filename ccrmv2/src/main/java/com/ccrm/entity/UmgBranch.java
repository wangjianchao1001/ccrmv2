package com.ccrm.entity;

import com.ccrm.entity.BaseEntity;

public class UmgBranch extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:父机构主码     
     * @字段:PPKID NUMBER(22)  
     */	
	private Long ppkid;

	/**
     * @备注:部门使用分类：     
     * @字段:KINDID NUMBER(22)  
     */	
	private Long kindid;

	/**
     * @备注:显示序号     
     * @字段:SEQNO NUMBER(22)  
     */	
	private Long seqno;

	/**
     * @备注:机构部门编码     
     * @字段:CID VARCHAR2(10)  
     */	
	private java.lang.String cid;

	/**
     * @备注:备注     
     * @字段:NAME VARCHAR2(30)  
     */	
	private java.lang.String name;

	/**
     * @备注:状态     
     * @字段:STATUS NUMBER(22)  
     */	
	private Long status;

	/**
     * @备注:联系电话     
     * @字段:CELLNO VARCHAR2(50)  
     */	
	private java.lang.String cellno;

	/**
     * @备注:联系人     
     * @字段:CONTACTS VARCHAR2(50)  
     */	
	private java.lang.String contacts;

	/**
     * @备注:记录新建时间     
     * @字段:DATENEW TIMESTAMP(6) WITH TIME ZONE(13)  
     */	
	private java.lang.Object datenew;

	/**
     * @备注:记录修改时间     
     * @字段:DATEEDIT TIMESTAMP(6) WITH TIME ZONE(13)  
     */	
	private java.lang.Object dateedit;

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
	public UmgBranch(){
	}

	public UmgBranch(
		Long pkid
	){
		this.pkid = pkid;
	}

	public void setPpkid(Long ppkid) {
		this.ppkid = ppkid;
	}
	 
	public Long getPpkid() {
		return this.ppkid;
	}
	public void setKindid(Long kindid) {
		this.kindid = kindid;
	}
	 
	public Long getKindid() {
		return this.kindid;
	}
	public void setSeqno(Long seqno) {
		this.seqno = seqno;
	}
	 
	public Long getSeqno() {
		return this.seqno;
	}
	public void setCid(java.lang.String cid) {
		this.cid = cid;
	}
	 
	public java.lang.String getCid() {
		return this.cid;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	 
	public java.lang.String getName() {
		return this.name;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	 
	public Long getStatus() {
		return this.status;
	}
	public void setCellno(java.lang.String cellno) {
		this.cellno = cellno;
	}
	 
	public java.lang.String getCellno() {
		return this.cellno;
	}
	public void setContacts(java.lang.String contacts) {
		this.contacts = contacts;
	}
	 
	public java.lang.String getContacts() {
		return this.contacts;
	}
	public void setDatenew(java.lang.Object datenew) {
		this.datenew = datenew;
	}
	 
	public java.lang.Object getDatenew() {
		return this.datenew;
	}
	public void setDateedit(java.lang.Object dateedit) {
		this.dateedit = dateedit;
	}
	 
	public java.lang.Object getDateedit() {
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
