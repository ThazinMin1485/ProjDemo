<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
<title>Employee Report</title>
</head>
<body>
	<div class="container mt-3">
		<c:if test="${not empty message}">
			<div class="alert alert-warning alert-dismissible fade show"
				role="alert">${message}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<h2>All Employee</h2>
		<div class="col  d-flex">
			<a href="addEmployee" class="btn btn-secondary mb-3">Add Employee</a>
			<a href="exportEmployee" class="btn btn-secondary mb-3 ml-3">Export
			</a>

			<c:url value="/importEmployee?${_csrf.parameterName}=${_csrf.token}"
				var="empImport"></c:url>
			<form:form action="${empImport}" method="post"
				enctype="multipart/form-data" id="importForm">
				<input type="file" name="file" class="form-control d-none "
					accept=".xlsx" id="importExcel" />
				<label for="importExcel" class="btn btn-secondary mb-3 ml-3">Import<i
					class="fa-solid fa-file-import ms-2"></i></label>
			</form:form>
		</div>
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
					<td><a href="editEmployee/${emp.id}"
						class="btn btn-outline-warning">Edit</a></td>
					<td><a href="deleteEmployee/${emp.id}"
						class="btn btn-outline-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="<c:url value="/logout" />" class="btn btn-warning">Logout</a>
	</div>
	<script src="<c:url value='/resources/js/import.js'/>"></script>
</body>
</html>