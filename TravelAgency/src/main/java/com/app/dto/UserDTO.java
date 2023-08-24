package com.app.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.app.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
  
	private long Id;

	@Column(length = 30)
	@NotBlank(message = "name must be provided")
	private String name;

	@Column(length = 30, unique = true)
	@NotBlank
	@Email
	private String email;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "role required here(enter in CAPITALS)")
	
 private Role role;

	@NotBlank
	@Length(min = 3, max = 8, message = "invalid password")
	private String password;

	@Column(length = 10)
	@NotBlank
	@Length(min = 10,max=10,message = "please enter a valid number")
	@Pattern(regexp = "^[789]\\d{9}$")
	private String ContactNo;

	
}
