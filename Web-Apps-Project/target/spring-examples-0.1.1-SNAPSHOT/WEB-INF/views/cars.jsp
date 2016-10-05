<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Cars</title>
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	</head>
	<body>
		<div class="carForm">
			<h1>Enter Car Details</h1>
			<form method="POST" name="carForm">
				<textarea name="make" cols="80" rows="5"></textarea><br/>
				<textarea name="model" cols="80" rows="5"></textarea><br/>
				<input type="submit" value="Add" />
			</form>
		</div>
		<div class="listTitle">
			<h1>Recent Cars</h1>
			<ul class="carList">
				<c:forEach items="${carList}" var="car" >
					<li id="car_<c:out value="car.id"/>">
						<div class="carMake"><c:out value="${car.make}"/></div>
						<div class="carModel"><c:out value="${car.model}"/></div>
						<div>
							<span class="carTime"><c:out value="${car.time}"/></span>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</body>
</html>