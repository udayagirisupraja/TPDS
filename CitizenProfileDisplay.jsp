<!DOCTYPE html>
<html lang="en">
<head>
<title>login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>

{box-sizing: border-box;}
body {font-family: Verdana, sans-serif;}

.container {
    border-radius: 5px;
    max-width: 500px;
     margin: auto;
     background-color: #f2f2f2;
    padding: 20px;
}

divleft {
    float: left;
    width: 20%;
    height: 500px;
    padding: 20px;
}

divright {
    float: left;
    padding: 30px;
    width: 62.824%;
    height: 500px;
}

divmiddle {
    float:left;
    padding:20px;
    width:15%;
    height:500px;
}
    
section:after {
    content: "";
    display: table;
    clear: both;
}

</style>
   <body background="12.jpg">
  <center><h1>PROFILE DISPLAY</h1></center>
   <divleft>
   </divleft>
   <divright>
   <div class="container">
   <center><img src = "logo.jpg" style = "width:120px;height:128px;"></center>
   <form action = "FrontController" method = "POST">
   <input type = "hidden" name = "action" value = "GotoCitizenHomePage">
   AadharId:</br>
   <input type = "text" name="aadhar"  readonly = "readonly"   value = ${CitizenData.aadharId}></br></br>
   FirstName:</br>
 <input type = "text" name="fname" readonly = "readonly"   value = ${CitizenData.firstName}><br></br>
   LastdName:</br>
   <input type = "text" name="lname" readonly = "readonly"   value = ${CitizenData.lastName}></br></br>
   DateOfBirth:</br>
   <input type = "text" name="dob" readonly = "readonly"  class = "Date" required="required" value = ${CitizenData.dOB}></br></br>
   Age:</br>
   <input type = "text" name="age"  readonly = "readonly"   value = ${CitizenData.age}></br></br>
   Gender:</br>
   <input type = "text" name="gender" readonly = "readonly"  value=${CitizenData.gender}></br></br>
   PhoneNo:</br>
   <input type = "text" name="phoneNo"readonly = "readonly" value = ${CitizenData.phoneNo}></br></br>
   EmailId:</br>
   <input type = "text" name="email" readonly = "readonly" value = ${CitizenData.emailId}></br></br>
   Occupation:</br>
   <input type = "text" name="oname"readonly = "readonly"  value = ${CitizenData.occupation}></br></br>
   Income:</br>
   <input type = "text" name="iname" readonly = "readonly"  value = ${CitizenData.income}></br></br>
   NoOfFamilyMembers:</br>
   <input type = "text" name="nname"  readonly = "readonly"   value = ${CitizenData.noOfFamilyMembers}></br></br> 
   WardId:</br>
   <input type = "text" name="wardId" readonly = "readonly"  value = ${CitizenData.wardId}><br></br>
   Password:</br>
   <input type = "text" name = "pwd" readonly = "readonly"value = ${Citizen.password}><br><br>
   <center><input type = "submit" name="sname" value = "GotoHomePage"></center></br>
</form>
   <form action = "FrontController" method = "post">
        <center>  <input type = "hidden" name = "action" value = "CitizenEdit">
         <input type = "submit" name="sname" value = "Edit"><br> </center>
   </form>
</div>
</divright>
<divmiddle>
   </divmiddle>
</body>
</html>
   