<%--
  Created by IntelliJ IDEA.
  User: 20241
  Date: 2020/7/17
  Time: 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加疾病</title>

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
                            <label for="name">请输入疾病名称 :</label>
                            <input type="text" name="name" id="name" required/>
                        </div>
                        <div class="form-submit">
                            <input type="button" value="查询" class="submit" name="check" id="check" />
                        </div>
                        <div class="form-submit">
                            <input type="button" value="确定" class="submit" name="check" id="submit" />
                        </div>
                    </div><br><br>

                    <div class="form-row">
                        <div class="table-responsive">
                            <table class="table table-hover" id="diseaseDetail">
                                <thead>
                                <tr>
                                    <th>ICD编码</th>
                                    <th>疾病名称</th>
                                </tr>
                                </thead>
                                <tbody>
                                <td>A01.001</td>
                                <td>伤寒</td>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
