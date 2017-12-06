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
<meta name="decorator" content="mainframe" />
<title>业务报表统计</title>
<style type="text/css">
#example,#statisticsTotal{width:93%;margin:auto;}
#example tr td,#example tr th,#statisticsTotal tr td,#statisticsTotal tr th{padding:0 8px;text-align: center}
</style>
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			业务统计<small>列表显示</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>业务报表统计</a></li>
			<!-- <li class="active">Here</li> -->
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">
		<div class="box   box-default">
			<div class="box-header">
				<shiro:hasPermission name="business:export">
					<button type="button" class="btn btn-default" id="export">导出excel</button>
				</shiro:hasPermission>
				<shiro:hasPermission name="businessReport:exportHtml">
					<button type="button" class="btn btn-default" id="exportHtml">导出至网页</button>
				</shiro:hasPermission>
				<div class="box-tools pull-right">
					<form class="form-horizontal" role="form" method="post" id="searchForm" action="<%=request.getContextPath()%>/businessReport/findList">
						<div style="display:inline-block"  >
							<div class="input-group input-group-sm" style="width:150px; height:30px;  "  >
								<input type="text" class="form-control input-sm" id="searchDate" readonly name="searchDate"
										value="<fmt:formatDate value="${searchDate}" pattern="yyyy-MM-dd"/>" 
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-{%d-1}'})">
					 				<div class="input-group-btn"  >
				                     	<button class="btn btn-sm btn-default" onclick="javascript:submitSearch();"><i class="fa fa-search"></i></button>
				                    </div>
							</div>
						</div>
					</form>
				</div>
			</div>
		
			<div class="box-body">
				<table id="example" class="table table-striped table-bordered"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th colspan="31" style="text-align:center; background-color: rgb(50,102,255);color:#fff">受理业务日报表-来电业务分布表&nbsp;&nbsp;<fmt:formatDate value="${searchDate}" pattern="yyyy-MM-dd"/></th>
						</tr>
						<tr>
							<th colspan="2"></th>
							<th colspan="2">终端</th>
							<th colspan="2">语言</th>
							<th colspan="25">业务类别</th>
						</tr>
						<tr>
							<th>时间间隔</th>
							<th>来电量</th>
							<th>手机</th>
							<th>车机</th>
							<th>中文</th>
							<th>英文</th>
							<th>目的地</th>
							<th>服务咨询</th>
							<th>账户管理</th>
							<th>联系经销商</th>
							<th>保养管理</th>
							<th>车辆相关咨询</th>
							<th>B-Call咨询</th>
							<th>E-Call咨询</th>
							<th>WIFI</th>
							<th>其他</th>
							<th>被盗车辆追踪</th>
							<th>酒店</th>
							<th>机票</th>
							<th>订餐</th>
							<th>电影票</th>
							<th>代驾</th>
							<th>高尔夫</th>
							<th>策划</th>
							<th>危机</th>
							<th>医疗</th>
							<th>中断</th>
							<th>无声</th>
							<th>闪断</th>
							<th>测试</th>
							<th>内部测试</th>

						</tr>
					</thead>
					<tbody id="data">
						<c:forEach var="statisticsList" items="${BReportStatisticsList }" varStatus="status">
							<tr style="height: 5px;">
								<td>
									${statisticsList.timeInterval}
								</td>
								<td>
									<c:if test="${statisticsList.callIn == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.callIn != 0}">${statisticsList.callIn}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.movecall == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.movecall != 0}">${statisticsList.movecall}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.carcall == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.carcall != 0}">${statisticsList.carcall}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.chinese == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.chinese != 0}">${statisticsList.chinese}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.english == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.english != 0}">${statisticsList.english}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.destination == 0}"><span style="color:#bbb">0</span></c:if>  
									<c:if test="${statisticsList.destination != 0}">${statisticsList.destination}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.consultingServices == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.consultingServices != 0}">${statisticsList.consultingServices}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.accountManage == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.accountManage != 0}">${statisticsList.accountManage}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.contactDealer == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.contactDealer != 0}">${statisticsList.contactDealer}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.maintenanceManage == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.maintenanceManage != 0}">${statisticsList.maintenanceManage}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.vehicleRelated == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.vehicleRelated != 0}">${statisticsList.vehicleRelated}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.bcall == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.bcall != 0}">${statisticsList.bcall}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.ecall == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.ecall != 0}">${statisticsList.ecall}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.wifi == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.wifi != 0}">${statisticsList.wifi}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.other == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.other != 0}">${statisticsList.other}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.stolenVehicle == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.stolenVehicle != 0}">${statisticsList.stolenVehicle}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.hotels == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.hotels != 0}">${statisticsList.hotels}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.airTicket == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.airTicket != 0}">${statisticsList.airTicket}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.ordering == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.ordering != 0}">${statisticsList.ordering}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.movieTicket == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.movieTicket != 0}">${statisticsList.movieTicket}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.bahalfDrive == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.bahalfDrive != 0}">${statisticsList.bahalfDrive}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.golf == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.golf != 0}">${statisticsList.golf}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList._plan == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList._plan != 0}">${statisticsList._plan}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.crisis == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.crisis != 0}">${statisticsList.crisis}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.medical == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.medical != 0}">${statisticsList.medical}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.interrupt == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.interrupt != 0}">${statisticsList.interrupt}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.silent == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.silent != 0}">${statisticsList.silent}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.flash == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.flash != 0}">${statisticsList.flash}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.test == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.test != 0}">${statisticsList.test}</c:if>
								</td>
								<td>
									<c:if test="${statisticsList.interTest == 0}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${statisticsList.interTest != 0}">${statisticsList.interTest}</c:if>
								</td>
							</tr> 
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

