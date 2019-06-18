$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
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
$(document).ready(function() {
    "use strict"
    $('.select2').select2();
    //Date picker
    $('#datepicker').datepicker({
        autoclose: true
    });

    $('#save-button').click(function () {
        console.log("click");
        $('#studenIDGroup').addClass("has-error");
        $('#studenIDError').html("Student ID can't be empty");
        $('#studenIDError').show();
        let data = JSON.stringify($("#retreatForm").serializeObject());
        console.log(data);
        $.ajax({
            type: "post",
            url: 'http://localhost:8080/retreat/save',
            data: data,
            contentType: 'application/json',
            dataType: "json",
            success: function (response) {
                console.log('success');
            },
            error: function(errors){
                console.log(errors.responseJSON);
            }
        })
    });
});