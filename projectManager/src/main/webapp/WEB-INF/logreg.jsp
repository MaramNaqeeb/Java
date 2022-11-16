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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div>
		<h1>Book Club</h1>
		<p>A place for friends to share their thoughts</p>
	</div>

	<div class="col-5">
		<h1>Register</h1>
		<form:form action="/register" method="post" modelAttribute="newUser">
			<p>
				<form:label path="userName"> User Name</form:label>
				<form:errors path="userName"/>
				<form:input path="userName" class="form-control mt-4" />
			</p>
			<p>
				<form:label path="email"> Email</form:label>
				<form:errors path="email" />
				<form:input type="email" path="email" class="form-control mt-4" />
			</p>

			<p>
				<form:label path="password"> Password</form:label>
				<form:errors path="password" />
				<form:input type="password" path="password"
					class="form-control mt-4" />
			</p>
			<p>
				<form:label path="confirm"> Confirm</form:label>
				<form:errors path="confirm" />
				<form:input type="password" path="confirm" class="form-control mt-4" />
			</p>

			<input type="submit" value="register" />
		</form:form>
	</div>

	<div>

		<div class="col-5">
			<h1>Login</h1>
			<form:form action="/login" method="post" modelAttribute="newLogin">
				</p>
				<p>
					<form:label path="email"> Email</form:label>
					<form:errors path="email" />
					<form:input type="email" path="email" class="form-control mt-4" />
				</p>

				<p>
					<form:label path="password"> Password</form:label>
					<form:errors path="password" />
					<form:input type="password" path="password"
						class="form-control mt-4" />
				</p>
				<input type="submit" value="login" />
			</form:form>

		</div>
	</div>

</body>
</html>