<!-- 	</section> -->
	
<!-- 	<section class="content"> -->
	<div class="box   box-default">
			<div class="box-body">
				<table id="statisticsTotal" class="table table-striped table-bordered"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th></th>
							<th>来电总时长</th>
							<th>手机</th>
							<th>车机</th>
							<th>中文</th>
							<th>英文</th>
							<th>目的地</th>
							<th>服务咨询</th>
							<th>账户管理</th>
							<th>联系经销商</th>
							<th>保养管理</th>
							<th>车辆相关咨询</th>
							<th>B-Call咨询</th>
							<th>E-Call咨询</th>
							<th>WIFI</th>
							<th>其他</th>
							<th>被盗车辆追踪</th>
							<th>酒店</th>
							<th>机票</th>
							<th>订餐</th>
							<th>电影票</th>
							<th>代驾</th>
							<th>高尔夫</th>
							<th>策划</th>
							<th>危机</th>
							<th>医疗</th>
							<th>中断</th>
							<th>无声</th>
							<th>闪断</th>
							<th>测试</th>
							<th>内部测试</th>
						</tr>
					</thead>
					<tbody id="statisticsTotal_tbody">
						<tr>
							<td>来电总时长(s)</td>
							<td>${BReportStatistics.callIn}</td>
							<td>${BReportStatistics.movecall}</td>
							<td>${BReportStatistics.carcall}</td>
							<td>${BReportStatistics.chinese}</td>
							<td>${BReportStatistics.english}</td>
							<td>${BReportStatistics.destination}</td>
							<td>${BReportStatistics.consultingServices}</td>
							<td>${BReportStatistics.accountManage}</td>
							<td>${BReportStatistics.contactDealer}</td>
							<td>${BReportStatistics.maintenanceManage}</td>
							<td>${BReportStatistics.vehicleRelated}</td>
							<td>${BReportStatistics.bcall}</td>
							<td>${BReportStatistics.ecall}</td>
							<td>${BReportStatistics.wifi}</td>
							<td>${BReportStatistics.other}</td>
							<td>${BReportStatistics.stolenVehicle}</td>
							<td>${BReportStatistics.hotels}</td>
							<td>${BReportStatistics.airTicket}</td>
							<td>${BReportStatistics.ordering}</td>
							<td>${BReportStatistics.movieTicket}</td>
							<td>${BReportStatistics.bahalfDrive}</td>
							<td>${BReportStatistics.golf}</td>
							<td>${BReportStatistics._plan}</td>
							<td>${BReportStatistics.crisis}</td>
							<td>${BReportStatistics.medical}</td>
							<td>${BReportStatistics.interrupt}</td>
							<td>${BReportStatistics.silent}</td>
							<td>${BReportStatistics.flash}</td>
							<td>${BReportStatistics.test}</td>
							<td>${BReportStatistics.interTest}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	
	</section>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/plugins/jquery/pager/jquery.pager.bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/plugins/jquery/pager/pager.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/plugins/datepicker/WdatePicker.js"></script>
	
	<script>
	 	var path="<%=request.getContextPath()%>";
		$(document).ready(function() {
			
			$("#export").bind('click',function(){
				$("#searchForm").attr("action");
				$("#searchForm").attr("action",path+"/businessReport/export");
				$("#searchForm").submit();
				
				$("#searchForm").attr("action",path+"/businessReport/findList");
			});
			
			$("#exportHtml").bind('click',function(){
				$("#searchForm").attr("action");
				$("#searchForm").attr("action",path+"/businessReport/exportHtml");
				$("#searchForm").submit();
				
				$("#searchForm").attr("action",path+"/businessReport/findList");
			});
			
		});
		
		function submitSearch(){
			$("#searchForm").submit();
		}
		
	</script>
</body>
</html>