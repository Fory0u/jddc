<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>酒店订单结算页面</title>
    
	<script src="<%=path%>/qt/res/jquery/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css"
	href="<%=path%>/qt/res/layui/css/layui.css">
    <link rel="stylesheet" href="<%=path%>/qt/css/orderJs.css" />
	<script src="<%=path%>/qt/res/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=path%>/qt/res/layui/layui.js"></script>
    <script type="text/javascript">
	       
    </script>
    <script src="<%=path%>/qt/js/orderJs.js"></script>
</head>

<body>
	<c:import url="head.jsp"></c:import>
    <div id="content" class="containter">
        <div class="login_content">
            <div class="order_content_main">
                <div class="confirmation_order">
                    <!-- 导航条 -->
                    <div class="confirmation_order_title">
                            <img src="http://res.4008823823.com.cn/kfcios/Html/res/images/step_3.gif" border="0" usemap="#Map">
                    </div>
                    <!-- 订单明细和优惠 -->
                    <div id="order_promotion">
                        <!-- 订单详细  -->
                        <div class="order_detail_1">
                            <table width="100%" border="1" class="order_detail_table">
                                <tbody>
                                    <tr>
                                        <th style="display: none;">id</th>
                                        <th width="6%">序号</th>
                                        <th width="20%">品名</th>
                                        <th width="9%">单价</th>
                                        <th width="10%">数量</th>
                                        <th width="9%">小计</th>
                                        <th width="8%"><a href="javascript:;" id="clearProduct" style="color:#363435;">全部取消</a></th>
                                    </tr>
                                    <c:forEach items="${orderList}" var="o" varStatus="oo">
	                                    <tr class="food_row" >
	                                        <td style="display: none;">${o.cid}</td>
	                                        <td>${oo.count}</td>
	                                        <td>${o.cdmc}</td>
	                                        <td>¥${o.jg}</td>
	                                        <td>
	                                            <a class="doMinus" style="text-decoration: none;"><img src="<%=path%>/qt/img/minus_icon_2.gif"></a>
	                                            <input type="text" class="pro_number_input2" value="${o.dcsl}"  disabled="disabled">
	                                            <a class="doPlus"><img src="<%=path%>/qt/img/add_icon._2.gif"></a>
	                                        </td>
	                                        <td>¥ ${o.xj}</td>
	                                        <td><img src="<%=path%>/qt/img/delete_icon_3.png"><a class="oiCancel" >取消</a></td>
	                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="coupon_code" style="margin-bottom: 37px;*margin-bottom: 40px;">
                            <p>
                                <span class="price_span" style="margin-left: -46px">
                                        小　计：<span class="xj"></span>元 | 
                                        外送费 ： <span class="wsf">9.0 </span>元
                                </span>
                            </p>
                            <span class="total_price_span hj" style="margin-left: -46px">总金额：${order.FZj}元</span>
                            <p class="coupon_explain">
                                <span>促销活动中，欢迎大家点菜。</span>
                            </p>
                        </div>
                    </div>
                    
                    <div class="clear"></div>
                </div>
                <p>
                        <input type="button" class="b_shang" id="back_menu_btn">
                        <input type="button" class="b_xia" id="submit_btn" value="确定提交订单">
                </p>
            </div>

        </div>
        <form style="display: none;" id="orderForm" >
                <input type="text" name="cid" value="${order.CId}"><!--订单id ${cd.CId}-->
                <input name="dcxx" type="text" value="">
                <input name="dcsl" type="text" value="">
                <input name="user" type="text" value="${loginUser.CId}">
		        <input name="czmc" type="text" value="${cz.CId}">
                <input name="ddzt" type="text" value="未结账">
                <input type="text" name="qt" value="qt">
        </form>
    </div>
    <c:import url="footer.jsp"></c:import>
    
</body>
</html>