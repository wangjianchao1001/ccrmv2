
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
			帐户管理 <small>帐户修改</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>帐户列表</a></li>
			<li><a href="#"><i class="fa"></i>帐户修改</a></li>
			<!-- <li class="active">Here</li> -->
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">
		<div class="box box-solid box-default">
			<div class="box-header">帐户列表</div>
			<div class="box-body">
				<form class="form-horizontal" role="form" id="mgtuserForm" method="post" action="<%=path%>/user/${user.pkid==null?"add":"update"}">
					<div class="form-group"  hidden="true">
						<input type="hidden" class="form-control" id="userId" name="userId" value="${user.userId}">
					</div>
					<div class="form-group">
						<label for="loginName" class="col-sm-2 control-label"><font color="red">*</font>用户名</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="loginName" name="loginName" placeholder="请输入用户名" value="${user.loginName}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">真实姓名</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入真实姓名" value="${user.nickName}">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label"><font color="red">*</font>密码</label>
						<div class="input-group col-sm-5">
							<c:if test="${empty user.userId}">
								<input type="text" class="form-control" id="password" name="password" value="000000" readonly="readonly">
							</c:if>
							<c:if test="${not empty user.userId}">
								<input type="password" class="form-control" id="password" name="password" value="${user.password}" readonly="readonly">
							</c:if>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-primary">提交</button>
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
							    url:"../user/userExist",     //后台处理程序
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