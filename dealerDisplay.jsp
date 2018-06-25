<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
   <body background = "four.jpg">
 <center><h1>DEALER DETAILS</h1></center>
   <divleft>
   </divleft>
   <divright>
   <div class="container">
                 <form action = "FrontController" method = "POST">
   <input type = "hidden" name = "action" value = "GotoDealerPage">
    AadharId:<br>
   <input type = "text" name="aadharId" readonly="readonly" value = ${DealerData.aadharId}><br><br>
  Firstname:<br>
   <input type = "text" name="fname" readonly="readonly" value = ${DealerData.firstName}><br><br>
  Lastname:<br>   
  <input type = "text" name="lname" readonly="readonly" value = ${DealerData.lastName}><br><br>
   PhoneNO<br>
   <input type = "text" name="phoneNo"  readonly="readonly" value = ${DealerData.phoneNo}><br><br>
   Email Id:<br>
   <input type = "text" name = "email"  readonly="readonly" value = ${DealerData.emailId}><br><br> 
   Gender:<br>
   <input type = "text" name="gender" readonly="readonly" value = ${DealerData.gender}><br><br>
   Date Of Birth:<br>
   <input type = "text" name = "dob" readonly = "readonly" value = ${DealerData.dOB}><br><br>
   Age:<br> 
  <input type = "text" name="age" readonly="readonly" value = ${DealerData.age}><br><br>
WardId:<br>   
<input type = "text" name="wardid" readonly="readonly"  value = ${DealerData.wardId.getwardId()}><br><br>
   Password :<br>
   <input type = "text" name="pwd" readonly="readonly" value = ${DealerData.password}><br><br>
  <center> <input type = "submit" name="submit" value = "GotoHomePage"></center><br>
  </form>
                  
   <form action = "FrontController" method = "POST">
   <input type = "hidden" name = "action" value = "DealerEdit">
   <center> <input type = "submit" name="submit" value = "Edit"></center>
  
   </form>
</div>
</divright>
<divmiddle>
   </divmiddle>
</body>
</html>
   
