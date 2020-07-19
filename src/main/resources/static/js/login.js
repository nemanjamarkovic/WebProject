$(document).ready(function (event) {
    if(sessionStorage.getItem("id"))
        window.location.href = "user.html";

});

$(document).on("submit", "form", function (event) {           // kada je submitovana forma za kreiranje novog zaposlenog
    event.preventDefault();


    var email = $("#email").val();
    var password = $("#password").val();



    var loginJSON = loginFormToJSON(password,  email);  // pozivamo pomoćnu metodu da kreira JSON

    $.ajax({
        type: "Post",                                               // HTTP metoda je POST
        url: "http://localhost:8080/api/user/login",                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: loginJSON,                                      // Šaljemo novog zaposlenog
        success: function (data) {
            sessionStorage.setItem("id",data["id"]);
            sessionStorage.setItem("role",data["role"]);
            window.location.href = "user.html";
        },
        error: function (data) {
            console.log("ERROR : ", data);
            alert("User not found!");
        }
    });
});

// Pomoćna funkcija koja serijalizuje polja iz forme i od njih kreira JSON
function loginFormToJSON(password, email) {
    return JSON.stringify({
        "email": email,
        "password": password,

    });
}