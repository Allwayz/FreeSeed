function sendCode(){
    window.location="/"
}

$(function () {
    $("#getCode").removeAttr("disabled");
    $("#getCode").click(function(){

        $.ajax({
            url: "src/main/java/com/allwayz/freeseed/JSPController/SignUpController.java",
            data:{
                "email":$(#email).nodeValue
            },
            type:"post",
            async:true,
            success:function (data) {
                if(data==true){
                alert("Email is Sended...");
                }else{
                    alert("Send File");
                }
            }
        })

    })

})