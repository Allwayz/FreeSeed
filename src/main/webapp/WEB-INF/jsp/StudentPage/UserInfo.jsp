<%--
  Created by IntelliJ IDEA.
  User: allwayz
  Date: 2020/2/24
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
    <link href="asserts/css/myCss.css" rel="stylesheet">
</head>
<body style="background-image: url('asserts/img/background.png')">
<%@ include file="../jspTemplates/top.jsp"%>
<div class="container-fluid">
    <div class="row">
        <%@include file="../jspTemplates/StudentSide.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                <h1 class="h2">Hi ${sessionScope.UserDtl.getFirstName()}</h1>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <div class="btn-group mr-2">
                        <!--TODO finish Share and Export function-->
                        <button class="btn btn-sm btn-outline-secondary" >Share</button>
                        <button class="btn btn-sm btn-outline-secondary">Export</button>
                    </div>
                </div>
            </div>

            <div class="info element-animation">
                <div class="mr-2">
                    <img src="">
                    <p>First Name:  <span>${sessionScope.UserDtl.getFirstName()}</span></p>
                    <p>Last Name:  <span>${sessionScope.UserDtl.getLastName()}</span></p>
                    <p>Email:  <span>${sessionScope.User.getUserEmail()}</span></p>
                    <p>Password:  <span>${sessionScope.User.getUserPassword()}</span></p>
                    <p>Birthday:  <span>${sessionScope.UserDtl.getBirthday()}</span></p>
                </div>
                <div style="padding-right: 0">
                    <%--修改个人信息--%>
                    <a href="">
                        <img src="https://img.icons8.com/cotton/64/000000/settings--v1.png" width="25" height="25">
                    </a>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>
