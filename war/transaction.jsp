<!DOCTYPE html>
<%@page import = "java.util.*" %>
<%@page import = "com.google.appengine.api.datastore.Entity" %>
<% Entity profile=(Entity)request.getAttribute("profile");%>



<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="assets/ico/favicon.png">

    <title>Transaction</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/navbar-fixed-top.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <!-- Fixed navbar -->

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">IFM</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="/home?mail=<%=profile.getProperty("Email")%>">Home</a></li>
            <li><a href="/profile?mail=<%=profile.getProperty("Email")%>">Profile</a></li>
            <li class="active"><a href="#">Transaction</a></li>
            
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="../navbar/">Settings</a></li>
                        
			<li class="dropdown">
              <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"><img src="images/userPic/<%out.print(profile.getProperty("Email")); %>.jpg"
			  style="width:20px;height:20px;" class="img-circle" id="navbarimg"> &nbsp;<%out.print(profile.getProperty("Name")); %><b class="caret"></b></a>
              <ul class="dropdown-menu" role = "menu">
                <li><a href="#">Change Password</a></li>
                <li><a href="#">Help</a></li>
				<li><a href="#">FeedBack</a></li>
                <li><a href="index.html">Logout</a></li>
                </ul>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
	
    
<div class="container">	
		
		
			<div class="col-sm-1">
			</div>
			
			<div class="col-sm-7">
				<div class="panel panel-primary">
						<div class="panel-heading">
							<h2 class="panel-title">&nbsp;&nbsp;&nbsp;&nbsp;Transactions</h2>
						</div>
				</div>
				<h1><br></h1>
			</div>
</div>

<div class="container">

        <div class="col-sm-1">
		</div>
		
		<div class="col-sm-7">
		
			<form>	
			<table name = "transaction" border="3" CELLSPACING="6" CELLPADDING="7">
				<col width="100">
				<col width="250">
				<col width="250">	
				<col width="150">
				<col width="150">
				<col width="250">
			
				<tr>
					<th> Serial No.</th>
					<th> Paid By</th>
					<th> Recieved By</th>
					<th> Amount</th>
					<th> Date</th>
					<th> Description</th>
				</tr>
				<tr>
					<td>1 </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
				</tr>
				<tr>
					<td>2 </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
				</tr>
				<tr>
					<td>3 </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
				</tr>
				<tr>
					<td> 4</td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
				</tr>
				<tr>
					<td>5 </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
				</tr>
				<tr>
					<td> 6</td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
				</tr>
				<tr>
					<td>7 </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
				</tr>
				<tr>
					<td>8 </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
				</tr>
				<tr>
					<td> 9</td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
				</tr>
				<tr>
					<td>10 </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
				</tr>
				<tr>
					<td>11 </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
				</tr>
				<tr>
					<td>12 </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
				</tr>
				<tr>
					<td> 13</td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
				</tr>
				<tr>
					<td> 14</td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
				</tr>
				<tr>
					<td>15 </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
				</tr>
			</table>
			
			</form>
		</div>
			
		<div class="col-sm-1">
		</div>
		
		<div class="col-sm-3">
			<div class="well sidebar-nav">
				<ul class="nav">
					<li>Notifications</li>
					<li class="active"><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
					<li><a href="#">See More</a></li>
			</div>
					
			  <div class="well sidebar-nav">
				<ul class="nav">
					  <li>Groups</li>
					  <li><a href="#">Join a Group</a></li>
					  <li><a href="#">Create a Group</a></li>
					  <li><a href="#">Group 1</a></li>
					  <li><a href="#">Group 2</a></li>
					  <li><a href="#">See More</a></li>
					  </ul>
			</div>
			<br>
				  <button type="button" class="btn btn-lg btn-info" name="query">Send a Query</button> 
				  <br><br><br>
				  <button type="button" class="btn btn-lg btn-danger" name = "feedback">FEEDBACK</button>
		</div>
		  
		</div><!--/span-->
		<hr>

    <footer>
        <div class="container">
			<p class="text-muted credit">Contact us at: <a>iiitd.finance.management@gmail.com</a></p>
			<p>&copy; SE Project 2013</p>
		</div>
    </footer>

</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
