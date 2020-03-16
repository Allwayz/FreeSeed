<%--
  Created by IntelliJ IDEA.
  User: allwayz
  Date: 2020/2/27
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Major</title>

    <!-- Bootstrap core CSS -->
    <link href="asserts/css/bootstrap.min.css" rel="stylesheet">
    <link href="asserts/css/myCss.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="asserts/css/dashboard.css" rel="stylesheet">
    <script src="asserts/js/jquery-3.4.1.js"></script>
    <script>
        function addEnrollment(majorDtlId) {
            var r = confirm("Confirm to take over this major!");
            if(r) {
                $.ajax({
                    url: "addEnrollment/" + majorDtlId,
                    method: "put",
                    dataType: "json",
                    success: function (data) {
                        //console.log("insert Enrollment Successfully!")
                        alert("Success");
                    }
                })
            }
        }
    </script>
</head>
<body style="background-image: url('asserts/img/background.png')">
<%@ include file="../jspTemplates/top.jsp"%>
<div class="container-fluid">
    <div class="row">
        <%@include file="../jspTemplates/teacherSide.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
                <div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                    <div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div>
                </div>
                <div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                    <div style="position:absolute;width:200%;height:200%;left:0; top:0"></div>
                </div>
            </div>
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                <h1 class="h2">Majors</h1>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <div class="btn-group mr-2">
                        <!--TODO finish Share and Export function-->
                        <button class="btn btn-sm btn-outline-secondary" >Share</button>
                        <button class="btn btn-sm btn-outline-secondary">Export</button>
                    </div>
                    <button class="btn btn-sm btn-outline-secondary dropdown-toggle">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-calendar">
                            <rect x="3" y="4" width="18" height="18" rx="2" ry="2">
                            </rect>
                            <line x1="16" y1="2" x2="16" y2="6">
                            </line>
                            <line x1="8" y1="2" x2="8" y2="6">
                            </line>
                            <line x1="3" y1="10" x2="21" y2="10">
                            </line>
                        </svg>
                        This week
                    </button>
                </div>
            </div>
            <%--Session:"MajorDtlList",majorDtlList--%>
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
                                Takeover
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
