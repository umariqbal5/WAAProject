
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
    });
});