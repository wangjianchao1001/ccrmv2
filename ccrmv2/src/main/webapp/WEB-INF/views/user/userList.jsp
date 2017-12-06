<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="decorator" content="mainframe" />
<title>帐户管理</title>
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
			操作员 <small>列表显示</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>操作员管理</a></li>
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">
		<div class="box box-default">
			<div class="box-header">
				<shiro:hasPermission name="user:add">
					<button type="button" class="btn btn-default" id="add">添加</button>
				</shiro:hasPermission>
				<div class="box-tools"></div>
			</div>
			<div class="box-body">
				<input type="hidden" value="${message}" id="message" />
				<table id="example" class="table table-striped table-bordered"
					cellspacing="0" width="100%">
					<!--<caption>基本的表格布局</caption>  -->
					<thead>
						<tr>
							<th hidden="true">编号</th>
							<th>用户名(工号)</th>
							<th>真实姓名</th>
							<th>账号状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${pager.datas}" varStatus="status">
							<tr>
								<td hidden="true">
								 	<input type="hidden" value="${user.pkid}" id="pkid" name="pkid" />
								</td>
								<td><input type="hidden"
									value="${user.loginName}" id="loginName" name="loginName" />${user.loginName}</td>
								<td>${user.nickName}</td>
								<td>
									<c:if test="${user.status==1}"><span style="color:green;">正常</span></c:if>
                                    <c:if test="${user.status==0}"><span style="color:red">已停用</span></c:if>
								</td>
								<td>
									<c:if test="${user.loginName != 'admin' }">
										<shiro:hasPermission name="user:permission">
											<c:if test="${user.loginName != 'admin' and user.status == 1}">
												<a href="javascript:void(0)" onclick='setAuth(this);' style="cursor: pointer;">分配权限</a>&nbsp;&nbsp;
											</c:if>
										</shiro:hasPermission>
										<shiro:hasPermission name="user:initPassword">
											<c:if test="${user.status == 1}">
												<a href="javascript:void(0)" onclick='updatePassword(this)' style="cursor: pointer;">密码初始化</a>&nbsp;&nbsp;
											</c:if>
										</shiro:hasPermission>
										<shiro:hasPermission name="user:edit">
											<c:if test="${user.status == 1}">
												<a href="javascript:void(0)" onclick='updateMgtUser(this)' style="cursor: pointer;">修改</a>&nbsp;&nbsp;
											</c:if>
										</shiro:hasPermission>
										<shiro:hasPermission name="user:DisableorEnable">
												<c:if test="${user.status==1 and currentUser !=user.userId }">
													<a href="javascript:void(0)" onclick='disableOrEnabble(this,0)' style="cursor: pointer;">停用</a>&nbsp;&nbsp;
												</c:if>
												<c:if test="${user.status==0}">
													<a href="javascript:void(0)" onclick='disableOrEnabble(this,1)' style="cursor: pointer;">启用</a>&nbsp;&nbsp;
												</c:if>
										</shiro:hasPermission>
										<c:if test="${currentUser !=user.userId }">
											<shiro:hasPermission name="user:delete">
												<a href="javascript:void(0)" onclick='deleteMgtUser(this);' style="cursor: pointer;">删除</a>
											</shiro:hasPermission>
										</c:if>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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
				window.location.href=path + "/user/editUI.html";
             });
		});
		
		initPager("pager", pageNumber, totalPages, function(pageclickednumber){
 			window.location.href="<%=request.getContextPath()%>/user/findPageList?pageNumber=" + pageclickednumber + "&pageSize=" +pageSize;
		}, {});
		
		//分配权限
		function setAuth(obj){
			var pkid = $(obj).parent().parent().find("input[name=pkid]").val();
			var loginName = $(obj).parent().parent().find("input[name=loginName]").val();
			modalFrame(path + "/user/setAuth.html?userId="+pkid+"&loginName="+loginName, {
				width:"350px",
				height:"455",
				overflow:"hidden"
			});
		}
		//初始化密码
		function updatePassword(obj){
			var userId = $(obj).parent().parent().find("input[name=pkid]").val();
			$.ajax({
				 url : path + "/user/password/reset",
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
		
		//停用/启用
		function disableOrEnabble(obj,flag){
			var confirm = flag == 0 ?"停用":"启用";
			confirmBox("确定"+confirm+"吗？",function(){
				var userId = $(obj).parent().parent().find("input[name=pkid]").val();
				$.ajax({
					 url : path + "/user/disableOrEnabble",
					 data : {userId : userId,status:flag},
		             dataType : "json",
					 success: function(msg){
							if(msg > 0){
								window.location.href=path + "/user/findPageList";
								alert("修改成功");
							}else{
								alert("修改失败");
							};
					},
					error:function(msg){
						alert("error");
					}
				});
			});
		}

		//删除
		function deleteMgtUser(nowTr){
			confirmBox("确定删除?", function(nowTr){
				var userId= $(nowTr).parent().parent().find("input[name=pkid]").val();
				 $.ajax({
					 url : path + "/user/delete",
					 data : {userId : userId},
		             dataType : "json",
		             success: function(msg){
							if(msg > 0){
								alert("删除成功");
								 $(nowTr).parent().parent().remove();
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
		
		function updateMgtUser(nowTr){
			var userId= $(nowTr).parent().parent().find("input[name=pkid]").val();
			window.location.href=path + "/user/editUI.html?userId="+ userId;
		};
 		
	</script>
</body>
</html>