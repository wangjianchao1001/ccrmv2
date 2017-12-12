<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/plugins/datepicker/skin/WdatePicker.css">
<meta name="decorator" content="mainframe" />
<title>家政企业员工管理</title>
</head>
<body>
	<section class="content-header">
		<h1 style="text-align : left;">
			员工管理<small>列表显示</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>员工列表信息</a></li>
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">
		<div class="box   box-default">
		<div class="box-header">
				<shiro:hasPermission name="10010100">
					<button type="button" class="btn btn-default" id="add">添加</button>
				</shiro:hasPermission>
				<div class="box-tools pull-right" var="agentUser" items="${agentUser}">
					<form class="form-horizontal" role="form" id="searchForm" action="<%=request.getContextPath()%>/employee/employeeList.html">
						<div class="input-group input-group-sm" style="width:220px;display:inline-block">
							<select class="form-control select2" name="organid" >
								<c:forEach items="${organList }" var="organ">
									<option value='${organ.pkid }' <c:if test="${employee.organid eq organ.pkid }">selected="selected"</c:if>>${organ.name }</option>
								</c:forEach>
							</select> 
						</div>
						<div style="display: inline-block">
							<div class="input-group input-group-sm"	style="width: 140px;">
								<input type="text" class="form-control input-sm" value="${employee.name }" name="name" placeholder="按姓名查询" />
							</div>	
						</div>
						<div style="display: inline-block">
							<div class="input-group input-group-sm"	style="width: 140px;">
								<input type="text" class="form-control input-sm" value="${employee.phoneno }" name="phoneno" placeholder="按联系电话查询" />
							</div>	
						</div>
						<div style="display: inline-block">
							<div class="input-group input-group-sm"	style="width: 120px;">
								<input type="text" class="form-control" id="dateentry1" name="dateentry1" placeholder="按入职时间查询" readonly 
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-{%d-1}'})" value="${dateentry1}">
							</div>	
						</div>
						至
						<div style="display: inline-block">
							<div class="input-group input-group-sm"	style="width: 120px;">
								<input type="text" class="form-control" id="dateentry2" name="dateentry2" placeholder="按入职时间查询" readonly 
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-{%d-1}'})" value="${dateentry2}">		
								<div class="input-group-btn">
									<button class="btn btn-sm btn-default" onclick="javascript:submitSearch();"> <i class="fa fa-search"></i> </button>
								</div>
							</div>	
						</div>
						
						<input type="hidden" name="pageNumber" id="pageNumber" value="${pager.pageNumber }"/>
						<input type="hidden" name="pageSize" value="${pager.pageSize }"/>
					</form>
				</div>
			</div>
			<div class="box-body">
				<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
					<input type="hidden" value="${message}" id="message" />
					<!--<caption>基本的表格布局</caption>  -->
					<thead>
					
						<tr>
							<th hidden="true">序号</th>
							<th>所属家庭服务业企业</th>
							<th>员工姓名</th>
							<th>身份证号</th>
							<th>联系电话</th>
							<th>邮箱</th>
							<th>入职时间</th>
							<th>离职时间</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="employ" items="${pager.datas }" varStatus="status"> 
							<tr>
								<td hidden="true">
									<input type="hidden" value="${employ.pkid}" id="pkid" name="pkid" />${employ.pkid}
								</td>
								<td><input type="hidden" value="${employ.organid}" name="organid" />${employ.orgName}</td>
								<td>${employ.name}</td>
								<td>${employ.idno}</td>
								<td>${employ.phoneno}</td>
								<td>${employ.email}</td>
								<td>${employ.dateentry}</td>
								<td>${employ.dateleave}</td>
								<td>
									<c:if test="${employ.status == 2 }">
										离职
									</c:if>
									<c:if test="${employ.status == 1 }">
										在职
									</c:if>
								</td>
								<td>
									<shiro:hasPermission name="10010600">
										<a href="#"onclick="addorUpdate(this,'update')">修改</a>&nbsp;&nbsp;
									</shiro:hasPermission>
									<shiro:hasPermission name="10010200">
										<a href="#" onclick="delteEmployee(this)">删除</a>&nbsp;&nbsp;
									</shiro:hasPermission>
										<a href="#" onclick="addorUpdate(this,'view')">查看</a>&nbsp;&nbsp;
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
					<div class="row">
						<div class="dataTables_paginate paging_simple_numbers">
							<nav id="pager" class="col-sm-10"></nav>
						</div>
						<div class="col-sm-2" style="padding: 20px 0 0 20px ">
							<div class="dataTables_info" id="example1_info" role="status" aria-live="polite">${pager.pageNumber }/${pager.totalPages}页 共${pager.total }条</div>
						</div>
					</div>
			</div>
		</div>
		<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
			<ul id="treeDemo" class="ztree" style="margin-top:0; width:220px;"></ul>
		</div>
	</section>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/plugins/jquery/pager/jquery.pager.bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/plugins/jquery/pager/pager.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/plugins/datepicker/WdatePicker.js"></script>
	
	<script>
		var path = "<%=request.getContextPath()%>";
		var totalPages = ${pager.totalPages};	
		var pageNumber = ${pager.pageNumber};	
		var pageSize = ${pager.pageSize};
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
		$(document).ready(function() {
			
			$("#add").bind('click',function(){
				window.location.href =path + "/employee/edit.html?openType=add";
			});
			
			//操作成功提示
			var message=  $('#message').val();
			if(message!=null&&message!=''){
				  alert(message);
			}
			initPager("pager", pageNumber, totalPages, function(pageclickednumber){
				$("#pageNumber").val(pageclickednumber);
				$("#searchForm").submit();
			}, {});
			
		});
		
		function submitSearch(){
			$("#searchForm").submit();
		};
		
		//删除
		function delteEmployee(nowTr){
			confirmBox("确认删除？",function(nowTr){
				var id = $(nowTr).parent().parent().find("input[name=pkid]").val();
				$.ajax({
					url : path+"/employee/delete",
					data : {id : id},
					dataType : "json",
					success : function(msg){
						if(msg > 0){
							alert("删除成功");
							 $(nowTr).parent().parent().remove();
						}else{
							alert("删除失败");
						}
					}
					
				});				
			},nowTr,{
				cancleText : "再想想",
				okText : "删除",
			});
		};
		function addorUpdate(nowTr,openType){
			var pkid = $(nowTr).parent().parent().find("input[name=pkid]").val();
			window.location.href = path + "/employee/edit.html?openType="+openType+"&id="+pkid;
		}; 
	</script>
</body>
</html>