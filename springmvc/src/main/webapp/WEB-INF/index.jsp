<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isErrorPage="true"%>
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
		<h1>Houston, we have lift-off</h1>
		<form:form action='/tweet/create' method='POST'
			modelAttribute="newTweet">
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
			<!-- 			<input type='submit' value='Count By This'> -->
			<form:button>Submit</form:button>
		</form:form>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Content</th>
					<th>RandomInteger</th>
					<th>createdAt</th>
					<th>updatedAt</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var='thing' items="${allTheThings}">
					<tr>
						<td><c:out value="${thing.id}"/></td>
						<td><c:out value="${thing.tweetContent}"/></td>
						<td><c:out value="${thing.imaginaryIntAtt}"/></td>
						<td><fmt:formatDate pattern="yyy-MM-dd h:m a" value="${thing.createdAt}"/></td>
						<td><fmt:formatDate pattern="yyy-MM-dd h:m a" value="${thing.updatedAt}"/></td>
						<td><a href="/tweet/edit/${thing.id}">Edit</a> | <a href="/tweet/delete/${thing.id}">Delete</a>
						<form action="/tweet/delete/${thing.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
						</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			
	</div>
</body>
</html>