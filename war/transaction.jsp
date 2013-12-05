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

        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
           <li><a style="color:white; ">IIIT-D Finance Management</a></li>
            <li><a href="/home">Home</a></li>
            <li><a href="/profile">Profile</a></li>
            <li class="active"><a href="#">Transaction</a></li>
            
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
              <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"><img src="images/userPic/<%out.print(profile.getProperty("Email")); %>.jpg"  
			  style="width:20px;height:20px;" class="img-circle" id="navbarimg"> &nbsp;<%out.print(profile.getProperty("Name")); %><b class="caret"></b></a>
              <ul class="dropdown-menu" role = "menu">
                <li><a href="password_change.html">Change Password</a></li>
                <li><a href="mailto:iiitd.finance.management@gmail.com?Subject=Support">Help</a></li>
				<li><a href="mailto:iiitd.finance.management@gmail.com?Subject=Feedback">FeedBack</a></li>
                <li><a href="/logout">Logout</a></li>
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
					<th > Serial No.</th>
					<th> Paid By</th>
					<th> Recieved By</th>
					<th> Amount</th>
					<th> Date</th>
					<th> Description</th>
				</tr>
				
			<%if(trans == null) 
			out.print("<tr>  <td colspan=\"6\" align=\"center\"><h3>No Transactions For You!</h3></td></tr>");
			else
			{
				for(int i=0;i<(trans.size()-1) && i<500 ;i++)
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
			
		<div class="col-sm-1">
		</div>
		
		<div class="col-sm-3">
			<div class="well sidebar-nav">
				<ul class="nav">
					<li><h3>Notifications</h3></li>
					<%if(notify == null)
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
					
			  <div class="well sidebar-nav">
				<ul class="nav">
					  <li>Groups</li>
					  <li><a href="#">Join a Group</a></li>
					  <li><a href="#">Create a Group</a></li>
					  <li><a href="#">See More</a></li>
					  </ul>
			</div>
			<br>
				  <a href="mailto:iiitd.finance.management@gmail.com?Subject=Query"><button type="button" class="btn btn-lg btn-info" name ="query">Send a Query</button></a>
		  <br><br><br>
		  <button type="button" class="btn btn-lg btn-success" name="query">Request for Grant</button>
		  <br><br><br>
		  <a href="mailto:iiitd.finance.management@gmail.com?Subject=Feedback"><button type="button" class="btn btn-lg btn-danger" name ="feedbck">FEEDBACK</button></a>
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
