package com.ccrm.entity;

import com.ccrm.entity.BaseEntity;

public class TirClassimage extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:培训班级pkid     
     * @字段:IDXID NUMBER(22)  
     */	
	private Long idxid;

	/**
     * @备注:附件文件的扩展名     
     * @字段:FILEEXP VARCHAR2(50)  
     */	
	private java.lang.String fileexp;

	/**
     * @备注:     
     * @字段:VALUE BLOB(4000)  
     */	
	private String value;

	/**
     * @备注:状态：-1——删除；1——正常     
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
	public TirClassimage(){
	}

	public TirClassimage(
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
