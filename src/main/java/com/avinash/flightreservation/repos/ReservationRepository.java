package com.avinash.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avinash.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
