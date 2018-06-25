<!DOCTYPE html>
<html lang="en">
<head>
<title>AdminRegister</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
	{box-sizing: border-box;}
	body {font-family: Verdana, sans-serif;}

	.container {
 	   border-radius: 5px;
 	   max-width: 450px;
       margin: auto;
   	   background-color: #f2f2f2;
       padding: 20px;
    }
    divleft {
   	   float: left;
       width: 15%;
       height: 300px;
       background: white;
       padding: 20px;
    }
    divright {
    float: left;
       padding: 20px;
       width: 62.824%;
   	   background-color: palepink;
       height: 500px;
    }
    divmiddle {
        float:left;
    	padding:20px;
    	width:15%;
    	background:white;
    	height:300px;
    }
    section:after {
    	content: "";
    	display: table;
    	clear: both;
    }

</style>
 <body background = "15.jpg">
 <center><h1><b>Admin Registration</b></h1></center>
    <divright>
 		  <div class="container">
   				<form action = "FrontController" method = "POST">
   					<input type = "hidden" name = "action" value = "AdminRegister">
   					<input type = "text" name="userName" placeholder="username" required="required"><br><br>
   					<input type = "password" name="pwd" placeholder="Password" required="required"><br><br>
   					<input type = "hidden" name = "action" value = "AdminRegister" required="required">
   					<center><input type = "submit" name="sname" value = "Register"></center><br>
 				 </form>
		</div>
	</divright>
</body>
</html>
   
