<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

h3 {
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
		<h3>Password Reset Page</h3>
		<form:form action="login" method="post">
    Enter UserName: <input type="text" name="username" />
			<br />
			<br />
			<input type="submit" value="Login" />
		</form:form>
	</div>
</body>
</html>