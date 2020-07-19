$(document).ready(function () {          // kada je button (čija je class = btnSeeMore) kliknut



    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/viewer/allwatchedmovies/" + sessionStorage.getItem('id'),  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
            for (i = 0; i < data.length; i++) {
                if(data[i]['rating'] != 0) {
                    var row = "<tr>";
                    row += "<td>" + data[i]['title'] + "</td>";     // ubacujemo podatke jednog zaposlenog u polja
                    row += "<td>" + data[i]['genre'] + "</td>";
                    row += "<td>" + data[i]['duration'] + "</td>";
                    row += "<td>" + data[i]['rating'] + "</td>";
                    var name = "input" + data[i]['id'].toString();
                    //alert(name);
                    var input = "<input  id ='input" + data[i]['id'] + "'type = text></input>";
                    row += "<td>" + input + "</td>";
                    var btn = "<button class='changeRating btn btn-dark' id = " + data[i]['id'] + ">Change rating</button>";
                    row += "<td>" + btn + "</td>";
                    $('#ratedMovies').append(row);
                }else{
                    var row = "<tr>";
                    row += "<td>" + data[i]['title'] + "</td>";     // ubacujemo podatke jednog zaposlenog u polja
                    row += "<td>" + data[i]['genre'] + "</td>";
                    row += "<td>" + data[i]['duration'] + "</td>";
                    row += "<td>" + "Neocijenjen" + "</td>";
                    var name = "input" + data[i]['id'].toString();
                    //alert(name);
                    var input = "<input  id ='input" + data[i]['id'] + "'type = text></input>";
                    row += "<td>" + input + "</td>";
                    var btn = "<button class='rateMovie btn btn-dark' id = " + data[i]['id'] + ">Rate Movie</button>";
                    row += "<td>" + btn + "</td>";
                    $('#NonRatedMovies').append(row);



                }
            }
            allWatchedMoviesDiv.show();
        },


        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '.rateMovie', function () {            // kada je button (čija je class = btnSeeMore) kliknut
    // alert(this.id);
    var rating = $("#input"+this.id).val();

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/viewer/ratemovie/" + sessionStorage.getItem('id') + "&" + this.id + "&" + rating,  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {

            window.location.href = "/user.html";
        },


        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});


//promijeni ocjenu filmu
$(document).on('click', '.changeRating', function () {            // kada je button (čija je class = btnSeeMore) kliknut
    // alert(this.id);
    var rating = $("#input"+this.id).val();

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/viewer/changerating/" + sessionStorage.getItem('id') + "&" + this.id + "&" + rating,  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {

            window.location.href = "/user.html";
        },


        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});