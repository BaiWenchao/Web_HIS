<%--
  Created by IntelliJ IDEA.
  User: 20241
  Date: 2020/7/17
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发药</title>

    <!-- Main css -->
    <link rel="stylesheet" href="css_js/regist/css/style.css">
    <link rel="stylesheet" href="css_js/doc/tabpagecss/bootstrap.css" type="text/css">

    <!-- JS -->
    <script src="css_js/regist/js/jquery.min.js"></script>
    <script src="css_js/regist/js/main.js"></script>
    <script src="css_js/doc/tabpagecss/bootstrap.js"></script>
</head>
<body>
<div class="main">
    <div class="container">
        <div class="signup-content">
            <div class="signup-form">

                <form method="POST" class="drug-form" id="drug-form">
                    <h7>待发药品查询：</h7>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="id">病历号 :</label>
                            <input type="text" name="id" id="id" required/>
                        </div>
                        <div class="form-group">
                            <div class="form-submit">
                                <input type="button" value="查询" class="submit" name="check" id="check" />
                            </div>
                        </div>
                    </div><br>

                    <h7>药品信息</h7>
                    <div class="ibox-content" style="margin-left: 20px">
                        <div class="table-responsive">
                            <table class="table table-hover" id="prescDetail">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" name="selectAll" style="width: 30px"></th>
                                    <th>药品名称</th>
                                    <th>单价</th>
                                    <th>数量</th>
                                    <th>开立时间</th>
                                    <th>缴费状态</th>
                                </tr>
                                </thead>
                                <tbody id="deliverDrugs">
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="form-submit" id = "submitForm">
                        <input type="button" value="发药" class="submit" name="submit" id="submit" />
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $('input[name="selectAll"]').change(function () {
            if ($(this).is(":checked")) {
                $(this).attr('checked', true);
                $("input[name='choice']").attr({'checked': true});
            } else {
                $(this).attr('checked', false);
                $("input[name='choice").attr({'checked': false});
            }
        });
    });
</script>


<script>
    $("#check").click(function () {
        var rId = $("#id").val();
        // 获取药品数据：
        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/PharmacyGetInfo",
            dataType: "json",
            data: {regId: rId},
            success: function (msg) {
                for (let i = 0; i < msg.length; i++) {
                    $('#deliverDrugs').append(
                        '<tr>' +
                        '<th>' + '<input type="checkbox" name="choice" style="width: 30px">'+'</th>'+
                        '<td>' + msg[i].itemName + '</td>' +
                        '<td>' + msg[i].itemPrice + '</td>' +
                        '<td>' + msg[i].amount + '</td>' +
                        '<td>' + msg[i].opentime + '</td>' +
                        '<td>' + msg[i].drugStatus + '</td>' +'<tr>'
                    )
                }
            }
        })
    })
</script>

<script>

    $("#submit").click(function () {
        alert("发药成功！")

        var rows = document.getElementById("deliverDrugs").rows;

        for (let i=rows.length-1; i>=0; i--) {
            rows[i].remove();
        }
    })

</script>

</body>
</html>
