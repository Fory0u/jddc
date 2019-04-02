
var $shopCat;
var $cd;
var $js ;
var dcxx = "";
var dcsl = "";
$(function(){
	$shopCat =  $('#cart_menus');
	$cd = $(".thumbnail");
	$js = $('.order_btn_1');
    zs()
    //初始化菜单
     /*$.ajax({
    	 type: "POST",
         url: $('.nav.nav-pills').find('li:first a').attr('href'),
         success: function(rs){
        	 console.log(rs);
         }
     })*/
    $('.cls').on("click",function(){
    	$.ajax({
       	 type: "POST",
            url: $(this).data('src'),
            success: function(rs){
				$('.row .col-md-6').children().remove();
                for ( var i = 0; i < rs.length; i++) {
					var obj = rs[i];
					var cd = '<div class="col-sm-6 col-md-4">'+
				                '<div class="thumbnail">'+
				                    '<img src="qt/img/点心小吃/南瓜饼.jpg" style="height: 200px; width: 100%; display: block;" />'+
				                    '<div class="caption">'+
				                        '<h3 class="cdmc">'+obj.CCdmc+'</h3>'+
				                        '<p class="money">价格：'+obj.FJg.toFixed(2)+'</p>'+
				                        '<p><a href="javascript:void(0);" class="btn btn-primary dc" role="button" onclick="dc(this)">点菜</a></p>'+
				                        '<input type="hidden" name="cdid" value="'+obj.CId+'">'+
				                    '</div>'+
				               '</div>'+
				           '</div>';
					$('.row .col-md-6').append(cd);
                }
            }
        })
    	
    })
    
    $cd.find(".caption .dc").on("click",dc); 
    $shopCat.find(".doMinus").on("click",jian);
    $shopCat.find(".doPlus").on("click", ja);
    $shopCat.find(".del").on("click",sc);
    $js.on("click",jiesuan);
    
    //判断登录 和餐桌
    (function(){
    	var $user = $('input[name="user"]');
        var $cz = $('input[name="czmc"]');
//        console.log(getHref())
        if(!$user.val() || $user.val() == ''){
        	window.location.href = getHref()+'';
        }
        else if(!$cz.val() || $cz.val() == ''){
        	window.location.href = getHref()+'cz.do?listCzQt';
        }
    })();
    
})
  function getHref(){
	return  window.location.protocol + '//' + window.location.host +   window.location.pathname.substring(0, window.location.pathname.substring(1).indexOf('/')+1)+'/'
}
  function jiesuan (){
//	 var json =  $.parseJSON($("#orderForm").serializeObject());
	 var json =  $("#orderForm").serializeObject();
        $.ajax({
            url:'order.do?addOrder',
            dataType: 'json',
            type:"POST",
            data:json,
            contentType: "application/json;charset=UTF-8", //缺失会出现URL编码，无法转成json对象
            success:function(rs){
            	var index = '';
            	if(rs && rs.index && rs.index !=null && rs.index !='')
            		index ='&index='+rs.index;
            	window.location.href = getHref()+'order.do?listOrderByRyid&ryid='+$('input[name="user"]').val()+index;
//                console.log(rs)
                // alert("成功");
            }
        });
    }
	function sc (){
        $(this).eq(0).parents().eq(0).remove()
        zs();
    }
    
    function ja (){
        var input =$(this).eq(0).parents().eq(0).children().eq(1);
        if(input.val()*1>=5){
            return;
        }else{
           input.val(input.val()*1+1+"") 
        }
        zs();
    }
    function jian (){
        var input =$(this).eq(0).parents().eq(0).children().eq(1);
        if(input.val()*1<=1){
            return;
        }else{
           input.val(input.val()*1-1+"") 
        }
        zs();
        // $(this).eq(0).parents().eq(0).remove()
    }

    function zs(){
        var allInput = $shopCat.find(".pro_numbers_input");
        var allLi = $shopCat.find("li");
        var zs = 0;
        var zj = 0;
        dcsl = "";
        dcxx = "";
        allInput.each(function(){
            zs+= $(this).val()*1;
            dcsl +=  $(this).val()+";"
        })
        allLi.each(function(){
            zj +=$(this).find("input").eq(0).val()*parseFloat($(this).find(".price").html().replace(/^\D+/ig,""))
            dcxx += $(this).find("input").eq(1).val() + ";";
        })
        
        $('input[name=dcxx]').val(dcxx)
        $('input[name=dcsl]').val(dcsl)
        $("#tatalnum").html(zs);
        $(".xj").html(zj.toFixed(2));
        $(".hj").html( (zj + $(".wsf").html()*1).toFixed(2) )
    }
    function dc(e){
        var _this = $(e);
        // debugger;
        console.log( )
        // $.ajax({
        //    type: "POST",
        //    url: "/cd.do?cid=",
        //    data: "name=John&location=Boston",
        //    success: function(rs){
                // if(rs){
                    var shopItem = "<li>"+
                    '<div class="pro_title">'+_this[0].parentNode.parentNode.children[0].innerHTML+'</div>'+
                    '<div class="del"><a href="javascript:void(0);"></a></div>'+
                    '<div class="pro_numbers">'+
                    '<a href="javascript:void(0);" style="cursor: default;"  class="doMinus"> '+
                    '<img src="./qt/img/minus_icon_2s_dis.gif"></a> '+
                    '<input type="text" class="pro_numbers_input" value="1" maxlength="4"   disabled="disabled"  > '+
                    '<a class="doPlus"><img src="./qt/img/plus_icon_2s.gif"></a>'+
                    '</div>'+
                    '<div class="price">'+_this[0].parentNode.parentNode.children[1].innerHTML+'</div>'+
                    '<input type="hidden" value='+_this.eq(0).parents().eq(1).find('input').val()+'>'+
                    '</li>';
                    $shopCat.append(shopItem)
                    $shopCat.find(".del").off().on("click",sc)
                    $shopCat.find(".doMinus").off().on("click",jian);
                    $shopCat.find(".doPlus").off().on("click", ja);
                    zs();
                // }
                
           // }

        // });
        
    }
