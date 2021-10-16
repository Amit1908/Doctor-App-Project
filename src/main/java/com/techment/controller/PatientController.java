package com.techment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.dto.Patientdto;
import com.techment.entity.Patient;
import com.techment.exception.PatientNotFound;
import com.techment.service.IPatientService;


@RestController
@CrossOrigin
@RequestMapping(value = "/clientController")
public class PatientController {
	
	@Autowired
	IPatientService clientService;
	
	@PostMapping(value = "/addClient")
	public ResponseEntity<String> addnewClient(@Valid @RequestBody Patientdto client)
	{		
		Patient patient = clientService.PatientCheck(client.getPatientMobile());
	
		if(patient ==null)
		{
			String OutputString =clientService.AddClient(client);
			return new ResponseEntity<String>(OutputString,HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("User Already Exist",HttpStatus.BAD_REQUEST);
		
					
	}
	
	@GetMapping("/viewAll")
	public List<Patientdto> ViewClients()
	{
		return clientService.GetClients();
	}
	
	@GetMapping("/viewAll/{id}")
	public Patientdto ViewClientById(@PathVariable int id)
	{
		try
		{
			Patientdto patient = clientService.GetClientById(id);
				return patient;
		}
		catch (Exception e) {
			throw new PatientNotFound("No User found");
		}
		
	}
	
	@PutMapping("/UpdateClient/{id}")
	public ResponseEntity<String>  ViewClientById(@PathVariable int id,@Valid @RequestBody Patientdto client)
	{
			
			
			try {
				Patientdto clientupdate = clientService.GetClientById(id);
				if(clientupdate!=null)
				{
					clientupdate.setPatientId(id);
					clientupdate.setPatientAddress(client.getPatientAddress());
					clientupdate.setPatientAge(client.getPatientAge());
					clientupdate.setPatientBloodGroup(client.getPatientBloodGroup());
					clientupdate.setPatientEmail(client.getPatientEmail());
					clientupdate.setPatientGender(client.getPatientGender());
					clientupdate.setPatientMobile(client.getPatientMobile());
					clientupdate.setPatientName(client.getPatientName());
					clientupdate.setPatientPassword(client.getPatientPassword());
					
					clientService.AddClient(clientupdate);
					
					return new ResponseEntity<String>("Client Updated",HttpStatus.ACCEPTED);
				}
				else
					return new ResponseEntity<String>(HttpStatus.BAD_GATEWAY);
			} catch (Exception e) {
				throw new PatientNotFound("No User found");
			}
			
			
				
	}
	
	@DeleteMapping("/DeleteClient/{id}")
	public ResponseEntity<String> DeleteClientById(@PathVariable int id)
	{
		try
		{

			clientService.DeleteClientById(id);
			return new ResponseEntity<String>("Client Deleted Successfully",HttpStatus.ACCEPTED);	
		}
		catch (Exception e) {
			throw new PatientNotFound("No User found");
		}
	}
	@GetMapping("/Login/{username}/{password}")
	public Patientdto LoginPatient(@PathVariable String username,@PathVariable String password)
	{
		return clientService.PatientLogin(username,password);
	}
	
	
}
