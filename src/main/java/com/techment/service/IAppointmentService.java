package com.techment.service;

import java.util.List;

import com.techment.dto.Appointmentdto;
import com.techment.entity.Appointment;

public interface IAppointmentService {

	List<Appointmentdto> viewAllAppointments();
	Appointmentdto viewAppointmentForId(int id);
	String TakeAppointment(Appointmentdto appointment);
	String deleteAppointment(int id);
	
}
