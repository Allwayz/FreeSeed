<%@ page import="com.allwayz.freeseed.model.entity.NationalDtl" %><%--
    Document   : Sign_Up
    Created on : 2050-2-14, 18:26:30
    Author     : Allwayz
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Sign_Up</title>
    <meta charset="UTF-8">
    <!-- Bootstrap core CSS -->
    <link href="asserts/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="asserts/css/signin.css" rel="stylesheet">

    <link rel="stylesheet" href="asserts/location/style.css">

    <script src="asserts/js/jquery-3.4.1.js"></script>

    <script>
        $(document).ready(function () {
            $.ajax({
                type:"GET",
                url:"locationSelect",
                dataType: "json",
                success: function (data) {
                    var str ="<div><select>"
                    for(i=0;i<data.length;i++){
                        str +="<option value='"+data[i].nationalDtlName+"'>"+data[i].nationalDtlName+"</option>";
                    }
                    str +="</select></div>"
                    $("#nation").html(str)
                }
            });
            $.ajax({
                type:"GET",
                url:"roleLoad",
                dataType: "json",
                success: function (data) {
                    var str ="<div><select>"
                    for(i=0;i<data.length;i++){
                        str +="<option value='"+data[i].roleDesc+"'>"+data[i].roleDesc+"</option>";
                    }
                    str +="</select></div>"
                    $("#roleDescComboBox").html(str)
                }
            })
        })

        function showProvince(nationInput) {
            $.ajax({
                type: "GET",
                url: "showProvince?national="+nationInput,
                dataType: "json",
                success: function (data) {
                    var str ="<div><select>"
                    for(i=0;i<data.length;i++){
                        str +="<option value='"+data[i].provinceDtlName+"'>"+data[i].provinceDtlName+"</option>";
                    }
                    str +="</select></div>"
                    $("#province").html(str);
                }
            });
        }

        function showCity(provinceInput) {
            $.ajax({
                type: "GET",
                url: "showCity?province="+provinceInput,
                dataType: "json",
                success: function (data) {
                    var str ="<div><select>"
                    for(i=0;i<data.length;i++){
                        str +="<option value='"+data[i].cityDtlName+"'>"+data[i].cityDtlName+"</option>";
                    }
                    str +="</select></div>"
                    $("#city").html(str);
                }
            });
        }

        function sendAuCode() {
            var a = $("#email").val();
            $.ajax({
                type: "GET",
                url: "sendAuCode?email="+a,
                dataType: "json",
                success: function (data) {
                    alert("Send")
                }
            });
        }

        function Sign_UpFunction() {
            var email = $("#email").val();
            var password = $("#password").val();
            var role = $("#roleDescComboBox").val();
            $.ajax({
               type: "POST",
               url: "addUser?email="+email+"&password="+password+"&role="+role,
                dataType: "json",
                success: function (data) {
                    alert(data)
                }
            });
        }

    </script>
</head>

<body class="text-center" style="background-image: url('asserts/img/background.png');background-repeat: no-repeat;
background-attachment: fixed; background-size: cover">
<div>
    <div>
        <img class="mb-4" src="asserts/img/FreeSeed.png" alt="" width="500" style="margin-top: 300px">
    </div>
    <div>
        <form class="form-signin" action="">
            <h1 class="h3 mb-3 font-weight-normal">Sign Up Right Now!</h1>
            <!--Email Validation-->
            <form id="validate">
                <!--Email-->
                <input type="text" class="form-control" id="email" placeholder="Email" required="" autofocus="">
                <div>
                    <input class="form-control" style="width: auto;display: inline" type="text"placeholder="Authorization Code" name="AuCode">
                    <input class="btn btn-lg btn-primary btn-block" style="display: inline;width: 90px" id="getCode" name="getCode" type="button" value="Send"  autocomplete ="off" onclick="sendAuCode()"/>
                </div>
            </form>
            <!--Password-->
            <input type="password" class="form-control" placeholder="Password" required="" id="password">

            <!--Role-->
            <select id="roleDescComboBox" class="form-control" style="display: inline">

            </select>
            <br><br>

            <div>
                <fieldset>
                    <legend>Detail</legend>
                    <div>
                        <select id="nation" onchange="showProvince(this.options[this.options.selectedIndex].value)">
                            <option id="nationDtl">
                                Nation
                            </option>
                        </select>

                        <select id="province" onchange="showCity(this.options[this.options.selectedIndex].value)">
                            <option>
                                Province
                            </option>
                        </select>

                        <select id="city">
                            <option>
                                City
                            </option>
                        </select>
                    </div>
                    <br>
                    <div>
                        <input type="text" class="form-control" placeholder="Address" required="" autofocus="">
                    </div>
                </fieldset>
            </div>
            <br>
            <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="Sign_UpFunction()">Sign Up</button>
            <a href="/index" ><h6>Already Have Acount</h6></a>
            <p class="mt-5 mb-3 text-muted">© 1999 - ∞</p>

            <!--TODO 国际化-->
            <a class="btn btn-sm" >中文</a>
            <a class="btn btn-sm">English</a>
        </form>
    </div>
</div>
</body>

</html>