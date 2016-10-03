<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Car</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
	</head>
	<body>
		<div class="carView">
			<div class="carMake"><c:out value="${car.make}"/></div><br/>
			<div class="carModel"><c:out value="${car.model}"/></div>
			<div><span class="carTime"><c:out value="${car.time}"/></span></div>
		</div>
	</body>
</html>