package com.ccrm.entity;

import com.ccrm.entity.BaseEntity;

public class PmpMessge extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:信息分类sys_dictionary.pkid ， idxid = 50     
     * @字段:KINDID NUMBER(22)  
     */	
	private Long kindid;

	/**
     * @备注:0：主页显示；1：置顶；2：取消置顶
主页显示用于在主页直接显示内容，比如通知，注意事项等等     
     * @字段:ISSTICK NUMBER(22)  
     */	
	private Long isstick;

	/**
     * @备注:显示序号     
     * @字段:SEQNO NUMBER(22)  
     */	
	private Long seqno;

	/**
     * @备注:标题     
     * @字段:TITLE VARCHAR2(500)  
     */	
	private java.lang.String title;

	/**
     * @备注:HTM正文内容，以大对象方式保存     
     * @字段:TEXTBODY BLOB(4000)  
     */	
	private String textbody;

	/**
     * @备注:发布单位     
     * @字段:UNITPOST VARCHAR2(50)  
     */	
	private java.lang.String unitpost;

	/**
     * @备注:界面可以设置发布时间，指的是信息的发布日期，非记录的发布日期     
     * @字段:DATEPOST CHAR(8)  
     */	
	private java.lang.String datepost;

	/**
     * @备注:创建操作员     
     * @字段:CROPPERID NUMBER(22)  
     */	
	private Long cropperid;

	/**
     * @备注:发布操作员     
     * @字段:CMOPERID NUMBER(22)  
     */	
	private Long cmoperid;

	/**
     * @备注:记录的发布时间     
     * @字段:CMDATE CHAR(14)  
     */	
	private java.lang.String cmdate;

	/**
     * @备注:记录状态
?  -1：删除；
?  1：正常；
?  0：新建（新建的前台界面是不可见的）；
?  2：冻结，冻结后后台可见但是前台是不可见的。
     
     * @字段:STATUS NUMBER(22)  
     */	
	private Long status;

	/**
     * @备注:记录Insert日期     
     * @字段:DATENEW TIMESTAMP(6) WITH TIME ZONE(13)  
     */	
	private java.lang.Object datenew;

	/**
     * @备注:记录Update日期     
     * @字段:DATEEDIT TIMESTAMP(6) WITH TIME ZONE(13)  
     */	
	private java.lang.Object dateedit;

	/**
     * @备注:     
     * @字段:PKID NUMBER(20)  
     */	
	private Long pkid;
	public PmpMessge(){
	}

	public PmpMessge(
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
	public void setIsstick(Long isstick) {
		this.isstick = isstick;
	}
	 
	public Long getIsstick() {
		return this.isstick;
	}
	public void setSeqno(Long seqno) {
		this.seqno = seqno;
	}
	 
	public Long getSeqno() {
		return this.seqno;
	}
	public void setTitle(java.lang.String title) {
		this.title = title;
	}
	 
	public java.lang.String getTitle() {
		return this.title;
	}
	public void setTextbody(String textbody) {
		this.textbody = textbody;
	}
	 
	public String getTextbody() {
		return this.textbody;
	}
	public void setUnitpost(java.lang.String unitpost) {
		this.unitpost = unitpost;
	}
	 
	public java.lang.String getUnitpost() {
		return this.unitpost;
	}
	public void setDatepost(java.lang.String datepost) {
		this.datepost = datepost;
	}
	 
	public java.lang.String getDatepost() {
		return this.datepost;
	}
	public void setCropperid(Long cropperid) {
		this.cropperid = cropperid;
	}
	 
	public Long getCropperid() {
		return this.cropperid;
	}
	public void setCmoperid(Long cmoperid) {
		this.cmoperid = cmoperid;
	}
	 
	public Long getCmoperid() {
		return this.cmoperid;
	}
	public void setCmdate(java.lang.String cmdate) {
		this.cmdate = cmdate;
	}
	 
	public java.lang.String getCmdate() {
		return this.cmdate;
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
	public void setPkid(Long pkid) {
		this.pkid = pkid;
	}
	 
	public Long getPkid() {
		return this.pkid;
	}
}
