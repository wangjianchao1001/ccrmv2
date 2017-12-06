<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>呼市职业技能培训登记统计系统</title>
<!-- Tell the browser to be responsive to screen width -->
<%@ include file="/WEB-INF/views/include/commoncss.jsp"%>
<%@ include file="/WEB-INF/views/include/commonjs.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/plugins/iCheck/square/blue.css"></link>

</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<img src="static/images/benz_logo.png" /><b>&nbsp;</b><a>呼市职业技能培训登记统计系统</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">登陆管理系统</p>
			<form action="login" method="post">
				<div class="form-group has-feedback">
					<input type="text" name="loginName"
						class="form-control text-center" placeholder="Name"> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="password"
						class="form-control text-center" placeholder="Password"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row has-error text-center">
					<lable class="control-label">${errorMessage }</lable>
				</div>
				<div class="row text-center">
					<!-- <div class="col-xs-4">
						<div class="checkbox icheck">
							<lable> <input type="checkbox" /> 记住我 </lable>
						</div>
					</div>
					<div class="col-xs-4"></div> -->
					<div class="col-xs-12">
						<button type="submit" class="btn btn-primary btn-block btn-flat">登陆</button>
					</div>
					<!-- /.col -->
				</div>
			</form>
			<br /> <a href="javascript:void(0)">忘记密码请与管理员联系</a><br>
		</div>
	</div>
	<!-- /.login-box -->

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/static/plugins/iCheck/icheck.min.js"></script>
	<script>
		var path = "<%=request.getContextPath()%>";
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
			if (window != top) {
				top.location.href = location.href;
			}
		});
	</script>
</body>
</html>

