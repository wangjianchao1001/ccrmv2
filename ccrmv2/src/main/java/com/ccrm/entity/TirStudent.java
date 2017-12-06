package com.ccrm.entity;

import com.ccrm.entity.BaseEntity;
import com.ccrm.util.excelExport.ExcelResources;

public class TirStudent extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:学员姓名     
     * @字段:NAME VARCHAR2(50)  
     */	
	private java.lang.String name;

	/**
     * @备注:身份证号     
     * @字段:IDNO VARCHAR2(20)  
     */	
	private java.lang.String idno;

	/**
     * @备注:名族，idxid=70     
     * @字段:NATIONID NUMBER(22)  
     */	
	private Long nationid;

	/**
     * @备注:户口性质，idix=71     
     * @字段:HOUSEHOLDID NUMBER(22)  
     */	
	private Long householdid;

	/**
     * @备注:文化成都，idxid=72     
     * @字段:CULTUREID NUMBER(22)  
     */	
	private Long cultureid;

	/**
     * @备注:地址     
     * @字段:ADRESS VARCHAR2(80)  
     */	
	private java.lang.String adress;

	/**
     * @备注:联系电话     
     * @字段:PHONENO VARCHAR2(50)  
     */	
	private java.lang.String phoneno;

	/**
     * @备注:人员类别，idxid=73     
     * @字段:STRUCTID NUMBER(22)  
     */	
	private Long structid;

	/**
     * @备注:证件类型，idxid=74     
     * @字段:IDENTID NUMBER(22)  
     */	
	private Long identid;

	/**
     * @备注:证件号码     
     * @字段:IDENTNO VARCHAR2(30)  
     */	
	private java.lang.String identno;

	/**
     * @备注:失业日期     
     * @字段:DATEUNEMPLOYED CHAR(8)  
     */	
	private java.lang.String dateunemployed;

	/**
     * @备注:培训审批情况，idxid=75     
     * @字段:TRAINAPRID NUMBER(22)  
     */	
	private Long trainaprid;

	/**
     * @备注:结业审批情况，idxid=75     
     * @字段:COMPLETEAPRID NUMBER(22)  
     */	
	private Long completeaprid;

	/**
     * @备注:理论课成绩＜就业专用＞     
     * @字段:SCORETHEORY NUMBER(22)  
     */	
	private Long scoretheory;

	/**
     * @备注:技能课成绩＜就业专用＞     
     * @字段:SCORESKILL NUMBER(22)  
     */	
	private Long scoreskill;

	/**
     * @备注:结业考试是否合格（创业计划书是否合格），idxid=76     
     * @字段:ISPASSER NUMBER(22)  
     */	
	private Long ispasser;

	/**
     * @备注:结业证书编号（创业合格证书编号）     
     * @字段:CERTIFYNO VARCHAR2(30)  
     */	
	private java.lang.String certifyno;

	/**
     * @备注:结业证书（创业合格证书）发放时间     
     * @字段:CERTIFYDATE CHAR(8)  
     */	
	private java.lang.String certifydate;

	/**
     * @备注:是否就业（是否创业），idxid=77     
     * @字段:ISEMPLOY NUMBER(22)  
     */	
	private Long isemploy;

	/**
     * @备注:就业单位名称（创业单位名称）     
     * @字段:EMPLOYUNIT VARCHAR2(100)  
     */	
	private java.lang.String employunit;

	/**
     * @备注:就业时间（创业时间）     
     * @字段:EMPLOYDATE CHAR(8)  
     */	
	private java.lang.String employdate;

	/**
     * @备注:创业项目名称＜创业专用＞     
     * @字段:PROJECTNAME VARCHAR2(100)  
     */	
	private java.lang.String projectname;

	/**
     * @备注:营业执照     
     * @字段:LICENSENO VARCHAR2(50)  
     */	
	private java.lang.String licenseno;

	/**
     * @备注:就业（创业）形式，idxid=78     
     * @字段:EMPLOYFORMAID NUMBER(22)  
     */	
	private Long employformaid;

	/**
     * @备注:单位联系人＜就业专用＞     
     * @字段:UNITLINKMAN VARCHAR2(30)  
     */	
	private java.lang.String unitlinkman;

	/**
     * @备注:单位联系电话＜就业专用＞     
     * @字段:UNITPHONENO VARCHAR2(50)  
     */	
	private java.lang.String unitphoneno;

	/**
     * @备注:劳动合同或就业证明     
     * @字段:LABORCONTRACT VARCHAR2(200)  
     */	
	private java.lang.String laborcontract;

	/**
     * @备注:是否就业困难，idxid=77＜就业专用＞     
     * @字段:ISDIFFICULTY NUMBER(22)  
     */	
	private Long isdifficulty;

	/**
     * @备注:是否残疾人，idxid=77＜就业专用＞     
     * @字段:ISHANDICAPPED NUMBER(22)  
     */	
	private Long ishandicapped;

	/**
     * @备注:带动就业树＜创业专用＞     
     * @字段:EMPLOYFIGURE NUMBER(22)  
     */	
	private Long employfigure;

	/**
     * @备注:是否参加鉴定，idxid=77     
     * @字段:ISAPPRASE NUMBER(22)  
     */	
	private Long isapprase;

	/**
     * @备注:是否享受补贴，idxid=77     
     * @字段:ISSUBSIDY NUMBER(22)  
     */	
	private Long issubsidy;

	/**
     * @备注:照片     
     * @字段:IMAGE BLOB(4000)  
     */	
	private String image;

	/**
     * @备注:状态：-1——删除；1——正常     
     * @字段:STATUS NUMBER(22)  
     */	
	private Long status;

	/**
     * @备注:记录新建时间     
     * @字段:DATENEW TIMESTAMP(6) WITH TIME ZONE(13)  
     */	
	private java.util.Date datenew;

	/**
     * @备注:记录修改时间     
     * @字段:DATEEDIT TIMESTAMP(6) WITH TIME ZONE(13)  
     */	
	private java.util.Date dateedit;

	/**
     * @备注:证书类型（idxid=40）     
     * @字段:CERTIFICATETYPE NUMBER(22)  
     */	
	private Long certificatetype;

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

	/**
     * @备注:     
     * @字段:IDXID VARCHAR2(20)  
     */	
	private java.lang.String idxid;

	/**
     * @备注:证书等级     
     * @字段:IDENTLEVEL NUMBER(22)  
     */	
	private Long identlevel;
	
	private Long branchId;
	private String organName;
	private String className;
	private String hoseholdName;
	private String nation;
	private String education;
	private String certiType;
	private String certiLevel;
	private String zjCertiType;
	private String zjCertiNo;
	private String peopleType;
	private String isEmploy;

	public TirStudent(){
	}

	public TirStudent(
		Long pkid
	){
		this.pkid = pkid;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	@ExcelResources(title="姓名",order=1)
	public java.lang.String getName() {
		return this.name;
	}
	public void setIdno(java.lang.String idno) {
		this.idno = idno;
	}
	@ExcelResources(title="身份证号",order=5)
	public java.lang.String getIdno() {
		return this.idno;
	}
	public void setNationid(Long nationid) {
		this.nationid = nationid;
	}
	 
	public Long getNationid() {
		return this.nationid;
	}
	public void setHouseholdid(Long householdid) {
		this.householdid = householdid;
	}
	 
	public Long getHouseholdid() {
		return this.householdid;
	}
	public void setCultureid(Long cultureid) {
		this.cultureid = cultureid;
	}
	 
	public Long getCultureid() {
		return this.cultureid;
	}
	public void setAdress(java.lang.String adress) {
		this.adress = adress;
	}
	@ExcelResources(title="地址",order=7)
	public java.lang.String getAdress() {
		return this.adress;
	}
	public void setPhoneno(java.lang.String phoneno) {
		this.phoneno = phoneno;
	}
	@ExcelResources(title="联系电话",order=8)
	public java.lang.String getPhoneno() {
		return this.phoneno;
	}
	public void setStructid(Long structid) {
		this.structid = structid;
	}
	 
	public Long getStructid() {
		return this.structid;
	}
	public void setIdentid(Long identid) {
		this.identid = identid;
	}
	 
	public Long getIdentid() {
		return this.identid;
	}
	public void setIdentno(java.lang.String identno) {
		this.identno = identno;
	}
	 
	public java.lang.String getIdentno() {
		return this.identno;
	}
	public void setDateunemployed(java.lang.String dateunemployed) {
		this.dateunemployed = dateunemployed;
	}
	@ExcelResources(title="失业日期",order=16)
	public java.lang.String getDateunemployed() {
		return this.dateunemployed;
	}
	public void setTrainaprid(Long trainaprid) {
		this.trainaprid = trainaprid;
	}
	 
	public Long getTrainaprid() {
		return this.trainaprid;
	}
	public void setCompleteaprid(Long completeaprid) {
		this.completeaprid = completeaprid;
	}
	 
	public Long getCompleteaprid() {
		return this.completeaprid;
	}
	public void setScoretheory(Long scoretheory) {
		this.scoretheory = scoretheory;
	}
	 
	public Long getScoretheory() {
		return this.scoretheory;
	}
	public void setScoreskill(Long scoreskill) {
		this.scoreskill = scoreskill;
	}
	 
	public Long getScoreskill() {
		return this.scoreskill;
	}
	public void setIspasser(Long ispasser) {
		this.ispasser = ispasser;
	}
	 
	public Long getIspasser() {
		return this.ispasser;
	}
	public void setCertifyno(java.lang.String certifyno) {
		this.certifyno = certifyno;
	}
	 
	public java.lang.String getCertifyno() {
		return this.certifyno;
	}
	public void setCertifydate(java.lang.String certifydate) {
		this.certifydate = certifydate;
	}
	 
	public java.lang.String getCertifydate() {
		return this.certifydate;
	}
	public void setIsemploy(Long isemploy) {
		this.isemploy = isemploy;
	}
	 
	public Long getIsemploy() {
		return this.isemploy;
	}
	public void setEmployunit(java.lang.String employunit) {
		this.employunit = employunit;
	}
	 
	public java.lang.String getEmployunit() {
		return this.employunit;
	}
	public void setEmploydate(java.lang.String employdate) {
		this.employdate = employdate;
	}
	 
	public java.lang.String getEmploydate() {
		return this.employdate;
	}
	public void setProjectname(java.lang.String projectname) {
		this.projectname = projectname;
	}
	 
	public java.lang.String getProjectname() {
		return this.projectname;
	}
	public void setLicenseno(java.lang.String licenseno) {
		this.licenseno = licenseno;
	}
	 
	public java.lang.String getLicenseno() {
		return this.licenseno;
	}
	public void setEmployformaid(Long employformaid) {
		this.employformaid = employformaid;
	}
	 
	public Long getEmployformaid() {
		return this.employformaid;
	}
	public void setUnitlinkman(java.lang.String unitlinkman) {
		this.unitlinkman = unitlinkman;
	}
	 
	public java.lang.String getUnitlinkman() {
		return this.unitlinkman;
	}
	public void setUnitphoneno(java.lang.String unitphoneno) {
		this.unitphoneno = unitphoneno;
	}
	 
	public java.lang.String getUnitphoneno() {
		return this.unitphoneno;
	}
	public void setLaborcontract(java.lang.String laborcontract) {
		this.laborcontract = laborcontract;
	}
	 
	public java.lang.String getLaborcontract() {
		return this.laborcontract;
	}
	public void setIsdifficulty(Long isdifficulty) {
		this.isdifficulty = isdifficulty;
	}
	 
	public Long getIsdifficulty() {
		return this.isdifficulty;
	}
	public void setIshandicapped(Long ishandicapped) {
		this.ishandicapped = ishandicapped;
	}
	 
	public Long getIshandicapped() {
		return this.ishandicapped;
	}
	public void setEmployfigure(Long employfigure) {
		this.employfigure = employfigure;
	}
	 
	public Long getEmployfigure() {
		return this.employfigure;
	}
	public void setIsapprase(Long isapprase) {
		this.isapprase = isapprase;
	}
	 
	public Long getIsapprase() {
		return this.isapprase;
	}
	public void setIssubsidy(Long issubsidy) {
		this.issubsidy = issubsidy;
	}
	 
	public Long getIssubsidy() {
		return this.issubsidy;
	}
	public void setImage(String image) {
		this.image = image;
	}
	 
	public String getImage() {
		return this.image;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	 
	public Long getStatus() {
		return this.status;
	}

	public java.util.Date getDatenew() {
		return datenew;
	}

	public void setDatenew(java.util.Date datenew) {
		this.datenew = datenew;
	}

	public java.util.Date getDateedit() {
		return dateedit;
	}

	public void setDateedit(java.util.Date dateedit) {
		this.dateedit = dateedit;
	}

	public void setCertificatetype(Long certificatetype) {
		this.certificatetype = certificatetype;
	}
	 
	public Long getCertificatetype() {
		return this.certificatetype;
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
	public void setIdxid(java.lang.String idxid) {
		this.idxid = idxid;
	}
	 
	public java.lang.String getIdxid() {
		return this.idxid;
	}
	public void setIdentlevel(Long identlevel) {
		this.identlevel = identlevel;
	}
	 
	public Long getIdentlevel() {
		return this.identlevel;
	}
	@ExcelResources(title="培训机构",order=2)
	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}
	@ExcelResources(title="培训班",order=3)
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	@ExcelResources(title="户口性质",order=4)
	public String getHoseholdName() {
		return hoseholdName;
	}

	public void setHoseholdName(String hoseholdName) {
		this.hoseholdName = hoseholdName;
	}
	@ExcelResources(title="民族",order=6)
	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
	@ExcelResources(title="文化程度",order=9)
	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}
	@ExcelResources(title="证书类型",order=10)
	public String getCertiType() {
		return certiType;
	}

	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}
	@ExcelResources(title="证书级别",order=11)
	public String getCertiLevel() {
		return certiLevel;
	}

	public void setCertiLevel(String certiLevel) {
		this.certiLevel = certiLevel;
	}
	@ExcelResources(title="证件类型",order=12)
	public String getZjCertiType() {
		return zjCertiType;
	}

	public void setZjCertiType(String zjCertiType) {
		this.zjCertiType = zjCertiType;
	}
	@ExcelResources(title="证件号",order=13)
	public String getZjCertiNo() {
		return zjCertiNo;
	}

	public void setZjCertiNo(String zjCertiNo) {
		this.zjCertiNo = zjCertiNo;
	}

	@ExcelResources(title="人员类别",order=14)
	public String getPeopleType() {
		return peopleType;
	}

	public void setPeopleType(String peopleType) {
		this.peopleType = peopleType;
	}
	@ExcelResources(title="是否就业",order=16)
	public String getIsEmploy() {
		return isEmploy;
	}

	public void setIsEmploy(String isEmploy) {
		this.isEmploy = isEmploy;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	@Override
	public String toString() {
		return "{name: " + name + ", \nidno: " + idno + ", \nnationid: "
				+ nationid + ", \nhouseholdid: " + householdid
				+ ", \ncultureid: " + cultureid + ", \nadress: " + adress
				+ ", \nphoneno: " + phoneno + ", \nstructid: " + structid
				+ ", \nidentid: " + identid + ", \nidentno: " + identno
				+ ", \ndateunemployed: " + dateunemployed + ", \ntrainaprid: "
				+ trainaprid + ", \ncompleteaprid: " + completeaprid
				+ ", \nscoretheory: " + scoretheory + ", \nscoreskill: "
				+ scoreskill + ", \nispasser: " + ispasser + ", \ncertifyno: "
				+ certifyno + ", \ncertifydate: " + certifydate
				+ ", \nisemploy: " + isemploy + ", \nemployunit: " + employunit
				+ ", \nemploydate: " + employdate + ", \nprojectname: "
				+ projectname + ", \nlicenseno: " + licenseno
				+ ", \nemployformaid: " + employformaid + ", \nunitlinkman: "
				+ unitlinkman + ", \nunitphoneno: " + unitphoneno
				+ ", \nlaborcontract: " + laborcontract + ", \nisdifficulty: "
				+ isdifficulty + ", \nishandicapped: " + ishandicapped
				+ ", \nemployfigure: " + employfigure + ", \nisapprase: "
				+ isapprase + ", \nissubsidy: " + issubsidy + ", \nimage: "
				+ image + ", \nstatus: " + status + ", \ndatenew: " + datenew
				+ ", \ndateedit: " + dateedit + ", \ncertificatetype: "
				+ certificatetype + ", \nmemo: " + memo + ", \npkid: " + pkid
				+ ", \nidxid: " + idxid + ", \nidentlevel: " + identlevel
				+ ", \nbranchId: " + branchId + ", \norganName: " + organName
				+ ", \nclassName: " + className + ", \nhoseholdName: "
				+ hoseholdName + ", \nnation: " + nation + ", \neducation: "
				+ education + ", \ncertiType: " + certiType
				+ ", \ncertiLevel: " + certiLevel + ", \nzjCertiType: "
				+ zjCertiType + ", \nzjCertiNo: " + zjCertiNo
				+ ", \npeopleType: " + peopleType + ", \nisEmploy: " + isEmploy
				+ "}";
	}
	
	
	
}
