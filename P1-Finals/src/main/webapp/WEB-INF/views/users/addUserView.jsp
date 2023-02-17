<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>
	<jsp:include page="../_header.jsp"></jsp:include>
	<jsp:include page="../menus/_menuAdmin.jsp"></jsp:include>

	<h3>Add Question</h3>

	<p style="color: red;">${errorString}</p>

	<form method="POST" action="doAddUser">
		<table border="0">
			<tr>
				<td>Question ID</td>
				<td><input type="text" name="questionid" value="${newUser.userLogin}" /></td>
			</tr>
			<tr>
				<td>Question Section</td>
				<td><input type="text" name="questionsection" value="${newUser.userPass}" /></td>
			</tr>
			<tr>
				<td>Question Text</td>
				<td><input type="text" name="questiontext" value="${newUser.userPass}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" />
				<td><input type="reset" name="rest" value="Reset" /></td>

			</tr>
		</table>
	</form>

	<jsp:include page="../_footer.jsp"></jsp:include>

</body>
</html>