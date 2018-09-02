<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find Flights Page</title>
</head>
<body>
	<h2>Search Flights :</h2>
	<form action="findFlights" method="post">
		<pre>
		
		From: <input type="text" name="from"/>
		To: <input type="text" name="to"/>
		Departure Date: <input type="text" name="departureDate"/>
		
		<input type="submit" value="Search"/>

		</pre>

	</form>
</body>
</html>