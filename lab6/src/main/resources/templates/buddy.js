$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/addbuddy"
    }).then(function(data) {
       $('.buddyid').append(data.id);
       $('.buddyname').append(data.name);
       $('.buddynumber').append(data.number);
    });
});