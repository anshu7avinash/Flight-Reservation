package com.avinash.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avinash.flightreservation.dto.ReservationRequest;
import com.avinash.flightreservation.entities.Flight;
import com.avinash.flightreservation.entities.Passenger;
import com.avinash.flightreservation.entities.Reservation;
import com.avinash.flightreservation.repos.FlightRepository;
import com.avinash.flightreservation.repos.PassengerRepository;
import com.avinash.flightreservation.repos.ReservationRepository;
import com.avinash.flightreservation.util.EmailUtil;
import com.avinash.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PDFGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;

	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {

		//make payment
		
		//get the flight id and then using the id get the whole flight details
		long flightId = request.getFlightId();
		
		//Store flight details into the var 'flight' --being used for the reservation
		Flight flight = flightRepository.findOne(flightId);
		
		//set the passenger details and save into the db--used for the reservation
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		
		//inject into db
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		
		//create the reservation and set the passenger details and flight details created and saved above
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		//inject the reservation into the database
		Reservation savedReservation = reservationRepository.save(reservation);
		
		
		//send the mail to user with the pdf attachment
		String filePath = "C:/Users/Abc/Documents/reservations/reservation"+savedReservation.getId()+".pdf";	//attachment kept in this file path
		pdfGenerator.generateItinerary(savedReservation, filePath);												
		//generate the attachment - pass the reservation details and file path for attachment
		
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		
		return savedReservation;
	}

}
