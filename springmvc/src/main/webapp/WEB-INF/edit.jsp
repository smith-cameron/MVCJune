<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testing 123...</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="wrapper">
		<h1>Edit a Tweet</h1>
			<form:form action='/tweet/update/${tweetToEdit.id}' method='POST' modelAttribute="tweetToEdit">
<!-- 			<input type="hidden" name="_method" value="put"> -->
			<form:errors path="tweetContent" />
			<div>
				<form:label path="tweetContent">Content:</form:label>
				<form:input type="text" path='tweetContent' />
			</div>
			<form:errors path="imaginaryIntAtt" />
			<div>
				<form:label path="imaginaryIntAtt">Integer:</form:label>
				<form:input type='number' path='imaginaryIntAtt' required='true' />
			</div>
			<!-- <input type='submit' value='Count By This'> -->
			<form:button>Submit</form:button>
		</form:form>
	</div>
</body>
</html>