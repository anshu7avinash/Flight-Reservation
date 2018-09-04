<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Flight Page</title>
</head>
<body>
<h2>Add Flights </h2>
<hr>

<pre>

<form action="addFlight" method="post">
	Flight Number : <input type="text" name="flightNumber"/><br>
	Departure City : <input type="text" name="departureCity"/><br/>
	Arrival City : <input type="text" name="arrivalCity"/><br/>

<input type="submit" value="Add Flight"/>
${msg}

</pre>

</form>
</body>
</html>