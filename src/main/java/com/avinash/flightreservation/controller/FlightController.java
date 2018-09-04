package com.avinash.flightreservation.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.avinash.flightreservation.entities.Flight;
import com.avinash.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	FlightRepository flightRepository;

	@RequestMapping(value="/findFlights", method=RequestMethod.POST)
	public String findFlights(@RequestParam("from") String from,
			@RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate, 
			ModelMap modelMap){
		
		List<Flight> flights = flightRepository.findFlights(from,to,departureDate);
		modelMap.addAttribute("flights", flights);
		return "displayFlights";
	}
	
	@RequestMapping("admin/showAddFlight")
	public String showAddFlight(){
		return "addFlight";
	}
	
	@RequestMapping(value="/addFlight",method=RequestMethod.POST)
	public String addFlight(@ModelAttribute("flight") Flight flight, ModelMap modelMap){

		flightRepository.save(flight);
		modelMap.addAttribute("msg","New Flight has been added with id : "+flight.getId());
		
		return "addFlight";
	}
}
