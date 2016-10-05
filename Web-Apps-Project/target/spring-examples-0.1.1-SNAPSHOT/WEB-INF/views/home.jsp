<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Home</title>
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	</head>
	<body>
		<h1>Welcome to Test App</h1>
		<a href="<c:url value="/cars" />">Cars</a> |
		<a href="<c:url value="/user/register" />">Register</a>
	</body>
</html>