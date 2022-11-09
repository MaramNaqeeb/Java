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
	<h1>Home Page</h1>
	<div>
	<a href="/product/new">New Product</a>
	</div>
	<div>
	<a href="/category/new">New Category</a>
	</div>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Products</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${products}">
				<tr>

					<td><a href="/products/${product.id}"><c:out
								value="${product.name }"></a> </c:out></td>
				</tr>
			</c:forEach>
		</tbody>
		</thead>

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Categories</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="category" items="${categories}">
					<tr>

						<td><a href="/categories/${category.id}"><c:out
									value="${category.name }"></a> </c:out></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
</body>
</html>