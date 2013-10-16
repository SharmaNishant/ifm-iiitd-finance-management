<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="assets/ico/favicon.png">

    <title>Sign Up</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/jumbotron-narrow.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body background="images/back.jpg">

    <div class="container">
      <div class="header">
        <ul class="nav nav-pills pull-right">
          <li><a href="index.html">Home</a></li>
          <li><a href="about.html">About</a></li>
        </ul>
        <h3 class="text-muted">IIIT-D Finance Management</h3>
      </div>

      <form class="form-horizontal" action="signup_final" method="POST">
  <fieldset>
    <div id="legend">
      <legend class="">Sign up</legend>
    </div>
    <div class="control-group">
      <!-- roll no -->
      <label class="control-label" for="roll">Roll No</label>
      <div class="controls">
        <input type="text" id="roll" name="roll" placeholder="" class="input-xlarge">
        <p class="help-block">Please provide your Roll number</p>
      </div>
    </div>
    <%String[] a=(String[] )request.getAttribute("signup_info"); %>
    <input type="hidden"  name="name" value="<% out.println(a[0]); %>" />
    <input type="hidden"  name="mail" value="<% out.println(a[1]); %>" />
    <input type="hidden"  name="phone" value="<% out.println(a[2]); %>" />
    <input type="hidden"  name="add" value="<% out.println(a[3]); %>" />
    <input type="hidden"  name="role" value="<% out.println(a[4]); %>" />
	<div class="control-group">
      <!-- stream -->
      <label class="control-label" for="stream">Stream</label>
      <div class="controls">
        <input type="text" id="stream" name="stream" placeholder="" class="input-xlarge">
        <p class="help-block">Please mention yor Stream : CSE/ECE </p>
      </div>
    </div>
	
    <div class="control-group">
      <!-- Password-->
      <label class="control-label" for="password">Password</label>
      <div class="controls">
        <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
        <p class="help-block">Password should be at least 4 characters</p>
      </div>
    </div>

    <div class="control-group">
      <!-- Password -->
      <label class="control-label"  for="password_confirm">Password (Confirm)</label>
      <div class="controls">
        <input type="password" id="password_confirm" name="password_confirm" placeholder="" class="input-xlarge">
        <p class="help-block">Please confirm password</p>
      </div>
    </div>

	
    <div class="control-group">
      <!-- Button -->
      <div class="controls">
	  <label><input type="checkbox" name="terms" value="1"> I agree with the <a href="#">Terms and Conditions</a>.</label><br>
        <button class="btn btn-success" name = "confirm">Confirm</button>
		<button class="btn btn-danger" name = "cancel">Cancel</button>
      </div>
    </div>
  </fieldset>
</form>

      

      <div class="footer">
        <p>&copy; SE Project 2013</p>
      </div>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
