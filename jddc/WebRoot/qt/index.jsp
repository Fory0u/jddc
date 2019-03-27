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
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- 指示器 -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>
        <!-- 轮播图片及说明文字 -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="img/13.jpg" alt="图片1">
            </div>
            <div class="item">
                <img src="img/16.png" alt="图片2">
            </div>
            <div class="item">
                <img src="img/17.png" alt="图片3">
            </div>
        </div>
        <!-- 控制按钮：左右切换 -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
    </div>
    <div class="form-inline" style="margin-left: 20px">
        <h3>热门分类</h3>
        <a href="#"><img src="img/19.jpg" class="img-thumbnail"></a>
        <a href="#"><img src="img/20.jpg" class="img-thumbnail" style="margin-left: 10px">
        </a>
        <a href="#"><img src="img/21.jpg" class="img-thumbnail" style="margin-left: 10px">
        </a>
        <a href="#"><img src="img/22.jpg" class="img-thumbnail" style="margin-left: 10px">
        </a>
        <a href="#"><img src="img/19.jpg" class="img-thumbnail" style="margin-left: 10px">
        </a>
    </div>


    ​</div>
<c:import url="footer.jsp"></c:import>
</body>
</html>


