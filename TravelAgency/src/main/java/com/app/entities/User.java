package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

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
@ToString(exclude = "password")
public class User {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long UserId;
	
	@Column(length = 30)
	@NotBlank(message = "name must be provided")
	private String name;
	
	@Column(length = 30,unique = true)
	@NotBlank
	@Email
	private String email;
	
	@Column
	@NotBlank
	@Length(min=3,max=8,message ="invalid password")
	private String password;
	
	@Column(length = 10)
	@NotBlank
	@Pattern(regexp = "^(?:[789]\\d{10})$")
	private String ContactNo;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Booking>bokings=new ArrayList<>();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @OneToMany(mappedBy = "User",cascade = CascadeType.ALL,orphanRemoval = true )
	 * //@Column(name = "Bookings") private List<Booking>bookings;//=new
	 * ArrayList<>();
	 */	
	/*
	 * @OneToMany(mappedBy = "userPayment",cascade = CascadeType.ALL, orphanRemoval
	 * = true) private List<Payment> payments = new ArrayList<>();
	 */
}
