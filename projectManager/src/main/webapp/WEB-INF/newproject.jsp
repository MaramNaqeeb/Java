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
				<div>
					<h1>Create a Project</h1>
					<a href="/projects">back to the shelves</a>
				</div>
				
				<div>
					<div class="container col-10 ">
						<form:form action="/create/project" method="post"
							modelAttribute="project">
							<form:input type="hidden" path="lead" value="${myUser.id}" />
							<p>
								<form:label path="title"> Title</form:label>
								<form:errors path="title"/>
								<form:input path="title" class="form-control mt-4 " />
							</p>
							<p>
								<form:label path="due_date"> Due Date</form:label>
								<form:errors path="due_date" />
								<form:input type="date" path="due_date" class="form-control mt-4 " />
							</p>

							<p>
								<form:label path="description">Description</form:label>
								<form:errors path="description"/>
								<form:input path="description" class="form-control mt-4 " />
							</p>
							
							<input type="submit" value="submit"/>
						
						</form:form>
							<a href="/projects"><button>Cancel</button></a>
							
					</div>
				</div>
			</div>
	
</body>
</html>