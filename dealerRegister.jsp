<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>login</title>
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
        
        height:300px;
    }
    section:after {
        content: "";
        display: table;
        clear: both;
    }
</style>
</head>
<center><h1>Dealer Registration</h1></center>
<body background ="22.jpg">
   <divleft>
   </divleft>
   <divright>
        <div class="container">
               <form action = "FrontController" method = "POST" enctype="multipart/form-data">
                   <input type = "hidden" name = "action" value = "DealerRegister">
      			   <input name="aadharId" placeholder="AadharId" type="text" required="required"><br><br>
    		       <input name="fname" placeholder="FirstName" type="text" required="required">
  			       <input name="lname" placeholder="SecondName" type="text" required="required"><br><br>
    		        DateOfBirth:<br>
      			   <input name="dob" type="date" required="required"><br><br> 
    		       <input name="age" placeholder="Age" type="text" required="required"><br><br>
        		   Gender:<br>
     		       <input name="gender" value="Male" type="radio">Male
    		       <input name="gender" value="Female" type="radio">Female
   		           <input name="gender" value="Other" type="radio">Other<br><br>
   			       <input name="phoneNo" placeholder="PhoneNumber" type="text" required="required"><br><br>
   			       <input name="email" placeholder="EmailId" type="text" required="required"><br><br>
   			       <input name="wardid" placeholder="id" type="text" required="required"><br><br>   
    		       Photo:
   			       <input name="picture" placeholder="Select the picture" type="file" required="required"><br><br>
  			       <input name="pwd" placeholder="Password" type="password" required="required"><br><br>
  			       <center><input name="sname" value="Register" type="submit" required="required"></center><br>
  				  </form>
			</div>
	</divright>
	<divmiddle>
   </divmiddle>
</body>
</html>