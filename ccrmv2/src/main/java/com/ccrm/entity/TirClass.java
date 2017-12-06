package com.ccrm.entity;

import com.ccrm.util.excelExport.ExcelResources;

public class TirClass extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:所属培训机构     
     * @字段:ORGID NUMBER(22)  
     */	
	private Long orgid;

	/**
     * @备注:培训班分类：
6001——就业培训班；6002——创业培训班
     
     * @字段:KINDID NUMBER(22)  
     */	
	private Long kindid;

	/**
     * @备注:培训班专业名称或者是培训类型，如果kindid=6001则应用字典表中sys_dictionary.idxid=61下的字典项；如果kindid=6002则引用字典表中sys_dictionary.idxid=65下的字典项     
     * @字段:CAREERID NUMBER(22)  
     */	
	private Long careerid;
	
	/**
	 */	
	private String careerName;

	/**
     * @备注:培训等级（就业培训班专用）     
     * @字段:GRADEID NUMBER(22)  
     */	
	private Long gradeid;

	/**
     * @备注:开班时间（存储yyyyMMdd导出yyyy-MM-dd）     
     * @字段:DATEBEGIN CHAR(8)  
     */	
	private java.lang.String datebegin;

	/**
     * @备注:结课时间（存储yyyyMMdd导出yyyy-MM-dd）     
     * @字段:DATEEND CHAR(8)  
     */	
	private java.lang.String dateend;

	/**
     * @备注:期限ID，如果kindid=6001，则引用sys_dictionary.idxid=63中的字典项，如果kindid=6002，则引用sys_dictionary.idxid=66中的字典项     
     * @字段:TERMID NUMBER(22)  
     */	
	private Long termid;

	/**
     * @备注:联系人     
     * @字段:LINKMAN VARCHAR2(50)  
     */	
	private java.lang.String linkman;

	/**
     * @备注:联系电话     
     * @字段:PHONENO VARCHAR2(50)  
     */	
	private java.lang.String phoneno;

	/**
     * @备注:授课老师或者班主任姓名     
     * @字段:TEACHERNAME VARCHAR2(50)  
     */	
	private java.lang.String teachername;

	/**
     * @备注:课时安排     
     * @字段:TIMES VARCHAR2(100)  
     */	
	private java.lang.String times;

	/**
     * @备注:授课地点     
     * @字段:TEACHADDRESS VARCHAR2(100)  
     */	
	private java.lang.String teachaddress;

	/**
     * @备注:授课内容     
     * @字段:TEACHCONTENT VARCHAR2(100)  
     */	
	private java.lang.String teachcontent;

	/**
     * @备注:理论课时     
     * @字段:TIMESTHEORY VARCHAR2(50)  
     */	
	private java.lang.String timestheory;

	/**
     * @备注:实操课时     
     * @字段:TIMESWORK VARCHAR2(50)  
     */	
	private java.lang.String timeswork;

	/**
     * @备注:使用教材     
     * @字段:TEACHMATERIAL VARCHAR2(100)  
     */	
	private java.lang.String teachmaterial;

	/**
     * @备注:开班申请日期（存储yyyyMMdd导出yyyy-MM-dd）     
     * @字段:BDATEAPP CHAR(8)  
     */	
	private java.lang.String bdateapp;

	/**
     * @备注:开班审批情况，idxid = 67     
     * @字段:BAPPID NUMBER(22)  
     */	
	private Long bappid;

	/**
     * @备注:开班审批日期（存储yyyyMMdd导出yyyy-MM-dd）     
     * @字段:BDATEAPR CHAR(8)  
     */	
	private java.lang.String bdateapr;

	/**
     * @备注:开班审批人     
     * @字段:BAPRMAN CHAR(50)  
     */	
	private java.lang.String baprman;

	/**
     * @备注:结业申请日期（存储yyyyMMdd导出yyyy-MM-dd）     
     * @字段:EDATEAPP CHAR(8)  
     */	
	private java.lang.String edateapp;

	/**
     * @备注:结业审批情况，idxid = 68     
     * @字段:EAPPID NUMBER(22)  
     */	
	private Long eappid;

	/**
     * @备注:结业审批日期（存储yyyyMMdd导出yyyy-MM-dd）     
     * @字段:EDATEAPR CHAR(8)  
     */	
	private java.lang.String edateapr;

	/**
     * @备注:结业审批人     
     * @字段:EAPRMAN VARCHAR2(50)  
     */	
	private java.lang.String eaprman;

	/**
     * @备注:是否特色专业，仅涉及到就业培训班，sys_dictionary.idxid = 64     
     * @字段:ISSPEC NUMBER(22)  
     */	
	private Long isspec;

	/**
     * @备注:EMail     
     * @字段:EMAIL VARCHAR2(200)  
     */	
	private java.lang.String email;

	/**
     * @备注:状态：-1——删除；0——新建（新建后不能马上使用）需要提交；1——已提交；2——已完成（已完成的不能添加学员）     
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
     * @备注: 备注     
     * @字段:MEMO VARCHAR2(4000)  
     */	
	private java.lang.String memo;

	/**
     * @备注:     
     * @字段:PKID NUMBER(20)  
     */	
	private Long pkid;
	public TirClass(){
	}

	public TirClass(
		Long pkid
	){
		this.pkid = pkid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}
	@ExcelResources(title="时间间隔",order=1)
	public Long getOrgid() {
		return this.orgid;
	}
	public void setKindid(Long kindid) {
		this.kindid = kindid;
	}
	 
	public Long getKindid() {
		return this.kindid;
	}
	public void setCareerid(Long careerid) {
		this.careerid = careerid;
	}
	 
	public Long getCareerid() {
		return this.careerid;
	}
	public void setGradeid(Long gradeid) {
		this.gradeid = gradeid;
	}
	 
	public Long getGradeid() {
		return this.gradeid;
	}
	public void setDatebegin(java.lang.String datebegin) {
		this.datebegin = datebegin;
	}
	 
	public java.lang.String getDatebegin() {
		return this.datebegin;
	}
	public void setDateend(java.lang.String dateend) {
		this.dateend = dateend;
	}
	 
	public java.lang.String getDateend() {
		return this.dateend;
	}
	public void setTermid(Long termid) {
		this.termid = termid;
	}
	 
	public Long getTermid() {
		return this.termid;
	}
	public void setLinkman(java.lang.String linkman) {
		this.linkman = linkman;
	}
	 
	public java.lang.String getLinkman() {
		return this.linkman;
	}
	public void setPhoneno(java.lang.String phoneno) {
		this.phoneno = phoneno;
	}
	 
	public java.lang.String getPhoneno() {
		return this.phoneno;
	}
	public void setTeachername(java.lang.String teachername) {
		this.teachername = teachername;
	}
	 
	public java.lang.String getTeachername() {
		return this.teachername;
	}
	public void setTimes(java.lang.String times) {
		this.times = times;
	}
	 
	public java.lang.String getTimes() {
		return this.times;
	}
	public void setTeachaddress(java.lang.String teachaddress) {
		this.teachaddress = teachaddress;
	}
	 
	public java.lang.String getTeachaddress() {
		return this.teachaddress;
	}
	public void setTeachcontent(java.lang.String teachcontent) {
		this.teachcontent = teachcontent;
	}
	 
	public java.lang.String getTeachcontent() {
		return this.teachcontent;
	}
	public void setTimestheory(java.lang.String timestheory) {
		this.timestheory = timestheory;
	}
	 
	public java.lang.String getTimestheory() {
		return this.timestheory;
	}
	public void setTimeswork(java.lang.String timeswork) {
		this.timeswork = timeswork;
	}
	 
	public java.lang.String getTimeswork() {
		return this.timeswork;
	}
	public void setTeachmaterial(java.lang.String teachmaterial) {
		this.teachmaterial = teachmaterial;
	}
	 
	public java.lang.String getTeachmaterial() {
		return this.teachmaterial;
	}
	public void setBdateapp(java.lang.String bdateapp) {
		this.bdateapp = bdateapp;
	}
	 
	public java.lang.String getBdateapp() {
		return this.bdateapp;
	}
	public void setBappid(Long bappid) {
		this.bappid = bappid;
	}
	 
	public Long getBappid() {
		return this.bappid;
	}
	public void setBdateapr(java.lang.String bdateapr) {
		this.bdateapr = bdateapr;
	}
	 
	public java.lang.String getBdateapr() {
		return this.bdateapr;
	}
	public void setBaprman(java.lang.String baprman) {
		this.baprman = baprman;
	}
	 
	public java.lang.String getBaprman() {
		return this.baprman;
	}
	public void setEdateapp(java.lang.String edateapp) {
		this.edateapp = edateapp;
	}
	 
	public java.lang.String getEdateapp() {
		return this.edateapp;
	}
	public void setEappid(Long eappid) {
		this.eappid = eappid;
	}
	 
	public Long getEappid() {
		return this.eappid;
	}
	public void setEdateapr(java.lang.String edateapr) {
		this.edateapr = edateapr;
	}
	 
	public java.lang.String getEdateapr() {
		return this.edateapr;
	}
	public void setEaprman(java.lang.String eaprman) {
		this.eaprman = eaprman;
	}
	 
	public java.lang.String getEaprman() {
		return this.eaprman;
	}
	public void setIsspec(Long isspec) {
		this.isspec = isspec;
	}
	 
	public Long getIsspec() {
		return this.isspec;
	}
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	 
	public java.lang.String getEmail() {
		return this.email;
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

	public String getCareerName() {
		return careerName;
	}

	public void setCareerName(String careerName) {
		this.careerName = careerName;
	}

	
	
}
