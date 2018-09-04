package com.avinash.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avinash.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
