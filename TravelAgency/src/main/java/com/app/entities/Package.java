package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Package {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@ManyToOne
	@JoinColumn(name = "bookingId")
	private Booking booking;

}
