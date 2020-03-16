<%--
  Created by IntelliJ IDEA.
  User: allwayz
  Date: 2020/2/25
  Time: 00:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
    <link href="asserts/css/bootstrap.min.css" rel="stylesheet">
    <link href="asserts/css/myCss.css" rel="stylesheet">

    <script src="asserts/js/jquery-3.4.1.js"></script>
    <script src="asserts/js/bootstrap.min.js"></script>
<%--    <script src="asserts/js/addEnrollment.js"></script>--%>
    <script>
        function addEnrollment(majorDtlId) {
            $.ajax({
                url: "addEnrollment/"+majorDtlId,
                method: "put",
                dataType: "json",
                success: function (data) {
                    //console.log("insert Enrollment Successfully!")
                    alert("Success");
                }
            })
        }
    </script>
</head>
<body style="background-image: url('asserts/img/background.png')">
<%@ include file="../jspTemplates/top.jsp"%>
<div class="container-fluid">
    <div class="row">
        <%@include file="../jspTemplates/StudentSide.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                <h1 class="h2">Major Resource</h1>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <div class="btn-group mr-2">
                        <button class="btn btn-sm btn-outline-secondary" onclick="location.reload()">
                            <img src="https://img.icons8.com/officel/16/000000/available-updates.png" width="30"/>
                            Refresh
                        </button>
                    </div>
                </div>
            </div>
            <h2><b>My Majors</b></h2>
            <div class="card-columns">
                <c:forEach items="${sessionScope.MyMajor}" var="myMajor">
                    <div class="card mb-3 element-animation" style="max-width: 540px;">
                        <div class="row no-gutters">
                            <div class="col-md-4">
                                <img src="asserts/img/2.png" class="card-img" alt="">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body element-animation">
                                    <h5 class="card-title"><span>${myMajor.get("major_Name")}</span></h5>
                                    <p class="card-text">Semester Year:  <span>${myMajor.get("semesterYear")}</span></p>
                                    <p class="card-text">Semester:  <span>${myMajor.get("semester")}</span></p>
                                    <p class="card-text">Classroom:  <span>${myMajor.get("classroom")}</span></p>
                                    <p class="card-text"><small class="text-muted">${myMajor.get("createTime")}</small></p>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer bg-transparent border-success">
                            <span>${myMajor.get("createTime")}</span>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <hr>
            <h2><b>All Majors</b></h2>
            <div class="card-columns">
                <c:forEach items="${sessionScope.mapList}" var="mapList">
                <div class="card mb-3 element-animation" style="max-width: 540px;">
                        <div class="row no-gutters">
                            <div class="col-md-4">
                                <img src="asserts/img/1.png" class="card-img" alt="">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body element-animation">
                                    <h5 class="card-title">Major Name:  <span>${mapList.get("major_Name")}</span></h5>
                                    <p class="card-text">Semester Year:  <span>${mapList.get("semesterYear")}</span></p>
                                    <p class="card-text">Semester:  <span>${mapList.get("semester")}</span></p>
                                    <p class="card-text">Classroom:  <span>${mapList.get("classroom")}</span></p>
                                    <p class="card-text"><small class="text-muted">${mapList.get("createTime")}</small></p>
                                </div>
                            </div>
                    </div>
                    <div class="card-footer bg-transparent border-success">
                        <span>${mapList.get("createTime")}</span>
                        <button type="button" class="btn btn-default btn-success" style="float: right" onclick="addEnrollment(${mapList.get("majorDtlId")})">
                            Enroll Me
                        </button>
                    </div>
                </div>
            </c:forEach>
            </div>
        </main>
    </div>
</div>
</body>
</html>
