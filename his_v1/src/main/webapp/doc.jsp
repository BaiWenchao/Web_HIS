<%--
  Created by IntelliJ IDEA.
  User: 20241
  Date: 2020/7/17
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>看诊</title>
    <link rel="stylesheet" href="css_js/doc/tabpagecss/bootstrap.css" type="text/css">
    <script src="css_js/doc/tabpagecss/bootstrap.js" type="text/javascript"></script>
    <script src="css_js/regist/js/jquery.js" type="text/javascript"></script>

    <link rel="stylesheet" href="css_js/regist/css/style.css">
</head>
<body>
<div class="row">

    <div class="ibox-content">
        <h7>未诊患者：</h7>
        <div class="table-responsive">
            <table class="table table-hover" id="patientNotDiagnose">
                <thead>
                <tr>
                    <th>挂号ID</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                </tr>
                </thead>
                <tbody id="RegRecord_fore">
                </tbody>
            </table>
        </div><br>
        <h7>已诊患者：</h7>
        <div class="table-responsive">
            <table class="table table-hover" id="patientDiagnose">
                <thead>
                <tr>
                    <th>挂号ID</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                </tr>
                </thead>
                <tbody id="RegRecord_after">
                </tbody>
            </table>
        </div>
    </div>



    <div class="signup-form" style="margin-left: 20px">

        <form method="POST" class="diag-form" id="diag-form">
            <h2>看诊信息：</h2>
            <div class="form-row">
                <div class="form-group">
                    <label for="name">姓名 :</label>
                    <input type="text" name="name" id="name" style="width: 300px" required/>
                </div>
                <div class="form-group">
                    <label for="regId">挂号ID</label>
                    <input type="text" name="regId" id="regId" style="width: 300px" required/>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="selfComplaint">主诉 :</label>
                    <input type="text" name="selfComplaint" id="selfComplaint" style="width: 700px"  required/>
                </div>
            </div>


            <div class="form-row">
                <div class="form-group">
                    <label for="currentHistory">现病史 :</label>
                    <input type="text" name="currentHistory" id="currentHistory" style="width: 700px" required/>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="currentStatus">现病治疗情况 :</label>
                    <input type="text" name="currentStatus" id="currentStatus" style="width: 700px" required/>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="pastHistory">既往史 :</label>
                    <input type="text" name="pastHistory" id="pastHistory" style="width: 700px" required/>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="allergyHistory">过敏史 :</label>
                    <input type="text" name="allergyHistory" id="allergyHistory" style="width: 700px" required/>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="bodyCheck">体格检查 :</label>
                    <input type="text" name="bodyCheck" id="bodyCheck" style="width: 700px" required/>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="searchDisease">疾病检索 :</label>
                    <input type="text" name="searchDisease" id="searchDisease" style="width: 200px" required/>
                </div>
                <div class="form-group">
                    <br>
                    <input type="button" value="添加疾病" class="submit" name="add" id="add" />
                    <input type="button" value="删除疾病" class="submit" name="delete" id="delete" />
                </div>
            </div>

            <div class="ibox-content" style="margin-left: 20px">
                <h7>诊断：</h7>
                <div class="table-responsive">
                    <table class="table table-hover" id="diseaseDetail">
                        <thead>
                        <tr>
                            <th><input type="checkbox" name="selectAll" style="width: 30px"></th>
                            <th>ICD编码</th>
                            <th>疾病名称</th>
                        </tr>
                        </thead>
                        <tbody id="diseases">
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="form-submit">
                <input type="reset" value="重置" class="submit" name="reset" id="reset" />
                <input type="button" value="提交表单" class="submit" name="submit" id="submit" />
            </div>
        </form>
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



<%--导入表单--%>
<script>
    // 导入患者列表
    $.ajax({
        type: "get",
        url: "${pageContext.request.contextPath}/DocGetPatient",
        dataType: "json",
        data: {docName: "${userName}"},
        success: function (msg) {
            var row = Number(0);

            for (let i = 0; i < msg.length; i++) {
                if (msg[i].regStatus === 1) {
                    // 插入未诊列表元素
                    $('#RegRecord_fore').append(
                        '<tr onclick="choosePatient(this)">' +
                        '<td>' + msg[i].id + '</td>' +
                        '<td>' + msg[i].patientName + '</td>' +
                        '<td>' + msg[i].patientGender + '</td>' +
                        '<td>' + msg[i].patientAge + '</td>' + '<tr>'
                    )

                    row++;
                } else if(msg[i].regStatus === 2) {
                    // 插入已诊列表元素
                    $('#RegRecord_after').append(
                        '<tr>' +
                        '<td>' + msg[i].id + '</td>' +
                        '<td>' + msg[i].patientName + '</td>' +
                        '<td>' + msg[i].patientGender + '</td>' +
                        '<td>' + msg[i].patientAge + '</td>' + '<tr>'
                    )
                }
            }

            if (row === 0) {
                alert("无未诊患者，不能填写病历！");
            }

        }
    })


