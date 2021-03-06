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
<title>家政培训机构管理</title>
</head>
<body>
	<section class="content-header">
		<h1 style="text-align : left;">
			家政培训机构<small>列表显示</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>家政培训机构信息</a></li>
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
					<form class="form-horizontal" role="form" id="searchForm" action="<%=request.getContextPath()%>/hktirInst/hktirInstList.html">
						<div class="input-group input-group-sm" style="width:220px;display:inline-block">
							<input type="text" class="form-control " id="branchName" name="branchName" placeholder="按所属机构查找" readonly value="${hkTirInst.branchName }" onfocus="showBranchTree('#branchName'); return false;"/>
							<input type="hidden" class="form-control " id="branchid" name="branchid" value="${hkTirInst.branchid }"/>
						</div>
						<div class="input-group input-group-sm" style="width:180px;display:inline-block">
							<select class="form-control selectpicker show-tick" name="type" >
								<option value='' <c:if test="${hkTirInst.type == '' }">selected="selected"</c:if>>按机构分类查询</option>
								<option value='1' <c:if test="${hkTirInst.type == 2 }">selected="selected"</c:if>>高等院校</option>
								<option value='2' <c:if test="${hkTirInst.type == 1 }">selected="selected"</c:if>>技工技校、职业学院、培训机构</option>
								<option value='3' <c:if test="${hkTirInst.type == 1 }">selected="selected"</c:if>>企业内设培训机构</option>
							</select> 
						</div>
						<div style="display: inline-block">
							<div class="input-group input-group-sm"	style="width: 180px;">
								<input type="text" class="form-control input-sm" value="${hkTirInst.corpphone }" name="corpphone" placeholder="按法人电话查询" />
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
					<thead>
						<tr>
							<th hidden="true">序号</th>
							<th>管理机构名称</th>
							<th>法人代表</th>
							<th>法人电话</th>
							<th>法人代码</th>
							<th>成立时间</th>
							<th>开设专业名称</th>
							
							<th>师资总数/员工总数</th>
							<th>全职教师数</th>
							<th>兼职教师人数</th>
							<th>高级职称教师数</th>
							<th>当年培养的毕业生人数</th>
							<th>通过职业技能鉴定人数</th>
							<th>毕业后当年实现就业人数</th>
							<th>培训后合格人数</th>
							<th>本企业员工技能提升培训人数</th>
							<th hidden="true">共建培训实习基地名称</th>
							<th>稳定合作关系的企业名称</th>
							<th>稳定合作关系的家政企业名称</th>
							<th>备注</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="hkTirInst" items="${pager.datas }" varStatus="status"> 
							<tr>
								<td hidden="true">
									<input type="hidden" value="${hkTirInst.pkid}" id="pkid" name="pkid" />${hkTirInst.pkid}
									<input type="hidden" value="${hkTirInst.organid}" id="organid" name="organid" />${hkTirInst.organid}
									<input type="hidden" value="${hkTirInst.branchid}" id="branchid" name="branchid" />${hkTirInst.branchid}
								</td>
								<td>${hkTirInst.branchName}</td>
								<td>${hkTirInst.corpperson}</td>
								<td>${hkTirInst.corpphone}</td>
								<td>${hkTirInst.corpcode}</td>
								<td><fmt:formatDate value='${hkTirInst.established}' pattern='yyyy-MM-dd'/></td>
								<td>${hkTirInst.professioname}</td>
								
								<td>${hkTirInst.teacher }</td>
								<td>${hkTirInst.fulltimeteacher }</td>
								<td>${hkTirInst.parttimeteacher }</td>
								<td>${hkTirInst.seniortitleteacher }</td>
								
								<td>${hkTirInst.graduate }</td>
								<td>${hkTirInst.thridentify }</td>
								<td>${hkTirInst.yearemployment }</td>
								<td>${hkTirInst.passtraining }</td>
								<td>${hkTirInst.employeetraining }</td>
								<td hidden="true">${hkTirInst.trainingplace }</td>
								<td>${hkTirInst.relationshipenterprise }</td>
								<td>${hkTirInst.relationshipdomenterpris }</td>
								<td>${hkTirInst.memo }</td>
								<td>
									<shiro:hasPermission name="10010600">
										<a href="#"onclick="addorUpdate(this)">修改</a>&nbsp;&nbsp;
									</shiro:hasPermission>
									<shiro:hasPermission name="10010200">
										<a href="#" onclick="delteInst(this)">删除</a>&nbsp;&nbsp;
									</shiro:hasPermission>

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
				window.location.href ="<%=request.getContextPath()%>/hktirInst/edit.html";
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
		function delteInst(nowTr){
			confirmBox("确认删除？",function(nowTr){
				var id = $(nowTr).parent().parent().find("input[name=pkid]").val();
				$.ajax({
					url : path+"/hktirInst/delete",
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
		function addorUpdate(nowTr){
			var pkid = $(nowTr).parent().parent().find("input[name=pkid]").val();
			window.location.href = path + "/hktirInst/edit.html?id="+pkid;
		}; 
		
		
		
	</script>
</body>
</html>