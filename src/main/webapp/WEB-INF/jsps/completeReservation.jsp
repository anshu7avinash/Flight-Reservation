<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Details Page</title>
</head>
<body>
	<h2>Complete Reservation Details:</h2>
	<hr><hr>
	Airlines : 		${flight.operatingAirlines}<br>
	Flight Number : ${flight.flightNumber}<br>
	Departure City: ${flight.departureCity}<br>
	Arrival City : 	${flight.arrivalCity}<br>
	
	<hr>
	<form action="completeReservation" method="post">
		
		<h2>Passenger Details : </h2>
		
			First Name: <input type="text" name="passengerFirstName"/><br><br>
			Last Name: 	<input type="text" name="passengerLastName"/><br><br>
			Email: 		<input type="text" name="passengerEmail"/><br><br>
			Phone: 		<input type="text" name="passengerPhone"/><br><br>

		<hr>
		<h2>Card Details : </h2>
			Name on the Card: 	<input type="text" name="nameOnTheCard"/><br><br>
			Card No: 		   	<input type="text" name="cardNumber"/><br><br>
			Expiry Date: 		<input type="text" name="expirationDate"/><br><br>
			CVV Number: 		<input type="text" name="securityCode"/><br><br>
		<br>
		
		<input type="hidden" name="flightId" value="${flight.id }"/>
		
		<input type="submit" value="Confirm"/>
		
	</form>

</body>
</html>