</script>

<%--选中患者行，将患者信息打印在病历信息中--%>
<script>
    function choosePatient(tr) {
        $("#regId").val(tr.cells[0].innerHTML);
        $("#name").val(tr.cells[1].innerHTML);
    }

</script>

<script>
    $("#add").click(function () {
        var dName = $("#searchDisease").val();
        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/DocGetDisease",
            dataType: "json",
            data: {diseaseName: dName},
            success: function (msg) {
                if(msg != null) {
                    // 插入药品列表：
                    $('#diseases').append(
                        '<tr>' +
                        '<td>' + '<input type="checkbox" name="choice" style="width: 30px">' + '</td>' +
                        '<td>' + msg.diseaseICD + '</td>' +
                        '<td>' + msg.diseaseName + '</td>' + '</tr>'
                    )
                } else {
                    alert("请输入正确的疾病名称！")
                }
            }
        })
    })

</script>


<%--遍历疾病表格，删除选中的行--%>
<script>
    $("#delete").click(function () {
        $("input[type='checkbox']").each(function () {
            if($(this).prop("checked")) {
                $(this).closest('tr').remove();
            }
        })
    })
</script>


<%--遍历表格，将其发送出去--%>
<script>
    $("#submit").click(function () {
        var
            table = document.getElementById("diseaseDetail"),
            rows = table.rows,
            diseases = '';

        // 分号隔开疾病，逗号隔开疾病参数
        for (let i=1; i<rows.length; i++) {
            diseases += rows[i].cells[2].innerHTML+',';
        }

        var info = {
            diseaseInfo: diseases,
            name: $("#name").val(),
            regId: $("#regId").val(),
            selfComplaint: $("#selfComplaint").val(),
            currentHistory: $("#currentHistory").val(),
            currentStatus: $("#currentStatus").val(),
            pastHistory: $("#pastHistory").val(),
            allergyHistory: $("#allergyHistory").val(),
            bodyCheck: $("#bodyCheck").val()
        }

        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/DocPostInfo",
            dataType: "json",
            data: info
        })


        var
            before = document.getElementById("patientNotDiagnose").rows,
            after = document.getElementById("patientDiagnose").rows,
            dica = document.getElementById("diseaseDetail").rows;

        for (let i=before.length-1; i>0; i--) {
            before[i].remove();
        }
        for (let i=after.length-1; i>0; i--) {
            after[i].remove();
        }
        for (let i=dica.length-1; i>0; i--) {
            dica[i].remove();
        }

    })
</script>


<script>
    $("#reset").click(function () {
        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/DocGetPatient",
            dataType: "json",
            data: {docName: "${userName}"},
            success: function (msg) {
                var row = Number(0);

                for (let i = 0; i < msg.length; i++) {
                    console.log(msg[i].regStatus);

                    if (msg[i].regStatus === 1) {
                        // 插入未诊列表元素
                        $('#RegRecord_fore').append(
                            '<tr onclick="choosePatient(this)">' +
                            '<td>' + msg[i].id + '</td>' +
                            '<td>' + msg[i].patientName + '</td>' +
                            '<td>' + msg[i].patientGender + '</td>' +
                            '<td>' + msg[i].patientAge + '</td>' + '<tr>'
                        )

                        row++;
                    } else if(msg[i].regStatus === 2) {
                        // 插入已诊列表元素
                        $('#RegRecord_after').append(
                            '<tr>' +
                            '<td>' + msg[i].id + '</td>' +
                            '<td>' + msg[i].patientName + '</td>' +
                            '<td>' + msg[i].patientGender + '</td>' +
                            '<td>' + msg[i].patientAge + '</td>' + '<tr>'
                        )
                    }
                }

                if (row === 0) {
                    alert("无未诊患者，不能填写病历！");
                }

            }
        })
    })
</script>

</body>
</html>
