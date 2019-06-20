
$(document).ready(function(){
    console.log('loaded auth.js')

    //Set User Name
    if(localStorage.getItem("user")){
        $("#username").text(localStorage.getItem("user"))

        let roles = localStorage.getItem("roles");
        console.log(roles)
        if(!roles.includes("ROLE_ADMIN")){
            //Hide Admin Menu
            $(".link_admin").addClass('hidden')
        }
    }


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
            console.log(response)
            localStorage.setItem('token',response.token);
            let tokenJson= parseJwt(response.token);
            if(tokenJson){
                if(response.student)
                    localStorage.setItem("student", JSON.stringify(response.student));
                localStorage.setItem("user", tokenJson.sub);
                localStorage.setItem("roles", tokenJson.roles);
            }
            //Redirect to Next Page
            window.location.replace("attendance_report.html");

        }).fail(function (xhr, status, error) {
            console.log(xhr.responseText);
          $("#error").text("");
            $("#error").text("Username or password not found.");
        }).always(function() {
        });

    });

    $("#logout").click(function () {
        localStorage.removeItem("token");
        localStorage.removeItem("student");
        localStorage.removeItem("user");
        localStorage.removeItem("roles");
        //Redirect to Login
        window.location.replace("/FrontEnd/login.html");
    });

    function parseJwt (token) {
        var base64Url = token.split('.')[1];
        var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
        var jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
            return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
        }).join(''));

        return JSON.parse(jsonPayload);
    };

});

