<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Register Form</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
		<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />">
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
				  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				    <span class="sr-only">Toggle navigation</span>
				    <span class="icon-bar"></span>
				    <span class="icon-bar"></span>
				    <span class="icon-bar"></span>
				  </button>
				  <a class="navbar-brand" href="#">Bootstrap theme</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
				  <ul class="nav navbar-nav">
				    <li class="active"><a href="<c:url value="/" />">Home</a></li>
				    <li><a href="<c:url value="/cars" />">Cars</a></li>
					<li><a href="<c:url value="/user/register" />">Register</a></li>
				    <li class="dropdown">
				      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
				      <ul class="dropdown-menu">
				        <li><a href="#">Action</a></li>
				        <li><a href="#">Another action</a></li>
				        <li><a href="#">Something else here</a></li>
				        <li role="separator" class="divider"></li>
				        <li class="dropdown-header">Nav header</li>
				        <li><a href="#">Separated link</a></li>
				        <li><a href="#">One more separated link</a></li>
				      </ul>
				    </li>
				  </ul>
				</div>
			</div>
	    </nav>
		<h1>Register</h1>
		<form method="POST">
			First Name: <input type="text" name="firstName" /><br/>
			Last Name: <input type="text" name="lastName" /><br/>
			Email: <input type="text" name="email" /><br/>
			UserName: <input type="text" name="username" /><br/>
			Password: <input type="password" name="password" /><br/>
			<input type="submit" value="Register" />
		</form>
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
	</body>
</html>