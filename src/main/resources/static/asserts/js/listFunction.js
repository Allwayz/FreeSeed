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
        url: "list?table=user",
        dataType: "json",
        success: function (data) {

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