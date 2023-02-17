<%@page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomePage</title>
</head>
<body>
	<jsp:include page="../_header.jsp"></jsp:include>
	<jsp:include page="../menus/_menuAdmin.jsp"></jsp:include>
	<h3>Hello! This is "Training Feedback Management System"</h3>
	These are the operations that you can perform on this module.
	<br>
	<b>It includes the following functions in Question Data:</b>
	<ul>
		<li>Login as Admin</li>
		<li>Log Out</li>
		<li>Add Questions
		<li>Edit Questions</li>
		<li>Delete Questions</li>
	</ul>
	<jsp:include page="../_footer.jsp"></jsp:include>
</body>
</html>
