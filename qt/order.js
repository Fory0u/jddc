$(function(){
    var $cd = $(".thumbnail");
    var $shopCat = $('#cart_menus');
    zs()
    $cd.find(".caption .dc").on("click",function(){
        var _this = $(this);
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
                    '<img src="img/minus_icon_2s_dis.gif"></a> '+
                    '<input type="text" class="pro_numbers_input" value="1" maxlength="4"   disabled="disabled"  > '+
                    '<a class="doPlus"><img src="img/plus_icon_2s.gif"></a>'+
                    '</div>'+
                    '<div class="price">'+_this[0].parentNode.parentNode.children[1].innerHTML+'</div>'+
                    '</li>';

                    $shopCat.append(shopItem)
                    $shopCat.find(".del").off().on("click",sc)
                    $shopCat.find(".doMinus").off().on("click",jian);
                    $shopCat.find(".doPlus").off().on("click", ja);
                    zs();
                // }
                
           // }

        // });
        
    });
    $shopCat.find(".doMinus").on("click",jian);
    $shopCat.find(".doPlus").on("click", ja);
    $shopCat.find(".del").on("click",sc);
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
        allInput.each(function(){
            zs+= $(this).val()*1;
        })
        allLi.each(function(){
            zj +=$(this).find("input").val()*parseFloat($(this).find(".price").html().replace(/^\D+/ig,""))
        })
        $("#tatalnum").html(zs);
        $(".xj").html(zj.toFixed(2));
        $(".hj").html( (zj + $(".wsf").html()*1).toFixed(2) )
    }
})