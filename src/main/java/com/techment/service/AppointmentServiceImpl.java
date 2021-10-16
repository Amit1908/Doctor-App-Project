package com.techment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techment.dao.IAppointmentDao;
import com.techment.dto.Appointmentdto;
import com.techment.entity.Appointment;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	IAppointmentDao Appointmentdao;
	
	@Override
	public List<Appointmentdto> viewAllAppointments() {
		List<Appointment> appointments = Appointmentdao.findAll();
		List<Appointmentdto> appointmentdtos = new ArrayList<Appointmentdto>();
		for(Appointment appointment :appointments)
		{
			appointmentdtos.add(new Appointmentdto(appointment.getPatientName(), appointment.getAge(), appointment.getSymptoms(), appointment.getAppointmentDate(), appointment.getAppointmentStatus(), appointment.getRemarks(), appointment.getBookingAt(), appointment.getPatient(), appointment.getDoctor()));
		}
		
		
		
		return appointmentdtos;
	}

	@Override
	public Appointmentdto viewAppointmentForId(int id) {
		Appointment appointment = Appointmentdao.findById(id).get();
		Appointmentdto appointmentdto = new Appointmentdto(appointment.getPatientName(), appointment.getAge(), appointment.getSymptoms(), appointment.getAppointmentDate(), appointment.getAppointmentStatus(), appointment.getRemarks(), appointment.getBookingAt(), appointment.getPatient(), appointment.getDoctor());

		return appointmentdto;
	}

	@Override
	public String TakeAppointment(Appointmentdto appointment) {

		Appointment addappointment = new Appointment(appointment.getPatientName(), appointment.getAge(), appointment.getSymptoms(), appointment.getAppointmentDate(), appointment.getAppointmentStatus(), appointment.getRemarks(), appointment.getBookingAt(), appointment.getPatient(), appointment.getDoctor());
		
				if(appointment.getAppointmentId()!=0)
		{
			addappointment.setAppointmentId(appointment.getAppointmentId());
		}
					Appointmentdao.save(addappointment);
		return "Appointment Scheduled Sucessfully";
	}

	@Override
	public String deleteAppointment(int id) {
		
		Appointmentdao.deleteById(id);
		return "Appointment Cancelled Sucessfully";
	}

}
