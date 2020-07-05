$(document).on("submit", "form", function (event) {           // kada je submitovana forma za kreiranje novog zaposlenog
    event.preventDefault();


    var password = $("#password").val();
    var name = $("#name").val();
    var lastname = $("#lastname").val();
    var email = $("#email").val();


    var registrationJSON = registrationFormToJSON(password, name, lastname, email);  // pozivamo pomoćnu metodu da kreira JSON

    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8080/api/user/registration",                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: registrationJSON,                                      // Šaljemo novog zaposlenog
        success: function (data) {
            alert("Nalog uspjesno kreiran " + data['name']);
            window.location.href = "index.html";
        },
        error: function (data) {
            console.log("ERROR : ", data);
            alert("Greška!");
        }
    });
});

// Pomoćna funkcija koja serijalizuje polja iz forme i od njih kreira JSON
function registrationFormToJSON(password, name, lastname, email) {
    return JSON.stringify({
        "password": password,
        "name": name,
        "lastname": lastname,
        "email": email
    });
}