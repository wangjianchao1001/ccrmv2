
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/plugins/datepicker/skin/WdatePicker.css">
<!--[if lt IE 9]>
		<script src="js/html5.js"></script>	
	<![endif]-->
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			员工管理 <small>员工新增/修改</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>员工列表</a></li>
			<li><a href="#"><i class="fa"></i>员工新增/修改</a></li>
			<!-- <li class="active">Here</li> -->
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">
		<div class="box box-solid box-default">
			<div class="box-header">学员列表</div>
			<div class="box-body">
				<form class="form-horizontal" role="form" id="mgtuserForm" method="post" action="<%=request.getContextPath()%>/employee/save">
						<input id="hid_pkid" name="pkid" type="hidden" value="${employ.pkid }"/>
					    <input id="hid_organid" name="organid" type="hidden" value="${employ.organid }"/>
				
					<div class="form-group">
						<label for="loginName" class="col-sm-2 control-label"><font color="red">*</font>所属家庭服务业企业</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="organid" name="organid" placeholder="请输入家庭服务企业名称" value="${employ.orgName }">
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">员工姓名</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名" value="${employ.name}">
						</div>
					</div>
					<div class="form-group">
						<label for="idno" class="col-sm-2 control-label">身份证号</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="idno" name="idno" placeholder="请输入身份证号" value="${employ.idno}">
						</div>
					</div>
					<div class="form-group">
						<label for="phoneno" class="col-sm-2 control-label">联系电话</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="phoneno" name="phoneno" placeholder="请输入联系电话" value="${employ.phoneno}">
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">邮箱</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱" value="${employ.email}">
						</div>
					</div>
					<div class="form-group">
						<label for="status" class="col-sm-2 control-label">状态</label>
						<div class="input-group col-sm-5">
							<select class="form-control selectpicker show-tick" name="status" >
								<option value='1' <c:if test="${employ.status == 1 }">selected="selected"</c:if>>在职</option>
								<option value='0' <c:if test="${employ.status == 0 }">selected="selected"</c:if>>离职</option>
							</select> 
						</div>
					</div>
					<div class="form-group">
						<label for="dateentry" class="col-sm-2 control-label"><font color="red">*</font>入职时间</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="dateentry" name="dateentry" placeholder="请输选择入职日期" readonly 
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-{%d-1}'})" value="${employ.dateentry}">
						</div>
					</div>
					<div class="form-group">
						<label for="dateleave" class="col-sm-2 control-label"><font color="red">*</font>离职时间</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="dateleave" name="dateleave" placeholder="请输选择离职日期" readonly 
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-{%d-1}'})" value="${employ.dateleave}">
						</div>
					</div>
					<div class="form-group">
						<label for="memo" class="col-sm-2 control-label">备注</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="memo" name="memo" placeholder="请输入备注" value="${employ.memo}">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<c:if test="${openType != 'view' }">
								<button type="submit" class="btn btn-primary">提交</button>
							</c:if>
							<input type="button" class="btn btn-default" id="back" name="back" onclick="javascript:window.history.go(-1);" value="返回" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/static/plugins/datepicker/WdatePicker.js"></script>
	<script>
		$(function(){
			var validateRules = {
			};
			validateRules.loginName={
					required : true,
					remote : {
							    url:"../mgtuser/mgtUserExist",     //后台处理程序
							    type: "post",               //数据发送方式
							    dataType: "json",           //接受数据格式   
							    data: {                     //要传递的数据
							    	loginName: function() {
							            return $("#loginName").val();
							        },
							        userId: function() {
							            return $("#userId").val();
							        }
							    }
							}
			};
			$("#mgtuserForm").validate({
				rules : validateRules,
				messages:{
					loginName:{
						required :"用户名不能为空",
						remote:"该用户名已经存在，请修改"
					}
				}
			});
		});
	
	</script>
</body>

</html>