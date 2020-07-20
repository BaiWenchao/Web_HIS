<%--
  Created by IntelliJ IDEA.
  User: 20241
  Date: 2020/7/17
  Time: 8:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>挂号</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Main css -->
    <link rel="stylesheet" href="css_js/regist/css/style.css">

    <!-- JS -->
    <script src="css_js/regist/js/jquery.min.js"></script>
    <script src="css_js/regist/js/main.js"></script>
</head>
<body>
<div class="main">
    <div class="container">
        <div class="signup-content">
            <div class="signup-form">

                <form method="POST" class="register-form" id="register-form">
                    <h2>挂号信息：</h2>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="name">姓名 :</label>
                            <input type="text" name="name" id="name" required/>
                        </div>
                        <div class="form-group">
                            <label for="age">年龄</label>
                            <input type="text" name="age" id="age" required/>
                        </div>
                        <div class="form-group">
                            <label for="birthday">出生日期</label>
                            <input type="date" name="birthday" id="birthday" required/>
                        </div>
                    </div>


                    <div class="form-radio">
                        <label class="radio-label">性别 :</label>
                        <div class="form-radio-item">
                            <input type="radio" name="gender" id="male" checked>
                            <label for="male">男</label>
                            <span class="check"></span>
                        </div>
                        <div class="form-radio-item">
                            <input type="radio" name="gender" id="female">
                            <label for="female">女</label>
                            <span class="check"></span>
                        </div>
                    </div>


                    <div class="form-row">
                        <div class="form-group">
                            <label for="idNum">身份证号 :</label>
                            <input type="text" name="idNum" id="idNum" required/>
                        </div>
                        <div class="form-group">
                            <label for="address">家庭住址 :</label>
                            <input type="text" name="address" id="address"/>
                        </div>
                    </div>


                    <div class="form-row">
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
                        <div class="form-group">
                            <label for="date">看诊日期</label>
                            <input type="date" name="date" id="date" required/>
                        </div>
                        <div class="form-group">
                            <label for="regNoon">午别 :</label>
                            <div class="form-select">
                                <select name="regNoon" id="regNoon">
                                    <option value="morning">上</option>
                                    <option value="afternoon">下</option>
                                </select>
                                <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
                            </div>
                        </div>
                    </div>


                    <div class="form-row">
                        <div class="form-group">
                            <label for="dept">挂号科室 :</label>
                            <div class="form-select">
                                <select name="dept" id="dept">
                                    <option selected="selected"></option>
                                    <option value="blood">心血管内科</option>
                                    <option value="neuron">神经内科</option>
                                </select>
                                <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="regLevel">号别 :</label>
                            <div class="form-select">
                                <select name="regLevel" id="regLevel">
                                    <option selected="selected"></option>
                                    <option value="normal">普通号</option>
                                    <option value="expert">专家号</option>
                                </select>
                                <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="doctor">看诊医生 :</label>
                            <div class="form-select">
                                <select name="doctor" id="doctor" class="test">
                                    <option></option>
                                </select>
                                <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
                            </div>
                        </div>
                    </div>


                    <div class="form-row">
                        <div class="form-group">
                            <label for="regLimit">初诊号额 :</label>
                            <input type="text" name="regLimit" id="regLimit"/>
                        </div>
                        <div class="form-group">
                            <label for="regConsume">已用号额 :</label>
                            <input type="text" name="regConsume" id="regConsume"/>
                        </div>
                    </div>

                    <div class="form-radio">
                        <label class="radio-label">病历本要否 :</label>
                        <div class="form-radio-item">
                            <input type="radio" name="needBook" id="notneed" checked>
                            <label for="notneed">不需要</label>
                            <span class="check"></span>
                        </div>
                        <div class="form-radio-item">
                            <input type="radio" name="needBook" id="need">
                            <label for="need">需要</label>
                            <span class="check"></span>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group">
                            <label for="payAmount">应收金额 :</label>
                            <input type="text" name="payAmount" id="payAmount"/>
                        </div>
                        <div class="form-group">
                            <label for="payType">收费方式 :</label>
                            <div class="form-select">
                                <select name="payType" id="payType">
                                    <option value="wechat">微信</option>
                                    <option value="alipay">支付宝</option>
                                </select>
                                <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
                            </div>
                        </div>
                    </div>

                    <div class="form-submit" id = "submitForm">
                        <input type="reset" value="全部清空" class="submit" name="reset" id="reset" />
                        <input type="button" value="提交表单" class="submit" name="submit" id="submit" />
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>


<%--验证输入合法性：--%>
<script type="text/javascript">
    function validform() {
        return $("#register-form").validate({
            rules: {
                name: {
                    required: true
                },
                age: {
                    required: true,
                    digits: true
                },
                birthday: {
                    required: true
                },
                idNum: {
                    required: true
                },
                date: {
                    required: true
                }
            }
        })
    }
