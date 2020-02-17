<%--
  Created by IntelliJ IDEA.
  User: allwayz
  Date: 2020/2/17
  Time: 00:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Title</title>
    <script src="asserts/js/jquery-3.4.1.js"></script>

<%--TODO find out the fucking Ajax function!!!!!!!! --%>
    <script>
        $(document).ready(function () {
            $.ajax({
                type:"GET",
                url:"locationSelect",
                dataType: "json",
                success: function (data) {
                    var str ="<div><select>"
                    for(i=0;i<data.length;i++){
                        str +="<option value='"+data[i].nationalDtlName+"'>"+data[i].nationalDtlName+"</option>";
                    }
                    str +="</select></div>"
                    $("#nation").html(str)
                }
            });
        })

        function showProvince(nationInput) {
            $.ajax({
                type: "GET",
                url: "showProvince?national="+nationInput,
                dataType: "json",
                success: function (data) {
                    var str ="<div><select>"
                    for(i=0;i<data.length;i++){
                        str +="<option value='"+data[i].provinceDtlName+"'>"+data[i].provinceDtlName+"</option>";
                    }
                    str +="</select></div>"
                    $("#province").html(str);
                }
            });
        }

        function showCity(provinceInput) {
            $.ajax({
                type: "GET",
                url: "showCity?province="+provinceInput,
                dataType: "json",
                success: function (data) {
                    var str ="<div><select>"
                    for(i=0;i<data.length;i++){
                        str +="<option value='"+data[i].cityDtlName+"'>"+data[i].cityDtlName+"</option>";
                    }
                    str +="</select></div>"
                    $("#city").html(str);
                }
            });
        }
    </script>
</head>
<body>
<button id="showData">aaaa</button>
<div id="a">
    <select id="nation" onchange="showProvince(this.options[this.options.selectedIndex].value)">
        <option id="nationDtl">
            Nation
        </option>
    </select>

    <select id="province" onchange="showCity(this.options[this.options.selectedIndex].value)">
        <option>
            Province
        </option>
    </select>

    <select id="city">
        <option>
            City
        </option>
    </select>

</div>
</body>


</html>
