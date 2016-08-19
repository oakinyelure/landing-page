<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link href="/emailNotification.css" rel="stylesheet" type="text/css">
<title>Get Notified</title>
</head>

<body>
<div class="container">
    <header id="top" class="header">
	<div class="text-vertical-center modal-header">
  		<h1>campustradein</h1>

	</div>
    </header>
    </div>

<!--start of form*******************-->
      <form class="form-signin" id = "getNotified" >

          <!--Submit success status message-->
          <div role="alert" id = "successful">
              <span aria-hidden="true" id = "checkMark"></span>
                <span class="sr-only">Success</span>
          </div>
          <!--End of success status message-->


          <h4 class="form-signin-heading">Want to be the first to get Notified? </h4>

            <label for="fullName" class = "sr-only">Full Name</label>
                <input type="text" class="form-control" id = "fullName" name = "fullName" placeholder = "Full Name" aria-describedby="sizing-addon1" required autofocus>
          <br/>

            <label for="email" class="sr-only">Email address</label>
                <input type="email" id="email" name = "email" class="form-control" placeholder="Email address" aria-describedby="sizing-addon1" required >
          <br/>
             <button class="btn btn-lg btn-primary btn-block" type="submit" id = "submit" name = "submit">Sign Up for Notification</button>

          <!--Server Error Status message-->
          <div id = "error" role="alert">
              <span id = "exclamationSign" aria-hidden="true"></span>
          </div>
          <!--End of Server error message-->

      </form>
<!--End of form -->

    </div> <!-- /container -->


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script   src="https://code.jquery.com/jquery-2.2.4.js"   integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="   crossorigin="anonymous"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="/submitData.js"></script>
</body>
</html>
