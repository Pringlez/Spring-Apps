<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Profile</title>
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	</head>
	<body>
		<h1>Your Profile</h1>
		<c:out value="${profile.username}" /><br/>
    	<c:out value="${profile.firstName}" /> <c:out value="${profile.lastName}" /><br/>
    	<c:out value="${profile.email}" />
	</body>
</html>