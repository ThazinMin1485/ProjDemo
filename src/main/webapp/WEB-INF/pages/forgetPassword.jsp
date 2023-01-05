<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="./base.jsp"%>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<style>
.fodesign {
	border: 1px solid #0000ff;
	width: 500px;
	text-align: center;
	margin: 100px auto;
	padding: 30px 0px 100px;
	color: #025add;
	background-color: #003050;
}

h2 {
	font-size: 25px;
	margin-bottom: 50px;
	color: #05a0de;
}

.btn {
	width: 80px;
	margin-top: 20px;
}
</style>
</head>
<body>
	<div class="fodesign">
		<h2>Forgot Password</h2>
		<form:form action="processEmail" method="post"
			modelAttribute="resetForm">
			<form:label path="email">Email</form:label>
			<form:input path="email" placeholder="Enter email" />
			<form:errors path="email" cssClass="text-danger" /><br /><br />
			<button type="submit" class="btn btn-primary">Send</button>

		</form:form>
	</div>
</body>
</html>