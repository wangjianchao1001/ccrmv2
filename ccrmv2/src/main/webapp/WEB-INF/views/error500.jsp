<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>500</title>
	<%@ include file="/WEB-INF/views/include/commoncss.jsp"%>
	<%@ include file="/WEB-INF/views/include/commonjs.jsp"%>
</head>
<body>
	<!-- Main content -->
	<section class="content" style="padding: 15% 0 15% 0">
		<div class="error-page">
			<h2 class="headline text-yellow">500</h2>
			<div class="error-content" style="padding: 5% 0 5% 0">
				<h3>
					<i class="fa fa-warning text-yellow"></i> 系统开个小差，马上回来哦。
				</h3>
				<div class="input-group">
					<p>
						内部错误，你可以 <a href="javascript:void(0);" onclick="javascript:window.history.go(-1);">点这里返回重试</a>
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

