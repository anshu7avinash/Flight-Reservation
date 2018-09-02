package com.avinash.flightreservation.services;

import com.avinash.flightreservation.dto.ReservationRequest;
import com.avinash.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
