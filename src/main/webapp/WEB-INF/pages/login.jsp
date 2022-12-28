<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./base.jsp"%>
<title>Login</title>
<style>
.fodesign{
border:1px solid #0000ff;
width:500px;
text-align:center;
margin:100px auto;
padding: 30px 0px 100px;
color:#025add;
background-color:#003050;
}
h3{
font-size:25px;
margin-bottom:50px;
color:#05a0de;
}
.btn{
width:80px;
margin-top:20px;
}
</style>
</head>
<body>
<div class="fodesign">
  <h3>Login Page</h3>
  <font color="red"> ${SPRING_SECURITY_LAST_EXCEPTION.message} </font>
  <form:form action="login" 
    method="post">
    Enter UserName: <input type="text" name="username" /><br /><br />
    Enter Password: <input type="password" name="password" /> <br /><br />
    <input type="submit" value="Login" class="btn btn-outline-primary"/>
  </form:form>
  </div>
</body>
</html>
