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
	<div class="container my-4">
		<div style="display: flex; justify-content: space-evenly;">
			<h4>Welcome"${myUser.userName}"</h4>
			<a href="/logout">Logout</a>
		</div>
		<div style="display: flex; justify-content: space-evenly;">
			<p>Books from everyone's shelves</p>
			<a href="/book/new">+Add to my shell</a>
		</div>
	</div>
	<div>
		<table class="table container col-5">
			<thead class="thead-dark">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Title</th>
					<th scope="col">Author Name</th>
					<th scope="col">Owner</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${mybooks2}">
					<tr>
						<td><c:out value="${book.id }"></c:out></td>
						<td><a href="/book/${book.id}"><c:out
									value="${book.title }"></c:out></a></td>
						<td><c:out value="${book.author }"></c:out></td>
						<td><c:out value="${book.user.userName}"></c:out></td>  



						<c:if test="${myUser.id==book.user.id}">
							<td style="display:inline-flex;"><a href="/books/${book.id}/edit">edit</a>
							<form action="/books/${book.id}" method="post">
								    <input type="hidden" name="_method" value="delete">
								    <input type="submit" value="Delete"></form></td>
						</c:if>
						<c:if test="${userId!=book.user.id}">
							<td><a href="/bookmarket/${book.id}">borrow</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div>
		<table class="table container col-5">
			<thead class="thead-dark">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Title</th>
					<th scope="col">Author Name</th>
					<th scope="col">Owner</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${borrower}">
						
				            <tr>
						<td><c:out value="${book.id }"></c:out></td>
						<td><a href="/book/${book.id}"><c:out
									value="${book.title }"></c:out></a></td>
						<td><c:out value="${book.author }"></c:out></td>
						<td><c:out value="${book.user.userName}"></c:out></td>  

						
						<td><a href="/bookmarket/remove/${book.id}">return</a></td>
					</tr>
				       
				       
					
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>