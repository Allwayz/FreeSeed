<%--
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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<body class="text-center" style="background-image: url('asserts/img/background.png');background-repeat: no-repeat;
background-attachment: fixed; background-size: cover">
<div>
    <div>
        <img class="mb-4" src="asserts/img/FreeSeed.png" alt="" width="500" style="margin-top: 300px">
    </div>
    <div>
        <form class="form-signin" action="dashboard">
            <h1 class="h3 mb-3 font-weight-normal">Sign Up Right Now!</h1>
            <!--Email Validation-->
            <form id="validate" action="sendAuCode" method="get">
                <!--Email-->
                <input type="text" class="form-control" id="email" placeholder="Email" required="" autofocus="">
                <div>
                    <input class="form-control" style="width: auto;display: inline" type="text"placeholder="Authorization Code" name="AuCode">
                    <input class="btn btn-lg btn-primary btn-block" style="display: inline;width: 90px" id="getCode" name="getCode" type="button" value="Send"  autocomplete ="off"/>
                </div>
            </form>
            <!--Password-->
            <input type="password" class="form-control" placeholder="Password" required="">
            <!--Role-->
            <select id="Role_Desc_ComboBox" class="form-control" style="display: inline">
                <option value ="student">student</option>
                <option value="staff">staff</option>
                <option value="security">security</option>
                <option value ="lecturer">lecturer</option>
                <option value ="Public_Relation">Public_Relation</option>
                <option value ="admin">admin</option>
            </select>
            <br><br>

            <div>
                <fieldset>
                    <legend>Detail</legend>
                    <div>
                        <label for="addr-show">您选择的是：
                            <input type="text" value="" id="addr-show">
                        </label>
                        <br/>

                        <!--省份选择-->
                        <select id="prov" onchange="showCity(this)">
                            <option>=请选择省份=</option>

                        </select>

                        <!--城市选择-->
                        <select id="city" onchange="showCountry(this)">
                            <option>=请选择城市=</option>
                        </select>

                        <!--县区选择-->
                        <select id="country" onchange="selecCountry(this)">
                            <option>=请选择县区=</option>
                        </select>
                    </div>
                    <br>
                    <div>
                        <input type="text" class="form-control" placeholder="Address" required="" autofocus="">
                    </div>
                </fieldset>
            </div>
            <br>
            <button class="btn btn-lg btn-primary btn-block" type="submit" >Sign Up</button>
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