$(function(){
    $table = $(".order_detail_table");
    $tr =$table.find('tr.food_row');

    $tr.find(".doMinus").on("click",jian)
    $tr.find(".doPlus").on("click",ja)
    $tr.find(".oiCancel").on("click",sc)

    zs();
    // function jiesuan (){
    //     $('input[name=dcxx]').val(dcxx)
    //     $('input[name=dcsl]').val(dcsl)
    //     $.ajax({
    //         url:'order.do?addOrder',
    //         type:"POST",
    //         data:$.parseJSON($("#orderForm").serializeObject()),
    //         contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
    //         success:function(rs){
    //             console.log(rs)
    //             // alert("成功");
    //         }
    //     });
    // }
    function sc (){
        $(this).eq(0).parents().eq(1).remove();
        
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
        var allSl = $table.find(".pro_number_input2");
        var allDj = $table.find("td:nth-child(4)");
        var allXj = $table.find("td:nth-child(6)");
        var allDcId = $table.find("td:nth-child(1)");
        var zs = 0;
        var zj = 0;
        dcsl = "";
        dcxx = "";

        $('.food_row').each(function(){
            var xj = (allSl.eq($(this).index()-1).val()* allDj.eq($(this).index()-1).html().replace(/^\D+/ig,"")).toFixed(2);
            zj += xj*1;
            dcsl += allSl.eq($(this).index()-1).val() + ";"; 
            dcxx += allDcId.eq($(this).index()-1).html() + ";";
            allXj.eq($(this).index()-1).html("¥ "+xj);
        })

        $('input[name=dcxx]').val(dcxx);
        $('input[name=dcsl]').val(dcsl);
        $(".xj").html(zj.toFixed(2));
        $(".hj").html( (zj + $(".wsf").html()*1).toFixed(2) )
    }
})