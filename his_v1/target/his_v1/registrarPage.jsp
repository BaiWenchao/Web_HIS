<%--
  Created by IntelliJ IDEA.
  User: 20241
  Date: 2020/7/17
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="css_js/sidebar/css/style.css">
</head>
<body>

<div class="wrapper d-flex align-items-stretch">
    <nav id="sidebar">
        <div class="sidebar-header">
            <h3 style="color: white">东软HIS</h3>
        </div>
        <br><br>

        <ul class="list-unstyled components">
            <h6 style="color: white">挂号员：${userName}</h6><br>
            <li class="active">
                <a href="#regSubmenu" data-toggle="collapse" aria-expanded="false">挂号收费</a>
                <ul class="collapse list-unstyled" id="regSubmenu">
                    <li><a href="#" id="reg">现场挂号</a></li>
                    <li><a href="#" id="dereg">退号</a></li>
                    <li><a href="#" id="charge">收费</a></li>
                </ul>
            </li>
            <li class="active">
                <a href="${pageContext.request.contextPath}/Logout">退出登录</a>
            </li>
        </ul>
    </nav>

    <!-- Page Content  -->
    <div id="content" class="p-4 p-md-5 pt-5"></div>

</div>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="css_js/sidebar/js/popper.js"></script>
<script src="css_js/sidebar/js/bootstrap.min.js"></script>
<script src="css_js/sidebar/js/main.js"></script>


<script>
    $(document).ready(function () {
        $("#reg").click(function () {
            $.ajax({
                dataType: "html",
                url: "regist.jsp",
                type: "GET",
                success: function (msg) {
                    $('#content').html(msg);
                }
            })
        })
    })

    $(document).ready(function () {
        $("#charge").click(function () {
            $.ajax({
                dataType: "html",
                url: "charge.jsp",
                type: "GET",
                success: function (msg) {
                    $('#content').html(msg);
                }
            })
        })
    })

    $(document).ready(function () {
        $("#dereg").click(function () {
            $.ajax({
                dataType: "html",
                url: "deregist.jsp",
                type: "GET",
                success: function (msg) {
                    $('#content').html(msg);
                }
            })
        })
    })
</script>

</body>
</html>
