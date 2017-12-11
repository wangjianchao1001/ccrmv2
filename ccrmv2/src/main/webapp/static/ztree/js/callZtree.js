var orgId = "";
var orgName="";
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
	/*if(orgId != ''){
		$.ajax({
			type:'POST',
			data:{branchId:nodes[0].id},
			url: path + '/housekeeping/getByBranchId',
			success:function(data){
				if(typeof(data) == 'string'){data = $.parseJSON(data);}
				var _data = data.organList;
				var html = "";
				for(var i=0; i<_data.length; i++){
					html += "<option value='"+_data[i].pkid+"'>"+_data[i].name+"</option>";
				}
				$("#employeeOrganid").find("option").remove(); 
				html="<option value='2001400000000001500'>歌蒂恩美容美发</option><option value='2001400000000001000'>爱丽丝理发店</option><option value='2001400000000001300'>爱尚美发会所</option><option value='2001400000000001300'>八点造型</option><option value='2001400000000001300'>大世界美发</option><option value='2001400000000001300'>顶尖一族美发店</option><option value='2001400000000001300'>发皇理发店</option><option value='2001400000000001300'>发缘理发店</option><option value='2001400000000001500'>芳菲化妆美容会所</option><option value='2001400000000004600'>魅尚美容美发养生会所</option><option value='2001400000000004600'>起点发艺</option><option value='2001400000000004900'>舒雅美发店</option><option value='2001400000000004900'>我们焕颜吧</option><option value='2001400000000004900'>无闪光儿童摄影小脚丫韩式</option><option value='2001400000000004900'>武川县方丽理发店</option><option value='2001400000000004400'>国义婚庆礼仪</option><option value='2001400000000004400'>金百合影像工作室</option><option value='2001400000000004400'>金色童年儿童摄影店</option><option value='2001400000000004600'>聚炫美容美妆会所</option><option value='2001400000000004600'>酷炫剪吧</option><option value='2001400000000004600'>利军保健按摩</option><option value='2001400000000004600'>魅力女人美容美体店</option><option value='2001400000000004600'>茹茹时尚化妆店</option><option value='2001400000000004900'>瑞倪维儿连锁机构</option><option value='2001400000000004900'>尚剪发艺工作室</option><option value='2001400000000004900'>首尔理发</option><option value='2001400000000004900'>瘦美康经络减肥店</option><option value='2001400000000004900'>舒静名推精剪理发店</option><option value='2001400000000004400'>佳 美理发店</option><option value='2001400000000004400'>简易发型工作室</option><option value='2001400000000004600'>郞迪美容美发店</option><option value='2001400000000005400'>起点发艺</option><option value='2001400000000005400'>简易发型工作室</option><option value='2001400000000004900'>小张理发</option><option value='2001400000000004900'>新浪理发店</option><option value='2001400000000004900'>星星理发店</option>";
				var a= $("#employeeOrganid");
				$("#employeeOrganid").append("<option value='2001400000000001500'>歌蒂恩美容美发</option><option value='2001400000000001000'>爱丽丝理发店</option><option value='2001400000000001300'>爱尚美发会所</option><option value='2001400000000001300'>八点造型</option><option value='2001400000000001300'>大世界美发</option><option value='2001400000000001300'>顶尖一族美发店</option><option value='2001400000000001300'>发皇理发店</option><option value='2001400000000001300'>发缘理发店</option><option value='2001400000000001500'>芳菲化妆美容会所</option><option value='2001400000000004600'>魅尚美容美发养生会所</option><option value='2001400000000004600'>起点发艺</option><option value='2001400000000004900'>舒雅美发店</option><option value='2001400000000004900'>我们焕颜吧</option><option value='2001400000000004900'>无闪光儿童摄影小脚丫韩式</option><option value='2001400000000004900'>武川县方丽理发店</option><option value='2001400000000004400'>国义婚庆礼仪</option><option value='2001400000000004400'>金百合影像工作室</option><option value='2001400000000004400'>金色童年儿童摄影店</option><option value='2001400000000004600'>聚炫美容美妆会所</option><option value='2001400000000004600'>酷炫剪吧</option><option value='2001400000000004600'>利军保健按摩</option><option value='2001400000000004600'>魅力女人美容美体店</option><option value='2001400000000004600'>茹茹时尚化妆店</option><option value='2001400000000004900'>瑞倪维儿连锁机构</option><option value='2001400000000004900'>尚剪发艺工作室</option><option value='2001400000000004900'>首尔理发</option><option value='2001400000000004900'>瘦美康经络减肥店</option><option value='2001400000000004900'>舒静名推精剪理发店</option><option value='2001400000000004400'>佳 美理发店</option><option value='2001400000000004400'>简易发型工作室</option><option value='2001400000000004600'>郞迪美容美发店</option><option value='2001400000000005400'>起点发艺</option><option value='2001400000000005400'>简易发型工作室</option><option value='2001400000000004900'>小张理发</option><option value='2001400000000004900'>新浪理发店</option><option value='2001400000000004900'>星星理发店</option>");
			}
		});
	}*/
	
	orgId = "";
	orgName = "";
}

function showBranchTree(id,param_orgId,param_orgName){
	var cityObj = $(id);
	var cityOffset = $(id).offset();
	$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
	
	$("body").bind("mousedown", onBodyDown);
	
	if(param_orgId != ""){
			orgId = param_orgId;
			orgName=param_orgName;
	}
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