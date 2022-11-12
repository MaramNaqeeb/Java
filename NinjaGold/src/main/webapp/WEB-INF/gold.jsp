<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div>
		<label> Your Gold</label> <input type="number" value="${gold}">
	</div>
	<div class="boxes">
		<div>
			<form action="/golds" method="post">
				<input type="hidden" value="farm" name="action"> <label>Farm</label>
				<span>earns 10-20 </span>
				<button>Find Gold</button>
			</form>
		</div>
		<div>
			<form action="/golds" method="post">
				<input type="hidden" value="cave" name="action"> <label>
					Cave</label> <span>earns 10-20 </span>
				<button>Find Gold</button>
			</form>
		</div>
		<div>
			<form action="/golds" method="post">
				<input type="hidden" value="house" name="action"> <label>
					House</label> <span>earns 10-20 </span>
				<button>Find Gold</button>
			</form>
		</div>
		<div>
			<form action="/golds" method="post">
				<input type="hidden" value="quest" name="action"> <label>
					Quest</label> <span>earns/takes 0-50 </span>
				<button>Find Gold</button>
			</form>
		</div>
	</div>
	<div>
		<label> Activities</label>
		<textarea name=" activities" cols="10" rows="10">
		
<c:forEach var="activity" items="${activities}">
        <c:out value="${activity}"></c:out>
    </c:forEach></textarea>

	</div>

</body>
</html>