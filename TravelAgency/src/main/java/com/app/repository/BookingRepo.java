package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {

}
