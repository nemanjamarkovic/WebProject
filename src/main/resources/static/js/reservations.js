$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    var allReservationsDiv = $("#allReservations");
    allReservationsDiv.hide();
    var allWatchedMovies = $("#allWatchedMovies");
    allWatchedMovies.hide();

    var tableHeaderDiv = $("#tableHeader");
    tableHeaderDiv.hide();
});




    $(document).ready(function () {           // kada je button (čija je class = btnSeeMore) kliknut


    // nakon što korisnik klikne button See more možemo i samo da se prebacimo na employee.html
    // tada ajax poziv za dobavljanje jednog zaposlenog moze da bude u fajlu employee.js
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/viewer/allreservations/" + sessionStorage.getItem('id'),  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {

            console.log(data);
            for(i = 0; i<data.length; i++) {
                var row = "<tr>";
                row += "<td>" + data[i]['movieTitle'] + "</td>";     // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + data[i]['day'] + "</td>";
                row += "<td>" + data[i]['price'] + "</td>";
                row += "<td>" + data[i]['free'] + "</td>";

                var btn = "<button class='removeReservation btn btn-dark' id = " + data[i]['id'] + ">Remove reservation</button>";
                row += "<td>" + btn + "</td>";
                $('#reservations').append(row);
            }
            allReservationsDiv.show();


        },

        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});


$(document).on('click', '.removeReservation', function () {            // kada je button (čija je class = btnSeeMore) kliknut
    var allReservationsDiv = $("#allReservations");
    // allReservationsDiv.show();


    // nakon što korisnik klikne button See more možemo i samo da se prebacimo na employee.html
    // tada ajax poziv za dobavljanje jednog zaposlenog moze da bude u fajlu employee.js
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/viewer/removereservation/" + sessionStorage.getItem('id') + "&" + this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
            window.location.href = "/user.html";

        },

        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '.showReservations', function () {
    $("#allReservations").show();
    $("#allWatchedMovies").hide();
});

$(document).on('click', '.showWatchedMovies', function () {
    $("#allReservations").hide();
    $("#allWatchedMovies").show();
});




$(document).on('click', '#closeButton', function () {
    $("#allReservations").hide();
    $("#allWatchedMovies").hide();


});

$(document).on('click', '#rated', function () {
    var nonRated = $("#allNonRatedMovies");
    nonRated.hide();
    var rated = $("#allRatedMovies");
    rated.show();

});

$(document).on('click', '#nonrated', function () {
    var nonRated = $("#allNonRatedMovies");
    nonRated.show();
    var rated = $("#allRatedMovies");
    rated.hide();

});
$(document).on('click', '#showAll', function () {
    var nonRated = $("#allNonRatedMovies");
    nonRated.show();
    var rated = $("#allRatedMovies");
    rated.show();

});
