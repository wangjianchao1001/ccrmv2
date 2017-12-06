<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="decorator" content="mainframe" />
<title>帐户管理</title>
<style>
	<!--
		body{overflow: hidden}
		.content-wrapper{background-color:#fff}
		.modal-content{box-shadow:none;}
		.modal-footer{}
	-->
</style>
</head>
<body>
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close" onclick="javascript:parent.modalFrame('hide')">
				<span aria-hidden="true">×</span>
			</button>
			<h4 class="modal-title">&nbsp;<b>${user.cid}</b>&nbsp;修改密码</h4>
		</div>
		<form class="form-horizontal" role="form" id="resetPasswordForm" >
		<input type="hidden" id="userId" name="userId" value="${user.pkid}" />
		<div class="modal-body" style="padding:5% 20% 0% 20%">
				<div class="form-group has-feedback">
					<input type="password" class="form-control" placeholder="原密码" id="oldPassword" >
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" placeholder="新密码" id="password" name="password">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" id="passwordConfirm" name="passwordConfirm" placeholder="请再次输入密码"> 
					<span class="glyphicon glyphicon-log-in form-control-feedback"></span>
				</div>
		</div>
		<div class="modal-footer">
			<div class="form-group has-error pull-left" style="display:inline-block;margin-left:15%">
				<label class="control-label" for="inputError" id="errorMessage">&nbsp;</label>
			</div>
			<div class="pull-right" style="display:inline-block">
				<button type="button" class="btn btn-default pull-left" id="button_hide" onclick="javascript:parent.modalFrame('hide')"
					data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-danger" id="submitBut" onclick="submitForm()">修改</button>
			</div>
		</div>
		</form>
	</div>
	<script>
		var path = "<%=request.getContextPath()%>";
		function submitForm(){
			$("div.modal-body div.form-group").removeClass("has-error");
			var userId = $("#userId").val();
			var oldPassword = $("#oldPassword").val();
			var password = $("#password").val();
			var passwordConfirm = $("#passwordConfirm").val();
			if(password == ""||oldPassword == ""||passwordConfirm==""){
				$("#password").parent().addClass("has-error");
				$("#errorMessage").html("密码不能为空");
				return false;
			}else{
				if(password.length<6){
					$("#errorMessage").html("密码长度不小于6位");
					return false;
				}
			}
			if(password != passwordConfirm){
				$("#passwordConfirm").parent().addClass("has-error");
				$("#errorMessage").html("两次输入不一致");
				return false;
			}
			
			var result = checkOldPassword(oldPassword,userId);
			if(result){
				$.ajax({
					url : path + "/user/password/update",
					data : {
						password : password,
						userId : userId
					},
					datetype : "json",
					error:function(msg){
						$("#errorMessage").val(msg);
					}, 
					success : function(msg) {
						parent.modalFrame('hide');
						setTimeout(function(){
							alert(msg);
						}, 200); 
					}
				});
			}else{
				return false;
			}
			
		}; 
		
		function checkOldPassword(oldPassword,userId){
			var flag=false;
			$.ajax({
				url : path + "/user/checkPassword",
				async: false,
				data : {
					password : oldPassword,
					userId : userId
				},
				datetype : "json",
				success : function(msg) {
					if(msg){
						flag = true;
					}else{
						$("#errorMessage").html("原密码不正确");
					}
				}
			});
			return flag;	
		}
		
	</script>
</body>
</html>