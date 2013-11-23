<!DOCTYPE html>
<%@page import = "java.util.*" %>
<%@page import = "com.google.appengine.api.datastore.Entity" %>
<% Entity profile=(Entity)request.getAttribute("profile");
	ArrayList<Entity> trans = (ArrayList<Entity>) request.getAttribute("all_trans");
	ArrayList<String> notify = (ArrayList<String>) request.getAttribute("notify");
%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.png">

    <title>Home Page</title>

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
<form>
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
          <li><a style="color:white; ">IIIT-D Finance Management</a></li>
            <li class="active"><a href="#">Home</a></li>
            <li><a href="/profile">Profile</a></li>
            <li><a href="/transaction">Transaction</a></li>
            
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
                <li><a href="/logout">Logout</a></li>
                </ul>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
</form>

    <div class="container">

        <div class="col-sm-8">
		<br><br>
          <div class="panel panel-primary">
            <div class="panel-heading">
			
              <h2 class="panel-title">Brief Profile</h2>
            </div>
            <div class="panel-body">
              <form>
			  
			  <table border="0">
				
				<tr>
				<td><img src ="images/userPic/<%out.print(profile.getProperty("Email")); %>.jpg" 
			  style="width:60px;height:60px; name="user_pic"></td>
				<td><h3> &nbsp;&nbsp;&nbsp;&nbsp;Name : </h3></td>
				<td><h3 name="user_name">&nbsp;&nbsp;<%out.print(profile.getProperty("Name")); %></h3></td>
				</tr>
				</table>
			   </form>
				
			<hr>
				<table>
				<tr>
				<td><img src = "images/mail.jpg"  
			  style="width:60px;height:60px; name="umail"></td>
				<td><h3> &nbsp;&nbsp;&nbsp;&nbsp; E-mail : </h3></td>
				<td><h3 name="user_email">&nbsp;&nbsp;<%out.print(profile.getProperty("Email")); %></h3></td>
				</tr>
				</table>
			<hr>
				<table>
				<tr>
				<td><img src = "images/phone.jpg"  
			  style="width:60px;height:60px; id="navbarimg"></td>
				<td><h3> &nbsp;&nbsp;&nbsp;&nbsp;Phone No. : </h3></td>
				<td><h3 name="user_phn">&nbsp;&nbsp;<%out.print(profile.getProperty("Phone")); %></h3></td>
				</tr>
				
			  </table>
			 
			 </form>
			 
            </div>
          </div>
		  <br><br><br><br>
          <div class="panel panel-primary">
            <div class="panel-heading">
              <h2 class="panel-title">Brief Transactions</h2>
            </div>
            <div class="panel-body">
			<form name = "transaction">
              <table border="1" CELLSPACING="6" CELLPADDING="7">
			  <col width="100">
			  <col width="150">
			  <col width="150">
			  <col width="100">
			  <col width="100">
			  <col width="200">
				<tr>
					<th> Serial No</th>
					<th> Paid By</th>
					<th> Recieved By</th>
					<th> Amount</th>
					<th> Date</th>
					<th> Description</th>
				</tr>
				
			<%if(trans == null) 
			out.print("<tr>  <td colspan=\"6\" align=\"center\">No Transactions For You!</td></tr>");
			else
			{
				for(int i=0;i<(trans.size()-1) && i<5;i++)
				{
					Entity temp = trans.get(i);
					out.print("<tr>\n");
					out.print("<td>"+(i+1)+"</td>\n");
					out.print("<td>"+ temp.getProperty("Paid_By") +"</td>\n");
					out.print("<td>"+temp.getProperty("Received_By")+" </td>\n");
					out.print("<td>"+temp.getProperty("Amount")+" </td>\n");
					out.print("<td>"+temp.getProperty("Date")+" </td>\n");
					out.print("<td>"+temp.getProperty("Description")+" </td>\n");
					out.print("</tr>\n\n\n");
				}
			}
			%>
				
			</table>
			</form>
			
            </div>
          </div>
        </div><!-- /.col-sm-4 -->
		
		<div class="col-sm-1">
		
		</div>
		
		<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
		<form>
          <div class="list-group">
            <a href="#" class="list-group-item active">
              NOTIFICATIONS
            </a>
					<%  if(notify == null)
					{
						//<li name="list2">Link</li>;
						out.println("<li name=\"temp\" >Nothing New Here</li>"); 
					}
					else
					{
						for(int i=0;i<notify.size();i++)
						{
							String t = notify.get(i);
							out.println("<li name=\""+i+"\">"+t+"</li>");
						}
					}
						%>
          </div>
		  </form>
		
		<br>
			
		<form>
		<div class="list-group">
            <a href="#" class="list-group-item active">
              GROUPS
            </a>
            <a href="#" class="list-group-item">Join a Group</a>
            <a href="#" class="list-group-item">Create a Group</a>
            <a href="#" class="list-group-item" name ="list1">LIST</a>
			<a href="#" class="list-group-item" name ="list2">LIST</a>
            <a href="#" class="list-group-item" name ="list3">See More</a>
          </div>
		<form>
		<br>
		<form>
		  <button type="button" class="btn btn-lg btn-info" name ="query">Send a Query</button> 
		  <br><br><br>
		  <button type="button" class="btn btn-lg btn-success" name="query">Request for Grant</button>
		  <br><br><br>
		  <button type="button" class="btn btn-lg btn-danger" name ="feedbck">FEEDBACK</button>
		 </div>
        </form>
<!--/row-->
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
