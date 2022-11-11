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
	<div class="container-sm mt-3">
		<div class="row justify-content-center">
			<div class="col-md-4 me-5 border p-4 mt-4">
				<div>
					<h1>Add a book to your shelf</h1>
					<a href="/books">back to the shelves</a>
				</div>
				
				<div>
					<div class="container col-10 ">
						<form:form action="/create/book" method="post"
							modelAttribute="book">
							<form:input type="hidden" path="user" value="${myUser.id}" />
							<p>
								<form:label path="title"> Title</form:label>
								<form:errors path="title" style="color:red;" />
								<form:input path="title" class="form-control mt-4 " />
							</p>
							<p>
								<form:label path="author"> Author</form:label>
								<form:errors path="author" style="color:red;" />
								<form:input path="author" class="form-control mt-4 " />
							</p>

							<p>
								<form:label path="thoughts"> My Thoughts</form:label>
								<form:errors path="thoughts" style="color:red;" />
								<form:input path="thoughts" class="form-control mt-4 " />
							</p>
							<input type="submit" value="submit" class="btn btn-success btn-sm" />
						</form:form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>