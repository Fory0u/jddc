$(function(){
    var $cd = $(".thumbnail");
    var $shopCat = $('#cart_menus');
    var $js = $('.order_btn_1');
    var dcxx = "";
    var dcsl = "";
    zs()
    
    //初始化菜单
     $.ajax({
    	 type: "POST",
         url: $('.nav.nav-pills').find('li:first a').attr('href'),
         success: function(rs){
        	 console.log(rs);
         }
     })
        
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
        
    });
    $shopCat.find(".doMinus").on("click",jian);
    $shopCat.find(".doPlus").on("click", ja);
    $shopCat.find(".del").on("click",sc);
    $js.on("click",jiesuan);
    
    function jiesuan (){
        $.ajax({
            url:'order.do?addOrder',
            type:"POST",
            data:$.parseJSON($("#orderForm").serializeObject()),
            contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
            success:function(rs){
                console.log(rs)
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










})
