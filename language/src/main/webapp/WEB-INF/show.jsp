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
<div style="margin-left:15%"><a href="/languages">Dashboard</a></div>
<div style="margin-left:5%" >
<p><c:out value="${language.name}"></c:out></p>
<p><c:out value="${language.creator}"></c:out></p>
<p><c:out value="${language.version}"></c:out></p>

<div><a href="/languages">Edit</a></div>
<div><a href="/languages">Delete</a></div>
</div>
</body>
</html>