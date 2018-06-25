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
   <body background="43.jpg">
   <center><h1> VALIDATION FORM </h1></center>
   <divleft>
   </divleft>
   <divright>
   <div class="container">
   <form>
    AadharId:</br>
   <input type = "text" name="aadhar"></br></br>
  OTP:</br>
   <input type = "text" name="otp"></br></br>
  <center> <input type = "submit" name="submit" value = "Submit"></center>
</div>
</divright>
<divmiddle>
   </divmiddle>
</body>
</html>
   
