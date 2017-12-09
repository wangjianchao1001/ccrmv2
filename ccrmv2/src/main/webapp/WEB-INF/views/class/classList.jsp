<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/plugins/datepicker/skin/WdatePicker.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/static/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/ztree/js/callZtree.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/ztree/css/demo.css" />	
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/ztree/css/zTreeStyle/zTreeStyle.css" />	
<meta name="decorator" content="mainframe" />
<title>培训班管理</title>
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1 style="text-align: left;">
			培训班<small>列表显示</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>培训班</a></li>
			<!-- <li class="active">Here</li> -->
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">
		<div class="box   box-default">
			<div class="box-header">
				<shiro:hasPermission name="10020100">
				<button type="button" class="btn btn-default" id="add">新增</button>
				</shiro:hasPermission>
				<shiro:hasPermission name="10020700">
				<button type="button" class="btn btn-default" id="export">导出excel</button>
				</shiro:hasPermission>
				<div class="box-tools pull-right">
				<form class="form-horizontal" role="form" method="post" id="searchForm" action="<%=request.getContextPath()%>/tirClass/tirClassList.html">
					<div class="input-group input-group-sm" style="width:180px;display:inline-block">
						<input type="text" class="form-control " id="branchName" name="branchName" placeholder="按所属机构查找" readonly value="${branchName }" onfocus="showBranchTree('#branchName'); return false;"/>
						<input type="hidden" class="form-cont
						rol " id="branchid" name="branchid" value="${branchid }"/>
					</div>
					<div class="input-group input-group-sm" style="width:120px;display:inline-block">
						<select class="form-control selectpicker show-tick" name="status">
								  <option value=""  <c:if test="${params.status eq ''}" >selected = "selected"</c:if>>按状态查找</option>
						          <option value="0" <c:if test="${params.status eq '0'}" >selected = "selected"</c:if>>新建</option>
						          <option value="1" <c:if test="${params.status eq '1'}" >selected = "selected"</c:if>>正常</option>
						          <option value="2" <c:if test="${params.status eq '2'}" >selected = "selected"</c:if>>完成</option>
						</select> 
					</div>
					<div class="input-group input-group-sm" style="width:120px;display:inline-block">
						<select class="form-control selectpicker show-tick" name="kindid">
								  <option value=""  <c:if test="${params.kindid eq ''}" >selected = "selected"</c:if>>按类型查找</option>
						          <option value="1" <c:if test="${params.kindid eq '1'}" >selected = "selected"</c:if>>创业培训班</option>
						          <option value="2" <c:if test="${params.kindid eq '2'}" >selected = "selected"</c:if>>就业培训班</option>
						</select> 
					</div>
					<div class="input-group input-group-sm" style="width:130px;display:inline-block">
							<input type="text" class="form-control input-sm" id="Search_datebegin" readonly name="Search_datebegin" placeholder="查询开始时间(开班)"
									value="<fmt:formatDate value="${params.datebegin}" pattern="yyyyMMdd"/>"
									onfocus="WdatePicker({dateFmt:'yyyyMMdd'})">
					</div>
					<div style="display:inline-block"  >
						<div class="input-group input-group-sm" style="width:165px; height:30px;  "  >
							<input type="text" class="form-control input-sm" id="Search_dateend" readonly name="Search_dateend" placeholder="查询结束时间(开班)"
									value="<fmt:formatDate value="${params.dateend}" pattern="yyyyMMdd"/>"
									onfocus="WdatePicker({dateFmt:'yyyyMMdd'})">
				 				<div class="input-group-btn"  >
			                     	<button class="btn btn-sm btn-default" onclick="javascript:submitSearch();"><i class="fa fa-search"></i></button>
			                    </div>
						</div>
					</div>
						<input type="hidden" name="pageNumber" id="pageNumber" value="${pager.pageNumber }"/>
						<input type="hidden" name="pageSize" value="${pager.pageSize }"/>
				</form>
				</div>
			</div>
			<div class="box-body">
				<input type="hidden" value="${message}" id="message" />
				<table id="example" class="table table-striped table-bordered table-condensed" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th hidden="true">序号</th>
							<th>培训机构</th>
							<th>培训班类型</th>
							<th>专业名称</th>
							<th>培训期限</th>
							<th>培训等级</th>
							<th>开班时间</th>
							<th>结课时间</th>
							<th>联系人</th>
							<th>联系人电话</th>
							<th>授课地点</th>
							<th>使用教材</th>
							<th>是否特色专业</th>
							<th>状态</th>
							<th>备注</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="tirClass" items="${pager.datas }" varStatus="status">
							<tr>
								<td hidden="true"><input type="hidden" value="${tirClass.pkid}" /></td>
								<td>
									<c:forEach var="organ" items="${organList }" >
											<c:if test="${organ.pkid eq tirClass.orgid}">${organ.name }</c:if>
									</c:forEach>
								</td>
								<td>
									<c:if test="${tirClass.kindid eq 6001}" >创业培训班</c:if>
									<c:if test="${tirClass.kindid eq 6002}" >就业培训班</c:if>
								</td>
								<td>
									<c:forEach var="dic" items="${dicList }" >
											<c:if test="${dic.pkid eq tirClass.careerid}">${dic.name }</c:if>
									</c:forEach>
								</td>
								<td>
									<c:forEach var="dic" items="${dicList }" >
											<c:if test="${dic.pkid eq tirClass.termid}">${dic.name }</c:if>
									</c:forEach>
								</td>
								<td>
									<c:forEach var="dic" items="${dicList }" >
											<c:if test="${dic.pkid eq tirClass.gradeid}">${dic.name }</c:if>
									</c:forEach>
								</td>
								<td>${tirClass.datebegin}</td>
								<td>${tirClass.dateend}</td>
								<td>${tirClass.linkman}</td>
								<td>${tirClass.phoneno}</td>
								<td>${tirClass.teachaddress}</td>
								<td>${tirClass.teachmaterial}</td>
								<td>
									<c:if test="${tirClass.isspec eq 1}">是</c:if>
									<c:if test="${tirClass.isspec eq 0}">否</c:if>
								</td>
								<td>
									<c:if test="${tirClass.status eq 0}">新建</c:if>
									<c:if test="${tirClass.status eq 1}">正常</c:if>
									<c:if test="${tirClass.status eq 2}">完成</c:if>
									<c:if test="${tirClass.status eq 3}">锁定</c:if>
								</td>
								<td>${tirClass.memo}</td>
								<td>
									<shiro:hasPermission name="10020200">
										<a href="#"onclick="addorUpdate(this)">修改</a>&nbsp;&nbsp;
									</shiro:hasPermission>
									<shiro:hasPermission name="10020300">
										<a href="#" onclick="updateTirClass(this,'删除')">删除</a>&nbsp;&nbsp;
									</shiro:hasPermission>
									<shiro:hasPermission name="10020400">
										<c:if test="${organ.status == 0 }">
											<a href="#" onclick="updateTirClass(this,'提交')">提交</a>&nbsp;&nbsp;
										</c:if>
									</shiro:hasPermission>
									<shiro:hasPermission name="10020500">
										<c:if test="${Classan.status == 0 }">
											<a href="#" onclick="updateTirClass(this),'锁定'">锁定</a>&nbsp;&nbsp;
										</c:if>
									</shiro:hasPermission>
									<shiro:hasPermission name="10020600">
										<c:if test="${organ.status == 0 }">
											<a href="#" onclick="updateTirClass(this),'结课'">结课</a>&nbsp;&nbsp;
										</c:if>
									<shiro:hasPermission name="10030700">
										<a href="#" onclick="importStudent(this),'导入学员'">导入学员</a>&nbsp;&nbsp;
									</shiro:hasPermission>
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
		<!-- Modal -->
		<div class="modal fade" id="setRuleBox" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Modal title</h4>
					</div>
					<div class="modal-body">...</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary">保存</button>
					</div>
				</div>
			</div>
		</div>
		<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
			<ul id="treeDemo" class="ztree" style="margin-top:0; width:180px;"></ul>
		</div>
	</section>
	<iframe name=HFrame width=0 height=0 frameborder="0"></iframe>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/plugins/jquery/pager/jquery.pager.bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/plugins/jquery/pager/pager.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/plugins/datepicker/WdatePicker.js"></script>
	
	<script>
	    var path="<%=request.getContextPath()%>";
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
			//操作成功提示
			var message=  $('#message').val();
			if(message!=null&&message!=''){
				  alert(message);
			}
			initPager("pager", pageNumber, totalPages, function(pageclickednumber){
	 			$("#pageNumber").val(pageclickednumber);
	 			$("#searchForm").submit();
			}, {});
			
			$("#add").bind('click',function(){
				window.location.href ="<%=request.getContextPath()%>/tirClass/edit.html";
			});
			
			$("#import").bind("click", function() {
		    	var userId = $(obj).parent().parent().find("input[name=pkid]").val();
				var loginName = $(obj).parent().parent().find("input[name=loginName]").val();
				modalFrame(path + "/tirStudent/importModal.html?userId="+userId+"&loginName="+loginName, {
					width:"350px",
					height:"455",
					overflow:"hidden"
				});
             });
			
			$("#export").bind("click", function() {
				var datebegin = $("#Search_datebegin").val();
				var dateend = $("#Search_dateend").val();
				$("#searchForm").attr("action")
				$("#searchForm").attr("action",path+"/tirClass/export");
				$("#searchForm").submit();
				//还原action
				$("#searchForm").attr("action",path+"/tirClass/tirClassList.html");
	        });
				$("#searchForm").attr("action",path+"/tirClass/tirClassList.html");
	        });
			
		
		//删除/提交/结课/锁定
		function updateTirClass(nowTr,flag){
			var status = "";
			//TODO
			if("删除"==flag){status = "-1";}else if("提交"==flag){status = "1";}else if("结课"==flag){status = "2";}else{status="3";}
			confirmBox("确认"+flag+"？",function(nowTr){
				var id = $(nowTr).parent().parent().find("input[name=pkid]").val();
				$.ajax({
					url : path+"/tirClass/delete",
					data : {ids : id,status : flag},
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
		
		function submitSearch(){
			$("#pageNumber").val(1);
			$("#searchForm").submit();
 		}
		
	</script>
</body>
</html>