
//Olusegun Akinyelure.
$(document).ready(function() {
    $("#getNotified").submit(function(e) {
        e.preventDefault();
        var email = $("#email").val();
        if (!email) {
            return;
        }
        var route = '/save/' + email;
        //Ajax to server data transfer took place here
        $.ajax({
            type: "POST",
            dataType: 'json',
            url: route
        }).success(function(data) {
            bootbox.dialog({
               message: "<h3>Thanks a lot. <br>We will notify you when we launch</h3>",
                buttons: {
                    success: {
                        label: 'Close',
                        className: 'btn-success'
                    }
                }
            });
        }).error(function () {
            bootbox.dialog({
                message: "<h3>An error occurred. <br>Please try again</h3>",
                buttons: {
                    success: {
                        label: 'Close',
                        className: 'btn-danger'
                    }
                }
            });
        });
    });
});
