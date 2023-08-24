package com.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PackageDTO {

	private long packageID;

	@Column(length = 30)
	@NotBlank
	private String name;

	@Column(length = 300)
	@NotBlank
	private String discription;

	@Column(length = 50)
	@NotBlank
	private String accomodation;

	@Column(length = 30)
	@NotBlank
	private String duration;

	@Column(length = 20)
	@NotNull
	private double price;

	@Column(length = 300)
	@NotBlank
	private String activities;

}
