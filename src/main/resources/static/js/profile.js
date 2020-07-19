$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv
    let id = sessionStorage.getItem("id");
    let role = sessionStorage.getItem("role");
    if(role.toString() == "MANAGER")
        $("#adminOptions").hide();
    else if(role.toString() == "ADMIN")
        $("#managerOptions").hide();
    else{
        $("#adminOptions").hide();
        $("#managerOptions").hide();
    }







    $.ajax({
        type: "Get",                                                // HTTP metoda
        url: "http://localhost:8080/api/user/profile/"+id.toString(),                 // URL koji se gađa
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS : ", data);
            $('#name').append(data['name']);
            $('#lastname').append(data['lastname']);
            $('#email').append(data['email']);

        },
        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});

// Pomoćna funkcija koja serijalizuje polja iz forme i od njih kreira JSON
function formToJSON(name, lastname, email) {
    return JSON.stringify({
        "name": name,
        "lastname": lastname,
        "email": email
    });
}


$(document).on('click', '#adminOptions', function () {
    window.location.href = "admin.html";

});

$(document).on('click', '#managerOptions', function () {
    window.location.href = "manager.html";
});

