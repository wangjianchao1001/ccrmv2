<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/ztree/js/callZtree.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/ztree/css/demo.css" />	
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/ztree/css/zTreeStyle/zTreeStyle.css" />	
<meta name="decorator" content="mainframe" />
<title>家庭服务企业管理</title>
</head>
<body>
	<section class="content-header">
		<h1 style="text-align : left;">
			家庭服务企业管理 <small>家庭服务企业添加/修改</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i></a></li>
			<li><a href="#"><i class="fa"></i>家庭服务企业添加/修改</a></li>
			<!-- <li class="active">Here</li> -->
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">
		<div class="box box-solid box-default">
			<div class="box-header"></div>
			<div class="box-body">
				<form class="form-horizontal" role="form" id="tirOrganForm" method="post" action="<%=request.getContextPath()%>/housekeeping/save">
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
							<c:if test="${type == 'add' }">
								<input type="text" class="form-control" id="branchName" required="required"
												name="branchName" placeholder="请选择所属机构" readonly 
												value="${branch.name}" onfocus="showBranchTree(); return false;"> 
							</c:if>
							<c:if test="${type != 'add' }">
								<c:if test="${not empty branchTree }">
									<c:forEach var="branch" items="${branchList }">
										<c:if test="${regOrgan.branchid eq branch.pkid }">
											<input type="text" class="form-control" id="branchName" required="required"
												name="branchName" placeholder="请选择所属机构" readonly 
												value="${branch.name}" onfocus="showBranchTree(); return false;"> 
										</c:if> 
									</c:forEach>
								</c:if>
							</c:if>
								<input type="hidden" class="form-control " id="branchid" name="branchid" value="${regOrgan.branchid }" />
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label"><font color="red">*</font>企业名称</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="name"  required="required" name="name" placeholder="请输入企业名称" value="${regOrgan.name}">
						</div>
					</div>
					<div class="form-group">
						<label for="valuecode01" class="col-sm-2 control-label"><font color="red">*</font>性质</label>
						<div class="input-group col-sm-5">
								<select class="form-control selectpicker show-tick" name="valuecode01" >
								
								<option value='8201' <c:if test="${regOrgan.valuecode01 == 8201 }">selected="selected"</c:if>>员工制企业</option>
								<option value='8202' <c:if test="${regOrgan.valuecode01 == 8202 }">selected="selected"</c:if>>综合类企业</option>
								<option value='8203' <c:if test="${regOrgan.valuecode01 == 8203 }">selected="selected"</c:if>>家政服务企业</option>
								<option value='8204' <c:if test="${regOrgan.valuecode01 == 8204 }">selected="selected"</c:if>>养老护理企业</option>
								<option value='8205' <c:if test="${regOrgan.valuecode01 == 8205 }">selected="selected"</c:if>>病患陪护企业</option>
								<option value='8206' <c:if test="${regOrgan.valuecode01 == 8206 }">selected="selected"</c:if>>社区照料企业</option>
								<option value='8207' <c:if test="${regOrgan.valuecode01 == 8207 }">selected="selected"</c:if>>其他业态企业</option>
							</select> 
						</div>
					</div>
					<div class="form-group">
						<label for="idno" class="col-sm-2 control-label"><font color="red">*</font>成立时间</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="cmdate" name="cmdate" placeholder="请输选择成立日期" readonly 
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-{%d-1}'})" value="${regOrgan.cmdate}">
						</div>
					</div>
					<div class="form-group">
						<label for="corpperson" class="col-sm-2 control-label"><font color="red">*</font>营业执照号</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="idno" required="required" name="idno" placeholder="请输入营业执照号" value="${regOrgan.idno}">
						</div>
					</div>
					<div class="form-group">
						<label for="linkman" class="col-sm-2 control-label"><font color="red">*</font>税务登记号</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="valuestr04" required="required" name="valuestr04" placeholder="请输入税务登记号" value="${regOrgan.valuestr04}">
						</div>
					</div>
					<div class="form-group">
						<label for="phoneno" class="col-sm-2 control-label"><font color="red">*</font>经营地址</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="address"  name="address" placeholder="请输入经营地址" value="${regOrgan.address}">
						</div>
					</div>
					<div class="form-group">
						<label for="address" class="col-sm-2 control-label"><font color="red">*</font>注册资金(万元)</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="regfund" name="regfund" placeholder="请输入注册资金(万元)" value="${regOrgan.regfund}" />
						</div>
					</div>
					<div class="form-group">
						<label for="valuestr01" class="col-sm-2 control-label">法人代表</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="corpperson" name="corpperson" placeholder="请输入法人代表" value="${regOrgan.corpperson}">
						</div>
					</div>
					<div class="form-group">
						<label for="valuestr02" class="col-sm-2 control-label">身份证号</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="valuestr06" name="valuestr06" placeholder="请输入身份证号" value="${regOrgan.valuestr06}">
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">联系电话</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="email" name="email" placeholder="请输入联系电话" value="${regOrgan.email}">
						</div>
					</div>
					<div class="form-group">
						<label for="valueint05" class="col-sm-2 control-label"><font color="red">*</font>企业联系人</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="linkman" required="required" name="linkman" placeholder="请输入企业联系人" value="${regOrgan.linkman}">
						</div>
					</div>
					<div class="form-group">
						<label for="valueint06" class="col-sm-2 control-label"><font color="red">*</font>单位职务</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="valuestr08" required="required" name="valuestr08" placeholder="请输入单位职务" value="${regOrgan.valuestr08}">
						</div>
					</div>
					<div class="form-group">
						<label for="valueint07" class="col-sm-2 control-label"><font color="red">*</font>联系电话</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="phoneno" required="required" name="phoneno" placeholder="请输入联系电话" value="${regOrgan.phoneno}">
						</div>
					</div>
					<div class="form-group">
						<label for="valuenum01" class="col-sm-2 control-label"><font color="red">*</font>职工总数</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="valuecode07" name="valuecode07" placeholder="请输入职工总数"required="required" value="${regOrgan.valuecode07}">
						</div>
					</div>
					<div class="form-group">
						<label for="valuenum02" class="col-sm-2 control-label"><font color="red">*</font>女性人数</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="valuecode08"   required="required" name="valuecode08" placeholder="请输入女性人数" value="${regOrgan.valuecode08}">
						</div>
					</div>
					<div class="form-group">
						<label for="valuenum03" class="col-sm-2 control-label"><font color="red">*</font>城镇户籍人数</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="valuecode09"  required="required" name="valuecode09" placeholder="请输入城镇户籍人数" value="${regOrgan.valuecode09}">
						</div>
					</div>
					<div class="form-group">
						<label for="valuenum03" class="col-sm-2 control-label"><font color="red">*</font>签订劳动合同人数</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="valuecode10"  required="required" name="valuecode10" placeholder="请输入签订劳动合同人数" value="${regOrgan.valuecode10}">
						</div>
					</div>
					<div class="form-group">
						<label for="valuenum03" class="col-sm-2 control-label"><font color="red">*</font>参加社保人数</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="valuenum04"  required="required" name="valuenum04" placeholder="请输入参加社保人数" value="${regOrgan.valuenum04}">
						</div>
					</div>
					<div class="form-group">
						<label for="valuenum03" class="col-sm-2 control-label"><font color="red">*</font>持证上岗人数</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="valuenum05"  required="required" name="valuenum05" placeholder="请输入持证上岗人数如果没有，请输入“0”" value="${regOrgan.valuenum05}">
						</div>
					</div>
					<div class="form-group">
						<label for="valuenum03" class="col-sm-2 control-label"><font color="red">*</font>享受就业政策情况</label>
						<div class="input-group col-sm-5">
							<input type="text" class="form-control" id="memo"  required="required" name="memo" placeholder="请输入享受就业政策情况" value="${regOrgan.memo}">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<c:if test="${type != 'view' }">
								<button type="submit" class="btn btn-primary">提交</button>
							</c:if>
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