//异步加载下拉框
$(function() {
    $("#search").keyup(function() {
        var rname = $(this).val();
        if (rname != null && "" != rname) {
            $.post("/listName", {
                "rname" : rname
            }, function(data) {
                var json = eval(data);
                console.log(data)
                var html = "<table border='0' width='410px'>";
                for (var i = 0; i < json.length; i++) {
                    html += "<tr><td>" + json[i].rname + "</td></tr>";
                }
                html += "</table>";
                $("#dtn").show().html(html);

                //鼠标移动到某行上改变颜色
                $("tr").bind("mouseover", function() {

                    $(this).css("background-color", "beige");
                });
                $("tr").bind("mouseout", function() {
                    $(this).css("background-color", "#ffffff");
                });
                //单击某行跳转到详细页面
                $("tr").bind("click", function() {
                    location.href = "/findRouteClick?rname=" + $(this).find("td").text();
                });
            } ,"json");
        } else {
            $("#dtn").hide();
        }
    });
});
