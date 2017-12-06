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
			培训机构管理 <small>培训机构添加/修改</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i></a></li>
			<li><a href="#"><i class="fa"></i>培训机构添加/修改</a></li>
			<!-- <li class="active">Here</li> -->
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">
		<div class="box box-solid box-default">
			<div class="box-header"></div>
			<div class="box-body">
				<form class="form-horizontal" role="form" id="tirOrganForm" method="post" action="<%=path%>/tirOrgan/save">
					<c:if test="${not empty regOrgan.pkid}">
						<div class="form-group"  hidden="true">
							<label for="pkid" class="col-sm-2 control-label">pkid</label>
							<div class="input-group col-sm-5">
								<input type="hidden" class="form-control" name="pkid" id="pkid" value="${regOrgan.pkid}">
							</div>
						</div>
					</c:if>
					<div class="form-group">
						<label for="branchid" class="col-sm-2 control-label"><font color="red">*</font>所属管理机构：</label>
						<div class="input-group col-sm-5">
							<c:if test="${empty branchTree }">
								<c:forEach var="branch" items="${branchList }">
									<c:if test="${regOrgan.branchid eq branch.pkid }">
										<input type="text" class="form-control" id="branchName" required="required"
											name="branchName" placeholder="请选择所属机构" readonly 
											value="${branch.name}"> 
									</c:if> 
								</c:forEach>
							</c:if>
							<%-- <c:if test="${not empty branchTree }">
								<input type="text" class="form-control " id="branchName" name="branchName" placeholder="按所属机构查找" readonly value="${regOrgan.branchName }" onfocus="showBranchTree(); return false;"/>
							</c:if> --%>
								<input type="hidden" class="form-control " id="branchid" name="branchid" value="${regOrgan.branchid }" />
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label"><font color="red">*</font>机构名称</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="name"  required="required"
								name="name" placeholder="请输入机构名称"
								value="${regOrgan.name}">
						</div>
					</div>
					<div class="form-group">
						<label for="valuecode01" class="col-sm-2 control-label"><font color="red">*</font>机构分类</label>
						<div class="input-group col-sm-5">
								<select class="form-control selectpicker show-tick" name="valuecode01" >
								<option value='' <c:if test="${regOrgan.valuecode01 == '' }">selected="selected"</c:if>>请选择机构分类</option>
								<option value='2' <c:if test="${regOrgan.valuecode01 == 2 }">selected="selected"</c:if>>民办</option>
								<option value='1' <c:if test="${regOrgan.valuecode01 == 1 }">selected="selected"</c:if>>公办</option>
							</select> 
						</div>
					</div>
					<div class="form-group">
						<label for="idno" class="col-sm-2 control-label"><font color="red">*</font>办学许可证号</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="idno" required="required"
								name="idno" placeholder="请输入办学许可证"
								value="${regOrgan.idno}">
						</div>
					</div>
					<div class="form-group">
						<label for="corpperson" class="col-sm-2 control-label"><font color="red">*</font>法人姓名</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="corpperson" required="required"
								name="corpperson" placeholder="请输入法人名称"
								value="${regOrgan.corpperson}">
						</div>
					</div>
					<div class="form-group">
						<label for="linkman" class="col-sm-2 control-label"><font color="red">*</font>联系人</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="linkman" required="required"
								name="linkman" placeholder="请输入联系人"
								value="${regOrgan.linkman}">
						</div>
					</div>
					<div class="form-group">
						<label for="phoneno" class="col-sm-2 control-label"><font color="red">*</font>联系电话</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="phoneno" 
								name="phoneno" placeholder="请输入联系电话"
								value="${regOrgan.phoneno}">
						</div>
					</div>
					<div class="form-group">
						<label for="address" class="col-sm-2 control-label"><font color="red">*</font>培训机构地址</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="address" 
								name="address" placeholder="请输入培训机构地址"
								value="${regOrgan.address}">
						</div>
					</div>
					<div class="form-group">
						<label for="cmdate" class="col-sm-2 control-label">注册日期</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="cmdate"
								name="cmdate" placeholder="请输选择注册日期" readonly 
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-{%d-1}'})"
								value="${regOrgan.cmdate}">
						</div>
					</div>
					<div class="form-group">
						<label for="valuestr01" class="col-sm-2 control-label">专业设置</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="valuestr01"
								name="valuestr01" placeholder="请输入专业设置"
								value="${regOrgan.valuestr01}">
						</div>
					</div>
					<div class="form-group">
						<label for="valuestr02" class="col-sm-2 control-label">培训规模</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="valuestr02"
								name="valuestr02" placeholder="请输培训规模"
								value="${regOrgan.valuestr02}">
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">电子邮箱</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="email"
								name="email" placeholder="请输入电子邮箱"
								value="${regOrgan.email}">
						</div>
					</div>
					<div class="form-group">
						<label for="valueint05" class="col-sm-2 control-label"><font color="red">*</font>在职教职工总人数</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="valueint05" required="required"
								name="valueint05" placeholder="请输入在职教职工总人数"
								value="${regOrgan.valueint05}">
						</div>
					</div>
					<div class="form-group">
						<label for="valueint06" class="col-sm-2 control-label"><font color="red">*</font>教师人数</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="valueint06" required="required"
								name="valueint06" placeholder="请输入技能组名称"
								value="${regOrgan.valueint06}">
						</div>
					</div>
					<div class="form-group">
						<label for="valueint07" class="col-sm-2 control-label"><font color="red">*</font>兼职教师人数</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="valueint07" required="required"
								name="valueint07" placeholder="请输入兼职教师人数"
								value="${regOrgan.valueint07}">
						</div>
					</div>
					<div class="form-group">
						<label for="valuenum01" class="col-sm-2 control-label"><font color="red">*</font>经费来源总计</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="valuenum01"   
								name="valuenum01" placeholder="请输入经费来源总计(千元)"required="required"
								value="${regOrgan.valuenum01}">
						</div>
					</div>
					<div class="form-group">
						<label for="valuenum02" class="col-sm-2 control-label"><font color="red">*</font>财政补助费</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="valuenum02"   required="required"
								name="valuenum02" placeholder="请输入财政补助费(千元)"
								value="${regOrgan.valuenum02}">
						</div>
					</div>
					<div class="form-group">
						<label for="valuenum03" class="col-sm-2 control-label"><font color="red">*</font>职业培训补贴</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="valuenum03"  required="required"
								name="valuenum03" placeholder="请输入职业培训补贴(千元)"
								value="${regOrgan.valuenum03}">
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