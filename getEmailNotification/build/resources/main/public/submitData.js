
//Olusegun Akinyelure.
$(function(){

    $('#getNotified').submit(function(e){
            //input values stored in json format.
            var dat = {
                    fullName : $('#fullName').val(),
                    email : $('#email').val()
                }
             //end of data collection

           //Ajax to server data transfer took place here
        $.ajax({
            datatype : "json",
            contentType : "application/json; charset=utf-8",
            type : "POST",
            url :'/save',
            data: JSON.stringify(dat),
            success: function(data){
                $('#successful').addClass("alert alert-success");
                $('#checkMark').addClass("glyphicon glyphicon-ok");
                $('#successful').html("Your email has been Submitted. You will notified as soon as we come live");
                $('#fullName').val("");
                $('#email').val("");
                setTimeout(function() {
                					$('#successful').fadeOut("slow");}, 2000 );
            },

            error: function(){
                $('#error').addClass("alert alert-danger");
                 $('#exclamationSign').addClass("glyphicon glyphicon-exclamation-sign");
                 $('#error').html("There was problem submitting your email. Please try Again Later");
                             setTimeout(function() {
                               $('#error').fadeOut("slow");}, 2000 );
            },
        });
        e.preventDefault();

    });
    //end of data transfer

});