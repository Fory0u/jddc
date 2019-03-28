<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/3/18
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>酒店点菜系统首页</title>
    <%--<link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<script src="http://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>--%>
    <%--<script src="http://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
</head>
<body>
	<c:import url="head.jsp"></c:import>
	​<div class="container">
	   	
	</div>
	<c:import url="footer.jsp"></c:import>
</body>
</html>


