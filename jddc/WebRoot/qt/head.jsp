<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/3/23
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>酒店点菜系统头部</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/qt/res/static/css/main.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/qt/res/layui/css/layui.css">
<link rel="stylesheet"
	href="<%=path%>/qt/res/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="<%=path%>/qt/res/jquery/jquery.min.js"></script>
<script src="<%=path%>/qt/res/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/qt/res/layui/layui.js"></script>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<script src="<%=path%>/qt/js/$json.js"></script>
<style type="text/css">
.header .mallSearch button {
	height: 35px;
}
</style>
</head>
<body>
	<div class="container ">
		<ul class="breadcrumb" style="text-align: right;">
			<li><a href="<%=path%>/qt/register.jsp"><span
					class="glyphicon glyphicon-user"></span>注册</a>
			</li>
			<c:if test="${loginUser==null}">
				<li><a href="<%=basePath%>login.jsp"><span
						class="glyphicon glyphicon-log-in"></span>登录</a>
				</li>
			</c:if>
			<c:if test="${loginUser!=null}">
				<li><i class="layui-icon layui-icon-username iphone-icon"></i>${loginUser.CName}</li>
				<li><a href="<%=path%>/user.do?qiehuan">切换账户</a>
				</li>
			</c:if>
			<li><a
				href="<%=path%>/order.do?listOrderByRyid&index=1&ryid=${loginUser.CId}"><span
					class="glyphicon glyphicon-shopping-cart"></span> 我的订单</a>
			</li>
		</ul>
		<div class="form-inline">
			<div class="header">
				<div class="headerLayout ">
					<div class="headerCon">
						<h1 class="mallLogo">
							<a href="<%=path%>/qt/czgl.jsp" title="酒店点菜系统"> 酒店点菜系统 </a>
						</h1>
						<div class="mallSearch">
							<form action="" class="layui-form" novalidate="">
								<input type="text" name="title" required=""
									lay-verify="required" autocomplete="off" class="layui-input"
									placeholder="请输入需要的菜名">
								<button class="layui-btn" lay-submit="" lay-filter="formDemo">
									<i class="layui-icon layui-icon-search"></i>
								</button>
								<input type="hidden" name="" value="">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 导航栏 -->
		<!--第一种方法-->
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class=""><a href="<%=path%>/cz.do?listCzQt">餐桌管理</a></li>
				<li class=""><a href="<%=path%>/cl.do?listClQt">菜单管理</a></li>
				<li class=""><a
					href="<%=path%>/order.do?listOrderByRyid&index=1&ryid=${loginUser.CId}">订单管理</a>
				</li>
			</ul>
		</div>

	</div>
</body>
</html>


