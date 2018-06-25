<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.bvrit.tpds.dto.FamilyMembers"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
    border: 2px solid black;
}
.container {
    border-radius: 5px;
    max-width: 450px;
    height:200px;
     margin: auto;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
</head>
<body>


<center><h1>Family Members</h1></center>
<div class="container">

<body background = "header.jpeg">
<table style="width:100%">
  <tr>
    <td bgcolor = "green">FirstName</td>
    <td bgcolor = "green">LastName</td>
    <td bgcolor = "green">Edit</td>
    <td bgcolor = "green">Delete</td>
  </tr>
  
  		<c:forEach var="familyMember" items="${FamilyMembers}">
			<tr>
				<td>${familyMember.firstName}</td>
				<td>${familyMember.lastName}</td>
				<td><a href="FrontController?action=FamilyMemberEdit">Edit</a></td>
				<td><a href="FrontContoller?action=FamilyMemberDelete">Delete</a></td>
			</tr>		
		</c:forEach>
</table>
<center>&#8594<a href = "FrontController?action=AddFamilyMember">AddFamilyMember</a></br></br></center>
</div>

</body>
</html>
