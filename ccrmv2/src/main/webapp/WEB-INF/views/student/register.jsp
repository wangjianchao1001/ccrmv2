<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="decorator" content="mainframe" />
<title>学员登记</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/plugins/iCheck/square/blue.css"></link>
<style>
	<!--
		body{overflow: hidden}
		.content-wrapper{background-color:#fff}
		.modal-content{box-shadow:none;}
		.modal-footer{}
	-->
	.jsfp label{display:inline-block;width:150px;font-weight:normal}
</style>
</head>
<body>
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close" onclick="javascript:parent.modalFrame('hide')">
				<span aria-hidden="true">×</span>
			</button>
			<h4 class="modal-title">&nbsp;<b>登记学员</b>&nbsp;</h4>
		</div>
		<div class="modal-body" style=" height:230px; overflow-y: scroll; ">
     		<c:forEach var="class" items="${classList}" varStatus="classStatus">
     			<label>
		     		<input type="checkbox" name="pkid" value="${class.pkid }">
			     		${class.careerName }(${class.datebegin } -- ${class.dateend })&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     		</label>
			</c:forEach>
		</div>
		<div></div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default pull-left" id="button_hide" onclick="javascript:parent.modalFrame('hide')"
				data-dismiss="modal">关闭</button>
			<button type="button" class="btn btn-primary" onclick="save()">保存</button>
		</div>
	</div>
	<!-- /.modal-content -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/plugins/iCheck/icheck.min.js"></script>
	<script>
		var path = "<%=request.getContextPath()%>";
		var studentIdList = "${ids}";
		$(function() {
			$("input").iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
			});
		});
		
		function save() {
			var classIdList = "";
			$("input[name='pkid']:checked").each(function() {
				classIdList += "," + $(this).val();
			});
			classIdList = classIdList.substring(1);
			$.ajax({
				url : path + "/tirStudent/register",
				data : {
					classIdList : classIdList,
					studentIdList : studentIdList
				},
				datetype : "json",
				success : function(msg) {
					var frame = top.frames["tabs-1027-iframe"];
					var _document = frame.contentDocument || frame.document;
					_document.location.reload();
					parent.modalFrame('hide');
					setTimeout(function(){
						alert(msg);
					}, 200);
				}
			});
		}
	</script>
</body>
</html>