<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			家政培训学员管理 <small>家政培训学员添加/修改</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i></a></li>
			<li><a href="#"><i class="fa"></i>家政培训学员添加/修改</a></li>
			<!-- <li class="active">Here</li> -->
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">
		<div class="box box-solid box-default">
			<div class="box-header"></div>
			<div class="box-body">
				<form class="form-horizontal" role="form" id="tirOrganForm" method="post" action="<%=request.getContextPath()%>/hktirStudent/save">
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
								<input type="hidden" class="form-control " id="branchid" name="branchid" value="${hktirStudent.branchid }" />
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label"><font color="red">*</font>姓名</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="name"  required="required"
								name="name" placeholder="请输入机构姓名"
								value="${hktirStudent.name}">
						</div>
					</div>
					<div class="form-group">
						<label for="idno" class="col-sm-2 control-label"><font color="red">*</font>性别</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="sexual" required="required"
								name="sexual" placeholder="请输入性别"
								value="${hktirStudent.sexual}">
						</div>
					</div>
					<div class="form-group">
						<label for="age" class="col-sm-2 control-label"><font color="red">*</font>年龄</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="age" required="required"
								name="age" placeholder="请输入年龄"
								value="${hktirStudent.age}">
						</div>
					</div>
					<div class="form-group">
						<label for="idnumber" class="col-sm-2 control-label"><font color="red">*</font>身份证号</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="idnumber" required="required"
								name="idnumber" placeholder="请输入身份证号"
								value="${hktirStudent.idnumber}">
						</div>
					</div>
					<div class="form-group">
						<label for="triainyear" class="col-sm-2 control-label"><font color="red">*</font>培训年度</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="triainyear" 
								name="triainyear" placeholder="请输入培训年度"
								value="${hktirStudent.triainyear}">
						</div>
					</div>
					<div class="form-group">
						<label for="triainyear" class="col-sm-2 control-label"><font color="red">*</font>培训时间</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="triainyear" 
								name="triainyear" placeholder="请输入培训时间"
								value="${hktirStudent.triainyear}">
						</div>
					</div>
					<div class="form-group">
						<label for="triainyear" class="col-sm-2 control-label">培训专业</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="triainyear"
								name="triainyear" placeholder="请输入培训专业"
								value="${hktirStudent.triainyear}">
						</div>
					</div>
					<div class="form-group">
						<label for="traintime" class="col-sm-2 control-label">培训期次</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="traintime"
								name="traintime" placeholder="请输培训期次"
								value="${hktirStudent.traintime}">
						</div>
					</div>
					<div class="form-group">
						<label for="trainprof" class="col-sm-2 control-label">培训等级</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="trainprof"
								name="trainprof" placeholder="请输入培训等级"
								value="${hktirStudent.trainprof}">
						</div>
					</div>
					<div class="form-group">
						<label for="trainperiod" class="col-sm-2 control-label"><font color="red">*</font>家庭住址</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="trainperiod" required="required"
								name="trainperiod" placeholder="请输入在职教职工总人数"
								value="${hktirStudent.trainperiod}">
						</div>
					</div>
					<div class="form-group">
						<label for="proflevel" class="col-sm-2 control-label"><font color="red">*</font>培训范围</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="proflevel" required="required"
								name="proflevel" placeholder="请输入培训范围"
								value="${hktirStudent.proflevel}">
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="col-sm-2 control-label"><font color="red">*</font>培训规模</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="phone" required="required"
								name="phone" placeholder="请输入培训规模"
								value="${hktirStudent.phone}">
						</div>
					</div>
					<div class="form-group">
						<label for="ispassidentify" class="col-sm-2 control-label"><font color="red">*</font>是否通过职业技能鉴定</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="ispassidentify"   
								name="ispassidentify" placeholder="请输入是否通过职业技能鉴定"required="required"
								value="${hktirStudent.ispassidentify}">
						</div>
					</div>
					<div class="form-group">
						<label for="istrainqualify" class="col-sm-2 control-label"><font color="red">*</font>培训是否合格</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="istrainqualify"   required="required"
								name="istrainqualify" placeholder="请输入培训是否合格"
								value="${hktirStudent.istrainqualify}">
						</div>
					</div>
					<div class="form-group">
						<label for="memo" class="col-sm-2 control-label"><font color="red">*</font>备注</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="memo"  required="required"
								name="memo" placeholder="请输入备注"
								value="${hktirStudent.memo}">
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