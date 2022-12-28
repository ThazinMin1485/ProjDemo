<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deny Page</title>
<style>
h3 {
	font-size: 25px;
	color: #ff0000;
	text-align:center;
}

a {
	text-decoration: none;
	font-size: 20px;
	color: #003080;
	display:block;
	text-align:center;
}
</style>
</head>
<body>
	<h3>You are not authorized to access this page.</h3>
	<a href="<%=request.getContextPath()%>/">Go to Home Page</a>
</body>
</html>