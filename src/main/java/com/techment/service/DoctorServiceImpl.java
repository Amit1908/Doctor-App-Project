package com.techment.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techment.dao.IDoctorDao;
import com.techment.dao.IUserDao;
import com.techment.dto.DoctorDto;
import com.techment.entity.Doctor;
import com.techment.entity.User;
import com.techment.service.IDoctorService;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	IDoctorDao dao;
	
	@Autowired
	IUserDao userdao;

	@Override
	public String addDoctor(DoctorDto d) {

		//Doctor newDoctor = new Doctor(d.getName(), d.getAge(), d.getExperience(), d.getQualification(), d.getLocation(), d.getFees(), d.getGender(), d.getMobile(), d.getPassword(), d.getBio(), d.getSpeciality(),d.getEmail());
		Doctor newDoctor = new Doctor(d.getDoctorName(), d.getAge(), d.getExperience(), d.getQualification(),
				d.getCity(), d.getFees(), d.getGender(), d.getMobile(), d.getAddress(), d.getBio(), d.getSpeciality(),
				d.getPassword(), d.getAvailabilityDates());
		
		if(userdao.findByUsername(d.getMobile())==null)
		{
			User user = new User(newDoctor.getMobile(), newDoctor.getPassword(),"Doctor");
			userdao.save(user);	
		}		
		dao.save(newDoctor);

		return "Doctor Registerd Successfully";
	}

	@Override
	public DoctorDto getDoctor(int id) {

		
		Doctor d = dao.findById(id).get();

//		DoctorDto dto = new DoctorDto(d.getDoctorName(), d.getAge(), d.getExperience(), d.getQualification(), d.getCity(),
//				d.getFees(), d.getGender(), d.getMobile(), d.getPassword(), d.getBio(),d.getSpeciality(),d.getEmail());
//		return dto;
		DoctorDto dto = new DoctorDto(d.getDoctorName(), d.getAge(), d.getExperience(), d.getQualification(),
				d.getCity(), d.getFees(), d.getGender(), d.getMobile(), d.getAddress(), d.getBio(), d.getSpeciality(),
				d.getPassword(), d.getAvailabilityDates());
		return dto;
	}

	@Override
	public String removeDoctor(int id) {

		dao.deleteById(id);
		return "Doctor deleted successfully";
	}

	@Override
	public List<DoctorDto> getDoctorList() {

		List<Doctor> doctorList = dao.findAll();
		List<DoctorDto> doctorDtoList = new ArrayList<DoctorDto>();
		
		
		for (Doctor d : doctorList) {
			doctorDtoList.add(new DoctorDto(d.getDoctorName(), d.getAge(), d.getExperience(), d.getQualification(),
					d.getCity(), d.getFees(), d.getGender(), d.getMobile(), d.getAddress(), d.getBio(),
					d.getSpeciality(), d.getPassword(), d.getAvailabilityDates()));
		}

		return doctorDtoList;
	}

	@Override
	public List<DoctorDto> getDoctorListBySpeciality(String speciality) {

		List<Doctor> doctorList = dao.findBySpeciality(speciality);


List<DoctorDto> doctorDtoList = new ArrayList<DoctorDto>();
		
		
//		for(Doctor d:doctorList)
//		{
//			doctorDtoList.add(new DoctorDto(d.getName(), d.getAge(), d.getExperience(), d.getQualification(), d.getLocation(),
//					d.getFees(), d.getGender(), d.getMobile(), d.getPassword(), d.getBio(),d.getSpeciality(),d.getEmail()));}
//		
for (Doctor d : doctorList) {
	doctorDtoList.add(new DoctorDto(d.getDoctorName(), d.getAge(), d.getExperience(), d.getQualification(),
			d.getCity(), d.getFees(), d.getGender(), d.getMobile(), d.getAddress(), d.getBio(),
			d.getSpeciality(), d.getPassword(), d.getAvailabilityDates()));
}
		
		return doctorDtoList;
	}

	@Override
	public String updateDoctor(DoctorDto d, int id) {

		Doctor exsitingDoctor = dao.findById(id).get();

//		exsitingDoctor.setName(d.getName());
//		exsitingDoctor.setAge(d.getAge());
//		//exsitingDoctor.setAddress(d.getAddress());
//		exsitingDoctor.setLocation(d.getLocation());
//		
//		exsitingDoctor.setBio(d.getBio());
//		exsitingDoctor.setPassword(d.getPassword());
//		exsitingDoctor.setExperience(d.getExperience());
//		exsitingDoctor.setFees(d.getFees());
//		exsitingDoctor.setGender(d.getGender());
//		exsitingDoctor.setMobile(d.getMobile());
//		exsitingDoctor.setQualification(d.getQualification());
//		exsitingDoctor.setSpeciality(d.getSpeciality());
//		exsitingDoctor.setEmail(d.getEmail());
//		dao.save(exsitingDoctor);
//		

		exsitingDoctor.setDoctorName(d.getDoctorName());
		exsitingDoctor.setAge(d.getAge());
		exsitingDoctor.setAddress(d.getAddress());

		exsitingDoctor.setBio(d.getBio());
		exsitingDoctor.setCity(d.getCity());
		exsitingDoctor.setExperience(d.getExperience());
		exsitingDoctor.setFees(d.getFees());
		exsitingDoctor.setGender(d.getGender());
		exsitingDoctor.setMobile(d.getMobile());
		exsitingDoctor.setQualification(d.getQualification());
		exsitingDoctor.setSpeciality(d.getSpeciality());
		exsitingDoctor.setAvailabilityDates(d.getAvailabilityDates());
		exsitingDoctor.setPassword(d.getPassword());
		dao.save(exsitingDoctor);
		return "Updated successfully";
	}

}
