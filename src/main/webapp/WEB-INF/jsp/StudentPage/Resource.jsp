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
                        <!--TODO finish Share and Export function-->
                        <button class="btn btn-sm btn-outline-secondary" >Share</button>
                        <button class="btn btn-sm btn-outline-secondary">Export</button>
                    </div>
                </div>
            </div>
            <div class="card-columns">
                <c:forEach items="${sessionScope.MajorDtlList}" var="majorDtlList">
                <div class="card mb-3 element-animation" style="max-width: 540px;">
                    <div class="row no-gutters">
                        <div class="col-md-4">
                            <img src="asserts/img/${majorDtlList.getMajorId()}.png" class="card-img" alt="">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body element-animation">
                                <h5 class="card-title">Major ID:  <span>${majorDtlList.getMajorId()}</span></h5>
                                <p class="card-text">Semester Year:  <span>${majorDtlList.getSemesterYear()}</span></p>
                                <p class="card-text">Semester:  <span>${majorDtlList.getSemester()}</span></p>
                                <p class="card-text">Class ID:  <span>${majorDtlList.getClassroomId()}</span></p>
                                <p class="card-text"><small class="text-muted">${majorDtlList.getUpdateTime()}</small></p>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer bg-transparent border-success">${majorDtlList.getCreateTime()}</div>
                </div>
            </c:forEach>
            </div>
        </main>
    </div>
</div>
</body>
</html>
