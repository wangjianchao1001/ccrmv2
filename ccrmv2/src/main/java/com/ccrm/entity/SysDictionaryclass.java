package com.ccrm.entity;

import com.ccrm.entity.BaseEntity;

public class SysDictionaryclass extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:维护分类：0——系统级不可维护；1——操作员可以维护     
     * @字段:KINDID NUMBER(22)  
     */	
	private Long kindid;

	/**
     * @备注:显示序号     
     * @字段:SEQNO NUMBER(22)  
     */	
	private Long seqno;

	/**
     * @备注:分类名称     
     * @字段:NAME VARCHAR2(50)  
     */	
	private java.lang.String name;

	/**
     * @备注:分类备注     
     * @字段:MEMO VARCHAR2(4000)  
     */	
	private java.lang.String memo;

	/**
     * @备注:     
     * @字段:PKID NUMBER(20)  
     */	
	private Long pkid;
	public SysDictionaryclass(){
	}

	public SysDictionaryclass(
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
	public void setSeqno(Long seqno) {
		this.seqno = seqno;
	}
	 
	public Long getSeqno() {
		return this.seqno;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	 
	public java.lang.String getName() {
		return this.name;
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
