package com.techment.dto;

import java.time.LocalDate;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;
import com.techment.entity.Doctor;
import com.techment.entity.Patient;

public class Appointmentdto {

private int appointmentId;
	

	private String patientName;
	private int age;
	private String symptoms;
	private String appointmentDate;
	private String appointmentStatus;
	private String remarks;
	private String bookingAt;
	
		
		Patient patient;
		
		
		Doctor doctor;

	

		public Appointmentdto() {
			super();
		}

		public Appointmentdto(String patientName, int age, String symptoms, String appointmentDate,
				String appointmentStatus, String remarks, String bookingAt, Patient patient, Doctor doctor) {
			super();
			this.patientName = patientName;
			this.age = age;
			this.symptoms = symptoms;
			this.appointmentDate = appointmentDate;
			this.appointmentStatus = appointmentStatus;
			this.remarks = remarks;
			this.bookingAt = bookingAt;
			this.patient = patient;
			this.doctor = doctor;
		}

		public int getAppointmentId() {
			return appointmentId;
		}

		public void setAppointmentId(int appointmentId) {
			this.appointmentId = appointmentId;
		}

		public String getPatientName() {
			return patientName;
		}

		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getSymptoms() {
			return symptoms;
		}

		public void setSymptoms(String symptoms) {
			this.symptoms = symptoms;
		}

		public String getAppointmentDate() {
			return appointmentDate;
		}

		public void setAppointmentDate(String appointmentDate) {
			this.appointmentDate = appointmentDate;
		}

		public String getAppointmentStatus() {
			return appointmentStatus;
		}

		public void setAppointmentStatus(String appointmentStatus) {
			this.appointmentStatus = appointmentStatus;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		public String getBookingAt() {
			return bookingAt;
		}

		public void setBookingAt(String bookingAt) {
			this.bookingAt = bookingAt;
		}

		public Patient getPatient() {
			return patient;
		}

		public void setPatient(Patient patient) {
			this.patient = patient;
		}

		public Doctor getDoctor() {
			return doctor;
		}

		public void setDoctor(Doctor doctor) {
			this.doctor = doctor;
		}
		

}
