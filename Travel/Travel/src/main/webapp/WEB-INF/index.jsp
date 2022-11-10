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


	<h1>Save Travels</h1>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">ExpenseName</th>
				<th scope="col">Vendor</th>
				<th scope="col">Amount</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="expense" items="${allExpenses}">
				<tr>

					<td><c:out value="${expense.getExpenseName() }"></c:out></td>
					<td><c:out value="${expense.getVendor() }"></c:out></td>
					<td><c:out value="${expense.getAmount() }"></c:out></td>
					<td><a href="/expense/${expense.id}">Edit</a></td>
					<td><form action="/expense/${expense.id}" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="Delete">
						</form></a></td>
			</c:forEach>
			</tr>
		</tbody>
	</table>

	<h2>Add An Expense:</h2>
	<h4>Description must not be blank</h4>
	<form:form action="/create" method="post" modelAttribute="expense">
		<p>
			<form:label path="expenseName">Expense Name</form:label>
			<form:errors path="expenseName" />
			<form:input path="expenseName" />
		</p>
		<p>
			<form:label path="vendor">Vendor</form:label>
			<form:errors path="vendor" />
			<form:input path="vendor" />
		</p>
		<p>
			<form:label path="amount">Amount</form:label>
			<form:errors path="amount" />
			<form:input type="number" path="amount" />
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:errors path="description" />
			<form:textarea path="description" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>