<%--
  Created by IntelliJ IDEA.
  User: 20241
  Date: 2020/7/17
  Time: 8:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>开药</title>

    <script src="css_js/doc/tabpagecss/bootstrap.js"></script>
    <link rel="stylesheet" href="css_js/doc/tabpagecss/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="css_js/regist/css/style.css">
    <script src="css_js/regist/js/jquery.js" type="text/javascript"></script>
</head>
<body>
<div class="row">
    <div class="ibox-content" style="margin-left: 30px">
        <h7>未诊患者：</h7>
        <div class="table-responsive">
            <table class="table table-hover" id="patientNotDiagnose">
                <thead>
                <tr>
                    <th>挂号ID</th><th>姓名</th><th>性别</th><th>年龄</th>
                </tr>
                </thead>
                <tbody id="before">
                </tbody>
            </table>
        </div><br>
        <h7>已诊患者：</h7>
        <div class="table-responsive">
            <table class="table table-hover" id="patientDiagnose">
                <thead>
                <tr>
                    <th>挂号ID</th><th>姓名</th><th>性别</th><th>年龄</th>
                </tr>
                </thead>
                <tbody id="after">
                </tbody>
            </table>
        </div>
    </div>

    <div class="ibox-content" style="margin-left: 50px">

        <div class="row">
            <div class="form-group" style="margin-left: 50px">
                <label>患者挂号ID：</label>
            </div>
            <div class="form-group">
                <label id="patientRegId"></label>
            </div>
            <div class="form-group" style="margin-left: 50px">
                <label>患者姓名：</label>
            </div>
            <div class="form-group">
                <label id="patientName"></label>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label for="searchPrescription">模板检索 :</label>
                <input type="text" name="searchPrescription" id="searchPrescription" style="width: 200px" required/>
            </div>
            <div class="form-group">
                <br>
                <input type="button" value="添加模板" class="submit" name="add" id="add" style="width: 100px"/>
                <input type="button" value="删除模板" class="submit" name="delete" id="delete" style="width: 100px"/>
                <input type="button" value="确认使用" class="submit" name="confirm" id="confirm" style="width: 100px"/>
            </div>
        </div>

        <div class="row">
            <div class="ibox-content" style="margin-left: 20px" id="prescrTable">
                <h7>模板预览：</h7>
                <div class="table-responsive">
                    <table class="table table-hover" id="prescList">
                        <thead>
                        <tr>
                            <th><input type="checkbox" name="selectAll" style="width: 30px"></th>
                            <th>模板ID</th>
                            <th>模板名称</th>
                            <th>使用范围</th>
                        </tr>
                        </thead>
                        <tbody id="template">
                        </tbody>
                    </table>
                </div>
            </div>

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
                        <tbody id="prescriptionDetail">
                        </tbody>
                    </table>
                </div>
            </div>
        </div><br><br>

        <h7>药品预览：</h7>
        <div class="table-responsive">
            <table class="table table-hover" id="drugList">
                <thead>
                <tr>
                    <th>药品名称</th><th>规格</th><th>单价</th><th>用法</th>
                    <th>用量</th><th>频次</th><th>数量</th>
                </tr>
                </thead>
                <tbody id="drugShow">

                </tbody>
            </table>
        </div><br>

        <div class="form-submit">
            <input type="button" value="提交表单" class="submit" name="submit" id="submit"/>
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


<%--导入表单--%>
<script>
    // 导入患者列表
    $.ajax({
        type: "get",
        url: "${pageContext.request.contextPath}/DocGetPatient",
        dataType: "json",
        data: {docName: "${userName}"},
        success: function (msg) {
            for (let i = 0; i < msg.length; i++) {
                console.log(msg[i].regStatus);

                if (msg[i].regStatus === 1) {
                    // 插入未诊列表元素
                    $('#before').append(
                        '<tr>' +
                        '<td>' + msg[i].id + '</td>' +
                        '<td>' + msg[i].patientName + '</td>' +
                        '<td>' + msg[i].patientGender + '</td>' +
                        '<td>' + msg[i].patientAge + '</td>' + '<tr>'
                    )
                } else if(msg[i].regStatus === 2) {
                    // 插入已诊列表元素
                    $('#after').append(
                        '<tr onclick="showDetail(this)">' +
                        '<td>' + msg[i].id + '</td>' +
                        '<td>' + msg[i].patientName + '</td>' +
                        '<td>' + msg[i].patientGender + '</td>' +
                        '<td>' + msg[i].patientAge + '</td>' + '<tr>'
                    )
                }
            }
        }
    })
</script>


