<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>酒店订单管理页面</title>
    <link rel="stylesheet" href="css/ddgl.css" />
  </head>

<body>
<c:import url="head.jsp"></c:import>
	<div class="container">
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th style="display:none;">cid</th>
					<th>餐桌名称</th>
					<th>点菜信息</th>
					<th>点菜数量</th>
					<th>总数</th>
					<th>总价</th>
					<th>订单状态</th>
					<th>订单创建时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orders}" var="o" >
					<tr >
						<th style="display:none;" > ${o.CId} </th>
						<th>餐桌名称${o.CId}</th>
						<th>点菜信息</th>
						<th>点菜数量</th>
						<th>总数</th>
						<th>总价</th>
						<th>订单状态</th>
						<th>订单创建时间</th>
						<th>操作</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:import url="footer.jsp"></c:import>
</body>
</html>
