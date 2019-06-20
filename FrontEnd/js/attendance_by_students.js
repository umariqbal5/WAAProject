$(document).ready(function () {
    console.log('loaded attendence_by_student.js')
    //Redirect to login page if not LogedIn
    let token = localStorage.getItem("token");
    if(!token)
        window.location.replace("login.html");



    var noOfDays = 0;

    function getPercent(num, total) {
        num = parseFloat(num);
        total = parseFloat(total);
        if (isNaN(num) || isNaN(total)) {
            return "-";
        }
        return total <= 0 ? "0%" : (Math.round(num / total * 10000) / 100.00) + "%";
    }

    function getStudents(data) {

        $('table tbody').empty();

        $('table tbody').append(
            "<tr>\n" +
            "  <td style='font-weight: bold'>\n" +
            "Student" +
            "  </td>\n" +
            "  <td style='font-weight: bold'>\n" +
            "No of days" +
            "  </td>\n" +
            "  <td style='font-weight: bold'>\n" +
            "This month Percent" +
            "  </td>\n" +
            "  <td style='font-weight: bold'>\n" +
            "Extra Point" +
            "  </td>\n" +
            "</tr>\n"
        );

        for (let i = 0; i < data.length; i++) {

            var itemArr = data[i].split(",")

            var extraPoint = 0;

            if (noOfDays - itemArr[1] < 3) {
                extraPoint = 1.5;
            } else if (noOfDays - itemArr[1] == 3) {
                extraPoint = 1;
            } else {
                extraPoint = 0;
            }

            $('table tbody').append(
                "<tr>\n" +
                "  <td>\n" +
                itemArr[0] +
                "  </td>\n" +
                "  <td>\n" +
                noOfDays +
                "  </td>\n" +
                "  <td>\n" +
                getPercent(itemArr[1], noOfDays) +
                "  </td>\n" +
                "  <td>\n" +
                extraPoint +
                "  </td>\n" +
                "</tr>\n"
            );

        }
    }

    function getBlocks() {
        $.ajax("http://localhost:8080/api/get/blocks").done(function (response) {
            $('#myBlock').empty();
            for (let i = 0; i < response.length; i++) {
                $('#myBlock').append('<option value="' + response[i].startDate + "|" + response[i].endDate + "|" + response[i].noOfDays + "|" + response[i].id + '" selected="selected">' + response[i].name + '</option>');
            }
            $('#myBlock').append('<option selected="selected">Select Block</option>');
        }).fail(function (err) {
        }).always(function () {
        });
    }

    getBlocks();

    $("#myBlock").change(function () {
        var blockDateStr = $("#myBlock").val();
        console.log(blockDateStr)
        var blockDateArr = blockDateStr.split("|");
        console.log(blockDateArr[1])
        $.ajax("http://localhost:8080/api/get/stu/" + blockDateArr[0].split("T")[0] + "/" + blockDateArr[1].split("T")[0]).done(function (response) {
            console.log(response);
            noOfDays = blockDateArr[2];
            getStudents(response);

        }).fail(function (err) {
        }).always(function () {
        });
    });

});