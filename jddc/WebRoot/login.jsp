<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="ht/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="ht/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="ht/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="ht/lib/Hui-iconfont/1.0.7/iconfont.css" rel="stylesheet" type="text/css" />
<title>"含蓄"美容美发</title>
</head>
<body>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="" method="post"  id="loginForms">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input id="name" name="userName" type="text" placeholder="账户" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input id="pwd" name="userPwd" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3" >
          <input type="button"  onclick="checkLogin()" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
      
    </form>
  </div>
</div>
<%--<div class="footer"><a href="${pageContext.request.contextPath}/pnindex.jsp">前台连接</a></div>
<script type="text/javascript" src="ht/lib/jquery/1.9.1/jquery.min.js"></script>--%> 
<script type="text/javascript" src="ht/static/h-ui/js/H-ui.js"></script> 

<script type="text/javascript"
			src="<%=path%>/ht/lib/jquery/1.9.1/jquery.min.js">
</script>
		<script type="text/javascript"
			src="<%=path%>/ht/lib/layer/2.1/layer.js">
</script>
		<script type="text/javascript"
			src="<%=path%>/ht/lib/laypage/1.2/laypage.js">
</script>
		<script type="text/javascript"
			src="<%=path%>/ht/static/h-ui/js/H-ui.js">
</script>
		<script type="text/javascript"
			src="<%=path%>/ht/static/h-ui.admin/js/H-ui.admin.js">
</script>
<script type="text/javascript">

	function checkLogin(){
		var name = document.getElementById("name").value;
		var pwd = document.getElementById("pwd").value;
		if(name==""){
			alert("登录名不能为空！");
			return false;
		}
		if(pwd==""){
			alert("密码不能为空！");
			return false;
		}
		 $.post(
              "${pageContext.request.contextPath}/user.do?isLogin",{'userNo':name,'userPwd':pwd},
                  function(data,status){
                    if(data=='A'){
                       alert("账号有误");
                       return false;
                        }if(data=='N'){
                         alert("密码有误");
                       return false;
                        }else{
                          location.href="${pageContext.request.contextPath}/user.do?indexBg";
		  				  return true;
                        }
                    }
            )
	   
		
          
         return  true;
	}
</script>
</body>
</html>