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
<div style="display:inline flex; margin-left:13%;">
<a href="/languages">Delete</a>
<a href="/languages">Dashboard</a>
</div>
<div style="margin-left:5%;">
<form:form action="/edit" method="post" modelAttribute="language">
  <input type="hidden" name="_method" value="put">
    <p><form:input type="hidden" path="id" value="${language.id}"/><p>
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

</div>
</body>
</html>