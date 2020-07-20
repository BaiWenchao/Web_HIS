<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link href="css_js/login/login.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Titles -->
        <h2 class="active"> 系统登录 </h2>
        <br><br>
        <!-- Login Form -->
        <form action="${pageContext.request.contextPath}/Login" method="post">
            <input type="text" id="login" class="fadeIn second" name="login" placeholder="账号"><br>
            <input type="text" id="password" class="fadeIn third" name="password" placeholder="密码"><br><br>
            <input type="submit" class="fadeIn fourth" id="submit" value="登录">
        </form>
    </div>
</div>

</body>
</html>
