package com.ccrm.entity;

import com.ccrm.entity.BaseEntity;

public class SysDictionary extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:字典分类主码     
     * @字段:IDXID NUMBER(22)  
     */	
	private Long idxid;

	/**
     * @备注:显示序号，每个分类单独维护     
     * @字段:SEQNO NUMBER(22)  
     */	
	private Long seqno;

	/**
     * @备注:字典项字符串编码     
     * @字段:CODEID VARCHAR2(20)  
     */	
	private java.lang.String codeid;

	/**
     * @备注:字典项名称     
     * @字段:NAME VARCHAR2(50)  
     */	
	private java.lang.String name;

	/**
     * @备注:字典项简称     
     * @字段:SNAME VARCHAR2(30)  
     */	
	private java.lang.String sname;

	/**
     * @备注:状态：1——正常；2——冻结；-1——作废     
     * @字段:STATUS NUMBER(22)  
     */	
	private Long status;

	/**
     * @备注:记录新建时间     
     * @字段:DATENEW TIMESTAMP(6)(11)  
     */	
	private java.util.Date datenew;

	/**
     * @备注:记录修改时间     
     * @字段:DATEEDIT TIMESTAMP(6)(11)  
     */	
	private java.util.Date dateedit;

	/**
     * @备注:字典项备注     
     * @字段:MEMO VARCHAR2(4000)  
     */	
	private java.lang.String memo;

	/**
     * @备注:     
     * @字段:PKID NUMBER(20)  
     */	
	private Long pkid;
	
	private String ppkid;
	
	public SysDictionary(){
	}

	public SysDictionary(
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
	public void setSeqno(Long seqno) {
		this.seqno = seqno;
	}
	 
	public Long getSeqno() {
		return this.seqno;
	}
	public void setCodeid(java.lang.String codeid) {
		this.codeid = codeid;
	}
	 
	public java.lang.String getCodeid() {
		return this.codeid;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	 
	public java.lang.String getName() {
		return this.name;
	}
	public void setSname(java.lang.String sname) {
		this.sname = sname;
	}
	 
	public java.lang.String getSname() {
		return this.sname;
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

	public String getPpkid() {
		return ppkid;
	}

	public void setPpkid(String ppkid) {
		this.ppkid = ppkid;
	}
	
}
