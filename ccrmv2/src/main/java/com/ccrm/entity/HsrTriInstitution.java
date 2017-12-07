package com.ccrm.entity;

import com.ccrm.entity.BaseEntity;

public class HsrTriInstitution extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:主键     
     * @字段:PKID NUMBER(20)  
     */	
	private Long pkid;

	/**
     * @备注:企业类别(1:高等院校，2：技工技校、职业学院、培训机构，3：企业内设培训机构)     
     * @字段:TYPE VARCHAR2(4)  
     */	
	private java.lang.String type;

	/**
     * @备注:     
     * @字段:ORGANID VARCHAR2(50)  
     */	
	private java.lang.String organid;

	/**
     * @备注:     
     * @字段:BRANCHID VARCHAR2(50)  
     */	
	private java.lang.String branchid;

	/**
     * @备注:法人代表     
     * @字段:CORPPERSON VARCHAR2(20)  
     */	
	private java.lang.String corpperson;

	/**
     * @备注:法人代码     
     * @字段:CORPCODE VARCHAR2(60)  
     */	
	private java.lang.String corpcode;

	/**
     * @备注:法人电话     
     * @字段:CORPPHONE VARCHAR2(20)  
     */	
	private java.lang.String corpphone;

	/**
     * @备注:联系人姓名     
     * @字段:CONTACTNAME VARCHAR2(10)  
     */	
	private java.lang.String contactname;

	/**
     * @备注:联系人电话     
     * @字段:CONTACTPHONE VARCHAR2(20)  
     */	
	private java.lang.String contactphone;

	/**
     * @备注:成立时间     
     * @字段:ESTABLISHED DATE(7)  
     */	
	private java.util.Date established;

	/**
     * @备注:开设的专业名称     
     * @字段:PROFESSIONAME VARCHAR2(50)  
     */	
	private java.lang.String professioname;

	/**
     * @备注:稳定合作关系的企业名称     
     * @字段:RELATIONSHIPENTERPRISE VARCHAR2(500)  
     */	
	private java.lang.String relationshipenterprise;

	/**
     * @备注:稳定合作关系的家政企业名称     
     * @字段:RELATIONSHIPDOMENTERPRIS VARCHAR2(500)  
     */	
	private java.lang.String relationshipdomenterpris;

	/**
     * @备注:师资总数     
     * @字段:TEACHER NUMBER(10)  
     */	
	private java.lang.Long teacher;

	/**
     * @备注:全职教师人数     
     * @字段:FULLTIMETEACHER NUMBER(10)  
     */	
	private java.lang.Long fulltimeteacher;

	/**
     * @备注:兼职教师人数     
     * @字段:PARTTIMETEACHER NUMBER(10)  
     */	
	private java.lang.Long parttimeteacher;

	/**
     * @备注:具有高级职称的教师人数     
     * @字段:SENIORTITLETEACHER NUMBER(10)  
     */	
	private java.lang.Long seniortitleteacher;

	/**
     * @备注:当年培养的毕业生人数     
     * @字段:GRADUATE NUMBER(10)  
     */	
	private java.lang.Long graduate;

	/**
     * @备注:通过职业技能鉴定的人数     
     * @字段:THRIDENTIFY NUMBER(10)  
     */	
	private java.lang.Long thridentify;

	/**
     * @备注:毕业后当年实现的就业人数     
     * @字段:YEAREMPLOYMENT NUMBER(10)  
     */	
	private java.lang.Long yearemployment;

	/**
     * @备注:培训后合格人数     
     * @字段:PASSTRAINING NUMBER(10)  
     */	
	private java.lang.Long passtraining;

	/**
     * @备注:共建培训实习基地名称     
     * @字段:TRAININGPLACE VARCHAR2(200)  
     */	
	private java.lang.String trainingplace;

	/**
     * @备注:本企业员工技能提升培训人数     
     * @字段:EMPLOYEETRAINING NUMBER(10)  
     */	
	private java.lang.Long employeetraining;

	/**
     * @备注:备注     
     * @字段:MEMO VARCHAR2(200)  
     */	
	private java.lang.String memo;

	/**
     * @备注:     
     * @字段:ADDTIME DATE(7)  
     */	
	private java.util.Date addtime;

	/**
     * @备注:     
     * @字段:UPDATETIME DATE(7)  
     */	
	private java.util.Date updatetime;

	/**
     * @备注:养老护理师资数     
     * @字段:YLHL_TEACHER NUMBER(10)  
     */	
	private java.lang.Long ylhlTeacher;

	/**
     * @备注:病患陪护师资数     
     * @字段:BHPH_TEACHER NUMBER(10)  
     */	
	private java.lang.Long bhphTeacher;

	/**
     * @备注:社区照料师资数     
     * @字段:SQZL_TEACHER NUMBER(10)  
     */	
	private java.lang.Long sqzlTeacher;

	/**
     * @备注:其他业态师资数     
     * @字段:QTYT_TEACHER NUMBER(10)  
     */	
	private java.lang.Long qtytTeacher;

	/**
     * @备注:家政服务师资数     
     * @字段:JZFW_TEACHER NUMBER(10)  
     */	
	private java.lang.Long jzfwTeacher;

	public HsrTriInstitution(
	){
	}

	public void setPkid(Long pkid) {
		this.pkid = pkid;
	}
	 
	public Long getPkid() {
		return this.pkid;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	 
	public java.lang.String getType() {
		return this.type;
	}
	public void setOrganid(java.lang.String organid) {
		this.organid = organid;
	}
	 
	public java.lang.String getOrganid() {
		return this.organid;
	}
	public void setBranchid(java.lang.String branchid) {
		this.branchid = branchid;
	}
	 
	public java.lang.String getBranchid() {
		return this.branchid;
	}
	public void setCorpperson(java.lang.String corpperson) {
		this.corpperson = corpperson;
	}
	 
	public java.lang.String getCorpperson() {
		return this.corpperson;
	}
	public void setCorpcode(java.lang.String corpcode) {
		this.corpcode = corpcode;
	}
	 
	public java.lang.String getCorpcode() {
		return this.corpcode;
	}
	public void setCorpphone(java.lang.String corpphone) {
		this.corpphone = corpphone;
	}
	 
	public java.lang.String getCorpphone() {
		return this.corpphone;
	}
	public void setContactname(java.lang.String contactname) {
		this.contactname = contactname;
	}
	 
	public java.lang.String getContactname() {
		return this.contactname;
	}
	public void setContactphone(java.lang.String contactphone) {
		this.contactphone = contactphone;
	}
	 
	public java.lang.String getContactphone() {
		return this.contactphone;
	}
	public void setEstablished(java.util.Date established) {
		this.established = established;
	}
	 
	public java.util.Date getEstablished() {
		return this.established;
	}
	 
	public void setProfessioname(java.lang.String professioname) {
		this.professioname = professioname;
	}
	 
	public java.lang.String getProfessioname() {
		return this.professioname;
	}
	public void setRelationshipenterprise(java.lang.String relationshipenterprise) {
		this.relationshipenterprise = relationshipenterprise;
	}
	 
	public java.lang.String getRelationshipenterprise() {
		return this.relationshipenterprise;
	}
	public void setRelationshipdomenterpris(java.lang.String relationshipdomenterpris) {
		this.relationshipdomenterpris = relationshipdomenterpris;
	}
	 
	public java.lang.String getRelationshipdomenterpris() {
		return this.relationshipdomenterpris;
	}
	public void setTeacher(java.lang.Long teacher) {
		this.teacher = teacher;
	}
	 
	public java.lang.Long getTeacher() {
		return this.teacher;
	}
	public void setFulltimeteacher(java.lang.Long fulltimeteacher) {
		this.fulltimeteacher = fulltimeteacher;
	}
	 
	public java.lang.Long getFulltimeteacher() {
		return this.fulltimeteacher;
	}
	public void setParttimeteacher(java.lang.Long parttimeteacher) {
		this.parttimeteacher = parttimeteacher;
	}
	 
	public java.lang.Long getParttimeteacher() {
		return this.parttimeteacher;
	}
	public void setSeniortitleteacher(java.lang.Long seniortitleteacher) {
		this.seniortitleteacher = seniortitleteacher;
	}
	 
	public java.lang.Long getSeniortitleteacher() {
		return this.seniortitleteacher;
	}
	public void setGraduate(java.lang.Long graduate) {
		this.graduate = graduate;
	}
	 
	public java.lang.Long getGraduate() {
		return this.graduate;
	}
	public void setThridentify(java.lang.Long thridentify) {
		this.thridentify = thridentify;
	}
	 
	public java.lang.Long getThridentify() {
		return this.thridentify;
	}
	public void setYearemployment(java.lang.Long yearemployment) {
		this.yearemployment = yearemployment;
	}
	 
	public java.lang.Long getYearemployment() {
		return this.yearemployment;
	}
	public void setPasstraining(java.lang.Long passtraining) {
		this.passtraining = passtraining;
	}
	 
	public java.lang.Long getPasstraining() {
		return this.passtraining;
	}
	public void setTrainingplace(java.lang.String trainingplace) {
		this.trainingplace = trainingplace;
	}
	 
	public java.lang.String getTrainingplace() {
		return this.trainingplace;
	}
	public void setEmployeetraining(java.lang.Long employeetraining) {
		this.employeetraining = employeetraining;
	}
	 
	public java.lang.Long getEmployeetraining() {
		return this.employeetraining;
	}
	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}
	 
	public java.lang.String getMemo() {
		return this.memo;
	}
	public void setAddtime(java.util.Date addtime) {
		this.addtime = addtime;
	}
	 
	public java.util.Date getAddtime() {
		return this.addtime;
	}
	 
	public void setUpdatetime(java.util.Date updatetime) {
		this.updatetime = updatetime;
	}
	 
	public java.util.Date getUpdatetime() {
		return this.updatetime;
	}
	 
	public void setYlhlTeacher(java.lang.Long ylhlTeacher) {
		this.ylhlTeacher = ylhlTeacher;
	}
	 
	public java.lang.Long getYlhlTeacher() {
		return this.ylhlTeacher;
	}
	public void setBhphTeacher(java.lang.Long bhphTeacher) {
		this.bhphTeacher = bhphTeacher;
	}
	 
	public java.lang.Long getBhphTeacher() {
		return this.bhphTeacher;
	}
	public void setSqzlTeacher(java.lang.Long sqzlTeacher) {
		this.sqzlTeacher = sqzlTeacher;
	}
	 
	public java.lang.Long getSqzlTeacher() {
		return this.sqzlTeacher;
	}
	public void setQtytTeacher(java.lang.Long qtytTeacher) {
		this.qtytTeacher = qtytTeacher;
	}
	 
	public java.lang.Long getQtytTeacher() {
		return this.qtytTeacher;
	}
	public void setJzfwTeacher(java.lang.Long jzfwTeacher) {
		this.jzfwTeacher = jzfwTeacher;
	}
	 
	public java.lang.Long getJzfwTeacher() {
		return this.jzfwTeacher;
	}
}
