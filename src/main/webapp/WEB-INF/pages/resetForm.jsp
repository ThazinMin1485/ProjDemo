<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Password Reset</title>
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
	<div class="container mt-3 fodesign">
		<h3>Reset Password</h3>
		<div class="row justify-content-md-center mb-2">
			<div class="col-md-6 p-5 rounded shadow-sm">
				<c:url value="/resetPassword" var="reset" />
				<form:form action="${reset}" method="POST"
					modelAttribute="resetForm" class="form-horizontal">
					<div class="row g-3">

						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<form:hidden path="token" value="${resetForm.token}" />

						<div class="col-12">
							<label for="email" class="form-label">New Password <span
								class="text-danger">*</span></label>
							<form:input type="password" path="password" name="password"
								id="password" placeholder="" class="form-control" />
							<form:errors path="password" class="fadeIn fourth text-danger" />
						</div>
						<div class="col-12">
							<label for="email" class="form-label">Confirm Password <span
								class="text-danger">*</span>
							</label>
							<form:input type="password" path="confirm_password"
								placeholder="" id="confirm_password" class="form-control" />
							<form:errors path="confirm_password"
								class="fadeIn fourth text-danger" />
							<c:if test="${not empty errorMsg }">
								<div class="fadeIn fourth text-danger">${errorMsg }</div>
							</c:if>

						</div>

						<div class="col-12 d-grid text-center my-4">
							<button class="btn btn-primary" type="submit">Change</button>
						</div>
					</div>

				</form:form>
			</div>
		</div>

	</div>

</body>
</html>