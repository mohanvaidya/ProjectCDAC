package com.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BookingDTO {

	private long BookingId;

	@Column(length = 20)
	@NotBlank
	@Future(message = "enter a valid travel date")
	private String BookingDate;

	@Column(length = 30)
	@NotNull
	private double TotalCost;
}
