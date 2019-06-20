var lines = [];

function previewText() {
    var inputFile = document.getElementById('input-file');
    var reader = new FileReader();
    reader.onload = function (evt) {
        var textContents = evt.target.result;
        lines = textContents.split(/\n/);
        lines = jQuery.unique(lines);
        // console.log(lines);
    };
    reader.readAsText(inputFile.files[0]);
};

const readFile = async () => {
    var objects = [];
    var cnt = 0;

    for (const value of lines) {
        values = value.split(",");
        var myObject = new Object();
        if (values.length == 4) {
            myObject.id = values[0];
            myObject.date = values[1];
            myObject.timeSlot = values[2];
            myObject.location = values[3];
        } else if (values.length == 3) {
            var now = new Date(values[0]);
            var dateString = moment(now).format('MM/DD/YY');
            myObject.date = dateString;
            myObject.timeSlot = 'AM';
            myObject.location = 'DB';
            myObject.student = new Object();
            myObject.student.registrationNumber = values[1];
            myObject.student.name = values[2];
        }
        objects.push(myObject)
        if (objects.length == 100) {
            cnt++;
            console.log("cnt: " + cnt);
            await makeAjaxCall(objects);
            objects = [];
        }
    }
    if (objects.length != 0) {
        await makeAjaxCall(objects);
    }
}

async function makeAjaxCall(objects) {
    objects = Array.from(new Set(objects.map(JSON.stringify))).map(JSON.parse);
    var data = JSON.stringify(objects);
    // var data = JSON.stringify($("#employeeForm").serializeFormJSON());
    console.log(data);
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/saveTmRecord",
        data: data,
        contentType: "application/json",
        dataType: "json",
        success: function (emp) {
            console.log(emp);
        },

        error: function (XMLHttpRequest) {
            console.log("ERROR...");
        }

    });
}

$(document).ready(function () {
    console.log('loaded upload.js')
    //Redirect to login page if not LogedIn
    let token = localStorage.getItem("token");
    if(!token)
        window.location.replace("login.html");

    $('#read-file').click(function (event) {
        readFile();
    });
});