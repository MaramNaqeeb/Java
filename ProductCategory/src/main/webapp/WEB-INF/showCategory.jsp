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
	<h1>${category.name}</h1>

	<c:forEach var="product" items="${category.products}">
		<p>
			<c:out value="${product.name}"></c:out>
		</p>
	</c:forEach>


	<form action="/categories/addproduct" method="post">
		<input type="hidden" name="categoryid" value="category.id"/>
		<select name="productid">
			<c:forEach var="pro" items="${products}">
				<option value="${pro.id}">
					<c:out value="${pro.name}"></c:out>
				</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add">
	</form>
</body>
</html>