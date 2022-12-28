<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
<title>Employee Report</title>
</head>
<body>
	<h2>All Employee</h2>
	<a href="addEmployee" class="btn btn-secondary">Add Employee</a>
	<br>
	<br>
	<table class="table table-hover table-striped">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Department</th>
			<th>Email</th>
			<th>Salary</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="emp" items="${employee}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.department}</td>
				<td>${emp.email}</td>
				<td>${emp.salary}</td>
				<td><a href="editEmployee/${emp.id}" class="btn btn-outline-warning">Edit</a></td>
				<td><a href="deleteEmployee/${emp.id}" class="btn btn-outline-danger">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="<c:url value="/logout" />" class="btn btn-warning">Logout</a>
</body>
</html>