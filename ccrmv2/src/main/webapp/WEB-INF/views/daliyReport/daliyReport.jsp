<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/plugins/datepicker/skin/WdatePicker.css">
<meta name="decorator" content="mainframe" />
<title>语音报表统计</title>
<style type="text/css">
#example,#statisticsTotal{width:90%;margin:auto;}
#example tr td,#example tr th,#statisticsTotal tr td,#statisticsTotal tr th{padding:0 8px;text-align: center}
</style>
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			语音统计<small>列表显示</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>语音报表统计</a></li>
			<!-- <li class="active">Here</li> -->
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">
		<div class="box   box-default">
			<div class="box-header">
				<shiro:hasPermission name="daliy:export">
					<button type="button" class="btn btn-default" id="export">导出excel</button>
				</shiro:hasPermission>
				<shiro:hasPermission name="daliy:exportHtml">
					<button type="button" class="btn btn-default" id="exportHtml">导出至网页</button>
				</shiro:hasPermission>
				<div class="box-tools pull-right">
					<form class="form-horizontal" role="form" method="post" id="searchForm" action="<%=request.getContextPath()%>/daliy/findPageList">
						<div style="display:inline-block"  >
							<div class="input-group input-group-sm" style="width:150px; height:30px;  "  >
								<input type="text" class="form-control input-sm" id="searchDate" readonly name="searchDate" value="<fmt:formatDate value="${searchDate}" pattern="yyyy-MM-dd"/>"
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
							<th colspan="13" style="text-align:center; background-color: rgb(50,102,255);color:#fff">语音服务日报表&nbsp;&nbsp;<fmt:formatDate value="${searchDate}" pattern="yyyy-MM-dd"/>(I-Call)</th>
						</tr>
						<tr>
							<th colspan="3"></th>
							<th colspan="8" style="text-align:center;">及时应答</th>
							<th colspan="2" style="text-align:center;">呼损</th>
						</tr>
						<tr>
							<th>时间间隔</th>
							<th>来电量</th>
							<th>无效来电</th>
							<th>有效来电</th>
							<th>15秒内应答量</th>
							<th>15秒内应答率</th>
							<th>90秒内应答量</th>
							<th>90秒内应答率</th>
							<th>90秒外应答量</th>
							<th>总应答量</th>
							<th>应答率</th>
							<th>总呼损量</th>
							<th>呼损率</th>
						</tr>
					</thead>
					<tbody id="data">
						<c:forEach var="daliy" items="${daliyList}" varStatus="status">
							<tr >
								<td>
									${daliy.timeInterval}
								</td>
								<td>
									<c:if test="${daliy.callVolum == '0'}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${daliy.callVolum != '0'}">${daliy.callVolum}</c:if>
								</td>
								<td>
									<c:if test="${daliy.invalidCallVolum == '0'}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${daliy.invalidCallVolum != '0'}">${daliy.invalidCallVolum}</c:if>
								</td>
								<td>
									<c:if test="${daliy.callOfferedVolum == '0'}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${daliy.callOfferedVolum != '0'}">${daliy.callOfferedVolum}</c:if>
								</td>
								<td>
									<c:if test="${daliy.responsedIn15 == '0'}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${daliy.responsedIn15 != '0'}">${daliy.responsedIn15}</c:if>
								</td>
								<td>
									<c:if test="${daliy.responsed15Rate == '0'}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${daliy.responsed15Rate != '0'}">
										<fmt:formatNumber type="percent" pattern="###.##%" value="${daliy.responsed15Rate}" />
									</c:if>
								</td>
								<td>
									<c:if test="${daliy.responsedIn90 == '0'}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${daliy.responsedIn90 != '0'}">${daliy.responsedIn90}</c:if>
								</td>
								<td>
									<c:if test="${daliy.responsed90Rate == '0'}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${daliy.responsed90Rate != '0'}">
										<fmt:formatNumber type="percent" pattern="###.##%" value="${daliy.responsed90Rate}" />
									</c:if>
								</td>
								<td>
									<c:if test="${daliy.resonsedBeyond90 == '0'}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${daliy.resonsedBeyond90 != '0'}">${daliy.resonsedBeyond90}</c:if>
								</td>
								<td>
									<c:if test="${daliy.responedTotal == '0'}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${daliy.responedTotal != '0'}">${daliy.responedTotal}</c:if>
								</td>
								<td>
									<c:if test="${daliy.callOfferedVolum == '0' and (daliy.responedRate == '0' or daliy.responedRate == '0.0')}">
										<fmt:formatNumber type="percent" pattern="###.##%" value="1" />
									</c:if> 
									<c:if test="${daliy.callOfferedVolum != '0' and daliy.responedRate != '0'}">
										<fmt:formatNumber type="percent" pattern="###.##%" value="${daliy.responedRate }" />
									</c:if>
									<c:if test="${daliy.callOfferedVolum != '0' and daliy.responedRate == '0'}">
										<fmt:formatNumber type="percent" pattern="###.##%" value="0" />
									</c:if>
								</td>
								<td>
									<c:if test="${daliy.abandonedCall == '0'}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${daliy.abandonedCall != '0'}">${daliy.abandonedCall}</c:if>
								</td>
								<td>
									<c:if test="${daliy.abandonedRate == '0'}"><span style="color:#bbb">0</span></c:if> 
									<c:if test="${daliy.abandonedRate != '0'}">
										<fmt:formatNumber type="percent" pattern="###.##%"  value="${daliy.abandonedRate }" />
									</c:if>
								</td>
							</tr>
						<%-- </c:forEach>
							   <td>${daliy.timeInterval }</td>
							   <td>${daliy.callVolum}</td>
							   <td>${daliy.invalidCallVolum }</td>
							   <td>${daliy.callOfferedVolum }</td>
							   <td>${daliy.responsedIn15 }</td>
							   <td>${daliy.responsedIn90 }</td>
							   <td>${daliy.resonsedBeyond90 }</td>
							   <td>${daliy.responedTotal }</td>
							   <td> <fmt:formatNumber type="percent" pattern="###.##%" value="${daliy.responedRate }" /></td>
							   <td>${daliy.abandonedCall }</td>
							   <td><fmt:formatNumber type="percent" pattern="###.##%"  value="${daliy.abandonedRate }" /></td>
							</tr> --%>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/plugins/datepicker/WdatePicker.js"></script>
	
	<script>
	 	var path="<%=request.getContextPath()%>";
		$(document).ready(function() {
			
			$("#export").bind('click',function(){
				$("#searchForm").attr("action",path+"/daliy/export");
				$("#searchForm").submit();
				
				$("#searchForm").attr("action",path+"/daliy/findPageList");
			});
			
			$("#exportHtml").bind('click',function(){
				$("#searchForm").attr("action",path+"/daliy/exportHtml");
				$("#searchForm").submit();
				
				$("#searchForm").attr("action",path+"/daliy/findPageList");
			});
		});
		
		function submitSearch(){
			$("#searchForm").submit();
		}
		
	</script>
</body>
</html>