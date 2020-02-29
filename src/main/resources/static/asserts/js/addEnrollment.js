function addEnrollment(majorDtlId) {
    $.ajax({
        url: "addEnrollment?majorDtlId="+majorDtlId,
        dataType: "json",
        success: function (data) {
            console.log("insert Enrollment Successfully!")
            alert("Success");
        }
    })
}