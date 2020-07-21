<%@ page import="service.ChargePostService" %><%--
  Created by IntelliJ IDEA.
  User: 20241
  Date: 2020/7/17
  Time: 8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>缴费</title>

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

                <form method="POST" class="charge-form" id="charge-form">
                    <h7>患者病历号查询：</h7>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="regId">病历号 :</label>
                            <input type="text" name="regId" id="regId" required/>
                        </div>
                        <div class="form-submit">
                            <input type="button" value="查询" class="submit" name="check" id="check" />
                        </div>
                    </div><br>

                    <h7>患者信息确认</h7>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="nameConfirm">姓名 :</label>
                            <input type="text" name="nameConfirm" id="nameConfirm"/>
                        </div>
                        <div class="form-group">
                            <label for="idNumConfirm">身份证号 :</label>
                            <input type="text" name="idNumConfirm" id="idNumConfirm"/>
                        </div>
                    </div><br>

                    <h7>患者消费信息</h7>
                    <div class="ibox-content" style="margin-left: 20px">
                        <div class="table-responsive">
                            <table class="table table-hover" id="prescDetail">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" name="selectAll" style="width: 30px"></th>
                                    <th>病历号</th>
                                    <th>姓名</th>
                                    <th>项目名称</th>
                                    <th>单价</th>
                                    <th>数量</th>
                                    <th>开立时间</th>
                                    <th>状态</th>
                                </tr>
                                </thead>
                                <tbody id="chargeInfo">
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="form-submit">
                        <input type="button" value="收费结算" class="submit" name="submit" id="submit" />
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<input type="hidden" id="idxArr"/>
<input type="hidden" id="sum"/>


<%--复选框全选--%>
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



<%--计算总金额，弹出弹窗--%>
<script language="javascript">

    $(document).ready(function () {
        $("#submit").click(function () {
            var idxArr = new Array();

            $("input:checkbox[name=choice]:checked").each(function () {
                let tmp = $(this).attr("id");
                idxArr.push(tmp);
            });

            $("#idxArr").val(JSON.stringify(idxArr));

            $.ajax({
                type: "get",
                url: "${pageContext.request.contextPath}/ChargeCalPay",
                dataType: "json",
                data: {data: $("#idxArr").val()},
                success: function (msg) {
                    $("#sum").val(msg);
                }
            })

            window.open('pop-up/invoice.jsp', '发票', 'height=500, width=1150, top=300,left=300')

            // 清空列表：
            var rows = document.getElementById("chargeInfo").rows;
            for (let i=rows.length-1; i>=0; i--) {
                rows[i].remove();
            }

        })
    })

</script>




<%--点击查询，获取信息--%>
<script>
   $("#check").click(function () {

        var rId = $("#regId").val();
        // 1. 去患者表中找到姓名身份证
       $.ajax({
           type: "get",
           url: "${pageContext.request.contextPath}/ChargeGetPatient",
           dataType: "json",
           data: {regId: rId},
           success: function (msg) {
               $("#nameConfirm").val(msg.patientName);
               $("#idNumConfirm").val(msg.idNumber);
           }
       })

       $.ajax({
           type: "get",
           url: "${pageContext.request.contextPath}/ChargeGetPay",
           dataType: "json",
           data: {regId: rId},
           success: function (msg) {
               var rows = document.getElementById("chargeInfo").rows;
               for (let i=rows.length-1; i>=0; i--) {
                   rows[i].remove();
               }
               for (let i=0; i<msg.length; i++) {
                   $('#chargeInfo').append(
                       '<tr>' +
                       '<th>'+'<input type="checkbox" name="choice" style="width: 30px" id="'+msg[i].id+'">'+'</th>' +
                       '<td>' + msg[i].regId + '</td>' +
                       '<td>' + msg[i].patientName + '</td>' +
                       '<td>' + msg[i].itemName + '</td>' +
                       '<td>' + msg[i].itemPrice + '</td>' +
                       '<td>' + msg[i].amount + '</td>' +
                       '<td>' + msg[i].opentime + '</td>' +
                       '<td>' + msg[i].drugStatus + '</td>' + '<tr>'
                   )}
           }
       })

   })
</script>


</body>
</html>
