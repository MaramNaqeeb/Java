
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
</head>
<body>
	<h1>${product.name}</h1>
	<a href="/">Home</a>

	<c:forEach var="category" items="${product.categories}">
		<p>
			<c:out value="${category.name}"></c:out>
		</p>
	</c:forEach>
	
	   	
 <form action="/products/addcategory" method="post" >  
 <input type="hidden" name="productid" value="${product.id}">	
  <select name="categoryid">
        <c:forEach var="cat" items="${categories}">
        <option value="${cat.id}"><c:out value="${cat.name}"></c:out></option>
    	</c:forEach>
        </select>
        <input type="submit" value="Add">
</form>

</body>
</html>