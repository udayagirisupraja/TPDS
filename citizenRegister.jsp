<!DOCTYPE html>
<html lang="en">
<head>
<title>CitizenRegister</title>
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
</head>
 <body  background = "two.jpg">
  <h1>Citizen Registration</h1>
   <divright>
        <div class="container">
             <form action = "FrontController" method = "POST" enctype="multipart/form-data">
        		  <input type = "hidden" name = "action" value = "CitizenRegister">
  				  <input type = "text" name="aadhar" placeholder="AadharId" required="required"><br><br>
				  <input type = "text" name="fname" placeholder="FirstName" required="required">
 				  <input type = "text" name="lname" placeholder="SecondName" required="required"><br><br>
  				  DateOfBirth:<br>
 				  <input type = "date" name = "dob"  required="required"><br><br> 
 				  <input type = "text" name="age" placeholder="Age" required="required"><br><br>
 				  Gender:<br>
 				  <input type = "radio" name="gender" value="Male" >Male
 				  <input type = "radio" name="gender" value="Female">Female
 				  <input type = "radio" name="gender" value="Other">Other<br><br>
  				  <input type = "text" name="phoneNo" placeholder="PhoneNumber" required="required"><br><br>
 				  <input type = "text" name="email" placeholder="EmailId" required="required"><br><br>
  				  <input type = "text" name="oname" placeholder="Occupation" required="required"><br><br>
  				  <input type = "text" name="income" placeholder="Income" required="required"><br><br>
   				  <input type = "file" name="myfile" required="required"><br><br>
  				  <input type = "text" name="nname" placeholder="NoOfFamilyMembers" required="required"><br><br>
  				  <input type = "text" name="wardId" placeholder="WardId" required="required"></br></br>
 				  <input type = "password" name="pwd" placeholder="Password" required="required"><br><br>
  				  <center><input type = "submit" name="sname" value = "Register"></center><br>
 			</form>
		</div>
</divright>
</body>
</html>
   
