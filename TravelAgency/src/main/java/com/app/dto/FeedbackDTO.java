package com.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class FeedbackDTO {

	private long feedbackID;

	@Column(length = 100)
	private String comment;

	@NotNull(message = "rate something based on your experience")
	private int rating;
}
