package com.techment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techment.dao.IPatientDao;
import com.techment.dao.IUserDao;
import com.techment.dto.Patientdto;
import com.techment.entity.Patient;
import com.techment.entity.User;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	IPatientDao clientdao;
	
	@Autowired
	IUserDao user;
	
	@Override
	public String AddClient(Patientdto client) {
		
		
	
			
		Patient patient = new Patient(client.getPatientName(),
				client.getPatientMobile(),client.getPatientEmail()
				,client.getPatientPassword(),client.getPatientBloodGroup()
				,client.getPatientGender(),client.getPatientAge(),client.getPatientAddress());
		if(client.getPatientId()!=0)
		{
			patient.setPatientId(client.getPatientId());
		}
		else
		{
			if(user.findByUsername(client.getPatientMobile())==null)
			{
				User user1 = new User(client.getPatientMobile(), client.getPatientPassword(), "Patient");
				user1.setToken(null);
				user.save(user1);
			}
		}
		clientdao.save(patient);
		return "Details Of Client Added Successfully";
	}
		

	@Override
	public List<Patientdto> GetClients() {
		List<Patient> clients = clientdao.findAll();
		List<Patientdto> clientList = new ArrayList<Patientdto>();
		for(Patient client : clients )
		{
			clientList.add(new Patientdto(client.getPatientName(),
					client.getPatientMobile(), client.getPatientEmail(),
					client.getPatientPassword(), client.getPatientBloodGroup(),
					client.getPatientGender(), client.getPatientAge(), client.getPatientAddress()));			
		}
		return clientList;
	}

	@Override
	public Patientdto GetClientById(int id) {
		Patient client = clientdao.findById(id).get();
//		if(client==null)
//		{
//			return "No Client With This Id";
//		}
		Patientdto clientdto =new Patientdto(client.getPatientName(), client.getPatientMobile(), client.getPatientEmail(), client.getPatientPassword(), client.getPatientBloodGroup(), client.getPatientGender(), client.getPatientAge(), client.getPatientAddress());
		return clientdto;
	}

	@Override
	public String DeleteClientById(int id) {
		
		clientdao.deleteById(id);
		return "Client Deleted Successfully";
	}

	@Override
	public Patientdto PatientLogin(String username, String password) {
		Patient client = clientdao.findByPatientMobileAndPatientPassword(username, password);
		Patientdto patient =new Patientdto(client.getPatientName(), client.getPatientMobile(), client.getPatientEmail(), client.getPatientPassword(), client.getPatientBloodGroup(), client.getPatientGender(), client.getPatientAge(), client.getPatientAddress());
		return patient;
//		return null;
	}

	@Override
	public Patient PatientCheck(String username) {
		
	
			Patient patient = clientdao.findByPatientMobile(username);
//			Patientdto patientdto = new Patientdto(patient.getPatientName(),
//					patient.getPatientMobile(),
//					patient.getPatientEmail(),
//					patient.getPatientPassword(),
//					patient.getPatientBloodGroup(),
//					patient.getPatientGender(),
//					patient.getPatientAge(),
//					patient.getPatientAddress());
			if(patient!=null)
			{
				return patient;
			}
			else
				return null;
	}

}
