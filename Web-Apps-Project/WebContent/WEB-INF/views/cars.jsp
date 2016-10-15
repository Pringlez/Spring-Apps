<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Cars</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
		<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />">
	</head>
	<body>
	    <nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
				  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				    <span class="sr-only">Toggle</span>
				    <span class="icon-bar"></span>
				    <span class="icon-bar"></span>
				    <span class="icon-bar"></span>
				  </button>
				  <a class="navbar-brand" href="/">Spring Web App</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
				  <ul class="nav navbar-nav">
				    <li class="active"><a href="<c:url value="/" />">Home</a></li>
				    <li><a href="<c:url value="/cars" />">Cars</a></li>
					<li><a href="<c:url value="/user/register" />">Register</a></li>
				    <li class="dropdown">
				      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
				      <ul class="dropdown-menu">
				        <li><a href="https://projects.spring.io/spring-framework/">Spring Framework</a></li>
				        <li><a href="https://spring.io/">Spring IO</a></li>
				        <li><a href="http://getbootstrap.com/">Bootstrap</a></li>
				        <li role="separator" class="divider"></li>
				        <li class="dropdown-header">Header</li>
				        <li><a href="http://www.w3schools.com/">W3Schools</a></li>
				        <li><a href="https://github.com/Pringlez/Spring-Apps">Spring Apps</a></li>
				      </ul>
				    </li>
				  </ul>
				</div>
			</div>
	    </nav>
	    <h1 class="pageHeader">Cars Page</h1>
	    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse vitae massa vel magna dictum hendrerit sit amet eu dui. 
	    Nullam dapibus mollis mi a sodales. Sed tempor tincidunt ex sit amet bibendum. Ut ut cursus dolor, vitae vehicula lectus. 
	    Integer ut elit felis. Phasellus finibus libero tellus, ac blandit sapien convallis sit amet. In sed ante leo. 
	    Nam mattis pretium augue, eget vulputate ipsum pretium nec. Pellentesque nec luctus metus.</p>
	    <h2 class="formHeader">Car Form</h2>
		<div class="carForm carFormPadding">
			<form method="POST" name="carForm">
				<div class="form-group">
					<label>Make</label>
	    			<input name="make" class="form-control">
				</div>
				<div class="form-group">
					<label>Model</label>
	    			<input name="model" class="form-control">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
		<br/>
	    <h2>Recent Cars</h2>
	    <table class="table table-striped">
	        <thead>
	            <tr>
	                <th>Make</th>
	                <th>Model</th>
	                <th>Time</th>
	            </tr>
	        </thead>
	        <tbody>
	        	<c:forEach items="${carList}" var="car" >
	        		<tr>
		                <td><c:out value="${car.make}"/></td>
		                <td><c:out value="${car.model}"/></td>
		                <td><c:out value="${car.time}"/></td>
	            	</tr>
	        	</c:forEach>
	        </tbody>
	    </table>
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
	</body>
</html>