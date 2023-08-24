package com.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class PaymentDTO {

	private long paymentID;

	@Column(length = 30)
	@NotNull
	private double amount;

}
