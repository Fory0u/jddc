<%@page import="com.sun.xml.internal.ws.client.RequestContext"%>
<%@page import="org.junit.runner.Request"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>酒店菜单管理页面</title>
    <script src="<%=path%>/qt/res/jquery/jquery.min.js"></script>
	<link rel="stylesheet" href="<%=path%>/qt/css/cdList.css" />
	<script src="<%=path%>/qt/js/order.js"></script>
</head>

<body>
<c:import url="head.jsp"></c:import>
    <div class="container ">
        <div class="row">
            <div class="col-md-3">
                <ul class="nav nav-pills nav-stacked">
                	<c:forEach items="${cls}" var="cl" >
	                    <li role="presentation"><a href="#" class="cls" data-src="cd.do?listCdByCl&clid=${cl.CId}">${cl.CCl}</a><i class="glyphicon glyphicon-chevron-right
	                    "></i></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-md-6">
            	<c:forEach items="${cds}" var="cd" >
            		<div class="col-sm-6 col-md-4">
	                     <div class="thumbnail">
	                        <img src="<%=path%>/qt/img/点心小吃/南瓜饼.jpg" style="height: 200px; width: 100%; display: block;" />
	                        <div class="caption">
	                            <h3 class="cdmc">${cd.CCdmc}</h3>
	                            <p class="money">价格：${cd.FJg}元</p>
	                            <p><a href="#" class="btn btn-primary dc" role="button" onclick="dc(this)">点菜</a></p>
	                            <input type="hidden" name="cdid" value="${cd.CId}">
	                        </div>
	                    </div> 
	                </div>
            	</c:forEach>
               <%-- <div class="col-sm-6 col-md-4">
                     <div class="thumbnail">
                        <img src="<%=path%>/qt/img/cz1.jpg" style="height: 200px; width: 100%; display: block;" />
                        <div class="caption">
                            <h3 class="cdmc">餐单1</h3>
                            <p class="money">价格：10</p>
                            <p><a href="#" class="btn btn-primary dc" role="button" >点菜</a></p>
                            <!-- <input type="hidden" name="cdid" value="${item.CId}"> -->
                        </div>
                    </div> 
                </div>--%>
            </div>
            <div class="col-md-3">
                <div class="right_order_menu">
                    <div class="right_order_top">
                        <h2>购物车</h2>
                        <span class="shop_cart_num" id="tatalnum">0</span>
                    </div>
                    <div class=" sub_right_order_main">
                        <div class="order_detail" style="height: 265px;">
                            <ul id="cart_menus">
                                <!-- <li>
                                    <div class="pro_title">9.9元黄金鸡块9块</div>
                                    <div class="del"><a href="javascript:void(0);"></a></div>
                                    <div class="pro_numbers"><a href="javascript:void(0);" style="cursor: default;"
                                            class="doMinus"><img
                                                src="img/minus_icon_2s_dis.gif"></a><input
                                            type="text" class="pro_numbers_input" value="1" maxlength="4"
                                            disabled="disabled" onkeyup="this.value=this.value.replace(/D/g,'');"><a
                                            href="javascript:void(0);" style="cursor: pointer;" class="doPlus"><img
                                                src="img/plus_icon_2s.gif"></a>
                                    </div>
                                    <div class="price">9.9</div>
                                </li> -->
                            </ul>
                        </div>
                    </div>
                    <div class="total">
                        <ul>
                            <li>
                                <span class="Til">小计:</span>
                                <span class="Price xj">0</span>
                            </li>
                            <li>
                                <span class="Til" style="width: 170px;">外送费</span>
                                <span class="Price wsf">9.0</span>
                            </li>
                            <li>
                                <span class="Til">合计:</span>
                                <span class="Price hj">9.0</span>
                            </li>
                        </ul>
                    </div>
                    <p class="al_c">
                        <input type="button" class="order_btn_1">
                    </p>
                    <p style="padding:6px 10px;">
                        <span class="span_3">提醒：根据您最终提交订单时间，送餐时间可能略有调整。</span>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <form style="display: none" id="orderForm" >
        <input name="dcxx" type="text" value="">
        <input name="dcsl" type="text" value="">
        <input name="user" type="text" value="${loginUser.CId}">
        <input name="czmc" type="text" value="${cz.CId}">
        <input name="ddzt" type="text" value="未结账">
        <input type="text" name="qt" value="qt">
    </form>
    <c:import url="footer.jsp"></c:import>
</body>

</html>
