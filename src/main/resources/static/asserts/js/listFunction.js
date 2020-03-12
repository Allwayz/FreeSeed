function showUserDtl(object) {
    alert("111");
};

$(".detailText").onclick(function a() {
    var name = $(this).html;
    confirm(name);
});


function majorDetailClick(dataInput) {
    $.ajax({
        url: "checkMajorDtl?input="+$(dataInput).html(),
        dataType: "json",
        success: function (data) {
            if(data[0] == null){
                alert("No such user's detail");
            }else {
                var str
                // TODO Fix bug that data cannot be traversed
                for(i = 0;i<data.length;i++){
                    str = "Major: "+data[i].majorId+"\n"+
                        "Semester Year: "+data[i].semesterYear+"\n"+
                        "Semester: "+data[i].semester+"\n"+
                        "Classroom: "+data[i].classroomId+"\n"+
                        "====================================="
                    +"\n\n";
                }
                alert(str);
            }
        }
    })
};

// $(".addMajorDtlConm").onclick(function addMajorDtl() {
//     var r = confirm("Confirm to add a Major Dtl")
//     //TODO: can not run here
//     if(r==true){
//         // $.ajax({
//         //     url: "addMajorDtl?year="+year+"&semester="+semester+"&classroom=1&majorId="+majorId,
//         //     dataType: "json",
//         //     success: function (data) {
//         //         alert(data)
//         //     }
//         // })
//         document.write("You pressed OK!")
//     }
//
// });


// 已弃用
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
            alert(str);
            $("#publicTable").html(str)
        },error: function (data) {

        }
    });
};

function majorClick() {
    $.ajax({
        type: "GET",
        url: "list?table=major",
        dataType: "json",
        success: function (data) {

        }
    });
};

function enrollmentClick() {
    $.ajax({
        type: "GET",
        url: "list?table=enrollment",
        dataType: "json",
        success: function (data) {

        }
    });
};

function reportClick() {
    $.ajax({
        type: "GET",
        url: "list?table=report",
        dataType: "json",
        success: function (data) {

        }
    });
};

