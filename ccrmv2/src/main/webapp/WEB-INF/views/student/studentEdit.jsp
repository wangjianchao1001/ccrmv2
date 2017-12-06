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
			学员管理 <small>学员新增/修改</small>
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
				<form class="form-horizontal" role="form" id="studentForm" method="post" action="<%=path%>/tirStudent/save">
				
					<div class="form-group"  hidden="true">
						<input type="hidden" class="form-control" id="pkid" name="pkid" value="${student.pkid}">
					</div>
					<div class="form-group">
						<label for="loginName" class="col-sm-2 control-label"><font color="red">*</font>培训班</label>
						<div class="input-group col-sm-5">
							<select class="form-control selectpicker show-tick" name="idxid" >
							<option value='' <c:if test="${student.idxid == '' }">selected="selected"</c:if>>选择培训班</option>
							<c:forEach var="tirClass" items="${classList }">
								<c:if test="${tirClass.careerName != '' or tirClass.careerName != null }">
									<option value='${tirClass.pkid }'<c:if test="${student.idxid == tirClass.pkid }">selected="selected"</c:if>>${tirClass.careerName }(${tirClass.datebegin } -- ${tirClass.dateend })</option>
								</c:if>
							</c:forEach>
						</select> 
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">学员姓名</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名" value="${student.name}">
						</div>
					</div> --%>
					<div class="form-group">
						<label for="nationid" class="col-sm-2 control-label">民族</label>
						<div class="input-group col-sm-5">
							<select class="form-control selectpicker show-tick" name="nationid" >
							<option value='0' <c:if test="${student.nationid == '' }">selected="selected"</c:if>>请选择民族</option>
							<c:forEach var="dic" items="${dicList }">
								<c:if test="${dic.idxid == 70}">
									<option value='${dic.pkid }'<c:if test="${student.nationid == dic.pkid }">selected="selected"</c:if>>${dic.name }</option>
								</c:if>
							</c:forEach>
						</select>
						</div>
					</div>
					<div class="form-group">
						<label for="householdid" class="col-sm-2 control-label">户口性质</label>
						<div class="input-group col-sm-5">
							<select class="form-control selectpicker show-tick" name="householdid" >
								<option value='0' <c:if test="${student.householdid == '' }">selected="selected"</c:if>>请选择户口性质</option>
								<c:forEach var="dic" items="${dicList }">
									<c:if test="${dic.idxid == 71}">
										<option value='${dic.pkid }'<c:if test="${student.householdid == dic.pkid }">selected="selected"</c:if>>${dic.name }</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="idno" class="col-sm-2 control-label">身份证号</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="idno" name="idno" placeholder="请输入身份证号" value="${student.idno}">
						</div>
					</div>
					<div class="form-group">
						<label for="phoneno" class="col-sm-2 control-label">联系电话</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="phoneno" name="phoneno" placeholder="请输入联系电话" value="${student.phoneno}">
						</div>
					</div>
					<div class="form-group">
						<label for="nickName" class="col-sm-2 control-label">地址</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="adress" name="adress" placeholder="请输入地址" value="${student.adress}">
						</div>
					</div>
					<div class="form-group">
						<label for="cultureid" class="col-sm-2 control-label">文化程度</label>
						<div class="input-group col-sm-5">
							<select class="form-control selectpicker show-tick" name="cultureid" >
								<option value='0' <c:if test="${student.cultureid == '' }">selected="selected"</c:if>>请选择文化程度</option>
								<c:forEach var="dic" items="${dicList }">
									<c:if test="${dic.idxid == 72 }">
										<option value='${dic.pkid }'<c:if test="${student.cultureid == dic.pkid }">selected="selected"</c:if>>${dic.name }</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="structid" class="col-sm-2 control-label">人员类型</label>
						<div class="input-group col-sm-5">
							<select class="form-control selectpicker show-tick" name="cultureid" >
								<option value='0' <c:if test="${student.structid == '' }">selected="selected"</c:if>>请选择人员类型</option>
								<c:forEach var="dic" items="${dicList }">
									<c:if test="${dic.idxid == 73}">
										<option value='${dic.pkid }'<c:if test="${student.structid == dic.pkid }">selected="selected"</c:if>>${dic.name }</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="identid" class="col-sm-2 control-label">证件类型</label>
						<div class="input-group col-sm-5">
							<select class="form-control selectpicker show-tick" name="identid" >
								<option value='0' <c:if test="${student.identid == '' }">selected="selected"</c:if>>请选择证件类型</option>
								<c:forEach var="dic" items="${dicList }">
									<c:if test="${dic.idxid == 74}">
										<option value='${dic.pkid }'<c:if test="${student.identid == dic.pkid }">selected="selected"</c:if>>${dic.name }</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="identno" class="col-sm-2 control-label">证件号</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="identno" name="identno" placeholder="请输入证件号" value="${student.identno}">
						</div>
					</div>
					<div class="form-group">
						<label for="certificateType" class="col-sm-2 control-label">证书类型</label>
						<div class="input-group col-sm-5">
							<select class="form-control selectpicker show-tick" name="certificatetype" >
								<option value='0' <c:if test="${student.certificatetype == '' }">selected="selected"</c:if>>请选择证书类型</option>
								<c:forEach var="dic" items="${dicList }">
									<c:if test="${dic.idxid == 40}">
										<option value='${dic.pkid }'<c:if test="${student.certificatetype== dic.pkid }">selected="selected"</c:if>>${dic.name }</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="identlevel" class="col-sm-2 control-label">证书级别</label>
						<div class="input-group col-sm-5">
							<select class="form-control selectpicker show-tick" name="identlevel" >
								<option value='0' <c:if test="${student.identlevel == '' }">selected="selected"</c:if>>请选择证书级别</option>
								<c:forEach var="dic" items="${dicList }">
									<c:if test="${dic.idxid == 81}">
										<option value='${dic.pkid }'<c:if test="${student.identlevel == dic.pkid }">selected="selected"</c:if>>${dic.name }</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="dateunemployed" class="col-sm-2 control-label">失业日期</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="dateunemployed" name="dateunemployed" placeholder="请选择失业日期" value="${student.dateunemployed}" onfocus="WdatePicker({dateFmt:'yyyyMMdd'})">
						</div>
					</div>
					<div class="form-group">
						<label for="isemploy" class="col-sm-2 control-label">是否就业/创业</label>
						<div class="input-group col-sm-5">
							<select class="form-control selectpicker show-tick" name="isemploy" >
								<option value='1' <c:if test="${student.isemploy == '1'}">selected="selected"</c:if>>是</option>
								<option value='0' <c:if test="${student.isemploy == '0' or student.isemploy == '' }">selected="selected"</c:if>>否</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="ispasser" class="col-sm-2 control-label">是否结业</label>
						<div class="input-group col-sm-5">
							<select class="form-control selectpicker show-tick" name="ispasser" >
								<option value='1' <c:if test="${student.ispasser == '1'}">selected="selected"</c:if>>是</option>
								<option value='0' <c:if test="${student.ispasser == '0' or student.ispasser == '' }">selected="selected"</c:if>>否</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="memo" class="col-sm-2 control-label">备注</label>
						<div class="input-group col-sm-5">
							<textarea cols="8" class="form-control" id="memo" name="memo"  placeholder="备注" >${student.memo}</textarea>
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
		/* $(function(){
			var validateRules = {
			};
			validateRules.loginName={
					required : true,
					remote : {
							    url:"../student/studentExist",     //后台处理程序
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
			$("#studentForm").validate({
				rules : validateRules,
				messages:{
					loginName:{
						required :"用户名不能为空",
						remote:"该用户名已经存在，请修改"
					}
				}
			});
		}); */
	
	</script>
</body>

</html>