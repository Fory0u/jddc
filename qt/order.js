$(function(){
    var $cd = $(".thumbnail");
    var $shopCat = $('#cart_menus');
    $cd.find(".caption .dc").on("click",function(){
        $.ajax({
            url:""

        })
        var shopItem = "<li>"+
            '<div class="pro_title">9.9元黄金鸡块9块</div>'+
            '<div class="del"><a href="javascript:void(0);"></a></div>'+
            '<div class="pro_numbers">'+
            '<a href="javascript:void(0);" style="cursor: default;"  class="doMinus"> '+
            '<img src="img/minus_icon_2s_dis.gif"></a> '+
            '<input type="text" class="pro_numbers_input" value="1" maxlength="4"   disabled="disabled"  > '+
            '<a class="doPlus"><img src="img/plus_icon_2s.gif"></a>'+
            '</div>'+
            '<div class="price">9.9</div>'+
            '</li>'

        $shopCat.append(shopItem)
    });
  
    
})