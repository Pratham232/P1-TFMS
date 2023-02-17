<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question Management</title>
</head>
<body>

	<jsp:include page="../_header.jsp"></jsp:include>
	<jsp:include page="../menus/_menuAdmin.jsp"></jsp:include>

	<h3 style="text-align: center;">Questions Details</h3>

	<p style="color: red;">${errorString}</p>

	<table border="1" cellpadding="5" cellspacing="1"; style="margin-left: auto;margin-right: auto;">
		<tr>
			<th>Question ID</th>
			<th>Question Section</th>
			<th>Question Text</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.userLogin}</td>
				<td>${user.userPass}</td>
				<td>${user.role}</td>
				<td><a href="editUser?id=${user.userLogin}">Edit</a></td>
				<td><a href="deleteUser?id=${user.userLogin}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<p  style="text-align: center;">
		<a href="addUser">Add New Question</a>
	</p>
	<jsp:include page="../_footer.jsp"></jsp:include>

</body>
</html>