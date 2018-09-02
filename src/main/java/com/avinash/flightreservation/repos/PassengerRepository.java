package com.avinash.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avinash.flightreservation.entities.Passenger;
import com.avinash.flightreservation.entities.User;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
