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
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="ht/static/h-ui/css/H-ui.min.css" rel="stylesheet"
	type="text/css" />
<link href="ht/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet"
	type="text/css" />
<link href="ht/static/h-ui.admin/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="ht/lib/Hui-iconfont/1.0.7/iconfont.css" rel="stylesheet"
	type="text/css" />

<title>编辑菜单</title>
</head>
<body>
	<article class="page-container">
		<form class="form form-horizontal" id="form-dish-edit"
			action="cd.do?editCd" method="post" target="_parent">
			<div class="row cl" style="display:none;">
				<label class="form-label col-xs-4 col-sm-3">id：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${cd.CId}"
						name="cid" readonly="readonly" style="width: 250px">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>菜名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" required id="cdmc"
						name="cdmc" value="${cd.CCdmc}" style="width: 250px">
				</div>
			</div>

			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>价格：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="number" class="input-text" step="0.01" required
						 value="${cd.FJg}" id="jg" name="jg" style="width: 250px">
				</div>
			</div>

			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>菜类：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<select id="cl" name="cl" required style='width:250px;height:30px'  >
						<!--<option value ="${cd.CCl}">${cd.CCl}</option> 
						 <option value ="女">女</option>  -->
					</select>
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<input class="btn btn-primary radius" type="submit"
						value="&nbsp;&nbsp;保存&nbsp;&nbsp;" style="width: 250px">
				</div>
			</div>
		</form>
	</article>

	<script type="text/javascript"
		src="http://lib.h-ui.net/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://lib.h-ui.net/layer/2.1/layer.js"></script>
	<script type="text/javascript"
		src="http://lib.h-ui.net/icheck/jquery.icheck.min.js"></script>
	<script type="text/javascript"
		src="http://lib.h-ui.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>
	<script type="text/javascript"
		src="http://lib.h-ui.net/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="http://lib.h-ui.net/jquery.validation/1.14.0/messages_zh.min.js"></script>
	<script type="text/javascript"
		src="<%=path%>/ht/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript"
		src="<%=path%>/ht/static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer /作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript">
		$(function() {
			$("#form-dish-edit").validate({

				onkeyup : false,
				focusCleanup : true,
				success : "valid",
				submitHandler : function(form) {
					$(form).ajaxSubmit();
					var index = parent.layer.getFrameIndex(window.name);
					parent.$('.btn-refresh').click();
					parent.layer.close(index);
				}
			});
			$.ajax({
				type: "post",
			  	url: "cl.do?getAllCl",
				success:function(rs){
					for ( var i = 0; i < rs.length; i++) {
						var obj = rs[i];
					/* 	var item =  */
						$('#cl').append("<option value ='"+obj.CId+"'>"+obj.CCl+"</option>");
				}
			}
		})	
		});
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>