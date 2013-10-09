<!DOCTYPE html>
<%@page import = "java.util.*" %>
<%@page import = "com.google.appengine.api.datastore.Entity" %>
<% Entity profile=(Entity)request.getAttribute("user");%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="assets/ico/favicon.png">

    <title>Profile</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/navbar-fixed-top.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="assets/js/html5shiv.js"></script>
      <script src="assets/js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <!-- Fixed navbar -->
	
<form>
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
            <li><a href="home?mail=<%=profile.getProperty("Email")%>" >Home</a></li>
            <li class="active"><a href="#">Profile</a></li>
            <% //String a=re[0]) %>
            <li><a href="transaction?mail=<%=profile.getProperty("Email")%>" >Transaction</a></li>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="../navbar/">Settings</a></li>
                        
			<li class="dropdown">
              <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"><img src="images/userPic/<%out.print(profile.getProperty("Email")); %>.jpg"  
			  style="width:20px;height:20px;" class="img-circle" id="navbarimg"> &nbsp;<% out.print(profile.getProperty("Name")); %><b class="caret"></b></a>
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
</form>	
    
<div class="container">	
		
		
			<div class="col-sm-1">
			</div>
			
			<div class="col-sm-7">
				<div class="panel panel-primary">
						<div class="panel-heading">
							<h2 class="panel-title">&nbsp;&nbsp;&nbsp;&nbsp;PROFILE</h2>
						</div>
				</div>
			</div>
</div>


<div class="container">

        <div class="col-sm-1">
		</div>
		
		<form>
		<div class="col-sm-3">
			
			<div class="row">
				<div class="span2">
				<h1></h1>
					
				<h2><br></h2>
				&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/userPic/<%out.print(profile.getProperty("Email")); %>.jpg" name = "user_pic"height = "200" width = "200" alt="" class="img-rounded">
				</div>
			</div>
		</div>
		</form>
		
		<form>
		<div class="col-sm-4">
			<div class="span4">
				<h1><br></h1>
					<blockquote>
						<h3 name = "user_name"><% out.print(profile.getProperty("Name")); %></h3>
							<p name = "user_no"><% out.print(profile.getProperty("Name")); %></p>
							<small><cite title="Source Title" name = "user_mail"><% out.print(profile.getProperty("Email")); %> <i class="icon-map-marker"></i></cite></small>
							
					</blockquote>
			</div>
		</div>
		</form>
		
		<div class="col-sm-1">
		</div>
		
		<form>
		<div class="col-sm-3">
			<div class="well sidebar-nav">
				<ul class="nav">
					<li>Notifications</li>
					<li class="active" name="list1"><a href="#">Link</a></li>
					<li name="list1"><a href="#">Link</a></li>
					<li name="list2"><a href="#">Link</a></li>
					<li name="list3"><a href="#">Link</a></li>
					<li name="list4"><a href="#">See More</a></li>
			</div>
		</div>
		</form>
		</div>
		<hr>
		<div class="container">	
		
		
			<div class="col-sm-1">
			</div>
			
			<div class="col-sm-7">
			
                <form action="/profile" method="POST">
				<table border="0" CELLSPACING="6" CELLPADDING="7">
				  <col width="120">
				  <col width="250">
				  <col width="450">
				  
				<tr>
					<td> <img src = "images/name.jpg " height = "60" width = "60"></img></td>
					<td> <h3><b> Name  </b></h3></td>
                    <td> <h3 name="user_name"> <% out.print(profile.getProperty("Name")); %> </h3></td>
				</tr>
				
				<tr>
					<td> <img src = "images/mail.jpg" height = "60" width = "60"></img></td>
					<td> <h3><b> E-mail  </b></h3></td>
					<td> <h3 name="user_email"><% out.print(profile.getProperty("Email")); %></h3></td>
				</tr>

				<tr>
					<td> <img src = "images/phone.jpg" height = "60" width = "60"></img></td>
					<td> <h3><b> Phone  </b></h3></td>
					<td> <h3 name="user_phn"><% out.print(profile.getProperty("Phone")); %></h3></td>
				</tr>
				
				<tr>
					<td> <img src = "images/address.png" height = "60" width = "60"></img></td>
					<td> <h3><b> Address </b></h3></td>
					<td> <h3 name="user_addr"><% out.print(profile.getProperty("Address"));%></h3></td>
				</tr>
				
				<tr>
					<td> <img src = "images/role.gif" height = "60" width = "60"></img></td>
					<td> <h3><b> Role  </b></h3></td>
					<td> <h3 name="user_role"><% out.print(profile.getProperty("Role"));%></h3></td>
				</tr>
				
				<tr>
					<td> <img src = "images/designation.jpg" height = "60" width = "60"></img></td>
					<td> <h3><b> Designation  </b></h3></td>
					<td> <h3 name="user_designation"><% out.print(profile.getProperty("Designation"));%></h3></td>
				</tr>
				
				</table>
			</form>	
			</div>
				
			<div class="col-sm-1">
			</div>
			
			
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
			
			<form>		
			  <div class="well sidebar-nav">
				<ul class="nav">
					  <li>Groups</li>
					  <li><a href="#">Join a Group</a></li>
					  <li><a href="#">Create a Group</a></li>
					  <li name="list1"><a href="#">Group 1</a></li>
					  <li name="list2"><><a href="#">Group 2</a></li>
					  <li name="list3"><><a href="#">See More</a></li>
					  </ul>
			</div>
			</form>
			
			<br>
			
			<form>
				  <button type="button" class="btn btn-lg btn-info" name="query">Send a Query</button> 
				  <br><br><br>
				  <button type="button" class="btn btn-lg btn-danger" name="feedback">FEEDBACK</button>
			</div>
			</form>
		  
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
