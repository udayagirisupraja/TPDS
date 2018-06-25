<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.bvrit.tpds.dto.DealerGoods"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    max-width: 600px;
     margin: auto;
    background:#ccc;
    padding: 20px;
}

divleft {
    float: left;
    width: 30%;
    height: 500px;
    padding: 20px;
}

divright {
    float: left;
    padding: 20px;
    width: 30%;
    height: 500px;
}

divmiddle {
    float:left;
    padding:20px;
    width:30%;
    height:500px;
}
    
section:after {
    content: "";
    display: table;
    clear: both;
}

table, th, td {
    border: 4px solid black;
    padding: 10px;
}
table {
    border-spacing: 15px;
}

</style>
   
<body background = "five.jpg">
   <section>
   
<h1>SUBSIDARY GOODS</h1>
<divmiddle>
<div class = "container">
<table style="width:50%">
  <tr>
    <th>Good Name</th>
    <th>Quantity</th> 
    <th>Price</th>
    <th>Price Per Unit</th>
  </tr>
  
          <c:forEach var="wdGoods" items="${dealerGoods}">
			<tr>
				<td>${wdGoods.productName}</td>
				<td>${wdGoods.qty}</td>
				<td>${wdGoods.price}</td>
				<td>${wdGoods.priceFor}</td>
			</tr>		
		</c:forEach> 

</table>
</div>
</divmiddle>
   
   
	
</section>
</body>
</html>
   
