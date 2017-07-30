package com.k15t.pat.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * Registration is an Entity class. The values given to the fields are stored in
 * the H2 Database.confirmPassword is annotated with @Transient and it is not
 * stored in the database.
 * 
 * @author Mahidhar
 */

@Entity
public class Registration {

	/**
	 * Id is generated automatically and stored in the DB as per the given
	 * strategy
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	@Pattern(regexp = "^[A-Za-z]*$" , message="Please enter only Alphabets")
	private String name;

	@NotEmpty
	private String password;

	/**
	 * confirmPassword is not stored in the Database
	 */
	@Transient
	private String confirmPassword;

	@NotEmpty
	private String address;

	@NotEmpty
	@Email
	private String email;

	@NotNull
	@Digits(integer = 11, fraction = 0)
	private BigDecimal phoneNumber;

	public Registration() {

	}

	/**
	 * Constructor with name,password,address,email and phoneNumber
	 * 
	 * @param name
	 * @param password
	 * @param address
	 * @param email
	 * @param phoneNumber
	 */
	public Registration(String name, String password, String address, String email, BigDecimal phoneNumber) {
		super();
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * This method returns id
	 * 
	 * @return Id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method is setting the id
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method returns the name
	 * 
	 * @return name
	 */

	public String getName() {
		return name;
	}

	/**
	 * This method sets the name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method returns the password
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method sets the password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method returns the confirmPassword
	 * 
	 * @return confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * This method sets the confirmPassword
	 * 
	 * @param confirmPassword
	 */

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * This method returns the address
	 * 
	 * @return address
	 */

	public String getAddress() {
		return address;
	}

	/**
	 * This method sets the address
	 * 
	 * @return address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * This method returns the email
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method sets the email
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method returns the phoneNumber
	 * 
	 * @return BigDecimal value of phoneNumber
	 */

	public BigDecimal getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * This method sets the phoneNumber
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(BigDecimal phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Registration [name=" + name + ", password=" + password + ", address=" + address + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
