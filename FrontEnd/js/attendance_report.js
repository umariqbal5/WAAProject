$(document).ready(function () {

    console.log('loaded attendence_report.js')
    //Redirect to login page if not LogedIn
    let token = localStorage.getItem("token");
    if(!token)
        window.location.replace("login.html");


    var studentIdCur = -1;
    var studentEntryBlockIdCur = -1;

    var studentTotalDaysCount = 0;
    var studentAttendanceDaysCount = 0;

    function getPercent(num, total) {
        num = parseFloat(num);
        total = parseFloat(total);
        if (isNaN(num) || isNaN(total)) {
            return "-";
        }
        return total <= 0 ? "0%" : (Math.round(num / total * 10000) / 100.00)+"%";
    }

    function getMeditations(studentId) {
        // this.alert(studentId);
        $.ajax("http://localhost:8080/api/get/meditations/" + studentId).done(function (response) {
            $('table tbody').empty();
            studentAttendanceDaysCount = response.length;
            $('#totalSessionsAttended').html(studentAttendanceDaysCount);
            $('#totalPercentAttended').html(getPercent(studentAttendanceDaysCount, studentTotalDaysCount));
            for (let i = 0; i < response.length; i++) {
                $('table tbody').append(
                    "<tr>\n" +
                    "  <td>\n" +
                    response[i].date +
                    "  </td>\n" +
                    "</tr>\n"
                );
            }

        }).fail(function (err) {
        }).always(function () {
        });
    }

    function getBlocks(studentEntryBlockIdCur) {
        $.ajax("http://localhost:8080/api/get/blocks/" + studentEntryBlockIdCur).done(function (response) {
            $('#myBlock').empty();
            studentTotalDaysCount = 0;
            for (let i = 0; i < response.length; i++) {
                studentTotalDaysCount += response[i].noOfDays;
                $('#myBlock').append('<option value="' + response[i].startDate + "|" + response[i].endDate + "|" + response[i].noOfDays + '" selected="selected">' + response[i].name + '</option>');
            }
            $('#myBlock').append('<option selected="selected">Select Block</option>');
            $('#totalSessionsPossible').html(studentTotalDaysCount);
        }).fail(function (err) {
        }).always(function () {
        });
    }

    $("#myBlock").change(function () {
        var blockDateStr = $("#myBlock").val();
        var blockDateArr = blockDateStr.split("|");
        $('#sessionInBlock').html(blockDateArr[2]);
        $.ajax("http://localhost:8080/api/get/meditations/" + studentIdCur + "/" + blockDateArr[0].split("T")[0] + "/" + blockDateArr[1].split("T")[0]).done(function (response) {
            $('#daysPresent').html(response.length);
            $('#percentageAttended').html(getPercent(response.length, blockDateArr[2]));

            if (blockDateArr[2] - response.length < 3) {
                $('#extraCreditPoints').html("1.5");
            } else if (blockDateArr[2] - response.length == 3) {
                $('#extraCreditPoints').html("1.0");
            } else {
                $('#extraCreditPoints').html("0");
            }

            $('table tbody').empty();
            for (let i = 0; i < response.length; i++) {
                $('table tbody').append(
                    "<tr>\n" +
                    "  <td>\n" +
                    response[i].date +
                    "  </td>\n" +
                    "</tr>\n"
                );
            }

        }).fail(function (err) {
        }).always(function () {
        });

    });

    $.ajax("http://localhost:8080/api/get/students").done(function (response) {
        for (let i = 0; i < response.length; i++) {
            $('#myStudent').append('<option value="' + response[i].id + "|" + response[i].entryBlock.id + '" selected="selected">' + response[i].name + '</option>');
        }
        $('#myStudent').append('<option selected="selected">Select Student</option>');
    }).fail(function (err) {
        // alert("error")
        console.log('err:' + err);
    }).always(function () {
    });

    $("#myStudent").change(function () {
        var studentStr = $("#myStudent").val();
        console.log(studentStr);
        var studentArr = studentStr.split("|");
        studentIdCur = studentArr[0];
        studentEntryBlockIdCur = studentArr[1];
        getBlocks(studentEntryBlockIdCur);
        getMeditations(studentIdCur);
    });

});

