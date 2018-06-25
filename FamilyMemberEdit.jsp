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
   <body background="15.jpg">
 <center><h1>FAMILY MEMBER</h1></center>
   <divleft>
   </divleft>
   <divright>
   <div class="container">
   <form action = "FrontController" method = "post">
   <input type = "hidden" name = "action" value = "AddFamilyMembers">
    AadharId:</br>
   <input type = "text" name="aadhar" value = ${FamilyMembersData.aadharId}></br></br>
  Firstname:</br>
   <input type = "text" name="fname" value = ${FamilyMembersData.firstName}></br></br>
  lastname:</br>   
  <input type = "text" name="lname" value = ${FamilyMembersData.lastName}></br></br>
   DateOfBirth:</br>
   <input type = "date" name = "dob"  value = ${FamilyMembersData.dOB}></br></br> 
   Age:<br>
   <input type = "text" name="age" value = ${FamilyMembersData.age}></br></br>
   Gender:<br> 
     <input type = "radio" name="gender" value = "Male">Male
     <input type = "radio" name="gender" value = "Female">Female
     <input type = "radio" name="gender" value = "Others">Others<br><br>

Occupation</br>   
<input type = "text" name="oname" value = ${FamilyMembersData.occupation}></br></br>

  <center> <input type = "submit" name="submit" value = "Submit"></center>
  </form>
</div>
</divright>
<divmiddle>
   </divmiddle>
</body>
</html>
   
