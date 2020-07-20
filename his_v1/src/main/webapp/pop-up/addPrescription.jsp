<%--
  Created by IntelliJ IDEA.
  User: 20241
  Date: 2020/7/17
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增方</title>

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
                            <label for="name">请输入模板名称 :</label>
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
                        <div class="ibox-content" style="margin-left: 20px">
                            <h7>处方明细：</h7>
                            <div class="table-responsive">
                                <table class="table table-hover" id="prescDetail">
                                    <thead>
                                    <tr>
                                        <th>药品名称</th><th>规格</th><th>单价</th><th>用法</th>
                                        <th>用量</th><th>频次</th><th>数量</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <td>头孢拉定</td><td>盒</td><td>12</td><td>一天两次</td>
                                    <td>每次两粒</td><td>11</td><td>2</td>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
