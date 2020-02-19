<%--
  Created by IntelliJ IDEA.
  User: allwayz
  Date: 2020/2/20
  Time: 01:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log</title>
    <script src="asserts/js/jquery-3.4.1.js"></script>
    <script src="https://cdn.bootcss.com/sockjs-client/1.1.4/sockjs.min.js"></script>
    <script src="https://cdn.bootcss.com/stomp.js/2.3.3/stomp.min.js"></script>

</head>
<body>
    <button onclick="openSocket()">开启日志</button>
    <button onclick="closeSocket()">关闭日志</button>
    <div id="log-container" style="height: 450px; overflow-y: scroll; background: #333; color: #aaa; padding: 10px;">
        <div></div>
    </div>
</body>
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

</html>
