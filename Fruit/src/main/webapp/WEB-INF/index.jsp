<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th> Name</th> 
<th> Price</th>
</tr>
<tr>
<c:forEach var="one" items="${myFruit}">
<td><c:out value="${one.name}"></c:out></td>
<td><c:out value="${one.price}"></c:out></td>
 </c:forEach>
</tr>
</table>

        
</body>
</html>