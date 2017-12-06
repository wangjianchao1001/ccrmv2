//ztree 下拉菜单
function onclick(){
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
	nodes = zTree.getSelectedNodes(),
	v = "";
	nodes.sort(function compare(a,b){return a.id-b.id;});
	for (var i=0, l=nodes.length; i<l; i++) {
		v += nodes[i].name + ",";
	}
	if (v.length > 0 ) v = v.substring(0, v.length-1);
	var cityObj = $("#branchName");
	$("#branchid").val(nodes[0].id);
	cityObj.attr("value", v);
}

function showBranchTree(){
	var cityObj = $("#branchName");
	var cityOffset = $("#branchName").offset();
	$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
	
	$("body").bind("mousedown", onBodyDown);
}

function hideMenu() {
	$("#menuContent").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown);
}
function onBodyDown(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
		hideMenu();
	}
}