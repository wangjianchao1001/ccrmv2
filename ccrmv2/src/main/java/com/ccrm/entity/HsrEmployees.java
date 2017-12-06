package com.ccrm.entity;

import com.ccrm.entity.BaseEntity;

public class HsrEmployees extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:所属家庭服务业企业ID     
     * @字段:ORGANID NUMBER(22)  
     */	
	private Long organid;

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
     * @备注:EMail     
     * @字段:EMAIL VARCHAR2(200)  
     */	
	private java.lang.String email;

	/**
     * @备注:入职日期     
     * @字段:DATEENTRY CHAR(8)  
     */	
	private java.lang.String dateentry;

	/**
     * @备注:离职日期     
     * @字段:DATELEAVE CHAR(8)  
     */	
	private java.lang.String dateleave;

	/**
     * @备注:HTML格式的培训证明，可以内嵌照片     
     * @字段:TRAINCONTENT BLOB(4000)  
     */	
	private String traincontent;

	/**
     * @备注:HTML证书，可以内嵌照片     
     * @字段:CERTIFICATE BLOB(4000)  
     */	
	private String certificate;

	/**
     * @备注:状态：-1——删除；1——在职；2——离职     
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
     * @备注:培训简述，点击可以查询traincontent     
     * @字段:TRAINMEMO VARCHAR2(4000)  
     */	
	private java.lang.String trainmemo;

	/**
     * @备注:证书简述，点击可以查询certificate     
     * @字段:CERMEMO VARCHAR2(4000)  
     */	
	private java.lang.String cermemo;

	/**
     * @备注:memo     
     * @字段:MEMO VARCHAR2(4000)  
     */	
	private java.lang.String memo;

	/**
     * @备注:     
     * @字段:PKID NUMBER(20)  
     */	
	private Long pkid;
	public HsrEmployees(){
	}

	public HsrEmployees(
		Long pkid
	){
		this.pkid = pkid;
	}

	public void setOrganid(Long organid) {
		this.organid = organid;
	}
	 
	public Long getOrganid() {
		return this.organid;
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
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	 
	public java.lang.String getEmail() {
		return this.email;
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
	public void setTraincontent(String traincontent) {
		this.traincontent = traincontent;
	}
	 
	public String getTraincontent() {
		return this.traincontent;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	 
	public String getCertificate() {
		return this.certificate;
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
	public void setTrainmemo(java.lang.String trainmemo) {
		this.trainmemo = trainmemo;
	}
	 
	public java.lang.String getTrainmemo() {
		return this.trainmemo;
	}
	public void setCermemo(java.lang.String cermemo) {
		this.cermemo = cermemo;
	}
	 
	public java.lang.String getCermemo() {
		return this.cermemo;
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
