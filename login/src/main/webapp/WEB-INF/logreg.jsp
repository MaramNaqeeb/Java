<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome</h1>
	<p>Join your growing community</p>
	<div>
		<h1>Login</h1>
		<form:form action="/login" method="post" modelAttribute="newLogin">
			</p>
			<p>
				<form:label path="email"> Email</form:label>
				<form:errors path="email" />
				<form:input type="email" path="email" />
			</p>

			<p>
				<form:label path="password"> Password</form:label>
				<form:errors path="password" />
				<form:input type="password" path="password" />
			</p>
			<input type="submit" value="login" />
		</form:form>
	</div>
	<div>
		<h1>Register</h1>
	<form:form action="/register" method="post" modelAttribute="newUser">
		<p>
			<form:label path="userName"> User Name</form:label>
			<form:errors path="userName" />
			<form:input path="userName" />
		</p>
		<p>
			<form:label path="email"> Email</form:label>
			<form:errors path="email" />
			<form:input type="email" path="email" />
		</p>

		<p>
			<form:label path="password"> Password</form:label>
			<form:errors path="password" />
			<form:input type="password" path="password" />
		</p>
		<p>
			<form:label path="confirm"> Confirm</form:label>
			<form:errors path="confirm" />
			<form:input type="password" path="confirm" />
		</p>

		<input type="submit" value="register" />
	</form:form>
	</div>
</body>
</html>