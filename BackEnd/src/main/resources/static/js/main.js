$(document).ready(function () {
    (function ($) {
        $.fn.serializeFormJSON = function () {

            var o = {};
            var a = this.serializeArray();
            $.each(a, function () {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };
    })(jQuery);
console.log("..........")
    $('#btnSubmit').click(function (event) {
        event.preventDefault();

        let data = JSON.stringify($('#categoryForm').serializeFormJSON());
    console.log(data);
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/api/post',
            data: data,
            contentType: "application/json",
            dataType: "json",
            success: function(employee){
                console.log("success....");
                $("#form-result").append("Success..")
            },
            error: function(error){
                debugger;
                let errorJson = error.responseJSON;

                if(errorJson.errorType == "ValidationError"){
                    let errorList = errorJson.fieldErrors;
                    var errorDiv = "";
                    errorList.forEach(error =>{
                        errorDiv+=error.message;
                    });

                    $("#form-result").append(errorDiv);

                }else{

                }


            }
        });
    });

    });