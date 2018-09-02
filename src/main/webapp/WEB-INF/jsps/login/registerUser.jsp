<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
</head>
<body>
	<form action="registerUser" method="post">
		<h1>User Registration</h1>
		<hr>
		<pre>
			first Name : <input type="text" name="firstName" /><br>
			Last Name : <input type="text" name="lastName" /><br>
			Email : <input type="text" name="email" /><br>
			Password : <input type="password" name="password" /><br>
			Confirm Password : <input type="password" name="confirmPassword" /><br>
			
			<input type="submit" value="Register" />
			
			<a href="directLogin">Go to Login Page-> </a> 			
						
		</pre>
	</form>


</body>
</html>