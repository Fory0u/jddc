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
<title>酒店点菜后台管理系统</title>
</head>
<body>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="user.do?register" method="post"  id="loginForms">
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
          <button  class="btn btn-primary radius zc size-L"  >&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;</button>
        </div>
      </div>
      
    </form>
  </div>
</div>


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
	$(function(){
		$('.zc').on("click",function(){
			/* $.ajax({
	            url:"${pageContext.request.contextPath}/user.do?register",
	            type:"POST",
	            dataType: 'json',
	            success:function(rs){
	            console.log(rs);
	            		//window.location.href=getHref()+rs+".jsp";
	            }
	        }); */
	        $('#loginForms').submit();
	        
		})
		
	});
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
                    if(data=='N'){
                         alert("账号或密码错误");
                       return false;
                        }else{
                          location.href="${pageContext.request.contextPath}/user.do?indexBg";
		  				  return true;
                        }
                    }
            )
	   
		
          
         return  true;
	}

	/* function zc(){
			window.top.location.href="${pageContext.request.contextPath}/user.do?register"; 
			
	}*/
	 function getHref(){
	return  window.location.protocol + '//' + window.location.host +   window.location.pathname.substring(0, window.location.pathname.substring(1).indexOf('/')+1)+'/'
}
</script>
</body>
</html>