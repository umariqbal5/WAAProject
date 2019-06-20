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

    console.log('loaded upload.js')
    //Redirect to login page if not LogedIn
    let token = localStorage.getItem("token");
    if(!token)
        window.location.replace("../../login.html");


    // $('#studentIDSelect').select2({
    //     $.ajax("http://localhost:8080/api/retreat").done(function (response){
    //
    //         console.log('response',response);
    //
    //     });
    //
    // });
    //Date picker
    $('#datepicker').datepicker({
        autoclose: true
    });

    $('#download').click(function () {
        $('#studenIDGroup').removeClass("has-error");
        $('#studenIDError').hide();

        let sid = $("#studentID").val();
        console.log(sid);
        if (sid == null || sid.length < 1) {
            $('#studenIDGroup').addClass("has-error");
            $('#studenIDError').html("Student ID can't be empty");
            $('#studenIDError').show();
            return;
        }
        window.open('http://localhost:8080/api/export/retreat?stu_id=' + sid)
    });
    $('#save-button').click(function () {
        $('#studenIDGroup').removeClass("has-error");
        $('#studenIDError').hide();
        $('#dateGroup').removeClass("has-error");
        $('#dateError').hide();
        let data = JSON.stringify($("#retreatForm").serializeObject());

        let sid = $("#studentID").val();
        if (sid == null || sid.length < 1) {
            $('#studenIDGroup').addClass("has-error");
            $('#studenIDError').html("Student ID can't be empty");
            $('#studenIDError').show();
            return;
        }
        let date = $("#datepicker").val();
        if (date == null || date.length < 1) {
            $('#dateGroup').addClass("has-error");
            $('#dateError').html("Date can't be empty");
            $('#dateError').show();
            return;
        }

        $.ajax("http://localhost:8080/api/retreat", {
            "type": "post",
            "contentType":"application/json",
            "data": data
        }).done(function (response){
            console.log(response);
            let str = '';//'<tr><th style="width: 10%">#</th><th>Data</th></tr>';
            $.each(response, function (index, retreat) {
                console.log(retreat);
                str += '<tr><td>' + retreat.id + '</td>' + '<td>' + retreat.date + '</td> </tr>';
            })
            $("tr[id!='tableTitle']").remove();
            $(".data-table").append(str);
        }).always(function() {
        });

    });
});