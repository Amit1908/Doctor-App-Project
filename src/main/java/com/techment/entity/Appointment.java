package com.techment.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name = "DoctorAppAppointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointmentId;
	

	private String patientName;
	private int age;
	private String symptoms;
	private String appointmentDate;
	private String appointmentStatus;
	private String remarks;
	private String bookingAt;
	
		@ManyToOne
		@JoinColumn(name = "patientId" , referencedColumnName = "patientId")
		Patient patient;
		
		@ManyToOne
		@JoinColumn(name = "doctorId",referencedColumnName = "doctorId")
		Doctor doctor;

		public Appointment(String patientName, int age, String symptoms, String appointmentDate,
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

		public Appointment() {
			super();
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
