<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!-- navigation.jsp
Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<script type="text/javascript">
		$(function(){
			$("section.sidebar ul li").unbind("click").bind("click", function(){
				$("section.sidebar ul li").removeClass("active");
				$(this).addClass("active");
			});
			//首页
			openTab('index','首页','<%=request.getContextPath()%>/home.html');
			
			
		});
	</script>
	<section class="sidebar">
		<!-- Sidebar Menu -->
		<ul class="sidebar-menu">
			<li class="header"><font style="color: white">
			<c:if test="${user.kindid != 3}">
			呼市职业技能培训登记统计系统
			</c:if>
			<c:if test="${user.kindid == 3}">
			家庭服务业企业登记统计系统
			</c:if>
			</font></li>
			
			<c:forEach var="authMenu" items="${authMenuList}" varStatus="status">
				<li class="treeview">
					<a href="#" onclick="openTab('${authMenu.pkid}','${authMenu.name }','<%=request.getContextPath()%>${authMenu.memo }')">
						<i class="${authMenu.sname }"></i> <span>${authMenu.name }</span>
					</a>
				</li>
			</c:forEach>
		</ul>
		<!-- /.sidebar-menu -->
	</section>
	<!-- /.sidebar -->
</aside>
<!-- navigation.jsp end -->
