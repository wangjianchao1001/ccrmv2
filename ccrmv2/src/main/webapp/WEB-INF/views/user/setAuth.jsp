<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="decorator" content="mainframe" />
<title>帐户管理</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/plugins/iCheck/square/blue.css"></link>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/ztree/js/jquery.ztree.excheck-3.5.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/ztree/css/zTreeStyle/zTreeStyle.css" />
<style>
<!--
body {
	overflow: hidden
}

.content-wrapper {
	background-color: #fff
}

.modal-content {
	box-shadow: none;
}

.modal-footer {
	
}

-->
ul.ztree {
	margin-top: 10px;
	border: 0px solid #617775;
	width: 280;
	height: 500;
	overflow:hidden;
}
</style>
</head>
<body>
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close" onclick="javascript:parent.modalFrame('hide')">
				<span aria-hidden="true">×</span>
			</button>
			<h4 class="modal-title">为&nbsp;<b>${loginName}</b>&nbsp;分配权限</h4>
		</div>
		<div class="modal-body">
			
			<div class="zTreeDemoBackground center" style="overflow-x:hidden;height:260px;">
				<ul id="treeDemo" class="ztree"></ul>
			</div>
			<input type="hidden" id="userId" value="${userId}"/>
			<input type="hidden" id="permissionTree" value="${permissionTree }"/>
		</div>
		<div></div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default pull-left" id="button_hide" onclick="javascript:parent.modalFrame('hide')"
				data-dismiss="modal">关闭</button>
			<button type="button" class="btn btn-primary" onclick="saveUserRole()">保存</button>
		</div>
	</div>
	<!-- /.modal-content -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/plugins/iCheck/icheck.min.js"></script>
	<script>
		var path = "<%=request.getContextPath()%>";
		var permissionTree = ${permissionTree };
		$(function() {
			var settting={};
			setting.check.chkboxType = { "Y" : "p", "N" : "s" };
			$.fn.zTree.init($("#treeDemo"), setting, permissionTree);
		});
		
		function saveUserRole() {
			var authIdList = "";
			var userId = $("#userId").val();
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			var nodes = treeObj.getCheckedNodes(true);
			if(nodes.length==0){
				return;
			}
			for(var i=0;i<nodes.length;i++){
				authIdList += "," + nodes[i].id;
			}
			authIdList = authIdList.substring(1);
			$.ajax({
				url : path + "/user/saveMgtUserAuth",
				data : {
					authIdList : authIdList,
					userId : userId
				},
				datetype : "json",
				success : function(msg) {
					parent.modalFrame('hide');
					setTimeout(function(){
						alert(msg);
					}, 200);
				}
			});
		}
		
		var setting = {
				check: {
					enable: true
				},
				data: {
					simpleData: {
						enable: true
					}
				}
			};

	</script>
	
</body>
</html>