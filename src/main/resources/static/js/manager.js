$(document).ready(function () {
    $("#hallEdit").hide();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/manager/"+sessionStorage.getItem('id'),  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
            var row = "<tr>";
            row += "<td>" + data['name'] + "</td>";     // ubacujemo podatke jednog zaposlenog u polja
            row += "<td>" + data['address'] + "</td>";
            row += "<td>" + data['email'] + "</td>";
            row += "<td>" + data['phoneNumber'] + "</td>";
            $("#manager").append(row);

        },


        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});

$(document).ready(function () {
    $("#hallEdit").show();

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/manager/allhalls/"+sessionStorage.getItem('id'),  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
            for (i = 0; i < data.length; i++) {
                var row = "<tr>";
                row += "<td>" + data[i]['id'] + "</td>";
                row += "<td>" + data[i]['label'] + "</td>";     // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + data[i]['capacity'] + "</td>";


                var btn = "<button class='editHall btn btn-dark' id = " + data[i]['id'] + ">Edit</button>";
                row += "<td>" + btn + "</td>";
                var btn = "<button class='removeHall btn btn-dark' id = " + data[i]['id'] + ">Remove</button>";
                row += "<td>" + btn + "</td>";
                $('#halls').append(row);
            }
        },
        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '.editHall', function () {

    var x = this.id;


    $.ajax({
        type: "GET",
        url: "http://localhost:8080/manager/allhalls/"+sessionStorage.getItem('id'),  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
            for (i = 0; i < data.length; i++) {
                if(x == data[i]['id']) {
                    var row = "<tr>";
                    row += "<td>" + data[i]['id'] + "</td>";     // ubacujemo podatke jednog zaposlenog u polja
                    row += "<td>" + data[i]['label'] + "</td>";
                    var input = "<input  id ='label" + data[i]['id'] + "'type = text></input>";
                    row += "<td>" + input + "</td>";
                    row += "<td>" + data[i]['capacity'] + "</td>";
                    var input = "<input  id ='capacity" + data[i]['id'] + "'type = text></input>";
                    row += "<td>" + input + "</td>";


                    var btn = "<button class='saveChanges btn btn-dark' id = " + data[i]['id'] + ">Save</button>";
                    row += "<td>" + btn + "</td>";
                    $("#halls").hide();
                    $('#hallEdit').append(row);
                }


            }

        },
        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '.saveChanges', function () {
    var label = $("#label"+this.id).val();
    var capacity = $("#capacity"+this.id).val();

    var id = this.id;
    var inputJSON = inputToJSON(label,capacity,id);

    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8080/manager/changehall",                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: inputJSON,
        success: function (data) {
            window.location.href = "manager.html";
        },
        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '.removeHall', function () {


    $.ajax({
        type: "GET",
        url: "http://localhost:8080/manager/removehall/"+this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
            window.location.href = "manager.html";
        },

        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});





function inputToJSON(label, capacity, id) {
    return JSON.stringify({
        "id": id,
        "label": label,
        "capacity": capacity
    });
}

