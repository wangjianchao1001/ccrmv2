package com.ccrm.entity;

import com.ccrm.entity.BaseEntity;

public class HsrTrinsStudent extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:     
     * @字段:PKID NUMBER(20)  
     */	
	private Long pkid;

	/**
     * @备注:姓名     
     * @字段:NAME VARCHAR2(12)  
     */	
	private java.lang.String name;

	/**
     * @备注:性别     
     * @字段:SEXUAL VARCHAR2(4)  
     */	
	private java.lang.String sexual;

	/**
     * @备注:年龄     
     * @字段:AGE NUMBER(4)  
     */	
	private Integer age;

	/**
     * @备注:身份证号     
     * @字段:IDNUMBER VARCHAR2(20)  
     */	
	private java.lang.String idnumber;

	/**
     * @备注:培训年度     
     * @字段:TRIAINYEAR VARCHAR2(10)  
     */	
	private java.lang.String triainyear;

	/**
     * @备注:培训时间     
     * @字段:TRAINTIME DATE(7)  
     */	
	private java.util.Date traintime;

	/**
     * @备注:培训专业（1：家政服务，2：养老护理，3：病患陪护，4：社区照料，5：其他业态）     
     * @字段:TRAINPROF VARCHAR2(4)  
     */	
	private java.lang.String trainprof;

	/**
     * @备注:培训期次     
     * @字段:TRAINPERIOD VARCHAR2(20)  
     */	
	private java.lang.String trainperiod;

	/**
     * @备注:专业等级     
     * @字段:PROFLEVEL VARCHAR2(20)  
     */	
	private java.lang.String proflevel;

	/**
     * @备注:家庭住址     
     * @字段:FAMADDRESS VARCHAR2(100)  
     */	
	private java.lang.String famaddress;

	/**
     * @备注:联系方式     
     * @字段:PHONE VARCHAR2(20)  
     */	
	private java.lang.String phone;

	/**
     * @备注:是否通过职业技能鉴定(0：否，1：是)     
     * @字段:ISPASSIDENTIFY NUMBER(4)  
     */	
	private Integer ispassidentify;

	/**
     * @备注:是否培训合格(0：否，1：是)     
     * @字段:ISTRAINQUALIFY NUMBER(4)  
     */	
	private Integer istrainqualify;

	/**
     * @备注:备注     
     * @字段:MEMO VARCHAR2(200)  
     */	
	private java.lang.String memo;

	/**
     * @备注:培训企业pkid     
     * @字段:INSTPKID NUMBER(20)  
     */	
	private Long instpkid;

	/**
     * @备注:     
     * @字段:BRANCHID VARCHAR2(100)  
     */	
	private java.lang.String branchid;
	private java.lang.String orgName;
	public HsrTrinsStudent(){
	}

	public HsrTrinsStudent(
		Long pkid
	){
		this.pkid = pkid;
	}

	public void setPkid(Long pkid) {
		this.pkid = pkid;
	}
	 
	public Long getPkid() {
		return this.pkid;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	 
	public java.lang.String getName() {
		return this.name;
	}
	public void setSexual(java.lang.String sexual) {
		this.sexual = sexual;
	}
	 
	public java.lang.String getSexual() {
		return this.sexual;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	 
	public Integer getAge() {
		return this.age;
	}
	public void setIdnumber(java.lang.String idnumber) {
		this.idnumber = idnumber;
	}
	 
	public java.lang.String getIdnumber() {
		return this.idnumber;
	}
	public void setTriainyear(java.lang.String triainyear) {
		this.triainyear = triainyear;
	}
	 
	public java.lang.String getTriainyear() {
		return this.triainyear;
	}
	public void setTraintime(java.util.Date traintime) {
		this.traintime = traintime;
	}
	 
	public java.util.Date getTraintime() {
		return this.traintime;
	}
	 
	public void setTrainprof(java.lang.String trainprof) {
		this.trainprof = trainprof;
	}
	 
	public java.lang.String getTrainprof() {
		return this.trainprof;
	}
	public void setTrainperiod(java.lang.String trainperiod) {
		this.trainperiod = trainperiod;
	}
	 
	public java.lang.String getTrainperiod() {
		return this.trainperiod;
	}
	public void setProflevel(java.lang.String proflevel) {
		this.proflevel = proflevel;
	}
	 
	public java.lang.String getProflevel() {
		return this.proflevel;
	}
	public void setFamaddress(java.lang.String famaddress) {
		this.famaddress = famaddress;
	}
	 
	public java.lang.String getFamaddress() {
		return this.famaddress;
	}
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}
	 
	public java.lang.String getPhone() {
		return this.phone;
	}
	public void setIspassidentify(Integer ispassidentify) {
		this.ispassidentify = ispassidentify;
	}
	 
	public Integer getIspassidentify() {
		return this.ispassidentify;
	}
	public void setIstrainqualify(Integer istrainqualify) {
		this.istrainqualify = istrainqualify;
	}
	 
	public Integer getIstrainqualify() {
		return this.istrainqualify;
	}
	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}
	 
	public java.lang.String getMemo() {
		return this.memo;
	}
	public void setInstpkid(Long instpkid) {
		this.instpkid = instpkid;
	}
	 
	public Long getInstpkid() {
		return this.instpkid;
	}
	public void setBranchid(java.lang.String branchid) {
		this.branchid = branchid;
	}
	 
	public java.lang.String getBranchid() {
		return this.branchid;
	}

	public java.lang.String getOrgName() {
		return orgName;
	}

	public void setOrgName(java.lang.String orgName) {
		this.orgName = orgName;
	}
	
}
