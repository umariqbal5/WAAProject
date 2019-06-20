
$(document).ready(function(){
    console.log('loaded auth.js')
    //form submit
    $("form").submit(function(event){
        event.preventDefault();
        $("#error").text("");


        var _email      = $('#username').val();
        var _password   = $('#password').val();


        var data = JSON.stringify(
            {
                username : _email,
                password : _password
            });


        $.ajax("http://localhost:8080/auth/signin", {
            "type": "post",
            "contentType":"application/json",
            "data": data
        }).done(function (response){

            localStorage.setItem('token',response.token);
            console.log('token',response.token);

            //Redirect to Next Page
            window.location.replace("upLoadFile.html");


        }).fail(function (xhr, status, error) {
            console.log(xhr.responseText);
          $("#error").text("");
            $("#error").text("Username or password not found.");
        }).always(function() {
        });

    });

    $("#logout").click(function () {
        localStorage.removeItem("token");
        //Redirect to Login
        window.location.replace("login.html");
    });



    // $('#btnGet').click(function () {
    //     $.ajax("http://localhost:8080/api/users").done(function (response){
    //         console.log('response',response);
    //     }).fail(function(err){
    //         console.log(err);
    //     }).always(function() {
    //     });
    // });
});

