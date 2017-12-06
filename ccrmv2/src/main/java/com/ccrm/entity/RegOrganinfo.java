package com.ccrm.entity;

import com.ccrm.entity.BaseEntity;

public class RegOrganinfo extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * @备注:变更前企业机构pkid，reg_organinfo.pkid     
     * @字段:PPKID NUMBER(22)  
     */	
	private Long ppkid;

	/**
     * @备注:登记信息状态：
-1——删除；
0——新建未提交；
1——提交后；
2——冻结，冻结后前台不能使用
     
     * @字段:STATUS NUMBER(22)  
     */	
	private int status;

	/**
     * @备注:所属管理机构pkid，umg_branch.pkid     
     * @字段:BRANCHID NUMBER(22)  
     */	
	private Long branchid;

	/**
     * @备注:登记企业机构名称     
     * @字段:NAME VARCHAR2(500)  
     */	
	private java.lang.String name;

	/**
     * @备注:登记企业机构标识，企业需要录入完整正确的营业执照号     
     * @字段:IDNO VARCHAR2(50)  
     */	
	private java.lang.String idno;

	/**
     * @备注:法人或者负责人     
     * @字段:CORPPERSON VARCHAR2(50)  
     */	
	private java.lang.String corpperson;

	/**
     * @备注:注册资金，以万元为单位     
     * @字段:REGFUND NUMBER(22)  
     */	
	private Long regfund;

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
     * @备注:企业联系EMail     
     * @字段:EMAIL VARCHAR2(200)  
     */	
	private java.lang.String email;

	/**
     * @备注:企业网址     
     * @字段:WWWURL VARCHAR2(200)  
     */	
	private java.lang.String wwwurl;

	/**
     * @备注:具体地址     
     * @字段:ADDRESS VARCHAR2(200)  
     */	
	private java.lang.String address;

	/**
     * @备注:创建操作员pkid，umg_operator.pkid     
     * @字段:CROPERID NUMBER(22)  
     */	
	private Long croperid;

	/**
     * @备注:提交操作员     
     * @字段:CMOPERID NUMBER(22)  
     */	
	private Long cmoperid;

	/**
     * @备注:提交时间yyyyMMddHHmmss     
     * @字段:CMDATE CHAR(14)  
     */	
	private java.lang.String cmdate;

	/**
     * @备注:记录新建时间     
     * @字段:DATENEW TIMESTAMP(6)(11)  
     */	
	private java.util.Date datenew;

	/**
     * @备注:记录编辑时间     
     * @字段:DATEEDIT TIMESTAMP(6)(11)  
     */	
	private java.util.Date dateedit;

	/**
     * @备注:是否有网点（0：否，1：是）     
     * @字段:VALUEINT01 NUMBER(22)  
     */	
	private Long valueint01;

	/**
     * @备注:     
     * @字段:VALUEINT02 NUMBER(22)  
     */	
	private Long valueint02;

	/**
     * @备注:     
     * @字段:VALUEINT03 NUMBER(22)  
     */	
	private Long valueint03;

	/**
     * @备注:     
     * @字段:VALUEINT04 NUMBER(22)  
     */	
	private Long valueint04;

	/**
     * @备注:在职员工总数     
     * @字段:VALUEINT05 NUMBER(22)  
     */	
	private Long valueint05;

	/**
     * @备注:教师     
     * @字段:VALUEINT06 NUMBER(22)  
     */	
	private Long valueint06;

	/**
     * @备注:兼职教师人数     
     * @字段:VALUEINT07 NUMBER(22)  
     */	
	private Long valueint07;

	/**
     * @备注:     
     * @字段:VALUEINT08 NUMBER(22)  
     */	
	private Long valueint08;

	/**
     * @备注:     
     * @字段:VALUEINT09 NUMBER(22)  
     */	
	private Long valueint09;

	/**
     * @备注:     
     * @字段:VALUEINT10 NUMBER(22)  
     */	
	private Long valueint10;

	/**
     * @备注:机构分类（1：公办，2：民办）     
     * @字段:VALUECODE01 NUMBER(22)  
     */	
	private Long valuecode01;

	/**
     * @备注:     
     * @字段:VALUECODE02 NUMBER(22)  
     */	
	private Long valuecode02;

	/**
     * @备注:     
     * @字段:VALUECODE03 NUMBER(22)  
     */	
	private Long valuecode03;

	/**
     * @备注:     
     * @字段:VALUECODE04 NUMBER(22)  
     */	
	private Long valuecode04;

	/**
     * @备注:     
     * @字段:VALUECODE05 NUMBER(22)  
     */	
	private Long valuecode05;

	/**
     * @备注:     
     * @字段:VALUECODE06 NUMBER(22)  
     */	
	private Long valuecode06;

	/**
     * @备注:     
     * @字段:VALUECODE07 NUMBER(22)  
     */	
	private Long valuecode07;

	/**
     * @备注:     
     * @字段:VALUECODE08 NUMBER(22)  
     */	
	private Long valuecode08;

	/**
     * @备注:     
     * @字段:VALUECODE09 NUMBER(22)  
     */	
	private Long valuecode09;

	/**
     * @备注:     
     * @字段:VALUECODE10 NUMBER(22)  
     */	
	private Long valuecode10;

	/**
     * @备注:经费来源总计     
     * @字段:VALUENUM01 NUMBER(18)  
     */	
	private Long valuenum01;

	/**
     * @备注:财政补助费     
     * @字段:VALUENUM02 NUMBER(18)  
     */	
	private Long valuenum02;

	/**
     * @备注:职业培训补贴     
     * @字段:VALUENUM03 NUMBER(18)  
     */	
	private Long valuenum03;

	/**
     * @备注:     
     * @字段:VALUENUM04 NUMBER(18)  
     */	
	private Long valuenum04;

	/**
     * @备注:     
     * @字段:VALUENUM05 NUMBER(18)  
     */	
	private Long valuenum05;

	/**
     * @备注:     
     * @字段:HSREMPLOYEES BLOB(4000)  
     */	
	private String hsremployees;

	/**
     * @备注:     
     * @字段:UMGBRANCH BLOB(4000)  
     */	
	private String umgbranch;

	/**
     * @备注:     
     * @字段:KINDID NUMBER(22)  
     */	
	private Long kindid;

	/**
     * @备注:备注     
     * @字段:MEMO VARCHAR2(4000)  
     */	
	private java.lang.String memo;

	/**
     * @备注:     
     * @字段:VALUESTR01 VARCHAR2(4000)  
     */	
	private java.lang.String valuestr01;

	/**
     * @备注:     
     * @字段:VALUESTR02 VARCHAR2(4000)  
     */	
	private java.lang.String valuestr02;

	/**
     * @备注:     
     * @字段:VALUESTR03 VARCHAR2(4000)  
     */	
	private java.lang.String valuestr03;

	/**
     * @备注:     
     * @字段:VALUESTR04 VARCHAR2(4000)  
     */	
	private java.lang.String valuestr04;

	/**
     * @备注:     
     * @字段:VALUESTR05 VARCHAR2(4000)  
     */	
	private java.lang.String valuestr05;

	/**
     * @备注:     
     * @字段:VALUESTR06 VARCHAR2(4000)  
     */	
	private java.lang.String valuestr06;

	/**
     * @备注:     
     * @字段:VALUESTR07 VARCHAR2(4000)  
     */	
	private java.lang.String valuestr07;

	/**
     * @备注:     
     * @字段:VALUESTR08 VARCHAR2(4000)  
     */	
	private java.lang.String valuestr08;

	/**
     * @备注:     
     * @字段:VALUESTR09 VARCHAR2(4000)  
     */	
	private java.lang.String valuestr09;

	/**
     * @备注:     
     * @字段:VALUESTR10 VARCHAR2(4000)  
     */	
	private java.lang.String valuestr10;

	/**
     * @备注:     
     * @字段:PKID NUMBER(20)  
     */	
	private Long pkid;
	
	private String branchName;
	//家政/培训
	private String type;
	
	public RegOrganinfo(){
	}

	public RegOrganinfo(
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
	public void setStatus(int status) {
		this.status = status;
	}
	 
	public int getStatus() {
		return this.status;
	}
	public void setBranchid(Long branchid) {
		this.branchid = branchid;
	}
	 
	public Long getBranchid() {
		return this.branchid;
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
	public void setCorpperson(java.lang.String corpperson) {
		this.corpperson = corpperson;
	}
	 
	public java.lang.String getCorpperson() {
		return this.corpperson;
	}
	public void setRegfund(Long regfund) {
		this.regfund = regfund;
	}
	 
	public Long getRegfund() {
		return this.regfund;
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
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	 
	public java.lang.String getEmail() {
		return this.email;
	}
	public void setWwwurl(java.lang.String wwwurl) {
		this.wwwurl = wwwurl;
	}
	 
	public java.lang.String getWwwurl() {
		return this.wwwurl;
	}
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	 
	public java.lang.String getAddress() {
		return this.address;
	}
	public void setCroperid(Long croperid) {
		this.croperid = croperid;
	}
	 
	public Long getCroperid() {
		return this.croperid;
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
	 
	public void setValueint01(Long valueint01) {
		this.valueint01 = valueint01;
	}
	 
	public Long getValueint01() {
		return this.valueint01;
	}
	public void setValueint02(Long valueint02) {
		this.valueint02 = valueint02;
	}
	 
	public Long getValueint02() {
		return this.valueint02;
	}
	public void setValueint03(Long valueint03) {
		this.valueint03 = valueint03;
	}
	 
	public Long getValueint03() {
		return this.valueint03;
	}
	public void setValueint04(Long valueint04) {
		this.valueint04 = valueint04;
	}
	 
	public Long getValueint04() {
		return this.valueint04;
	}
	public void setValueint05(Long valueint05) {
		this.valueint05 = valueint05;
	}
	 
	public Long getValueint05() {
		return this.valueint05;
	}
	public void setValueint06(Long valueint06) {
		this.valueint06 = valueint06;
	}
	 
	public Long getValueint06() {
		return this.valueint06;
	}
	public void setValueint07(Long valueint07) {
		this.valueint07 = valueint07;
	}
	 
	public Long getValueint07() {
		return this.valueint07;
	}
	public void setValueint08(Long valueint08) {
		this.valueint08 = valueint08;
	}
	 
	public Long getValueint08() {
		return this.valueint08;
	}
	public void setValueint09(Long valueint09) {
		this.valueint09 = valueint09;
	}
	 
	public Long getValueint09() {
		return this.valueint09;
	}
	public void setValueint10(Long valueint10) {
		this.valueint10 = valueint10;
	}
	 
	public Long getValueint10() {
		return this.valueint10;
	}
	public void setValuecode01(Long valuecode01) {
		this.valuecode01 = valuecode01;
	}
	 
	public Long getValuecode01() {
		return this.valuecode01;
	}
	public void setValuecode02(Long valuecode02) {
		this.valuecode02 = valuecode02;
	}
	 
	public Long getValuecode02() {
		return this.valuecode02;
	}
	public void setValuecode03(Long valuecode03) {
		this.valuecode03 = valuecode03;
	}
	 
	public Long getValuecode03() {
		return this.valuecode03;
	}
	public void setValuecode04(Long valuecode04) {
		this.valuecode04 = valuecode04;
	}
	 
	public Long getValuecode04() {
		return this.valuecode04;
	}
	public void setValuecode05(Long valuecode05) {
		this.valuecode05 = valuecode05;
	}
	 
	public Long getValuecode05() {
		return this.valuecode05;
	}
	public void setValuecode06(Long valuecode06) {
		this.valuecode06 = valuecode06;
	}
	 
	public Long getValuecode06() {
		return this.valuecode06;
	}
	public void setValuecode07(Long valuecode07) {
		this.valuecode07 = valuecode07;
	}
	 
	public Long getValuecode07() {
		return this.valuecode07;
	}
	public void setValuecode08(Long valuecode08) {
		this.valuecode08 = valuecode08;
	}
	 
	public Long getValuecode08() {
		return this.valuecode08;
	}
	public void setValuecode09(Long valuecode09) {
		this.valuecode09 = valuecode09;
	}
	 
	public Long getValuecode09() {
		return this.valuecode09;
	}
	public void setValuecode10(Long valuecode10) {
		this.valuecode10 = valuecode10;
	}
	 
	public Long getValuecode10() {
		return this.valuecode10;
	}
	public void setValuenum01(Long valuenum01) {
		this.valuenum01 = valuenum01;
	}
	 
	public Long getValuenum01() {
		return this.valuenum01;
	}
	public void setValuenum02(Long valuenum02) {
		this.valuenum02 = valuenum02;
	}
	 
	public Long getValuenum02() {
		return this.valuenum02;
	}
	public void setValuenum03(Long valuenum03) {
		this.valuenum03 = valuenum03;
	}
	 
	public Long getValuenum03() {
		return this.valuenum03;
	}
	public void setValuenum04(Long valuenum04) {
		this.valuenum04 = valuenum04;
	}
	 
	public Long getValuenum04() {
		return this.valuenum04;
	}
	public void setValuenum05(Long valuenum05) {
		this.valuenum05 = valuenum05;
	}
	 
	public Long getValuenum05() {
		return this.valuenum05;
	}
	public void setHsremployees(String hsremployees) {
		this.hsremployees = hsremployees;
	}
	 
	public String getHsremployees() {
		return this.hsremployees;
	}
	public void setUmgbranch(String umgbranch) {
		this.umgbranch = umgbranch;
	}
	 
	public String getUmgbranch() {
		return this.umgbranch;
	}
	public void setKindid(Long kindid) {
		this.kindid = kindid;
	}
	 
	public Long getKindid() {
		return this.kindid;
	}
	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}
	 
	public java.lang.String getMemo() {
		return this.memo;
	}
	public void setValuestr01(java.lang.String valuestr01) {
		this.valuestr01 = valuestr01;
	}
	 
	public java.lang.String getValuestr01() {
		return this.valuestr01;
	}
	public void setValuestr02(java.lang.String valuestr02) {
		this.valuestr02 = valuestr02;
	}
	 
	public java.lang.String getValuestr02() {
		return this.valuestr02;
	}
	public void setValuestr03(java.lang.String valuestr03) {
		this.valuestr03 = valuestr03;
	}
	 
	public java.lang.String getValuestr03() {
		return this.valuestr03;
	}
	public void setValuestr04(java.lang.String valuestr04) {
		this.valuestr04 = valuestr04;
	}
	 
	public java.lang.String getValuestr04() {
		return this.valuestr04;
	}
	public void setValuestr05(java.lang.String valuestr05) {
		this.valuestr05 = valuestr05;
	}
	 
	public java.lang.String getValuestr05() {
		return this.valuestr05;
	}
	public void setValuestr06(java.lang.String valuestr06) {
		this.valuestr06 = valuestr06;
	}
	 
	public java.lang.String getValuestr06() {
		return this.valuestr06;
	}
	public void setValuestr07(java.lang.String valuestr07) {
		this.valuestr07 = valuestr07;
	}
	 
	public java.lang.String getValuestr07() {
		return this.valuestr07;
	}
	public void setValuestr08(java.lang.String valuestr08) {
		this.valuestr08 = valuestr08;
	}
	 
	public java.lang.String getValuestr08() {
		return this.valuestr08;
	}
	public void setValuestr09(java.lang.String valuestr09) {
		this.valuestr09 = valuestr09;
	}
	 
	public java.lang.String getValuestr09() {
		return this.valuestr09;
	}
	public void setValuestr10(java.lang.String valuestr10) {
		this.valuestr10 = valuestr10;
	}
	 
	public java.lang.String getValuestr10() {
		return this.valuestr10;
	}
	public void setPkid(Long pkid) {
		this.pkid = pkid;
	}
	 
	public Long getPkid() {
		return this.pkid;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
