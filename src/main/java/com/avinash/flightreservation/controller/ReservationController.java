package com.avinash.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.avinash.flightreservation.dto.ReservationRequest;
import com.avinash.flightreservation.entities.Flight;
import com.avinash.flightreservation.entities.Reservation;
import com.avinash.flightreservation.repos.FlightRepository;
import com.avinash.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") long flightId, ModelMap modelMap) {
		Flight flight = flightRepository.findOne(flightId);
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}
	
	@RequestMapping(value="/completeReservation", method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap){
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully. "+reservation.getId());
		
		return "reservationConfirmation";
	}
}
