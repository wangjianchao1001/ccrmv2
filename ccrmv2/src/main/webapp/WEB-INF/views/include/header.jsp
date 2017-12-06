<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- header.jsp -->
<header class="main-header">
	<!-- Logo -->
	<a href="#" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<c:if test="${user.kindid != 3}">
			<span class="logo-mini"> <img src="static/images/px_logo.png" /></span>
			<!-- logo for regular state and mobile devices -->
			<span class="logo-lg"> <img src="static/images/px_logo.png" />
				<b>职业技能培训</b>
			</span>
		</c:if>
		<c:if test="${user.kindid == 3}">
			<span class="logo-mini"> <img src="static/images/jz_logo.png" /></span>
			<!-- logo for regular state and mobile devices -->
			<span class="logo-lg"> <img src="static/images/jz_logo.png" />
				<b>家政服务</b>
			</span>
		</c:if>
	</a>
	<!-- Header Navbar -->
	<nav class="navbar navbar-static-top" role="navigation">
		<!-- Sidebar toggle button-->
		<a id="toggleButton" href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span>
		</a>
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav collapse navbar-collapse">
				<!-- User Account: style can be found in dropdown.less -->
				<li class="dropdown user user-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown">
					<span class="glyphicon glyphicon-user"></span>
					<%-- <span class="hidden-xs">
						${user.loginName}
					</span> --%>
				</a>
				<ul class="dropdown-menu">
					<!-- User image -->
					<li class="user-header" style="height:auto;">
						<p>
							当前登录：<b>${user.cid}</b>&nbsp;
							<small>(${user.name})</small>
						</p>
					</li>
					<!-- Menu Body -->
				<!-- 	<li class="user-body">
					</li> -->
					<!-- Menu Footer-->
					<li class="user-footer">
						<div class="pull-left">
							<a href="#" class="btn btn-default btn-flat" onclick="javascript:updatePassword('${user.cid}')">
								<span class="fa fa-fw fa-gears"></span>&nbsp;&nbsp;个人中心
							</a>
						</div>
						<div class="pull-right">
							<a href="#" class="btn btn-default btn-flat" onclick="javascript:logout()">
								<i class="glyphicon glyphicon-log-in"></i>&nbsp;&nbsp;注销登录
							</a>
						</div>
					</li>
				</ul>
				</li>
				<!-- Control Sidebar Toggle Button -->
				<!-- <li><a href="javascript:;" onclick="javascript:logout();">
						<i class="glyphicon glyphicon-log-in"></i>
				</a></li> -->
			</ul>
		</div>
	</nav>
</header>
<!-- header.jsp END -->
<script>
	var path = "<%=request.getContextPath()%>";
	
	$(document).ready(function() {
		$("#toggleButton").click();
		
	});
	function logout() {
		confirmBox("确定注销么？", function() {
			window.location.href = path + "/logout";
		}, {}, {
			cancleText : "取消",
			okText : "注销",
		/* title : "提示消息" */
		});
	}
	
	function updatePassword(userId){
		modalFrame(path + "/user/personalCenter.html?cid=" + userId, {
			width:"500px",
			height:"295px",
			overflow:"hidden"
		});
	}

</script>