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
			<h4>Welcome"${myUser.userName}"</h4>
			<a href="/logout">Logout</a>
		</div>
		<div>
			<h3>All Projects</h3>
			<a href="/project/new">+Add to my shell</a>
		</div>
	</div>
	<div>
		<table class="table">
			<thead class="thead-dark">
				<tr>

					<th scope="col">Project</th>
					<th scope="col">Team Lead</th>
					<th scope="col">Due Date</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="project" items="${projects}">
					<c:if test="${myUser.id!=project.lead.id}">
						<tr>

							<td><a href="/project/${project.id}"><c:out
										value="${project.title }"></c:out></a></td>

							<td><c:out value="${project.lead.userName}"></c:out></td>
							<td><c:out value="${project.due_date}"></c:out></td>
							<td><a href="/join/${project.id}">join team</a></td>
					</c:if>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
<!-- 	user.getProjects1().!(contains(project)) -->
		<h3>Your Projects</h3>
		<table class="table">
			<thead class="thead-dark">
				<tr>

					<th scope="col">Project</th>
					<th scope="col">Team Lead</th>
					<th scope="col">Due Date</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach var="project" items="${myUser.getProjects1()}">


						<td><a href="/project/${project.id}"><c:out
									value="${project.title }"></c:out></a></td>

						<td><c:out value="${project.lead.userName}"></c:out></td>
						<td><c:out value="${project.due_date}"></c:out></td>
						<c:choose>
						<c:when test="${myUser.id==project.lead.id}">

								<td><a href="/projects/${project.id}/edit">edit</a></td>

								<br />
							</c:when>
							<c:otherwise>


								<td><a href="/leave/${project.id}">Leave Team</a></td>
								
								<br/>
								
							</c:otherwise>
						</c:choose>
					
				</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>