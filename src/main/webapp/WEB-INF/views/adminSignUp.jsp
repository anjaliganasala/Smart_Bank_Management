<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
</head>
<body>
	
	<div style="text-align: center">
		<h2>SignUp Form</h2>
		<form action="${pageContext.request.contextPath }/admin/signUp" method="post">
			<label>FullName:</label>
			<input type="text" name="fullName" required="required"/><br><br>
			<label>Email:</label>
			<input type="email" name="email" required="required"/><br><br>
			<label>Password:</label>
			<input type="password" name="password" required="required"/><br><br>
			<label>Branch Secret Code:</label>
			<input type="text" name="secretCode" required="required"/><br><br>
			<input type="submit" value="SignUp" />
		</form>
	</div>
</body>
</html>