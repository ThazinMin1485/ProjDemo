<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
<title>Spring MVC</title>
<style>
h3 {
	text-align: center;
	color: #30a0ab;
}

.btn {
	width: 200px;
}

.container {
	margin-top: 100px;
	text-align: center;
}
</style>
</head>
<body>
	<h2>${message }</h2>
	<h3>Home Page</h3>
	<div class="container">
		<div>
			<a href="login" class="btn btn-outline-primary">Login</a>
		</div>
		<br>
		<div>
			<a href="passwordReset" class="btn btn-outline-primary">Password
				Reset</a>
		</div>
		<br>
		<div>
			<a href="employeeReport" class="btn btn-outline-primary">Employee</a>
		</div>
	</div>

</body>
</html>