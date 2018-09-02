package com.avinash.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avinash.flightreservation.dto.ReservationUpdateRequest;
import com.avinash.flightreservation.entities.Reservation;
import com.avinash.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id")long id){
		return reservationRepository.findOne(id);
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request){
		Reservation reservation = reservationRepository.findOne(request.getId());
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		return reservationRepository.save(reservation);
	}
	
	//response body - it tells the spring at the run time that this object should be created with the content that comes
	//in the request. (mostly json/xml)
}
