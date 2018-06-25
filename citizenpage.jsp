<!DOCTYPE html>
<html lang="en">
<head>
  <title>CitizenPage</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body background = "header2.jpg">

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">TPDS</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#"></a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Profile <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="FrontController?action=CitizenProfileDisplay">Display</a></li>
          <li><a href="FrontController?action=CitizenEdit">Edit</a></li>
          
        </ul>
      </li>
       
    <ul class="nav navbar-nav">
      <li class="active"><a href="#"></a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">FamilyDetails <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="AddFamilyMembers.jsp">AddFamilyMembers</a></li>
          <li><a href="FrontController?action=FamilyMembersDisplay">Display</a></li>     
        </ul>
      </li>
    <ul class="nav navbar-nav navbar-right">    
      <li><a href="tpds.html"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
</body>
</html>

