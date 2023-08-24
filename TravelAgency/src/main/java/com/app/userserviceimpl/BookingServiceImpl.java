package com.app.userserviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.BookingDTO;
import com.app.entities.Booking;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.BookingRepo;
import com.app.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepo bookingrepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public BookingDTO bookPackage(BookingDTO bookingDto) {

		Booking booking = this.mapper.map(bookingDto, Booking.class);
		Booking bookedPackage = this.bookingrepo.save(booking);

		return this.mapper.map(bookedPackage, BookingDTO.class);

	}

	@Override

	public List<BookingDTO> getAllBookings() {
		List<Booking> bookings = bookingrepo.findAll();

		List<BookingDTO> collect = bookings.stream().map((book) -> this.mapper.map(book, BookingDTO.class))
				.collect(Collectors.toList());
		return collect;
	}
    @Override
	public void deletebooking(Long bookingID) {
		Booking booking = bookingrepo.findById(bookingID)
				.orElseThrow(() -> new ResourceNotFoundException("Booking", "bookingID", bookingID));
          this.bookingrepo.delete(booking);
	}

}