<%--导入选择的模板--%>
<script>
    $("#add").click(function () {
        var tName = $("#searchPrescription").val();
        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/DrugGetTemplate",
            dataType: "json",
            data: {templateName: tName},
            success: function (msg) {
                if(msg != null) {
                    // 插入药品列表：
                    $('#template').append(
                        '<tr onclick="showTemplate(this)">' +
                        '<td>' + '<input type="checkbox" name="choice" style="width: 30px">' + '</td>' +
                        '<td>' + msg.id + '</td>' +
                        '<td>' + msg.templateName + '</td>' +
                        '<td>' + msg.useRange + '</td>' + '</tr>'
                    )
                } else {
                    alert("请输入正确的模板名称！")
                }
            }
        })
    })
</script>


<%--处理患者表的点击事件--%>
<script>
    function showDetail(tr) {
        document.getElementById('patientRegId').innerHTML = tr.cells[0].innerHTML;
        document.getElementById('patientName').innerHTML = tr.cells[1].innerHTML;
    }
</script>

<%-- 处理模板预览表点击事件--%>
<script>
    function showTemplate(tr) {
        var tId = tr.cells[1].innerHTML;
        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/DrugGetDetail",
            dataType: "json",
            data: {templateId: tId},
            success: function (msg) {
                var rows = document.getElementById("prescDetail").rows;

                for (let i=rows.length-1; i>0; i--) {
                    rows[i].remove();
                }

                for (let i = 0; i < msg.length; i++) {
                    $('#prescriptionDetail').append(
                        '<tr>' +
                        '<td>' + msg[i].drugName + '</td>' +
                        '<td>' + msg[i].drugFormat + '</td>' +
                        '<td>' + msg[i].drugPrice + '</td>' +
                        '<td>' + msg[i].drugUsage + '</td>' +
                        '<td>' + msg[i].drugDosage + '</td>' +
                        '<td>' + msg[i].drugFrequency + '</td>' +
                        '<td>' + msg[i].drugAmount + '</td>' +'<tr>'
                    )
                }
            }
        })
    }
</script>

<%--模板删除操作：--%>
<script>
    $("#delete").click(function () {
        $("input[type='checkbox']").each(function () {
            if($(this).prop("checked")) {
                $(this).closest('tr').remove();
            }
        })
    })
</script>

<%--点击确认后将将模板药品发送到最终的药品预览区--%>
<script>
    $("#confirm").click(function () {
        var rows = document.getElementById("template").rows;
        var goalRows = document.getElementById("drugShow").rows;

        if (goalRows.length > 0) {
            for (let i=goalRows.length; i>0; i--) {
                goalRows[i].remove();
            }
        }

        for (let i=0; i<rows.length; i++) {
            var tmp = rows[i].cells[1].innerHTML;
            $.ajax({
                type: "get",
                url: "${pageContext.request.contextPath}/DrugGetDetail",
                dataType: "json",
                data: {templateId: tmp},
                success: function (msg) {

                    for (let i = 0; i < msg.length; i++) {
                        $('#drugShow').append(
                            '<tr>' +
                            '<td>' + msg[i].drugName + '</td>' +
                            '<td>' + msg[i].drugFormat + '</td>' +
                            '<td>' + msg[i].drugPrice + '</td>' +
                            '<td>' + msg[i].drugUsage + '</td>' +
                            '<td>' + msg[i].drugDosage + '</td>' +
                            '<td>' + msg[i].drugFrequency + '</td>' +
                            '<td>' + msg[i].drugAmount + '</td>' +'<tr>'
                        )
                    }
                }
            })
        }
    })
</script>


<%--传输表格内容：--%>
<script>
    $("#submit").click(function () {
        // 获取模板ID
        var rows = document.getElementById("template").rows;
        var str = '';
        for (let i=0; i<rows.length; i++) {
            str += rows[i].cells[1].innerHTML + ','
        }
        var regId = $("#patientRegId").html().trim();
        var name = $("#patientName").html().trim();

        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/DrugPostInfo",
            dataType: "json",
            data: {info: str,
                    patientRegId: regId,
                    patientName: name}
        })

        // 清空列表：
        var patientTable = document.getElementById("patientDiagnose").rows;
        var prescriptionTable = document.getElementById("prescriptionDetail").rows;
        var tempTable = document.getElementById("template").rows;
        var drugTable = document.getElementById("drugShow").rows;
        patientTable[1].remove();

        for (let i=prescriptionTable.length-1; i>=0; i--) {
            prescriptionTable[i].remove();
        }
        for (let i=tempTable.length-1; i>=0; i--) {
            tempTable[i].remove();
        }
        for (let i=drugTable.length-1; i>=0; i--) {
            drugTable[i].remove();
        }


        alert("开方成功！")

    })
</script>

</body>
</html>
