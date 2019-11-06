//获取所有上报机构
function getOrganList(){

    var parms = new Object();
    parms["reportOrgan"]=$("#reportOrgan").val();
    $.ajax({
        cache: true,
        type: "POST",
        url: '/report/findOrganList.do',
        data: parms,
        async: false,
        success:function(data){
            var json = $.parseJSON(data);
            if(json.data.length > 15){
                var html = "<table class='altrowstable'>";
            }else{
                var html = "<table class='altrowstables'>";
            }
            for(var i=0;i<json.data.length;i++){
                html += "<tr><td οnclick=\"selectValue(this);\">" +  json.data[i].sysOrganName + "</td></tr>";
            }
            html += "</table>";
            //将获得的数据填充到下拉的数据框里也就是table里
            $("#organ").html(html);
            $("#organ").css("display", "block");
            $("#organ").css("left", $("#reportOrgan").offset().left + "px");
            $("#organ").css("top", $("#reportOrgan").offset().top + $("#reportOrgan").height() + 14 + "px");
        },
        error: function(request) {
            layer.msg("Connection error", {
                icon : 2
            });
        }
    });
}

//选择机构
function selectValue(obj){
    var organName = $(obj).text();
    $("#reportOrgan").val(organName);
}
//输入框中根据用户输入内容动态查询
var clocker = null;
function innerKeydown() {
    if(null == clocker) {
        clocker = setTimeout(getOrganList,700);
        //连续击键，重新开始计时
    } else {
        clearTimeout(clocker);
        clocker = setTimeout(getOrganList,700);
    }
}

function hideOrganDiv(){
    $("#organ").css("display", "none");
}

function clearInput(){
    $("#reportOrgan").val("");
}
