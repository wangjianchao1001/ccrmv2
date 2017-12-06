<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="decorator" content="mainframe" />
<title>学员管理</title>
<style>
.test {
	overflow: hidden;
	margin-left: 1.15rem;
	width: 7rem;
	text-overflow: ellipsis;
	white-space: nowrap;
}
</style>
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			学员 <small>列表显示</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>学员管理</a></li>
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">
		<div class="box box-default">
			<div class="box-header">
				<shiro:hasPermission name="10030100">
					<button type="button" class="btn btn-default" id="add">添加</button>
				</shiro:hasPermission>
				<shiro:hasPermission name="10030300">
					<button type="button" class="btn btn-default" id="delete">批量删除</button>
				</shiro:hasPermission>
				<shiro:hasPermission name="10030500">
					<button type="button" class="btn btn-default" id="expot">导出</button>
				</shiro:hasPermission>
				<shiro:hasPermission name="10030600">
					<button type="button" class="btn btn-default" id="register">学员登记</button>
				</shiro:hasPermission>
				<div class="box-tools pull-right">
				<form class="form-horizontal" role="form" method="post" id="searchForm" action="<%=request.getContextPath()%>/tirStudent/studentList.html">
					<input type="hidden" id = "className" name="className" />
					<div class="input-group input-group-sm" style="width:290px;display:inline-block">
						<select class="form-control selectpicker show-tick" name="idxid" id="idxid" >
							<option value='' <c:if test="${student.idxid == '' }">selected="selected"</c:if>>按培训班查询</option>
							<c:forEach var="tirClass" items="${classList }">
								<c:if test="${tirClass.careerName != '' or tirClass.careerName != null }">
									<option value='${tirClass.pkid }'<c:if test="${student.idxid == tirClass.pkid }">selected="selected"</c:if>>${tirClass.careerName }(${tirClass.datebegin } -- ${tirClass.dateend })</option>
								</c:if>
							</c:forEach>
						</select> 
					</div>
					<div class="input-group input-group-sm" style="width:120px;display:inline-block">
						<input type="text" class="form-control " id="name" name="name" placeholder="按姓名查询"  value="${student.name}"/>
					</div>
					<div class="input-group input-group-sm" style="width:180px;display:inline-block">
						<input type="text" class="form-control " id="idno" name="idno" placeholder="按身份证号查询"  value="${student.idno}"/>
					</div>
					<div style="display: inline-block">
						<div class="input-group input-group-sm"	style="width: 180px;">
							<input type="text" class="form-control input-sm" value="${student.phoneno }" name="phoneno" placeholder="按联系电话查找" />
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
				<input type="hidden" value="${message}" id="message" />
				<table id="example" class="table table-striped table-bordered"
					cellspacing="0" width="100%">
					<!--<caption>基本的表格布局</caption>  -->
					<thead>
						<tr>
							<th><input type="checkbox" class="icheckbox_square-blue" id="checkAll" onclick="checkAll();" /></th>
							<th hidden="true">编号</th>
							<th>学员姓名</th>
							<th>培训机构</th>
							<th>培训班</th>
							<th>户口性质</th>
							<th>身份证号</th>
							<th>民族</th>
							<th>地址</th>
							<th>联系电话</th>
							<th>文化程度</th>
							<th>证书类型</th>
							<th>证书级别</th>
							<th>证件类型</th>
							<th>证件号</th>
							<th>人员类别</th>
							<th>失业日期</th>
							<th>是否就业</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="student" items="${pager.datas}" varStatus="status">
							<tr>
								<td>
									<input type="checkbox" name="checkbox" class="icheckbox_square-blue" />
								</td>
								<td hidden="true">
								 	<input type="hidden" value="${student.pkid}" id="pkid" name="pkid" />
								</td>
								<td>${student.name}</td>
								<td>
									<c:forEach var="tirClass" items="${classList }" >
											<c:if test="${tirClass.pkid eq student.idxid}">
												<c:forEach var="organ" items="${organList }" >
													<c:if test="${tirClass.orgid eq organ.pkid}">${organ.name }
													</c:if>
												</c:forEach>
											</c:if>
									</c:forEach>
								</td>
								<td>
									<c:forEach var="tirClass" items="${classList }" >
											<c:if test="${tirClass.pkid eq student.idxid}">${tirClass.careerName }
											</c:if>
									</c:forEach>
								</td>
								<td>
									<c:forEach var="dic" items="${dicList }" >
											<c:if test="${dic.pkid eq student.householdid}">${dic.name }</c:if>
									</c:forEach>
								</td>
								<td>${student.idno}</td>
								<td>
									<c:forEach var="dic" items="${dicList }" >
											<c:if test="${dic.pkid eq student.nationid}">${dic.name }</c:if>
									</c:forEach>
								</td>
								<td><span class="text" data-toggle='popover' data-trigger="hover" data-content="${student.adress} " style="width:7rem;">${student.adress}</span></td>
								<td>${student.phoneno}</td>
								<td>
									<c:forEach var="dic" items="${dicList }" >
											<c:if test="${dic.pkid eq student.cultureid}">${dic.name }</c:if>
									</c:forEach>
								</td>
								<td>${student.certificatetype}
									<c:forEach var="dic" items="${dicList }" >
											<c:if test="${dic.pkid eq student.certificatetype}">${dic.name }</c:if>
									</c:forEach>
								</td>
								<td>
									<c:if test="${student.identlevel != ''}">
										<c:forEach var="dic" items="${dicList }" >
												<c:if test="${dic.pkid eq student.identlevel}">${dic.name }</c:if>
										</c:forEach>
									</c:if>
								</td>
								<td>
									<c:forEach var="dic" items="${dicList }" >
											<c:if test="${dic.pkid eq student.identid}">${dic.name }</c:if>
									</c:forEach>
								</td>
								<td>${student.identno}</td>
								<td>
									<c:forEach var="dic" items="${dicList }" >
											<c:if test="${dic.pkid eq student.structid}">${dic.name }</c:if>
									</c:forEach>
								</td>
								<td>${student.dateunemployed}</td>
								<td>
									<c:if test="${student.isemploy == 1}"><span style="color:green;">是</span></c:if>
									<c:if test="${student.isemploy != 1}"><span style="color:gray;">否</span></c:if>
								</td>
								<td>
										<shiro:hasPermission name="10030200">
												<a href="javascript:void(0)" onclick='addOrUpdate(this);' style="cursor: pointer;">编辑</a>&nbsp;&nbsp;
										</shiro:hasPermission>
										<shiro:hasPermission name="10030300">
												<a href="javascript:void(0)" onclick='deletestudent(this)' style="cursor: pointer;">删除</a>&nbsp;&nbsp;
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
				<nav id="pager"></nav>
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
	</section>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/static/plugins/jquery/pager/jquery.pager.bootstrap.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/static/plugins/jquery/pager/pager.js"></script>
	<script>
		var path = "<%=request.getContextPath()%>";
		var totalPages = ${pager.totalPages};	
		var pageNumber = ${pager.pageNumber};	
		var pageSize = ${pager.pageSize};
	
		$(document).ready(function() {
			//操作成功提示
			  var message=  $('#message').val();
			  if(message!=null&&message!=''){
				  alert(message);
			  }
		    $("#add").bind("click", function() {
		    	addOrUpdate();
             });
		    $("#delete").bind("click", function() {
		    	deletestudent();
             });
		    $("#expot").bind("click", function() {
				$("#searchForm").attr("action")
				$("#searchForm").attr("action",path + "/tirStudent/exportExcel");
				$("#className").val($('#idxid').find("option:selected").text());
				$("#searchForm").submit();
				$("#searchForm").attr("action",path+"/tirStudent/studentList.html");
             });
		    $("#register").bind("click", function() {
		    	var checkboxList = $("input[name='checkbox']:checked");
				var ids = "";
				if(checkboxList.length==0){
					alert("请选择要登记的学员");
					return;
				}else{
					for(var i=0; i<checkboxList.length; i++){
						ids +=","+$(checkboxList[i]).parent().parent().find("input[name=pkid]").val();					
					}
					ids = ids.substring(1);
				}	
				modalFrame(path + "/tirStudent/register.html?ids="+ids, {
					width:"350px",
					height:"455",
					overflow:"hidden"
				});
             });
		});
		
		initPager("pager", pageNumber, totalPages, function(pageclickednumber){
			$("#pageNumber").val(pageclickednumber);
			$("#searchForm").submit();
		}, {});
	
		function submitSearch(){
			$("#searchForm").submit();
		};
		
		//初始化密码
		function updatePassword(obj){
			var userId = $(obj).parent().parent().find("input[name=userId]").val();
			$.ajax({
				 url : path + "/student/password/reset",
				 data : {userId:userId,password:'000000'},
	             dataType : "json",
	             success: function(msg){
						if(msg > 0){
							alert("操作成功");
						}else{
							alert("操作失败");
						};
				}
			});
		}
		
		//删除
		function deletestudent(nowTr){
			var checkboxList = $("input[name='checkbox']:checked");
			var userId= $(nowTr).parent().parent().find("input[name=pkid]").val();
			var ids = "";
			if((userId == "" || userId == undefined) && checkboxList.length==0){
				alert("请选择要删除的数据");
				return;
			}
			confirmBox("确定删除?", function(nowTr){
				if(userId != undefined){
					ids = userId;
				}else{
					for(var i=0; i<checkboxList.length; i++){
						ids +=","+$(checkboxList[i]).parent().parent().find("input[name=pkid]").val();					
					}
					ids = ids.substring(1);
				}	
				 $.ajax({
					 url : path + "/tirStudent/delete",
					 data : {ids : ids},
		             dataType : "json",
		             success: function(msg){
							if(msg > 0){
								alert("删除成功");
								$("#searchForm").submit();
							}else{
								alert("删除失败");
							};
					}
				});
			}, nowTr, {
				cancleText : "再想想", 
				okText :  "删除",
			});
		};
		
		function addOrUpdate(nowTr){
			var pkid = "";
			if(nowTr!= null && nowTr != undefined){
				pkid= $(nowTr).parent().parent().find("input[name=pkid]").val();
			}
			window.location.href=path + "/tirStudent/edit.html?id="+ pkid;
		};
 		
		function checkAll(){
			if($("#checkAll")[0].checked){ 
				$("input[name='checkbox']").prop("checked", true);
			}else{
				$("input[name='checkbox']").prop("checked", false);
			}
			
		}
 		
	</script>
</body>
</html>