<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Example App</title>
		<link rel="stylesheet"
		type="text/css"
		href="<c:url value="/resources/style.css" />" >
	</head>
	<body>
		<h1>Welcome to Example App</h1>
		<a href="<c:url value="/example" />">Example App</a> |
		<a href="<c:url value="/example/register" />">Register</a>
	</body>
</html>