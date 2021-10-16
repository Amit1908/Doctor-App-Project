package com.techment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity

public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	
	@NotNull(message = "name is required")
	@NotBlank(message = "name can not be empty")
	private String patientName;
	
	@NotNull(message = "Mobile Number is required")
	@NotBlank(message = "Mobile Number  can not be empty")
	private String patientMobile;
	
	@NotNull(message = "Email is required")
	@NotBlank(message = "Email can not be empty")
	private String patientEmail;
	
	@NotNull(message = "Password is required")
	@NotBlank(message = "Password can not be empty")
	private String patientPassword;
	
	@NotNull(message = "Blood Group is required")
	@NotBlank(message = "Blood Group can not be empty")
	private String patientBloodGroup;
	
	@NotNull(message = "Gender is required")
	@NotBlank(message = "Gender can not be empty")
	private String patientGender;
	
	@NotNull(message = "Number is required")
	@Min(1)
	@Max(110)
	private int patientAge;
	
	@NotNull(message = "Address is required")
	@NotBlank(message = "Address can not be empty")
	private String patientAddress;
	


	public Patient(
			@NotNull(message = "name is required") @NotBlank(message = "name can not be empty") String patientName,
			@NotNull(message = "Mobile Number is required") @NotBlank(message = "Mobile Number  can not be empty") String patientMobile,
			@NotNull(message = "Email is required") @NotBlank(message = "Email can not be empty") String patientEmail,
			@NotNull(message = "Password is required") @NotBlank(message = "Password can not be empty") String patientPassword,
			@NotNull(message = "Blood Group is required") @NotBlank(message = "Blood Group can not be empty") String patientBloodGroup,
			@NotNull(message = "Gender is required") @NotBlank(message = "Gender can not be empty") String patientGender,
			@NotNull(message = "Number is required") @Min(1) @Max(110) int patientAge,
			@NotNull(message = "Address is required") @NotBlank(message = "Address can not be empty") String patientAddress) {
		super();
		this.patientName = patientName;
		this.patientMobile = patientMobile;
		this.patientEmail = patientEmail;
		this.patientPassword = patientPassword;
		this.patientBloodGroup = patientBloodGroup;
		this.patientGender = patientGender;
		this.patientAge = patientAge;
		this.patientAddress = patientAddress;
	}

	public Patient() {
		super();
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientMobile() {
		return patientMobile;
	}

	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public String getPatientPassword() {
		return patientPassword;
	}

	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}

	public String getPatientBloodGroup() {
		return patientBloodGroup;
	}

	public void setPatientBloodGroup(String patientBloodGroup) {
		this.patientBloodGroup = patientBloodGroup;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	
	
}
