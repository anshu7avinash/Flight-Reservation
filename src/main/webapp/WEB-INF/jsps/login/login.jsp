<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login Page</title>
</head>
<body>

	<form action="login" method="post">
	
	<h2>User Login:</h2>
	<hr>
		<pre>
			Username: <input type="text" name="email"/>
			Password: <input type="password" name="password"/>
		
		<input type="submit" value="Login"/>
		${msg}
		</pre>
	
	
	</form>

</body>
</html>