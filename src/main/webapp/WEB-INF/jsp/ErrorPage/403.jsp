<%--
  Created by IntelliJ IDEA.
  User: allwayz
  Date: 2020/2/23
  Time: 04:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="ErrorPage">
    <meta name="author" content="allwayz">

    <title>Dashboard Template for Bootstrap</title>
    <!-- Bootstrap core CSS -->
    <link href="../static/asserts/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../static/asserts/css/dashboard.css" rel="stylesheet">
    <style type="text/css">
        /* Chart.js */

        @-webkit-keyframes chartjs-render-animation {
            from {
                opacity: 0.99
            }
            to {
                opacity: 1
            }
        }

        @keyframes chartjs-render-animation {
            from {
                opacity: 0.99
            }
            to {
                opacity: 1
            }
        }

        .chartjs-render-monitor {
            -webkit-animation: chartjs-render-animation 0.001s;
            animation: chartjs-render-animation 0.001s;
        }
    </style>
</head>

<body style="background-image: url('asserts/img/background.png')">
<%@ include file="../jspTemplates/top.jsp"%>
<div class="container-fluid">
    <div class="row">
        <%@ include file="../jspTemplates/Side.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <h1>403  <b>禁止访问：访问被拒绝</b></h1>
            <h3>${url}</h3>
            <h3>${exception.message}</h3>
        </main>
    </div>
</div>
</body>
</html>
