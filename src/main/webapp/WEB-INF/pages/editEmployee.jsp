<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>

	<div class="container mt-3">

		<h1>Edit Employee Form</h1>
		<form:form action="updateEmployee" method="post">

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="id">Id</label> <input type="text"
							value="${employee.id}" class="form-control" id="id" name="id"
							readonly="readonly">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="name">Name</label> <input type="text"
							value="${employee.name }" class="form-control" id="name"
							name="name" placeholder="Enter Name">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="department">Department</label> <input type="text"
							class="form-control" id="department"
							value="${employee.department }" name="department"
							placeholder="Enter department">
					</div>
				</div>
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="email">Email</label> <input type="text"
								value="${employee.email }" class="form-control" id="email"
								name="email" placeholder="Enter Emaill">
						</div>
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="salary">Salary</label> <input type="number"
							value="${employee.salary }" class="form-control" id="salary"
							name="salary" placeholder="Enter Salary">
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<input type="hidden"
							value="${employee.password }" id="password"
							name="password" >
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<input type="hidden"
							value="${employee.type }" id="type"
							name="type" >
					</div>
				</div>
			</div>


			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>

	</div>
</body>
</html>