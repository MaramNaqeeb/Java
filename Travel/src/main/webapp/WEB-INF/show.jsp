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
	<h1>Expense Details</h1>



		<p>
			<c:out value="${expense.expenseName }">Expense Name:</c:out>
		</p>
		<p>
			<c:out value="${expense.description}">Expense Description:</c:out>
		</p>
		<p>
			<c:out value="${expense.vendor }">Expense Vendor:</c:out>
		</p>

		<p>
			<c:out value="${expense.amount }">Amount Spent:</c:out>
		</p>

</body>
</html>