<%--
  Created by IntelliJ IDEA.
  User: 20241
  Date: 2020/7/17
  Time: 8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退号</title>

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

                <form method="POST" class="register-form" id="register-form">
                    <h7>患者病历号查询：</h7>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="regId">病历号 :</label>
                            <input type="text" name="regId" id="regId" required/>
                        </div>
                        <div class="form-group">
                            <div class="form-submit">
                                <input type="button" value="查询" class="submit" name="submit" id="check" />
                            </div>
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

                    <h7>患者挂号信息</h7>
                    <div class="ibox-content" style="margin-left: 20px">
                        <div class="table-responsive">
                            <table class="table table-hover" id="prescDetail">
                                <thead>
                                <tr>
                                    <th>病历号</th>
                                    <th>姓名</th>
                                    <th>挂号日期</th>
                                    <th>看诊科室</th>
                                    <th>看诊状态</th>
                                </tr>
                                </thead>
                                <tbody id="deRegist">
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="form-submit">
                        <input type="button" value="退号" class="submit" name="submit" id="submit" />
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


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

        // 2. 去挂号表中找挂号信息：
        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/ReReg",
            dataType: "json",
            data: {regId: rId},
            success: function (msg) {
                var status = (msg.regStatus===1) ? '未诊' : '非未诊';
                $('#deRegist').append(
                    '<tr>' +
                    '<td>' + msg.id + '</td>' +
                    '<td>' + msg.patientName + '</td>' +
                    '<td>' + msg.regDate + '</td>' +
                    '<td>' + msg.deptId + '</td>' +
                    '<td id="status">' + status + '</td>' +'<tr>'
                )}
        })
    })
</script>




<script>
    $("#submit").click(function () {
        var rId = $("#regId").val();
        var s = document.getElementById("status").innerHTML;
        if (s === '未诊') {
            alert("退号成功！")

            $.ajax({
                type: "get",
                url: "${pageContext.request.contextPath}/ChangeRegStatus",
                data: {status: 3, regId: rId}
            })


            // 将内容清空
            var rows = document.getElementById("deRegist").rows;
            for (let i=rows.length-1; i>=0; i--) {
                rows[i].remove();
            }


        } else {
            alert("无法退号！")
        }
    })
</script>



</body>
</html>
