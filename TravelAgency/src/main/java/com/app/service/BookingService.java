package com.app.service;

import java.util.List;

import com.app.dto.BookingDTO;

public interface BookingService {

	BookingDTO bookPackage(BookingDTO bookingDto);

	List<BookingDTO> getAllBookings();

	void deletebooking(Long bookingID);

	
	
}
