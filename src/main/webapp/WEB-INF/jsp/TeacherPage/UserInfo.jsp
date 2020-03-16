<%--
  Created by IntelliJ IDEA.
  User: allwayz
  Date: 2020/3/16
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
    <link href="asserts/css/myCss.css" rel="stylesheet">
    <script src="asserts/js/jquery-3.4.1.js"></script>
    <script>
        function UpdateUser() {
            var id=${sessionScope.User.getUserId()};
            var firstName=$("#firstName").val();
            var lastName=$("#lastName").val();
            var birthday=$("#Birthday").val();
            var telephone=$("#Telephone").val();
            $.ajax({
                type: "POST",
                url: "updateUserDtl?id="+id+"&firstName="+firstName+"&lastName="+lastName+"&Birthday="+birthday+"$Telephone="+telephone,
                //url: "updateUserDtl?id=8&firstName="+firstName+"&lastName="+lastName+"&Birthday="+birthday+"$Telephone="+telephone,
                dataType: "json",
                success: function (data) {
                    window.location.reload();
                }
            });
        }
    </script>
</head>
<body style="background-image: url('asserts/img/background.png')">
<%@ include file="../jspTemplates/top.jsp"%>
<div class="container-fluid">
    <div class="row">
        <%@include file="../jspTemplates/teacherSide.jsp"%>
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
                    <p>First Name:  <input id="firstName" type="text" value="${sessionScope.UserDtl.getFirstName()}"/></p>
                    <p>Last Name:  <input id="lastName" type="text" value="${sessionScope.UserDtl.getLastName()}"/></p>
                    <p>Email:  <input id="email" type="text" value="${sessionScope.User.getUserEmail()}"/></p>
                    <p>Password:  <input id="password" type="password" value="${sessionScope.User.getUserPassword()}"/></p>
                    <p>Birthday:  <input id="Birthday" type="text" value="${sessionScope.UserDtl.getBirthday()}"/></p>
                    <p>Birthday:  <input id="Telephone" type="text" value="${sessionScope.UserDtl.getTelephone()}"/></p>
                    <img src="https://img.icons8.com/cotton/64/000000/settings--v1.png" width="25" height="25"><button onclick="UpdateUser()">Update</button>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>
