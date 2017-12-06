<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/plugins/datepicker/skin/WdatePicker.css">
<style type="text/css">
.align-center{ 
 	position: absolute;
  	left:35%;
  	top:35%;  
	font-size:36px;
	text-align:center; vertical-align:middle;
}


</style>
<meta name="decorator" content="mainframe" />
</head>
<body>
	 <div class="align-center">
	 您好${user.cid}！</br>
	 <c:if test="${user.kindid != 3}">
		欢迎您来到呼市职业技能培训登记统计系统！
	</c:if>
	 <c:if test="${user.kindid == 3}">
		欢迎您来到家庭服务业企业登记统计系统！
	</c:if>
	 </div>
</body>
</html>