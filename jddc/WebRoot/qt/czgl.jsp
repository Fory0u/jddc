<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/3/18
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>酒店餐桌管理页面</title>
<link rel="stylesheet" href="css/index.css" />
</head>
<body>
	<c:import url="head.jsp"></c:import>
	<div class="container">
		<div class="row">
			<c:forEach items="${czs}" var="cz">
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
					<c:choose> 
						<c:when test="${cz.NCzrs >= 1 && cz.NCzrs <=4}">
							<img alt="#" src="./qt/img/cz1.jpg" style="height: 200px; width: 100%; display: block;" />
						</c:when>
						<c:when test="${cz.NCzrs >4 && cz.NCzrs <=8}">
							<img alt="#" src="./qt/img/cz3.jpg" style="height: 200px; width: 100%; display: block;" />
						</c:when>
						<c:otherwise >
								<img alt="#" src="./qt/img/cz2.jpg" style="height: 200px; width: 100%; display: block;" />
						</c:otherwise>
					</c:choose>
						<div class="caption">
							<input type="hidden" value="${cz.CId}">
							<h3>${cz.CCzmc }</h3>
							<p>餐桌状态：${cz.CCzzt }</p> 
							<p><a href="<%=path%>/cz.do?getCzIdtoCd&czid=${cz.CId}" class="btn btn-primary " role="button" <c:if test="${cz.CCzzt == '有客'}">disabled="disabled"</c:if> >入座</a></p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<c:import url="footer.jsp"></c:import>
</body>

<script type="text/javascript">
	
</script>
</html>


