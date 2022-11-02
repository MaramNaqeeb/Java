<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<h1>Here is your Omikuji</h1>
<p>In <c:out value="${number}"></c:out>  years, you will live in <c:out value="${city}"></c:out> 
<br>
with <c:out value="${person}"></c:out>as your roommate,
<br>
<c:out value="${hobby}"></c:out> for a living. The next time you see a <c:out value="${livingthing}"></c:out>,
<br>
 you will have good luck.Also, <c:out value="${nice}"></c:out>.</p>
<a href="/omikuji"> Go Back</a>

</body>
</html>