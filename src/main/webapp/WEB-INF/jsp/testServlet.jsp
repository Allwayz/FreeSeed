<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: allwayz
  Date: 2020/2/19
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="asserts/js/jquery-3.4.1.js"></script>
    <script>
        function showRoleTable() {
            $.ajax({
                type:"GET",
                url: "roleList",
                dataType: "json",
                success: function (data) {
                    var str ="<div><table border=\"1\" align=\"center\">\n" +
                        "        <tr>\n" +
                        "            <th>#</th>\n" +
                        "            <th>role</th>\n" +
                        "            <th>Create time</th>\n" +
                        "            <th>Update time</th>\n" +
                        "        </tr>"

                    for(i=0;i<data.length;i++){
                        str +="<tr>\n" +
                            "            <td>"+data[i].roleId+"</td>\n" +
                            "            <td>"+data[i].roleDesc+"</td>\n" +
                            "            <td>"+data[i].createTime+"</td>\n" +
                            "            <td>"+data[i].updateTime+"</td>\n" +
                            "        </tr>";
                    }
                    str +="</table></div>"
                    $("#role_table").html(str)
                }
            })
        }
    </script>
</head>
<body>
    <div id="role_table">

    </div>
    <table>
        <tr>
            <th>#</th>
            <th>role</th>
            <th>Create time</th>
            <th>Update time</th>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <!--循环-->
    </table>


    <button onclick="showRoleTable()">click</button>
</body>
</html>
