<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8"> 
<title></title>
<meta name="decorator" content="mainframe" />
<script type="text/javascript" src="<%=request.getContextPath()%>/static/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/ztree/js/callZtree.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/ztree/css/demo.css" />	
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/ztree/css/zTreeStyle/zTreeStyle.css" />	
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/plugins/datepicker/skin/WdatePicker.css">
<!--[if lt IE 9]>
		<script src="js/html5.js"></script>	
	<![endif]-->
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1 style="text-align : left;">
			家政培训机构管理 <small>家政培训机构添加/修改</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i></a></li>
			<li><a href="#"><i class="fa"></i>家政培训机构添加/修改</a></li>
			<!-- <li class="active">Here</li> -->
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">
		<div class="box box-solid box-default">
			<div class="box-header"></div>
			<div class="box-body">
				<form class="form-horizontal" role="form" id="tirOrganForm" method="post" action="<%=path%>/tirOrgan/save">
					<c:if test="${not empty hkTirInst.pkid}">
						<div class="form-group"  hidden="true">
							<label for="pkid" class="col-sm-2 control-label">pkid</label>
							<div class="input-group col-sm-5">
								<input type="hidden" class="form-control" name="pkid" id="pkid" value="${hkTirInst.pkid}">
							</div>
						</div>
					</c:if>
					<div class="form-group">
						<label for="branchid" class="col-sm-2 control-label"><font color="red">*</font>所属管理机构：</label>
						<div class="input-group col-sm-5">
							<c:if test="${empty branchTree }">
								<c:forEach var="branch" items="${branchList }">
									<c:if test="${hkTirInst.branchid eq branch.pkid }">
										<input type="text" class="form-control" id="branchName" required="required"
											name="branchName" placeholder="请选择所属机构" readonly 
											value="${branch.name}"> 
									</c:if> 
								</c:forEach>
							</c:if>
								<input type="hidden" class="form-control " id="branchid" name="branchid" value="${hkTirInst.branchid }" />
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label"><font color="red">*</font>所属家庭服务业企业</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="name"  required="required"
								name="name" placeholder="请输入所属家庭服务业企业"
								value="${}">
						</div>
					</div>
					<div class="form-group">
						<label for="corpperson" class="col-sm-2 control-label"><font color="red">*</font>法人代表</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="corpperson" required="required"
								name="corpperson" placeholder="请输入法人代表"
								value="${hkTirInst.corpperson}">
						</div>
					</div>
					<div class="form-group">
						<label for="corpperson" class="col-sm-2 control-label"><font color="red">*</font>法人姓名</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="corpperson" required="required"
								name="corpperson" placeholder="请输入法人名称"
								value="${hkTirInst.corpperson}">
						</div>
					</div>
					<div class="form-group">
						<label for="corpPhone" class="col-sm-2 control-label"><font color="red">*</font>法人电话</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="corpPhone" required="required"
								name="corpPhone" placeholder="请输入法人电话
								value="${hkTirInst.corpPhone}">
						</div>
					</div>
					<div class="form-group">
						<label for="corpCode" class="col-sm-2 control-label"><font color="red">*</font>法人代码</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="corpCode" 
								name="corpCode" placeholder="请输入法人代码"
								value="${hkTirInst.corpCode}">
						</div>
					</div>
					<div class="form-group">
						<label for="contectName" class="col-sm-2 control-label"><font color="red">*</font>联系人姓名</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="contectName" 
								name="contectName" placeholder="请输入联系人姓名"
								value="${hkTirInst.contectName}">
						</div>
					</div>
					<div class="form-group">
						<label for="contectPhone" class="col-sm-2 control-label">联系人电话</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="contectPhone"
								name="contectPhone" placeholder="请输入联系人电话"
								value="${hkTirInst.contectPhone}">
						</div>
					</div>
					<div class="form-group">
						<label for="established" class="col-sm-2 control-label">成立时间</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="established"
								name="established" placeholder="请输入成立时间"
								value="${hkTirInst.established}">
						</div>
					</div>
					<div class="form-group">
						<label for="professioname" class="col-sm-2 control-label"><font color="red">*</font>机构分类</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="professioname" required="required"
								name="professioname" placeholder="请输入机构分类"
								value="${hkTirInst.professioname}">
						</div>
					</div>
					<div class="form-group">
						<label for="valueint06" class="col-sm-2 control-label"><font color="red">*</font>机构分类</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="valueint06" required="required"
								name="valueint06" placeholder="请输入机构分类"
								value="${hkTirInst.valueint06}">
						</div>
					</div>
					<div class="form-group">
						<label for="professioname" class="col-sm-2 control-label"><font color="red">*</font>开设专业名称</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="professioname" required="required"
								name="professioname" placeholder="请输入开设专业名称"
								value="${hkTirInst.professioname}">
						</div>
					</div>
					<div class="form-group">
						<label for="relationshipenterprise" class="col-sm-2 control-label"><font color="red">*</font>稳定合作关系的企业名称</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="relationshipenterprise"   
								name="relationshipenterprise" placeholder="请输入稳定合作关系的企业名称"required="required"
								value="${hkTirInst.relationshipenterprise}">
						</div>
					</div>
					<div class="form-group">
						<label for="relationshipdomenterpris" class="col-sm-2 control-label"><font color="red">*</font>稳定合作关系的家政企业名称</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="relationshipdomenterpris"   required="required"
								name="relationshipdomenterpris" placeholder="请输入稳定合作关系的家政企业名称"
								value="${hkTirInst.relationshipdomenterpris}">
						</div>
					</div>
					<div class="form-group">
						<label for="teacher" class="col-sm-2 control-label"><font color="red">*</font>师资总数/员工总数</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="teacher"  required="required"
								name="teacher" placeholder="请输入师资总数/员工总数"
								value="${hkTirInst.teacher}">
						</div>
					</div>
					<div class="form-group">
						<label for="fulltimeteacher" class="col-sm-2 control-label"><font color="red">*</font>全职教师数</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="fulltimeteacher"  required="required"
								name="fulltimeteacher" placeholder="请输入全职教师数"
								value="${hkTirInst.fulltimeteacher}">
						</div>
					</div>
					<div class="form-group">
						<label for="parttimeteacher" class="col-sm-2 control-label"><font color="red">*</font>兼职教师人数</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="parttimeteacher"  required="required"
								name="parttimeteacher" placeholder="请输入兼职教师人数"
								value="${hkTirInst.parttimeteacher}">
						</div>
					</div>
					<div class="form-group">
						<label for="seniortitleteacher" class="col-sm-2 control-label"><font color="red">*</font>高级职称教师数</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="seniortitleteacher"  required="required"
								name="seniortitleteacher" placeholder="请输入高级职称教师数"
								value="${hkTirInst.seniortitleteacher}">
						</div>
					</div>
					<div class="form-group">
						<label for="graduate" class="col-sm-2 control-label"><font color="red">*</font>当年培养的毕业生人数</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="graduate"  required="required"
								name="graduate" placeholder="请输入当年培养的毕业生人数"
								value="${hkTirInst.graduate}">
						</div>
					</div>
					<div class="form-group">
						<label for="thridentify" class="col-sm-2 control-label"><font color="red">*</font>通过职业技能鉴定人数</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="thridentify"  required="required"
								name="thridentify" placeholder="请输入通过职业技能鉴定人数"
								value="${hkTirInst.thridentify}">
						</div>
					</div>
					<div class="form-group">
						<label for="yearemployment" class="col-sm-2 control-label"><font color="red">*</font>毕业后当年实现就业人数</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="yearemployment"  required="required"
								name="yearemployment" placeholder="请输入毕业后当年实现就业人数"
								value="${hkTirInst.yearemployment}">
						</div>
					</div>
					<div class="form-group">
						<label for="passtraining" class="col-sm-2 control-label"><font color="red">*</font>培训后合格人数</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="passtraining"  required="required"
								name="passtraining" placeholder="请输入培训后合格人数"
								value="${hkTirInst.passtraining}">
						</div>
					</div>
					<div class="form-group">
						<label for="trainingplace" class="col-sm-2 control-label"><font color="red">*</font>共建培训实习基地名称</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="trainingplace"  required="required"
								name="trainingplace" placeholder="请输入共建培训实习基地名称"
								value="${hkTirInst.trainingplace}">
						</div>
					</div>
					<div class="form-group">
						<label for="yearemployment" class="col-sm-2 control-label"><font color="red">*</font>本企业员工<br />技能提升<br />培训人数</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="yearemployment"  required="required"
								name="yearemployment" placeholder="请输入本企业员工技能提升培训人数"
								value="${hkTirInst.yearemployment}">
						</div>
					</div>
					<div class="form-group">
						<label for="employeetraining" class="col-sm-2 control-label"><font color="red">*</font>开办日期</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="employeetraining"  required="required"
								name="employeetraining" placeholder="请输入开办日期"
								value="${hkTirInst.employeetraining}">
						</div>
					</div>
					<div class="form-group">
						<label for="memo" class="col-sm-2 control-label"><font color="red">*</font>备注</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="memo"  required="required"
								name="memo" placeholder="请输入备注"
								value="${hkTirInst.memo}">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-primary">提交</button>
							<input type="button" class="btn btn-default" id="back"
								name="back" onclick="javascript:window.history.go(-1);"
								value="返回" />
						</div>
					</div>
				</form>
			</div>
		</div>
		<div id="menuContent" class="menuContent " style="display:none; position: absolute;z-index:999;">
			<ul id="treeDemo" class="ztree" style="margin-top:0; width:180px;"></ul>
		</div>
	</section>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/plugins/datepicker/WdatePicker.js"></script>
	<script>
	var branchTree = ${branchTree };
	var setting = {
			view: {
				dblClickExpand: false
			},data: {
				simpleData: {
					enable: true
				}
			},callback: {
				onClick : onclick
			}
		};
	
		
		$(function(){
			//机构数
			$.fn.zTree.init($("#treeDemo"), setting, branchTree);
			
			 var validateRules = {
				rules : {
					name : {
						required : true
					},valuecode01 : {
						required : true
					},idno : {
						required : true
					},corpperson : {
						required : true
					},linkman : {
						required : true
					},phoneno : {
						required : true
					},address : {
						required : true
					},valueint05 : {
						required : true
					},valueint06 : {
						required : true
					},valueint07 : {
						required : true
					},valuenum01 : {
						required : true
					},valuenum02 : {
						required : true
					},valuenum03 : {
						required : true
					
					}
				}
			};
			$("#tirOrganForm").validate({
				rules : validateRules
			}); 
		});
	</script>
</body>

</html>