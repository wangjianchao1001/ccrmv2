<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>403</title>
	<%@ include file="/WEB-INF/views/include/commoncss.jsp"%>
	<%@ include file="/WEB-INF/views/include/commonjs.jsp"%>
</head>
<body>
	<!-- Main content -->
	<section class="content" style="padding: 15% 0 15% 0">
		<div class="error-page">
			<h2 class="headline text-yellow">403</h2>
			<div class="error-content" style="padding: 5% 0 5% 0">
				<h3>
					<i class="fa fa-warning text-yellow"></i> 不可以这么做呢
				</h3>
				<div class="input-group">
					<p>
						没有对应权限，请联系管理员分配权限，你可以 <a href="javascript:void(0);" onclick="javascript:window.history.go(-1);">点这里返回</a>
					</p>
				</div>
				<!-- /.input-group -->
			</div>
			<!-- /.error-content -->
		</div>
		<!-- /.error-page -->
	</section>
</body>
</html>

