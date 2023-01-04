<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Password Reset</h2>
	<form:form action="processEmail" method="post"
		modelAttribute="employee">
		<form:label path="name">Email</form:label>
		<form:input path="email" class="form-control"
			placeholder="Enter email" />
		<form:errors path="email" cssClass="text-danger" />
		<button type="submit" class="btn btn-primary">Send</button>

	</form:form>
</body>
</html>