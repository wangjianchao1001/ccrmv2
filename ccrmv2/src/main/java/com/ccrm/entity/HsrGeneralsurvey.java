package com.ccrm.entity;

import com.ccrm.entity.BaseEntity;

public class HsrGeneralsurvey extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:默认为0，保存着相同身份证号被登记人上一次的登记记录的pkid     
     * @字段:PPKID NUMBER(22)  
     */	
	private Long ppkid;

	/**
     * @备注:管理机构ID     
     * @字段:BRANCHID NUMBER(22)  
     */	
	private Long branchid;

	/**
     * @备注:家庭服务行业项目分类，sys_dictionary.idxid = 80     
     * @字段:SVRITEMID NUMBER(22)  
     */	
	private Long svritemid;

	/**
     * @备注:雇主姓名（户主姓名）     
     * @字段:EMNAME VARCHAR2(50)  
     */	
	private java.lang.String emname;

	/**
     * @备注:雇主联系电话     
     * @字段:EMPHONENO VARCHAR2(30)  
     */	
	private java.lang.String emphoneno;

	/**
     * @备注:姓名     
     * @字段:NAME VARCHAR2(50)  
     */	
	private java.lang.String name;

	/**
     * @备注:身份证号     
     * @字段:IDNO VARCHAR2(20)  
     */	
	private java.lang.String idno;

	/**
     * @备注:联系电话     
     * @字段:PHONENO VARCHAR2(30)  
     */	
	private java.lang.String phoneno;

	/**
     * @备注:入职工作起始时间     
     * @字段:DATEENTRY VARCHAR2(8)  
     */	
	private java.lang.String dateentry;

	/**
     * @备注:离开时间     
     * @字段:DATELEAVE VARCHAR2(8)  
     */	
	private java.lang.String dateleave;

	/**
     * @备注:状态：-1——删除；1——在职；2——完成     
     * @字段:STATUS NUMBER(22)  
     */	
	private Long status;

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
     * @备注:备注     
     * @字段:MEMO VARCHAR2(4000)  
     */	
	private java.lang.String memo;

	/**
     * @备注:     
     * @字段:PKID NUMBER(20)  
     */	
	private Long pkid;
	public HsrGeneralsurvey(){
	}

	public HsrGeneralsurvey(
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
	public void setBranchid(Long branchid) {
		this.branchid = branchid;
	}
	 
	public Long getBranchid() {
		return this.branchid;
	}
	public void setSvritemid(Long svritemid) {
		this.svritemid = svritemid;
	}
	 
	public Long getSvritemid() {
		return this.svritemid;
	}
	public void setEmname(java.lang.String emname) {
		this.emname = emname;
	}
	 
	public java.lang.String getEmname() {
		return this.emname;
	}
	public void setEmphoneno(java.lang.String emphoneno) {
		this.emphoneno = emphoneno;
	}
	 
	public java.lang.String getEmphoneno() {
		return this.emphoneno;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	 
	public java.lang.String getName() {
		return this.name;
	}
	public void setIdno(java.lang.String idno) {
		this.idno = idno;
	}
	 
	public java.lang.String getIdno() {
		return this.idno;
	}
	public void setPhoneno(java.lang.String phoneno) {
		this.phoneno = phoneno;
	}
	 
	public java.lang.String getPhoneno() {
		return this.phoneno;
	}
	public void setDateentry(java.lang.String dateentry) {
		this.dateentry = dateentry;
	}
	 
	public java.lang.String getDateentry() {
		return this.dateentry;
	}
	public void setDateleave(java.lang.String dateleave) {
		this.dateleave = dateleave;
	}
	 
	public java.lang.String getDateleave() {
		return this.dateleave;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	 
	public Long getStatus() {
		return this.status;
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
