package com.usecase.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.usecase.entity.Patient;
import com.usecase.helper.CSVHelper;

import com.usecase.repository.PatientRepository;
@Service
public class CSVService {
	@Autowired
	PatientRepository repository;
	public void save(MultipartFile file) {
		 System.out.println("call at save");
	    try {
	      List<Patient> patientslist = CSVHelper.csvToPatient(file.getInputStream());
	      patientslist.forEach(System.out::println);
	      repository.saveAll(patientslist);
	      System.out.println("call after repo");
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }

	  public List<Patient> getPatients() {
	    return repository.findAll();
	  }

}
