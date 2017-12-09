<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
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
			家庭服务企业<small>列表显示</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>家庭服务企业信息</a></li>
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
					<form class="form-horizontal" role="form" id="searchForm" action="<%=request.getContextPath()%>/housekeeping/housekeepingList.html">
						<div class="input-group input-group-sm" style="width:220px;display:inline-block">
							<input type="text" class="form-control " id="branchName" name="branchName" placeholder="按所属机构查找" readonly value="${regOrgan.branchName }" onfocus="showBranchTree('#branchName'); return false;"/>
							<input type="hidden" class="form-control " id="branchid" name="branchid" value="${regOrgan.branchid }"/>
						</div>
						<div class="input-group input-group-sm" style="width:150px;display:inline-block">
							<select class="form-control selectpicker show-tick" name="valuecode01" >
								<option value='' <c:if test="${regOrgan.valuecode01 == '' }">selected="selected"</c:if>>请选择机构分类</option>
								<option value='8201' <c:if test="${regOrgan.valuecode01 == 8201 }">selected="selected"</c:if>>员工制企业</option>
								<option value='8202' <c:if test="${regOrgan.valuecode01 == 8202 }">selected="selected"</c:if>>综合类企业</option>
								<option value='8203' <c:if test="${regOrgan.valuecode01 == 8203 }">selected="selected"</c:if>>家政服务企业</option>
								<option value='8204' <c:if test="${regOrgan.valuecode01 == 8204 }">selected="selected"</c:if>>养老护理企业</option>
								<option value='8205' <c:if test="${regOrgan.valuecode01 == 8205 }">selected="selected"</c:if>>病患陪护企业</option>
								<option value='8206' <c:if test="${regOrgan.valuecode01 == 8206 }">selected="selected"</c:if>>社区照料企业</option>
								<option value='8207' <c:if test="${regOrgan.valuecode01 == 8207 }">selected="selected"</c:if>>其他业态企业</option>
							</select> 
						</div>
						<div style="display: inline-block">
							<div class="input-group input-group-sm"	style="width: 150px;">
								<input type="text" class="form-control input-sm" value="${regOrgan.name }" name="name" placeholder="按联系企业名称查询" />
							</div>	
						</div>
						<div style="display: inline-block">
							<div class="input-group input-group-sm"	style="width: 150px;">
								<input type="text" class="form-control input-sm" value="${regOrgan.phoneno }" name="phoneno" placeholder="按联系电话查询" />
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
							<th>管理机构名称</th>
							<th>企业名称</th>
							<th>类型</th>
							<th>营业执照号</th>
							<th>注册资金(万元)</th>
							<th>法人代表</th>
							<th>联系电话</th>
							<th>联系人</th>
							<th>企业地址</th>
							<th>职工总数</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="organ" items="${pager.datas }" varStatus="status"> 
							<tr>
								<td hidden="true">
									<input type="hidden" value="${organ.pkid}" id="pkid" name="pkid" />${organ.pkid}
								</td>
								<td><input type="hidden" value="${organ.branchid}" name="branchid" />${organ.branchName}</td>
								<td>
									<input type="hidden" value="${organ.name}" name="orgName" />
									<a href="#" onclick="addorUpdate(this,'view')">${organ.name}</a></td>
								<td>
									<c:if test="${organ.valuecode01 == 8201 }">员工制企业</c:if>
									<c:if test="${organ.valuecode01 == 8202 }">综合类企业</c:if>
									<c:if test="${organ.valuecode01 == 8203 }">家政服务企业</c:if>
									<c:if test="${organ.valuecode01 == 8204 }">养老护理企业</c:if>
									<c:if test="${organ.valuecode01 == 8205 }">病患陪护企业</c:if>
									<c:if test="${organ.valuecode01 == 8206 }">社区照料企业</c:if>
									<c:if test="${organ.valuecode01 == 8207 }">其他业态企业</c:if>
								</td>
								<td>${organ.idno}</td>
								<td>${organ.regfund}</td>
								<td>${organ.corpperson}</td>
								<td>${organ.phoneno}</td>
								<td>${organ.linkman}</td>
								<td>${organ.address}</td>
								<td>${organ.valuecode07}</td>
								<td>
									<c:if test="${organ.status == -1 }">
										删除
									</c:if>
									<c:if test="${organ.status == 0 }">
										新建未提交
									</c:if>
									<c:if test="${organ.status == 1 }">
										正常
									</c:if>
									<c:if test="${organ.status == 2 }">
										冻结
									</c:if>
								</td>
								<td>
									<shiro:hasPermission name="10010600">
										<a href="#"onclick="addorUpdate(this,'edit')">修改</a>&nbsp;&nbsp;
									</shiro:hasPermission>
									<shiro:hasPermission name="10010200">
										<a href="#" onclick="delteTirOrg(this)">删除</a>&nbsp;&nbsp;
									</shiro:hasPermission>
									<shiro:hasPermission name="10010400">
										<c:if test="${organ.status == 0 }">
											<a href="#" onclick="commitHK(this)">提交</a>&nbsp;&nbsp;
										</c:if>
									</shiro:hasPermission>
									<br />
									<a href="#" onclick="getEmployee(this)">查看员工</a>&nbsp;&nbsp;
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
		$(document).ready(function() {
			
			//机构数
			$.fn.zTree.init($("#treeDemo"), setting, branchTree);
			
			$("#add").bind('click',function(){
				window.location.href ="<%=request.getContextPath()%>/housekeeping/edit.html?type=add";
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
			//机构数
			$.fn.zTree.init($("#treeDemo"), setting, branchTree);
		};
		
		//删除
		function delteTirOrg(nowTr){
			confirmBox("确认删除？",function(nowTr){
				var id = $(nowTr).parent().parent().find("input[name=pkid]").val();
				$.ajax({
					url : path+"/tirOrgan/delete",
					data : {id : id},
					dataType : "json",
					success : function(msg){
						if(msg > 0){
							alert("删除成功");
							 $(nowTr).parent().parent().remove();
						}else{
							alert("删除失败");
						};	
					}
					
				});				
			},nowTr,{
				cancleText : "再想想",
				okText : "删除",
			});
		};
		function addorUpdate(nowTr,type){
			var pkid = $(nowTr).parent().parent().find("input[name=pkid]").val();
			window.location.href = path + "/housekeeping/edit.html?type="+type+"&id="+pkid;
		}; 
		function commitHK(nowTr){
			var pkid = $(nowTr).parent().parent().find("input[name=pkid]").val();
			window.location.href = path + "/housekeeping/commit?id="+pkid;
		}; 
		
		function getEmployee(nowTr){
			var pkid = $(nowTr).parent().parent().find("input[name=pkid]").val();
			var orgName = $(nowTr).parent().parent().find("input[name=orgName]").val();
			var tabUrl = path + "/employee/employeeList.html?organid="+pkid+"&orgName="+orgName;
			window.parent.parent.openTab('1018','员工管理',tabUrl);

		};
		
		
		
	</script>
</body>
</html>