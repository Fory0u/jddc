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
    <link rel="stylesheet" href="<%=path%>/qt/css/ddgl.css" />
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
						<td style="display:none;" > ${o.c_id} </td>
						<td>${o.c_czmc}</td>
						<td>${o.c_dcxx}</td>
						<td>${o.c_dcsl}</td>
						<td>${o.n_zs}</td>
						<td>${o.f_zj}</td>
						<td>${o.c_ddzt}</td>
						<td>${o.d_cjsj}</td>
						<c:if test="${o.c_ddzt == '未结账'}">
							<td><a href="<%=path%>/order.do?editOrderDdzt&ddzt=已结账&cid=${o.c_id}">结算</a></td>
						</c:if>
						<c:if test="${o.c_ddzt != '未结账'}">
							<td><a href="<%=path%>/order.do?deleteOrder&cid=${o.c_id}">删除</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:import url="footer.jsp"></c:import>
</body>
</html>
