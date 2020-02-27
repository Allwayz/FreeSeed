<%--
  Created by IntelliJ IDEA.
  User: allwayz
  Date: 2020/2/21
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>WorkOrder</title>
    <!-- Bootstrap core CSS -->
    <link href="asserts/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="asserts/css/dashboard.css" rel="stylesheet">

    <!--MarkDown Plug-->
    <link href="asserts/js/plugins/editormd/css/editormd.css" rel="stylesheet">
    <script src="asserts/js/plugins/editormd/js/jquery.min.js"></script>
    <script src="asserts/js/plugins/editormd/js/editormd.js"></script>
</head>
<body style="background-image: url('asserts/img/background.png')">
<%@ include file="../jspTemplates/top.jsp"%>
<div class="container-fluid">
    <div class="row">
        <%@ include file="../jspTemplates/StudentSide.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <div id="test-editormd">
                <textarea style="display:none;"  class="form-control" id="content-editormd-markdown-doc" name="content-editormd-markdown-doc"></textarea>
            </div>
        </main>
    </div>
</div>

    <script type="text/javascript">
        $(function() {
            var editor = editormd("test-editormd", {
                width  : "90%",
                height : 720,
                theme : "dark",
                path    : "asserts/js/plugins/editormd/lib/",
                saveHTMLToTextarea : true, // 保存 HTML 到 Textarea
                toolbarAutoFixed:true,//工具栏自动固定定位的开启与禁用
            });
        });
    </script>
</body>

</html>
