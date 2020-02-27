<%--
  Created by IntelliJ IDEA.
  User: allwayz
  Date: 2020/2/27
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transcript</title>
    <link href="asserts/css/bootstrap.min.css" rel="stylesheet">
    <link href="asserts/css/myCss.css" rel="stylesheet">

    <script src="asserts/js/jquery-3.4.1.js"></script>
    <script src="asserts/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="../jspTemplates/top.jsp"%>
<div class="container-fluid">
    <div class="row">
        <%@include file="../jspTemplates/StudentSide.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                <h1 class="h2">Transcript</h1>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <div class="btn-group mr-2">
                        <!--TODO finish Share and Export function-->
                        <button class="btn btn-sm btn-outline-secondary" >Share</button>
                        <button class="btn btn-sm btn-outline-secondary">Export</button>
                    </div>
                </div>
            </div>
            <div class="card-columns">
                <c:forEach items="${sessionScope.TranscriptList}" var="transcriptList">
                    <div class="card mb-3 element-animation" style="max-width: 540px;">
                        <div class="row no-gutters">
                            <div class="col-md-4">
                                <img src="asserts/img/1.png" class="card-img" alt="">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body element-animation">
                                    <h5 class="card-title">Major ID:  <span>${transcriptList.getMajorId()}</span></h5>
                                    <p class="card-text">Semester Year:  <span>${transcriptList.getMark()}</span></p>
                                    <p class="card-text"><small class="text-muted">${transcriptList.getUpdateTime()}</small></p>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer bg-transparent border-success">${transcriptList.getCreateTime()}</div>
                    </div>
                </c:forEach>
            </div>
        </main>
    </div>
</div>
</body>
</html>