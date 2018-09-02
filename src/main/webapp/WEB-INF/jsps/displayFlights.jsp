<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Flights Page</title>
</head>
<body>
	<form action="displayFlights" method="post">
		<h2>Display Flights:</h2>
		<pre>
	<table>
		<tr>
			<th>Airlines</th>
			<th>Flight Number</th>
			<th>Departure City</th>
			<th>Arrival  City</th>
			<th>Departure Time</th>	
		</tr>
		<hr>
		<c:forEach items="${flights}" var="flight">
		<tr>
			<td>${flight.operatingAirlines}</td>
			<td>${flight.flightNumber}</td>
			<td>${flight.departureCity}</td>
			<td>${flight.arrivalCity}</td>
			<td>${flight.estimatedDepartureTime}</td>
			<td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
		</tr>
		</c:forEach>

	</table>
</pre>


	</form>
</body>
</html>