<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>


<div class="container col-5">
<h1 >Send an Omikuji</h1>
<form action="/register" method="post">
<div class="form-group">
<label>Pick any number from 5to 25</label>
 <input type="number" class="form-control" id="vol" name="number" min="5" max="25">
 </div>
 <div class="form-group">
<label>Enter the name of any city</label>
<input type="text" class="form-control " name="city">
</div>
<div class="form-group">
<label>Enter the name of any real person</label>
<input type="text" class="form-control " name="person">
</div>
<div class="form-group">
<label>Enter professional endeavor or hobby</label>
<input type="text"  class="form-control " name="hobby">
</div>
<div class="form-group">
<label>Enter any type of living thing</label>
<input type="text" class="form-control " name="livingthing">
</div>
<div class="form-group">
<label>Say something nice to someone</label>
<textarea  name="nice" class="form-control " rows="2" cols="2"></textarea>
</div>
<div class="form-group">
<label>Send and show a friend</label>
<br>
<input type="submit" value="Register" />
</div>

</form>
</div>

</body>
</html>