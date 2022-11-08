<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="/create/ninja" method="post" modelAttribute="ninja">
	<h1>
		<c:out value="${dojo.name }"></c:out>
	</h1>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ninja" items="${dojo.getNinjas()}">
				<tr>

					<td><c:out value="${ninja.firstName }"></c:out></td>
					<td><c:out value="${ninja.lastName}"></c:out></td>
					<td><c:out value="${ninja.age }"></c:out></td>
					
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</form:form>
</body>
</html>