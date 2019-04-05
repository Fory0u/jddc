$(function() {
	var $table = $(".order_detail_table");
	var $tr = $table.find('tr.food_row');
	var $js = $('#submit_btn');
	$tr.find(".doMinus").on("click", jian);
	$tr.find(".doPlus").on("click", ja);
	$tr.find(".oiCancel").on("click", sc);
	$js.on("click", jiesuan);

	// 判断登录 和餐桌
	(function() {
		var $user = $('input[name="user"]');
		var $cz = $('input[name="czmc"]');
		// console.log(getHref())
		if (!$user.val() || $user.val() == '') {
			window.location.href = getHref() + '';
		} else if (!$cz.val() || $cz.val() == '') {
			window.location.href = getHref() + 'cz.do?listCzQt';
		}
	})();

	zs();

	function sc() {
		$(this).eq(0).parents().eq(1).remove();

		zs();
	}

	function ja() {
		var input = $(this).eq(0).parents().eq(0).children().eq(1);
		if (input.val() * 1 >= 5) {
			return;
		} else {
			input.val(input.val() * 1 + 1 + "")
		}
		zs();
	}
	function jian() {
		var input = $(this).eq(0).parents().eq(0).children().eq(1);
		if (input.val() * 1 <= 1) {
			return;
		} else {
			input.val(input.val() * 1 - 1 + "")
		}
		zs();
		// $(this).eq(0).parents().eq(0).remove()
	}

	function zs() {
		var allSl = $table.find(".pro_number_input2");
		var allDj = $table.find("td:nth-child(4)");
		var allXj = $table.find("td:nth-child(6)");
		var allDcId = $table.find("td:nth-child(1)");
		var zs = 0;
		var zj = 0;
		dcsl = "";
		dcxx = "";

		$('.food_row').each(
				function() {
					var xj = (allSl.eq($(this).index() - 1).val() * allDj.eq(
							$(this).index() - 1).html().replace(/^\D+/ig, ""))
							.toFixed(2);
					zj += xj * 1;
					dcsl += allSl.eq($(this).index() - 1).val() + ";";
					dcxx += allDcId.eq($(this).index() - 1).html() + ";";
					allXj.eq($(this).index() - 1).html("¥ " + xj);
				})

		$('input[name=dcxx]').val(dcxx);
		$('input[name=dcsl]').val(dcsl);
		$(".xj").html(zj.toFixed(2));
		$(".hj").html((zj + $(".wsf").html() * 1).toFixed(2))
	}

	function jiesuan() {
		var json = $("#orderForm").serializeObject();
		$.ajax({
			url : 'order.do?qrdd',
			dataType : 'json',
			type : "POST",
			data : json,
			contentType : "application/json;charset=UTF-8", // 缺失会出现URL编码，无法转成json对象
			success : function(rs) {
				var _index = '';
				var userId = '';
				if (rs && rs.index && rs.index != null && rs.index != '')
					_index = '&index=' + rs.index;
				if (rs && rs.userId && rs.userId != null && rs.userId != '') {
					userId = '&ryid=' + rs.userId;
				} else {
					window.location.href = getHref() + '';
				}
				layui.use('layer', function() {
					var layer = layui.layer;
					layer.open({
						content : '再次确定订单',
						btn : [ '确认', '取消' ],
						yes : function(index, layero) {
							// 按钮【按钮一】的回调
							window.location.href = getHref()
									+ 'order.do?listOrderByRyid' + userId
									+ _index;
						},
						btn2 : function(index, layero) {
							// 按钮【按钮二】的回调
							// return false 开启该代码可禁止点击该按钮关闭
						},
						cancel : function() {
							// 右上角关闭回调
							// return false 开启该代码可禁止点击该按钮关闭
						}
					});
				});
			}
		});
	}
	function getHref() {
		return window.location.protocol
				+ '//'
				+ window.location.host
				+ window.location.pathname.substring(0,
						window.location.pathname.substring(1).indexOf('/') + 1)
				+ '/'
	}
})