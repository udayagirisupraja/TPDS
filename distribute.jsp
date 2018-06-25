<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.bvrit.tpds.dto.CitizenGoods"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
table, th, td {
    border: 1px solid black;
}

.container {
    border-radius: 5px;
    max-width: 600px;
     margin: auto;
    background:#ccc;
    padding: 20px;
}
</style>
</head>

<body background = "back2.jpeg">
<center><h1>GOODS TO BE DISTRIBUTED</h1></center>
<div class = "container">
<table style="width:100%">
  <tr>
    <th bgcolor = "skyblue">Product</th>
    <th bgcolor = "skyblue">Quantity</th> 
     <th bgcolor = "skyblue">Price</th> 
        <c:forEach var="wdGoods" items="${citizenGoods}">
			<tr>
				<td>${wdGoods.productName}</td>
				<td>${wdGoods.qty}</td>
				<td>${wdGoods.price}</td>
				<td><a href="FrontController?action=AdminGoodsEdit">Edit</a></td>
				<td><a href="FrontContoller?action=AdminGoodsDelete">Delete</a></td>
			</tr>		
		</c:forEach> 
    
</table><br><br>
</div>
  <!-- Trigger the modal with a button -->
 <center> <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">addAnotherGood</button></center>

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
                <input type = "hidden" name = "action" value = "AddCitizenGoods">
                <input type = "text" name = "pname"><br><br>
                Quantity:<br>
                <input type = "text" name = "qty"><br><br>
                Price per unit:<br>
                <input type = "text" name = "priceFor"><br><br>
                Product Id :
				<input type = "text" name = "pId"><br><br>
                
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

