function profile() {           // kada je submitovana forma za kreiranje novog zaposleno

    var id = sessionStorage.getItem("id");
    alert(id);

    var idJSON = idToJSON(id);  // pozivamo pomoćnu metodu da kreira JSON

    $.ajax({
        type: "Post",                                               // HTTP metoda je POST
        url: "http://localhost:8080/api/user/profile",                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: idJSON,                                      // Šaljemo novog zaposlenog
        success: function (data) {
            alert("Profil pronadjen " );

        },
        error: function (data) {
            alert("User not found!");
        }
    });
});

// Pomoćna funkcija koja serijalizuje polja iz forme i od njih kreira JSON
function idToJSON(id) {
    return JSON.stringify({
        "id": id,
    });
}