
$(document).ready(function(){
    console.log('loaded')
    //form submit
    $("form").submit(function(event){
        event.preventDefault();
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

            // $.ajaxSetup({
            //     headers:{
            //         'Authorization': localStorage.getItem("Bearer "+'token')
            //     }
            // })

        }).always(function() {
        });

    });



    $('#btnGet').click(function () {
        $.ajax("http://localhost:8080/users").done(function (response){

            console.log('response',response);

        }).fail(function(err){
            console.log(err);
        }).always(function() {
        });
    });
});

