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

	<div class="container-sm mt-5">
		<div class="row justify-content-center">
			<div class="col-md-4 me-5 border p-4 mt-4">
				<div
					style="display: flex; justify-content: space-between; width: 400px">

					<h3>
						<c:out value="${book.title}"></c:out>
					</h3>
					<a href="/books">back to the shelves</a>
				</div>

				<p>
					Here are
					<c:out value="${book.user.userName}"></c:out>
					's thoughts
				</p>


				<p>

					<c:out value="${book.thoughts}"></c:out>
				</p>
				<c:if test="${userId==book.user.id}">
				
					<div style="width: 250px; display: inline-flex;">
						<div>
							<a href="/books/${book.id}/edit" method="post"><input
								type="submit" value="Edit"></a>
						</div>
						<div>
							<form action="/books/${book.id}" method="post">
								    <input type="hidden" name="_method" value="delete">
								    <input type="submit" value="Delete">
							</form>

						</div>
					</div>
				</c:if>
			</div>

		</div>
	</div>
	


</body>
</html>