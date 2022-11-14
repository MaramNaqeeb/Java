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
	<div class="container my-3">
		<h1>Book Club</h1>
		<p>A place for friends to share their thoughts</p>
	</div>
	<div class="container-sm mt-3">
		<div class="row justify-content-center">
			<div class="col-md-4 me-5 border p-4 mt-4">
				<h1>Register</h1>
				<form:form action="/register" method="post" modelAttribute="newUser">
					<p>
						<form:label path="userName"> User Name</form:label>
						<form:errors path="userName" style="color:red;" />
						<form:input path="userName" class="form-control mt-4" />
					</p>
					<p>
						<form:label path="email"> Email</form:label>
						<form:errors path="email" style="color:red;" />
						<form:input type="email" path="email" class="form-control mt-4" />
					</p>

					<p>
						<form:label path="password"> Password</form:label>
						<form:errors path="password" style="color:red;" />
						<form:input type="password" path="password"
							class="form-control mt-4" />
					</p>
					<p>
						<form:label path="confirm"> Confirm</form:label>
						<form:errors path="confirm" style="color:red;" />
						<form:input type="password" path="confirm"
							class="form-control mt-4" />
					</p>

					<input type="submit" value="register"
						class="btn btn-success btn-sm" />
				</form:form>
			</div>

			<div class="col-md-4 me-5 border p-4 my-4">

				<div>
					<h1>Login</h1>
					<form:form action="/login" method="post" modelAttribute="newLogin">
						</p>
						<p>
							<form:label path="email"> Email</form:label>
							<form:errors path="email" style="color:red;" />
							<form:input type="email" path="email" class="form-control mt-4" />
						</p>

						<p>
							<form:label path="password"> Password</form:label>
							<form:errors path="password" style="color:red;" />
							<form:input type="password" path="password"
								class="form-control mt-4" />
						</p>
						<input type="submit" value="login" class="btn btn-success btn-sm" />
					</form:form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>