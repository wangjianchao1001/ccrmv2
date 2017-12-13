
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
			派遣管理 <small>派遣人员修改</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>派遣人员列表</a></li>
			<li><a href="#"><i class="fa"></i>派遣人员修改</a></li>
			<!-- <li class="active">Here</li> -->
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">
		<div class="box box-solid box-default">
			<div class="box-header">派遣人员列表</div>
			<div class="box-body">
				<form class="form-horizontal" role="form" id="mgtuserForm" method="post" action="<%=path%>/dispatch/save}">
						<input id="hid_pkid" name="pkid" type="hidden"/>
				
					<div class="form-group">
						<label for="loginName" class="col-sm-2 control-label"><font color="red">*</font>所属家庭服务业企业</label>
						<div class="input-group col-sm-5">
							<select class="form-control select2" name="organid" placeholder="请选择家庭服务企业名称" >
								<c:forEach items="${organList }" var="organ">
									<option value='${organ.pkid }' <c:if test="${dispatch.organid eq organ.pkid }">selected="selected"</c:if>>${organ.name }</option>
								</c:forEach>
							</select> 
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">姓名</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名" value="${dispatch.name}">
						</div>
					</div>
					<div class="form-group">
						<label for="idno" class="col-sm-2 control-label">身份证号</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="idno" name="idno" placeholder="请输入身份证号" value="${dispatch.idno}">
						</div>
					</div>
					<div class="form-group">
						<label for="phoneno" class="col-sm-2 control-label">联系电话</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="phoneno" name="phoneno" placeholder="请输入联系电话" value="${dispatch.phoneno}">
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">邮箱</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="email" name="email" placeholder="邮箱" value="${dispatch.email}">
						</div>
					</div>
					<div class="form-group">
						<label for="svritemid" class="col-sm-2 control-label">家庭服务行业项目分类</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="branchName" placeholder="请选择家庭服务行业项目分类" value="${dispatch.svritemName}" onfocus="showBranchTree('#branchName'); return false;">
							<input type="hidden" class="form-control" id="branchid" name="svritemid" value="${dispatch.svritemid}">
						</div>
					</div>
					<div class="form-group">
						<label for="emname" class="col-sm-2 control-label">雇主姓名</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="emname" name="emname" placeholder="请输入雇主姓名" value="${dispatch.emname}">
						</div>
					</div>
					<div class="form-group">
						<label for="emphoneno" class="col-sm-2 control-label">雇主联系电话</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="emphoneno" name="emphoneno" placeholder="请输入雇主联系电话" value="${dispatch.emphoneno}">
						</div>
					</div>
					<div class="form-group">
						<label for="emadress" class="col-sm-2 control-label">雇主地址</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="emadress" name="emadress" placeholder="请输入雇主地址" value="${dispatch.emadress}">
						</div>
					</div>
					<div class="form-group">
						<label for="trainmemo" class="col-sm-2 control-label">培训简述</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="trainmemo" name="trainmemo" placeholder="请输入培训简述" value="${dispatch.trainmemo}">
						</div>
					</div>
					<div class="form-group">
						<label for="cermemo" class="col-sm-2 control-label">证书简述</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="cermemo" name="cermemo" placeholder="请输入证书简述" value="${dispatch.cermemo}">
						</div>
					</div>
					<div class="form-group">
						<label for="status" class="col-sm-2 control-label">状态</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="status" name="status" placeholder="请输入状态" value="${dispatch.status}">
						</div>
					</div>
					<div class="form-group">
						<label for="dateentry" class="col-sm-2 control-label">推荐日期</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="dateentry" name="dateentry" placeholder="请输选择入职日期" readonly 
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-{%d-1}'})" value="${dispatch.dateentry}">
						</div>
					</div>
					<div class="form-group">
						<label for="dateleave" class="col-sm-2 control-label">退回时间</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="dateleave" name="dateleave" placeholder="请输选择入职日期" readonly 
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-{%d-1}'})" value="${dispatch.dateleave}">
						</div>
					</div>
					<div class="form-group">
						<label for="memo" class="col-sm-2 control-label">备注</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="memo" name="memo" value="${dispatch.memo}">
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