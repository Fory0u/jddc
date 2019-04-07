<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>酒店点菜用户注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=path%>/qt/res/static/css/global.css">
</head>

<body>
<c:import url="head.jsp"></c:import>
<div class="site-content ">
	<div class="site-text site-block">
		<form class="layui-form"  action="">
		<div class="layui-form-item">
			<label class="layui-form-label">用户姓名：</label>
			<div class="layui-input-block">
				<input type="text" name="userName" required lay-verify="required"
					placeholder="请输入用户姓名：" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">登录id：</label>
			<div class="layui-input-block">
				<input type="text" name="loginid" required lay-verify="required"
					placeholder="请输入登录id：" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码框</label>
			<div class="layui-input-inline">
				<input type="password" name="userPwd" required
					lay-verify="required" placeholder="请输入密码" autocomplete="off"
					class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux">*英文或数字组成</div>
		</div>
		<input type="hidden" name="adminFlag" value="2">
		<!-- <div class="layui-form-item">
			<label class="layui-form-label">单选框</label>
			<div class="layui-input-block">
				<input type="radio" name="sex" value="男" title="男"> 
				<input type="radio" name="sex" value="女" title="女" checked>
			</div>
		</div> -->
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	</div>
</div>

	<script>
		//Demo
		layui.use('form', function(){
		  var form = layui.form;
		  
		  //监听提交
		  form.on('submit(formDemo)', function(data){
			  $.ajax({                 
				url: '${pageContext.request.contextPath}/user.do?addUser',                 
				type: 'get',                 
				data: $(data.form).serialize(),                 
				success: function(info) { 
					debugger                 
					if(info) {            
							location.href = '${pageContext.request.contextPath}/user.do?qiehuan';         
					}else{
						layer.msg(info.msg); 
					}                    
				}             
			});             
			return false;
		  
		  });
		});
	</script>
</body>
</html>