</script>

<script>
    $("#submit").click(function(){
        if(!validform().form()) {
            alert("请完善挂号信息！");
        } else {
            alert("挂号成功！")
        }
    });
</script>


<%--获取老患者的记录--%>
<script>
    $('#name').bind('keypress',function(event){
        if(event.keyCode == 13) {
            var
                name = $("#name").val(),
                age = $("#age"),
                birthday = $("#birthday"),
                male = $("#male"),
                female = $("#female"),
                idNum = $("#idNum"),
                address = $("#address");
           $.ajax({
               type: "get",
               url: "${pageContext.request.contextPath}/RegGetPatientInfo",
               dataType: "json",
               data: {patientName: name},
               success: function (msg) {
                   age.val(msg.age);
                   birthday.val(msg.birthday);
                   idNum.val(msg.idNumber);
                   address.val(msg.address);
                   if(msg.readableGender == "女") {
                       male.removeAttr("checked");
                       female.attr("checked", "checked");
                   } else {
                       female.removeAttr("checked");
                       male.attr("checked", "checked");
                   }
               }
           })
        }
    });
</script>


<%--根据挂号级别收费--%>
<script>
    var
        payAmount = $("#payAmount"),
        submit = $("#submit"),
        regLevel = $("#regLevel");

    payAmount.val(8);

    regLevel.change(function () {

        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/RegFee",
            dataType: "json",
            success: function (msg) {
                var
                    expert = Number(msg[0]),
                    normal = Number(msg[1]),
                    regLevelText = $("#regLevel option:selected").text();
                if(regLevelText === "普通号") {
                    payAmount.val(normal);
                    if(document.getElementById("need").checked) {
                        payAmount.val(normal + 1);
                    }
                } else {
                    payAmount.val(expert);
                    if(document.getElementById("need").checked) {
                        payAmount.val(expert + 1);
                    }
                }
            }
        })
    })
</script>

<%--二级联动：看诊的医生信息--%>
<script>
    $("#regLevel").change(function () {
        // 获取科室和号别
        var
            dept = $("#dept option:selected").text(),
            regLevel = $("#regLevel option:selected").text(),
            doctor = document.getElementById("doctor");

        doctor.options.length=0;

        if (dept === "心血管内科" && regLevel === "普通号") {
            doctor.options.add(new Option());
            doctor.options.add(new Option("张仲景", "zzj"));
            doctor.options.add(new Option("皇甫谧", "hfm"));
        } else if (dept === "心血管内科" && regLevel === "专家号") {
            doctor.options.add(new Option());
            doctor.options.add(new Option("扁鹊", "bq"));
        } else if (dept === "神经内科" && regLevel === "普通号") {
            doctor.options.add(new Option());
            doctor.options.add(new Option("葛洪", "gh"));
            doctor.options.add(new Option("孙思邈", "ssm"));
        } else {
            doctor.options.add(new Option());
            doctor.options.add(new Option("华佗", "ht"));
        }
    })
</script>

<%--获取医生初诊号额以及已用号额--%>
<script>
    $("#doctor").change(function () {
        var doctor = $("#doctor option:selected").text();

        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/RegGetDoctorInfo",
            dataType: "json",
            data: {docName: doctor},
            success: function (msg) {
                // msg[0]: 号额， msg[1]: 已用
                $("#regLimit").val(msg[0]);
                $("#regConsume").val(msg[1]);
            }
        })
    })
</script>

<%--检验病历本：--%>
<script>

    $("#need").change(function () {
        if(document.getElementById("need").checked) {
            var before = Number($("#payAmount").val());
            $("#payAmount").val(before+1);
        }
    })

    $("#notneed").change(function () {
        if(document.getElementById("notneed").checked) {
            var before = Number($("#payAmount").val());
            $("#payAmount").val(before-1);
        }
    })

</script>


<%--提交表单--%>
<script>
    $("#submit").click(function () {
        var regObj = {
            name : $("#name").val(),
            age : $("#age").val(),
            birthday : $("#birthday").val(),
            gender : document.getElementById("male").checked ? 27 : 28,
            idNum : $("#idNum").val(),
            address : $("#address").val(),
            feeType : $("#feeType option:selected").text(),
            date : $("#date").val(),
            regNoon : $("#regNoon option:selected").text(),
            dept : $("#dept option:selected").text(),
            regLevel : $("#regLevel option:selected").text(),
            doctor : $("#doctor option:selected").text(),
            regLimit : $("#regLimit").val(),
            regConsume : $("#regConsume").val(),
            needBook : document.getElementById("need").checked ? 1 : 0,
            payAmount : $("#payAmount").val(),
            payType : $("payType option:selected").text()
        }

        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/RegPostInfo",
            dataType: "json",
            data: regObj
        })

    })
</script>

</body>
</html>
