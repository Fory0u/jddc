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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>酒店餐桌管理页面</title>
    <link rel="stylesheet" href="css/index.css" />
</head>
<body>
	<c:import url="head.jsp"></c:import>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<img alt="100%x200" src="../img/cz1.jpg"
						style="height: 200px; width: 100%; display: block;" />
					<div class="caption">
						<h3>餐桌1</h3>
						<p>餐桌状态：未入座</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">入座</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="footer.jsp"></c:import>
</body>
</html>


