<!DOCTYPE html>
<html lang="en">
<head>
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
   <body background = "six.png">
 <center><h1>EDIT DETAILS</h1></center>
   <divleft>
   </divleft>
   <divright>
   <div class="container">
          <form action = "FrontController" method = "post">
   <input type = "hidden" name = "action" value = "DealerProfileEdit">
    AadharId:<br>
   <input type = "text" name="aadharId" value = ${DealerData.aadharId}><br><br>
  Firstname:<br>
   <input type = "text" name="fname" value = ${DealerData.firstName}><br><br>
  lastname:<br>   
  <input type = "text" name="lname" value = ${DealerData.lastName}><br><br>
   PhoneNO<br>
   <input type = "text" name="phoneNo" value = ${DealerData.phoneNo}><br><br>
   Email Id:<br>
   <input type = "text" name = "email" value = ${DealerData.emailId}><br><br> 
   Gender:<br>
   <input type = "text" name="gender" value = ${DealerData.gender}><br><br>
   Date Of Birth:<br>
   <input type = "dob" name="dob" value = ${DealerData.dOB}><br><br>
   Age:<br> 
  <input type = "text" name="age" value = ${DealerData.age}><br><br>
WardId:<br>   
<input type = "text" name="wardid" value = ${DealerData.wardId}><br><br>
   Password :<br>
   <input type = "text" name="pwd" value = ${DealerData.password}><br><br>
  <center> <input type = "submit" name="submit" value = "Change"></center>
  </form>
  <form action = "FrontController" method = "post">  
   <input type = "hidden" name = "action" value = "GotoDealerPage">
     <center> <input type = "submit" name="submit" value = "GotoHomePage"></center>
   </form>
  
</div>
</divright>
<divmiddle>
   </divmiddle>
</body>
</html>
   
