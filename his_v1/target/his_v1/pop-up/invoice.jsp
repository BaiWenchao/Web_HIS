<%--
  Created by IntelliJ IDEA.
  User: 20241
  Date: 2020/7/17
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发票</title>

    <!-- Main css -->
    <link rel="stylesheet" href="../css_js/regist/css/style.css">
    <link rel="stylesheet" href="../css_js/doc/tabpagecss/bootstrap.css" type="text/css">

    <!-- JS -->
    <script src="../css_js/doc/tabpagecss/bootstrap.js"></script>
    <script src="../css_js/regist/js/jquery.min.js"></script>
    <script src="../css_js/regist/js/main.js"></script>
</head>
<body>
<div class="main">
    <div class="container">
        <div class="signup-content">
            <div class="signup-form">
                <form method="POST" class="register-form" id="register-form">
                    <div class="form-row">
                        <div class="form-group">
                            <label for="invoiceNum">发票号 :</label>
                            <input type="text" name="invoiceNum" id="invoiceNum" required/>
                        </div>

                        <div class="form-group">
                            <label for="regNum">病历号 :</label>
                            <input type="text" name="regNum" id="regNum" required/>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group">
                            <label for="name">患者姓名 :</label>
                            <input type="text" name="name" id="name" required/>
                        </div>

                        <div class="form-group">
                            <label for="feeType">结算类别 :</label>
                            <div class="form-select">
                                <select name="feeType" id="feeType">
                                    <option value="self">自费</option>
                                    <option value="insurance">市医保</option>
                                </select>
                                <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
                            </div>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group">
                            <label for="get">应收金额 :</label>
                            <input type="text" name="get" id="get" required/>
                        </div>

                        <div class="form-group">
                            <label for="realget">实收金额 :</label>
                            <input type="text" name="realget" id="realget" required/>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group">
                            <label for="balance">找零 :</label>
                            <input type="text" name="balance" id="balance" required/>
                        </div>
                    </div>



                    <div class="form-submit">
                        <input type="button" value="刷新" class="submit" name="fresh" id="fresh" />
                        <input type="button" value="确定" class="submit" name="submit" id="submit" />
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>



<script type="text/javascript">

    $("#fresh").click(function () {
        var tmp = Number(window.opener.document.all.regId.value) + Number(1000);

        $("#invoiceNum").val(tmp);
        $("#regNum").val(window.opener.document.all.regId.value);
        $("#name").val(window.opener.document.all.nameConfirm.value);
        $("#get").val(20);
    })

    $("#realget").change(function () {
        var val = $("#realget").val() - $("#get").val();
        $("#balance").val(val);
    })
</script>



<script>
    $("#submit").click(function () {
        $.ajax({
        })
    })
</script>

</body>
</html>
