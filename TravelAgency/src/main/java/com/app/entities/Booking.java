package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long BookingId;
	
	
	
	@Column(length = 20)
	@NotBlank
	@Future(message = "enter a valid travel date")
	private String BookingDate;
	
	@Column(length = 30)
	@NotNull
	private double TotalCost;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	@OneToMany(mappedBy = "booking",cascade = CascadeType.ALL,orphanRemoval = true)
	
	private List<Package>packages=new ArrayList<>();
	
	@OneToMany(mappedBy = "booking",cascade = CascadeType.ALL,orphanRemoval =true)
	private List<Payment>payments=new ArrayList<>();
	
	
	@OneToMany(mappedBy = "booking",cascade = CascadeType.ALL,orphanRemoval =true)
	private List<Feedback>feedbacks= new ArrayList<>();
	
	
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name="UserBookingId") private User userBooking;
	 */
	/*
	 * @OneToOne(mappedBy = "UserPackges",cascade = CascadeType.ALL,orphanRemoval =
	 * true) private List<Package>packages=new ArrayList<>();
	 */
	
	/*
	 * @OneToMany(mappedBy = "Feedback",cascade = CascadeType.ALL,orphanRemoval =
	 * true) private List<Feedback>feedbacks=new ArrayList<>();
	 */
	/*
	 * @OneToOne(mappedBy = "UserPayments",cascade = CascadeType.ALL, orphanRemoval
	 * = true) private List<Payment>payments=new ArrayList<>();
	 */
	
}
