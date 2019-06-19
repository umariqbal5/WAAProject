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
    $('#datepicker').datepicker({
        autoclose: true
    });
    $('input').iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green'
    });
    $('#save-button').click(function () {
        let data = JSON.stringify($("#checkingForm").serializeObject());
        console.log(data);
        $.ajax("http://localhost:8080/api/checking", {
            "type": "post",
            "contentType":"application/json",
            "data": data
        }).done(function (response){
            console.log(response);
            let str = '';//'<tr><th style="width: 10%">#</th><th>Data</th></tr>';
            $.each(response, function (index, checking) {
                console.log(checking);
                str += '<tr><td>' + checking.id + '</td><td>' + checking.date + '</td>';
                if (checking.groupBool) {
                    str += '<td><span class="label label-success">Yes</span></td>';
                } else {
                    str += '<td><span class="label label-default">No</span></td>';
                }
                str += ' </tr>';
            })
            $("tr[id!='tableTitle']").remove();
            $(".data-table").append(str);
        }).always(function() {
        });
    });
});