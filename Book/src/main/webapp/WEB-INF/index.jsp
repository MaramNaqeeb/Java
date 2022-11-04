<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>All Books</h1>
	<table>
		<thread>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Language</th>
			<th>Pages</th>
		</tr>
		</thread>
		<tbody>
		<tr>
			<c:forEach var="one" items="${books}">
				<td><c:out value="${one.id}"></c:out></td>
				<td><a href="/books/${one.id}"></a><c:out value="${one.title}"></c:out></td>
				<td><c:out value="${one.language}"></c:out></td>
				<td><c:out value="${one.numOfPages}"></c:out></td>
			</c:forEach>
		</tr>
		</tbody>
	</table>
</body>
</html>