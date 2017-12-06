package com.ccrm.entity;

import com.ccrm.entity.BaseEntity;

public class UmgOperator extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:操作员分类：
0、  系统级操作员；
1、  管理机构操作员；
2、  登记机构操作员
     
     * @字段:KINDID NUMBER(22)  
     */	
	private Long kindid;

	/**
     * @备注:管理机构pkid     
     * @字段:BRANCHID NUMBER(22)  
     */	
	private Long branchid;

	/**
     * @备注:登记机构pkid     
     * @字段:ORGANID NUMBER(22)  
     */	
	private Long organid;

	/**
     * @备注:显示序号     
     * @字段:SEQNO NUMBER(22)  
     */	
	private Long seqno;

	/**
     * @备注:操作员登录名     
     * @字段:CID VARCHAR2(50)  
     */	
	private java.lang.String cid;

	/**
     * @备注:姓名     
     * @字段:NAME VARCHAR2(50)  
     */	
	private java.lang.String name;

	/**
     * @备注:姓名PY     
     * @字段:NAMEPY VARCHAR2(150)  
     */	
	private java.lang.String namepy;

	/**
     * @备注:密码     
     * @字段:PASSWORD VARCHAR2(50)  
     */	
	private java.lang.String password;

	/**
     * @备注:角色ID     
     * @字段:ROLEID NUMBER(22)  
     */	
	private Long roleid;

	/**
     * @备注:状态     
     * @字段:STATUS NUMBER(22)  
     */	
	private Long status;

	/**
     * @备注:联系手机     
     * @字段:MOBILECELL VARCHAR2(50)  
     */	
	private java.lang.String mobilecell;

	/**
     * @备注:E_MAIL     
     * @字段:EMAIL VARCHAR2(50)  
     */	
	private java.lang.String email;

	/**
     * @备注:记录新建时间     
     * @字段:DATENEW DATE(7)  
     */	
	private java.util.Date datenew;

	/**
     * @备注:记录修改时间     
     * @字段:DATEEDIT DATE(7)  
     */	
	private java.util.Date dateedit;

	/**
     * @备注:是否为初始化密码（默认是1）
0——否；1——是
初始化密码为“888888”，用户首次登录的时候必须修改密码，修改后设置为0，用户的密码起效
     
     * @字段:ISINITPASSWORD NUMBER(22)  
     */	
	private Long isinitpassword;

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
	public UmgOperator(){
	}

	public UmgOperator(
		Long pkid
	){
		this.pkid = pkid;
	}

	public void setKindid(Long kindid) {
		this.kindid = kindid;
	}
	 
	public Long getKindid() {
		return this.kindid;
	}
	public void setBranchid(Long branchid) {
		this.branchid = branchid;
	}
	 
	public Long getBranchid() {
		return this.branchid;
	}
	public void setOrganid(Long organid) {
		this.organid = organid;
	}
	 
	public Long getOrganid() {
		return this.organid;
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
	public void setNamepy(java.lang.String namepy) {
		this.namepy = namepy;
	}
	 
	public java.lang.String getNamepy() {
		return this.namepy;
	}
	public void setPassword(java.lang.String password) {
		this.password = password;
	}
	 
	public java.lang.String getPassword() {
		return this.password;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	 
	public Long getRoleid() {
		return this.roleid;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	 
	public Long getStatus() {
		return this.status;
	}
	public void setMobilecell(java.lang.String mobilecell) {
		this.mobilecell = mobilecell;
	}
	 
	public java.lang.String getMobilecell() {
		return this.mobilecell;
	}
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	 
	public java.lang.String getEmail() {
		return this.email;
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
	 
	public void setIsinitpassword(Long isinitpassword) {
		this.isinitpassword = isinitpassword;
	}
	 
	public Long getIsinitpassword() {
		return this.isinitpassword;
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
