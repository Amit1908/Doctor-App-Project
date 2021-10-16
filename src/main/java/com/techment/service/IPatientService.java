package com.techment.service;

import java.util.List;

import com.techment.dto.Patientdto;
import com.techment.entity.Patient;

public interface IPatientService {

	String AddClient(Patientdto client);//Add
	List<Patientdto> GetClients();//View All
	Patientdto GetClientById(int id);//View one
	String DeleteClientById(int id);//Delete
	Patientdto PatientLogin(String username,String password); // View respect to mobile and password
	Patient PatientCheck(String username);
	
	
	
	
}
