<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>
	<h2>Employee Form</h2>
	<form:form method="POST" action="insertEmployee" modelAttribute="employee">
		<table>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="department">Department</form:label></td>
				<td><form:input path="department" /></td>
				<td><form:errors path="department" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="salary">Salary</form:label></td>
				<td><form:input path="salary" /></td>
			</tr>
			<tr>
			<td><a href="${pageContext.request.contextPath }/"> Back </a></td>
				<td ><input type="submit" value="Submit" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>