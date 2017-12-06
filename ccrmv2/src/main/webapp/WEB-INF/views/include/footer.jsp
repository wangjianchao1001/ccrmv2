<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ccrm.util.AppConfig" %>
<!-- footer.jsp -->
<footer class="main-footer" style="position:fixed;bottom:-5px;width:100%;padding-right:250px">
	<!-- To the right -->
	<div class="pull-right hidden-xs">
		<b>Version</b>:&nbsp;<%=AppConfig.getParameter("system.version") %>
	</div>
	<!-- Default to the left -->
	<strong>Copyright &copy; <span id="footerYear"></span>&nbsp;&nbsp;<a href="http://www.yesway.cn" target="yesway">YESWAY</a>.
	</strong> All rights reserved.
	<script>
		document.getElementById("footerYear").innerHTML = new Date().getFullYear();
	</script>
</footer>
<!-- footer.jsp end -->