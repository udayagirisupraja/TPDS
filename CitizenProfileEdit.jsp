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
    max-width: 450px;
     margin: auto;
    background-color: #f2f2f2;
    padding: 20px;
}

divleft {
    float: left;
    width: 19%;
    height: 500px;
    padding: 20px;
}

divright {
    float: left;
    padding: 20px;
    width: 62.824%;
    height: 500px;
}

divmiddle {
    float:left;
    padding:20px;
    width:19%;
    height:500px;
}
    
section:after {
    content: "";
    display: table;
    clear: both;
}

</style>
   <body background="2.png">
  <center><h1>EDIT DETAILS</h1></center>
   <divleft>
   </divleft>
   <divright>
   <div class="container">
   <center><img src = "logo.jpg" style = "width:120px;height:128px;"></center>
   <form action = "FrontController" method = "POST">
          <input type = "hidden" name = "action" value = "GotoCitizenHomePage">
  AadharId:</br>
   <input type = "text" name="aadhar"  value = ${CitizenData.aadharId}></br></br>
  FirstName:</br>
   <input type = "text" name="fname"  value = ${CitizenData.firstName}></br></br>
   SecondName:</br>
   <input type = "text" name="lname"  value = ${CitizenData.lastName}></br></br>
   DateOfBirth:</br>
   <input type = "date" name="dob" required="required" value = ${CitizenData.dOB}></br></br>
   Age:</br>  
   <input type = "text" name="age" value = ${CitizenData.age}></br></br>
   Gender:</br>
   <input type = "text" name="gender" value=${CitizenData.gender}><br><br>
   PhoneNumber:</br>
   <input type = "text" name="phoneNo"   value = ${CitizenData.phoneNo}></br></br>
   EmailId:</br>
   <input type = "text" name="email"   value = ${CitizenData.emailId}></br></br>
   Occupation:</br>
   <input type = "text" name="oname"   value = ${CitizenData.occupation}></br></br>
   Income:</br>
   <input type = "text" name="iname"   value = ${CitizenData.income}></br></br>
   NoOfFamilyMembers:</br>
   <input type = "text" name="nname"   value = ${CitizenData.noOfFamilyMembers}></br></br>
   WardId:</br>
   <input type = "text" name="wardId" value = ${CitizenData.wardId}></br></br>
   Password:</br>
   <input type = "text" name = "pwd"  value = ${Citizen.password}><br><br>
   <center><input type = "submit" name="sname" value = "GotoHomePage"></center></br>
</form>
    <form action = "FrontController" method = "post">
         <input type = "hidden" name = "action" value = "CitizenProfileEdit" >
        <center><input type = "submit" name = "sname"  value = "Change"></center>
    
    </form>
</div>
</divright>
<divmiddle>
   </divmiddle>
</body>
</html>
   