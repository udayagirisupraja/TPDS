<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.bvrit.tpds.dto.FamilyMembers"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
    border: 1px solid black;
}

.container{
   border-radius: 5px;
    max-width: 600px;
     margin: auto;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
</head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body background = "th2WYGWCY5.jpg">
<center><h1>SubsidaryGoods</h1></center>
<div class = "container">
<table style="width:100%">
  <tr>
    <th bgcolor = "skyblue">Product</th>
    <th bgcolor = "skyblue">Quantity</th>  
    <th bgcolor = "skyblue">Price</th> 
    <th bgcolor = "skyblue">Price per unit</th>  
    <th bgcolor = "skyblue">Edit</th>
    <th bgcolor = "skyblue">Delete</th>
    </tr>
 
      <c:forEach var="adGds" items="${adminGoods}">
			<tr>
				<td>${adGds.name}</td>
				<td>${adGds.qty}</td>
				<td>${adGds.price}</td>
				<td>${adGds.priceFor}</td>
				<td><a href="FrontController?action=AdminGoodsEdit">Edit</a></td>
				<td><a href="FrontContoller?action=AdminGoodsDelete">Delete</a></td>
			</tr>		
		</c:forEach>    
</table><br><br>
</div><br>

  <!-- Trigger the modal with a button -->
  <center><button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">addGoods</button><center>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">AddGood</h4>
        </div>
        <div class="modal-body">
           Product:<br>
              <form action = "FrontController" method = "post">
                <input type = "hidden" name = "action" value = "AddAdminGoods">
                <input type = "text" name = "pname"><br><br>
                Quantity:<br>
                <input type = "text" name = "qty"><br><br>
                Price:<br>
                <input type = "text" name = "price"><br><br>
                Price per unit:<br>
                <input type = "text" name = "priceFor"><br><br>
             	<button type="submit" class="btn btn-primary">Submit</button>
             	</form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      </div>

</body>
</html>

