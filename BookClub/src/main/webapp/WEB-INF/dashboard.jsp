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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container my-4">
	<div style="display:flex; justify-content:space-evenly;">
		<h4>Welcome"${myUser.userName}"</h4>
		<a href="/logout">Logout</a>
	</div>
	<div style="display:flex;justify-content:space-evenly;">
		<p>Books from everyone's shelves</p>
		<a href="/book/new">+Add to my shell</a>
	</div>
	</div>
	<div>
		<table class="table  container col-5">
			<thead class="thead-dark">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Title</th>
					<th scope="col">Author Name</th>
					<th scope="col">Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${allbooks}">
					<tr>
						<td><c:out value="${book.id }"></c:out></td>
						<td><a href="/book/${book.id}"><c:out
									value="${book.title }"></c:out></a></td>
						<td><c:out value="${book.author }"></c:out></td>
						<td><c:out value="${book.user.userName}"></c:out></td>
				</c:forEach>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>