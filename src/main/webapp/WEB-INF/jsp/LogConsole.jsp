<%--
  Created by IntelliJ IDEA.
  User: allwayz
  Date: 2020/2/20
  Time: 01:58
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<!-- saved from url=(0052)http://getbootstrap.com/docs/4.0/examples/dashboard/ -->
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log</title>
    <!-- Bootstrap core CSS -->
    <link href="asserts/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="asserts/css/dashboard.css" rel="stylesheet">
    <script src="asserts/js/jquery-3.4.1.js"></script>

    <script src="asserts/js/listFunction.js"></script>


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
<%@ include file="jspTemplates/top.jsp"%>

<div class="container-fluid">
    <div class="row">
        <%@ include file="jspTemplates/Side.jsp"%>
        <!--TODO get data from database-->
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <div id="log-container" style="height: 450px; overflow-y: scroll; background: #333; color: #aaa; padding: 10px;">
                <div>
                </div>
            </div>
            <button onclick="openSocket()">开启日志</button>
            <button onclick="closeSocket()">关闭日志</button>
        </main>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="asserts/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="asserts/js/popper.min.js"></script>
<script type="text/javascript" src="asserts/js/bootstrap.min.js"></script>

<!-- Icons -->
<script type="text/javascript" src="asserts/js/feather.min.js"></script>
<script>
    feather.replace()
</script>

<!-- Graphs -->
<script type="text/javascript" src="asserts/js/Chart.min.js"></script>
<script>
    var ctx = document.getElementById("myChart");
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
            datasets: [{
                data: [15339, 21345, 18483, 24003, 23489, 24092, 12034],
                lineTension: 0,
                backgroundColor: 'transparent',
                borderColor: '#007bff',
                borderWidth: 4,
                pointBackgroundColor: '#007bff'
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: false
                    }
                }]
            },
            legend: {
                display: false,
            }
        }
    });
</script>

<script>
    var stompClient = null;
    $(document).ready(function() {openSocket();});
    function openSocket() {
        if(stompClient==null){
            var socket = new SockJS('http://localhost:8990/websocket');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                stompClient.subscribe('/topic/pullLogger', function(event) {
                    var content=JSON.parse(event.body);
                    $("#log-container div").append(content.timestamp +" "+ content.level+" --- ["+ content.threadName+"] "+ content.className+"   :"+content.body).append("<br/>");
                    $("#log-container").scrollTop($("#log-container div").height() - $("#log-container").height());
                },{});
            });
        }
    }
    function closeSocket() {
        if (stompClient != null) {
            stompClient.disconnect();
            stompClient=null;
        }
    }
</script>

</body>

</html>