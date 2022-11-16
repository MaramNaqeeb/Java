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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<div>
		<div
			style="display: flex; justify-content: space-between; width: 400px">
			<h1>Project Details</h1>
			
			<a href="/projects">back to the shelves</a>
		</div>

		<p>
		
			project:<c:out value="${project.title}"></c:out>
	
			
		</p>


		<p>

			Description: <c:out value="${project.description}"></c:out>
		</p>
		<p>

			Due Date: <c:out value="${project.due_date}"></c:out>
		</p>
		<c:if test="${userId==project.lead.id}">

			<div style="width: 250px; display: inline-flex;">
				<div>
					<a href="/projects/${project.id}/edit" method="post"><input
						type="submit" value="Edit"></a>
				</div>
				<div>
					<form action="/projects/${project.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
					</form>

				</div>
			</div>
		</c:if>
	</div>





</body>
</html>