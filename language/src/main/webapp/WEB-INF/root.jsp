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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<table class="table col-8">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Creator</th>
				<th scope="col">Version</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="language" items="${allLanguages}">
				<tr>

					<td><a href="/languages/${ language.id}"><c:out value="${language.name}"></c:out></a></td>
					<td><c:out value="${language.creator}"></c:out></td>
					<td><c:out value="${language.version }"></c:out></td>
					<td style="display:inline-flex;"><form action="/languages/${language.id}" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="Delete">
						</form>
					<a href="/languages/edit/${language.id}">Edit</a></td>
					
			</c:forEach>
			</tr>
		</tbody>
	</table>
	<form:form action="/create" method="post" modelAttribute="language">
		<p>
			<form:label path="name"> Name</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="creator">creator</form:label>
			<form:errors path="creator" />
			<form:input path="creator" />
		</p>
		<p>
			<form:label path="version">Version</form:label>
			<form:errors path="version" />
			<form:input type="number" path="version" />
		</p>
		
		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>