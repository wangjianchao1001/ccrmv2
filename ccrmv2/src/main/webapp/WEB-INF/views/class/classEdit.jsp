
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
			学员管理 <small>学员修改</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>学员列表</a></li>
			<li><a href="#"><i class="fa"></i>学员修改</a></li>
			<!-- <li class="active">Here</li> -->
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">
		<div class="box box-solid box-default">
			<div class="box-header">学员列表</div>
			<div class="box-body">
				<form class="form-horizontal" role="form" id="mgtuserForm" method="post" action="<%=path%>/mgtuser/${mgtUser.userId==null?"add":"update"}">
						<input id="hid_pkid" name="pkid" type="hidden"/>
					    <input id="hid_nationid" type="hidden"/>
						<input id="hid_householdid" type="hidden"/>
						<input id="hid_cultureid" type="hidden"/>
						<input id="hid_structid" type="hidden"/>
						<input id="hid_identid" type="hidden"/>
						<input id="hid_identlevel" type="hidden"/>
						<input id="hid_certificateType" type="hidden"/>
						<input id="hid_add_idxid"  name="idxid" type="hidden"/>
				
					<div class="form-group"  hidden="true">
						<input type="hidden" class="form-control" id="userId" name="userId" value="${mgtUser.userId}">
					</div>
					<div class="form-group">
						<label for="loginName" class="col-sm-2 control-label"><font color="red">*</font>班级联系人</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="careerid" name="careerid" placeholder="请输入用户名" value="${mgtUser.careerid}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">专业名称</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入真实姓名" value="${mgtUser.nickName}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">学员姓名</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入真实姓名" value="${mgtUser.nickName}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">民族</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入真实姓名" value="${mgtUser.nickName}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">户口性质</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入真实姓名" value="${mgtUser.nickName}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">身份证号</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入真实姓名" value="${mgtUser.nickName}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">联系电话</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入真实姓名" value="${mgtUser.nickName}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">地址</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入真实姓名" value="${mgtUser.nickName}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">文化程度</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入真实姓名" value="${mgtUser.nickName}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">人员类型</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入真实姓名" value="${mgtUser.nickName}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">证件类型</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入真实姓名" value="${mgtUser.nickName}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">证件号</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入真实姓名" value="${mgtUser.nickName}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">证书类型</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入真实姓名" value="${mgtUser.nickName}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">证书级别</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入真实姓名" value="${mgtUser.nickName}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">失业日期</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入真实姓名" value="${mgtUser.nickName}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">是否就业/创业</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入真实姓名" value="${mgtUser.nickName}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">是否结业</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入真实姓名" value="${mgtUser.nickName}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">备注</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入真实姓名" value="${mgtUser.nickName}">
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