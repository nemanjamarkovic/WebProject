$(document).ready(function () {
    console.log("nemanja");
    $("#allCinemasDiv").hide();
    $("#allUsersDiv").hide();
    $("#addCinemaFormDiv").hide();



    $.ajax({
        type: "GET",
        url: "http://localhost:8080/admin/allusers",  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
            for (i = 0; i < data.length; i++) {

                    var row = "<tr>";
                    row += "<td>" + data[i]['name'] + "</td>";     // ubacujemo podatke jednog zaposlenog u polja
                    row += "<td>" + data[i]['lastname'] + "</td>";
                    row += "<td>" + data[i]['email'] + "</td>";
                    row += "<td>" + data[i]['role'] + "</td>";
                    if(data[i]['cinemaId'] == null)
                        row += "<td>" + "" + "</td>";
                    else
                        row += "<td>" + data[i]['cinemaId'] + "</td>";
                    //alert(name);
                    var input = "<input  id ='input" + data[i]['id'] + "'type = text></input>";
                    row += "<td>" + input + "</td>";
                    var btn = "<button class='setManager btn btn-dark' id = " + data[i]['id'] + ">Set</button>";
                    row += "<td>" + btn + "</td>";
                    if(data[i]['role'].toString() == "MANAGER") {
                        var btn = "<button class='removeManager btn btn-dark' id = " + data[i]['id'] + ">Remove</button>";
                        row += "<td>" + btn + "</td>";
                    }
                    $('#allUsers').append(row);

            }

        },


        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});


$(document).on('click', '.setManager', function () {            // kada je button (čija je class = btnSeeMore) kliknut
    // alert(this.id);
    var cinemaId = $("#input"+this.id).val();

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/admin/setmanager/" + this.id + "&" + cinemaId,  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
            alert("Manager successfully added");
            window.location.href = "admin.html";
        },


        error: function (data) {
            alert("Cinema ID not found");
        }
    });
});

$(document).on('click', '.removeManager', function () {            // kada je button (čija je class = btnSeeMore) kliknut
    // alert(this.id);
    var cinemaId = $("#input"+this.id).val();

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/admin/removemanager/" + this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
            alert("Manager removed!");
            window.location.href = "admin.html";
        },


        error: function (data) {
            alert("Every cinema must have at least 1 manager");
        }
    });
});

$(document).ready(function () {
    console.log("nemanja");
    $("#allCinemasDiv").hide();




    $.ajax({
        type: "GET",
        url: "http://localhost:8080/admin/allcinemas",  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
            for (i = 0; i < data.length; i++) {
                var row = "<tr>";
                row += "<td>" + data[i]['id'] + "</td>";     // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + data[i]['name'] + "</td>";
                row += "<td>" + data[i]['address'] + "</td>";
                row += "<td>" + data[i]['email'] + "</td>";
                row += "<td>" + data[i]['phoneNumber'] + "</td>";

                var btn = "<button class='editCinema btn btn-dark' id = " + data[i]['id'] + ">Edit</button>";
                row += "<td>" + btn + "</td>";
                var btn = "<button class='removeCinema btn btn-dark' id = " + data[i]['id'] + ">Remove</button>";
                row += "<td>" + btn + "</td>";

                $('#cinemas').append(row);

            }

        },


        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '.editCinema', function () {
    console.log("nemanja");
    var x = this.id;


    $.ajax({
        type: "GET",
        url: "http://localhost:8080/admin/allcinemas",  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
            for (i = 0; i < data.length; i++) {
                if(x == data[i]['id']) {
                    var row = "<tr>";
                    row += "<td>" + data[i]['id'] + "</td>";     // ubacujemo podatke jednog zaposlenog u polja
                    row += "<td>" + data[i]['name'] + "</td>";
                    var input = "<input  id ='name" + data[i]['id'] + "'type = text></input>";
                    row += "<td>" + input + "</td>";
                    row += "<td>" + data[i]['address'] + "</td>";
                    var input = "<input  id ='address" + data[i]['id'] + "'type = text></input>";
                    row += "<td>" + input + "</td>";
                    row += "<td>" + data[i]['email'] + "</td>";
                    var input = "<input  id ='email" + data[i]['id'] + "'type = text></input>";
                    row += "<td>" + input + "</td>";
                    row += "<td>" + data[i]['phoneNumber'] + "</td>";
                    var input = "<input  id ='phoneNumber" + data[i]['id'] + "'type = text></input>";
                    row += "<td>" + input + "</td>";

                    var btn = "<button class='saveChanges btn btn-dark' id = " + data[i]['id'] + ">Save</button>";
                    row += "<td>" + btn + "</td>";
                    $("#cinemas").hide();
                    $('#cinemaEdit').append(row);
                }


            }

        },


        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '.saveChanges', function () {
    var name = $("#name"+this.id).val();
    var address = $("#address"+this.id).val();
    var email = $("#email"+this.id).val();
    var phoneNumber = $("#phoneNumber"+this.id).val();
    var id = this.id;

    var inputJSON = inputToJSON(name,address,email,phoneNumber,id);
    alert(phoneNumber);

    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8080/admin/changecinema",                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: inputJSON,
        success: function (data) {
            window.location.href = "admin.html";
        },
        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '.removeCinema', function () {


    $.ajax({
        type: "GET",
        url: "http://localhost:8080/admin/removecinema/"+this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
            window.location.href = "admin.html";
        },

        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});

$(document).on("submit", "form", function (event) {           // kada je submitovana forma za kreiranje novog zaposlenog
    event.preventDefault();


    var name = $("#name").val();
    var address = $("#address").val();
    var email = $("#email").val();
    var phoneNumber = $("#phoneNumber").val();


    var inputJSON = inputToJSON(name, address, email, phoneNumber);  // pozivamo pomoćnu metodu da kreira JSON

    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8080/admin/add-cinema",                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: inputJSON,                                      // Šaljemo novog zaposlenog
        success: function (data) {


            window.location.href = "admin.html";
        },
        error: function (data) {
            console.log("ERROR : ", data);
            alert("Greška!");
        }
    });
});

$(document).on("click", "#showUsers", function (event) {
    $("#allUsersDiv").show();
    $("#allCinemasDiv").hide();
});

$(document).on("click", "#showCinema", function (event) {
    $("#allUsersDiv").hide();
    $("#allCinemasDiv").show();
});

$(document).on("click", "#close", function (event) {
    window.location.href = "admin.html";

});


function inputToJSON(name, address, email, phoneNumber,id) {
    return JSON.stringify({
        "id": id,
        "name": name,
        "address": address,
        "email": email,
        "phoneNumber": phoneNumber
    });
}




