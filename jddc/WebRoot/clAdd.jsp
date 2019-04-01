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

<script type="text/javascript" src="<%=path%>/ht/lib/jquery/1.9.1/jquery.min.js"></script> 
<link href="ht/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="ht/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="ht/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="ht/lib/Hui-iconfont/1.0.7/iconfont.css" rel="stylesheet" type="text/css" />

<title>菜类添加</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-admin-add" action="cl.do?addCl" method="post"  target="_parent">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>菜类：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" required="required" id="cl" name="cl" placeholder="菜名" style="width: 250px">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit"   value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去--> 
<script type="text/javascript" src="http://lib.h-ui.net/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="http://lib.h-ui.net/layer/2.1/layer.js"></script> 
<script type="text/javascript" src="http://lib.h-ui.net/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="http://lib.h-ui.net/jquery.validation/1.14.0/jquery.validate.min.js"></script> 
<script type="text/javascript" src="http://lib.h-ui.net/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="http://lib.h-ui.net/jquery.validation/1.14.0/messages_zh.min.js"></script> 
<script type="text/javascript" src="<%=path%>/ht/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=path%>/ht/static/h-ui.admin/js/H-ui.admin.js"></script> 
<!--/_footer /作为公共模版分离出去--> 

<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript">
	/*$(function(){
		$.ajax({
				type: "post",
			  	url: "cl.do?getAllCl",
				success:function(rs){
					for ( var i = 0; i < rs.length; i++) {
						var obj = rs[i];
					 	var item =  
						$('#cl').append("<option value ='"+obj.CId+"'>"+obj.CCl+"</option>");
				}
			}
		})	
	});*/
	function validate(){
		
		$('#form-admin-add').submit();
		/* return false; */
		return true;
	}
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>