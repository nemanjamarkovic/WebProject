$(document).ready(function () {
    $("#searchedMovies").hide();
    $("#allProjections").hide();

    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/all-movies",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (data) {

            console.log("SUCCESS : ", data);                        // ispisujemo u konzoli povratnu vrednost
            for (i = 0; i < data.length; i++) {                     // prolazimo kroz listu svih zaposlenih
                var row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + data[i]['title'] + "</td>";     // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + data[i]['description'] + "</td>";
                row += "<td>" + data[i]['genre'] + "</td>";
                row += "<td>" + data[i]['duration'] + "</td>";
                row += "<td>" + data[i]['date'] + "</td>";
                row += "<td>" + data[i]['rating'] + "</td>";

                $('#movies').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});

$(document).on("submit", "form", function (event) {           // kada je submitovana forma za kreiranje novog zaposlenog
    event.preventDefault();
    $("#searchedMovies").show();
    var title = $("#title").val();
    var genre = $("#genre").val();
    var rating = $("#rating").val();

    //var x = document.getElementById("movies").rows[1].cells[5].innerHTML;


    var searchJSON = formToJSON(title, genre, rating);  // pozivamo pomoćnu metodu da kreira JSON

    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8080/search",                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: searchJSON,                                      // Šaljemo novog zaposlenog
        success: function (data) {

            for(i = 0; i<data.length; i++) {
                var row = "<tr>";
                row += "<td>" + data[i]['title'] + "</td>";     // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + data[i]['description'] + "</td>";
                row += "<td>" + data[i]['genre'] + "</td>";
                row += "<td>" + data[i]['duration'] + "</td>";
                row += "<td>" + data[i]['date'] + "</td>";
                row += "<td>" + data[i]['rating'] + "</td>";

                var btn = "<button class='btnSeeMore btn btn-dark' id = " + data[i]['id'] + ">See projections</button>";
                row += "<td>" + btn + "</td>";

                $('#searchedMovies').append(row);

            }
            $("#addUserForm").hide();
        },
        error: function (data) {
            console.log(data);
            $("#addUserForm").show();
            alert("No movies found!");

        }
    });
});


$(document).on('click', '.btnSeeMore', function () {            // kada je button (čija je class = btnSeeMore) kliknut
    var allMoviesDiv = $("#allMovies");                      // dobavi element čiji je id = allEmployees  (pogledati html)
    allMoviesDiv.hide();                                       // sakrij taj element
    var projectionDiv = $("#allProjections");



    // nakon što korisnik klikne button See more možemo i samo da se prebacimo na employee.html
    // tada ajax poziv za dobavljanje jednog zaposlenog moze da bude u fajlu employee.js
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/projection/" + this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
            for(i = 0; i<data.length; i++) {
                var row = "<tr>";
                row += "<td>" + data[i]['movieTitle'] + "</td>";     // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + data[i]['day'] + "</td>";
                row += "<td>" + data[i]['price'] + "</td>";
                row += "<td>" + data[i]['free'] + "</td>";

                var btn = "<button class='reserveTicket btn btn-dark' id = " + data[i]['id'] + ">Reserve ticket</button>";
                row += "<td>" + btn + "</td>";

                $('#projections').append(row);
                if(data[i]['free'] == 0)
                    document.getElementById(data[i]['id']).disabled = true;
            }

            projectionDiv.show();
        },

        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '.reserveTicket', function () {            // kada je button (čija je class = btnSeeMore) kliknut



    // nakon što korisnik klikne button See more možemo i samo da se prebacimo na employee.html
    // tada ajax poziv za dobavljanje jednog zaposlenog moze da bude u fajlu employee.js
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/projection/reservation/" + this.id + "&" + sessionStorage.getItem('id'),  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
            window.location.href = "/movies.html"
        },
        error: function (data) {
            alert("vec rezervisano");
        }
    });
});

// Pomoćna funkcija koja serijalizuje polja iz forme i od njih kreira JSON
function formToJSON(title, genre, rating) {
    return JSON.stringify({
        "title": title,
        "genre": genre,
        "rating": rating
    });
}
