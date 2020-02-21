function showUserDtl(object) {
    alert("111");
}


$(function(table){
    $.ajax({
        type: "GET",
        url: table+"list",
        dataType: "json",
        success: function (data) {
            // TODO Replace default table by database data
            document.getElementById("tableName").innerHTML = table;
        }
    })
})

function userClick() {
    $.ajax({
        type: "GET",
        url: "listPage?table=user",
        dataType: "json",
        success: function (data) {
            var str ="<div class=\"table-responsive\"><table class=\"table table-striped table-sm\" >\n" +
                "        <tr>\n" +
                "            <th>#</th>\n" +
                "            <th>Email</th>\n" +
                "            <th>Update time</th>\n" +
                "            <th>Role</th>\n" +
                "        </tr>";

            for(i=0;i<data.length;i++){
                str +="<tr>\n" +
                    "            <td>"+data[i].userId+"</td>\n" +
                    "            <td>"+data[i].userEmail+"</td>\n" +
                    "            <td>"+data[i].updateTime+"</td>\n" +
                    "            <td>"+data[i].roleId+"</td>\n" +
                    "        </tr>";
            }
            str +="</table></div>";
            $("#publicTable").html(str)
        }
    });
}

function majorClick() {
    $.ajax({
        type: "GET",
        url: "list?table=major",
        dataType: "json",
        success: function (data) {

        }
    });
}

function enrollmentClick() {
    $.ajax({
        type: "GET",
        url: "list?table=enrollment",
        dataType: "json",
        success: function (data) {

        }
    });
}

function reportClick() {
    $.ajax({
        type: "GET",
        url: "list?table=report",
        dataType: "json",
        success: function (data) {

        }
    });
}

function integrationsClick() {
    $.ajax({
        type: "GET",
        url: "list?table=integrations",
        dataType: "json",
        success: function (data) {

        }
    });
}