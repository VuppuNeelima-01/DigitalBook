package com.usecase.controller;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.usecase.entity.Admin;
import com.usecase.entity.Patient;
import com.usecase.helper.CSVHelper;
import com.usecase.message.message;
import com.usecase.repository.AdminRepository;
import com.usecase.repository.PatientRepository;
import com.usecase.service.AdminService;
import com.usecase.service.CSVService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class Controller {
	@Autowired
	AdminRepository repository;
	@Autowired
	AdminService service;
	@Autowired
	CSVService fileservice;
	@Autowired
	PatientRepository prepo;
	
	@PostMapping("/signup")
	public ResponseEntity signUp(@Valid @RequestBody Admin admin) {
		if (repository.existsByUserName((String) admin.getUserName())) {
			return ResponseEntity.badRequest().body("Username Already Exist");
		}
		
		String encodedPassword = 
				  Base64.getEncoder().encodeToString(admin.getPassword().getBytes());
		admin.setPassword(encodedPassword);
		repository.save(admin);
		System.out.println("");
		ResponseEntity responseEntity = new ResponseEntity(admin,HttpStatus.CREATED);
		return responseEntity;
		//return ResponseEntity.ok("User Registered Successfully");
	}
	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@Valid @RequestBody Admin signin) {
		
		String encodedPassword = 
				  Base64.getEncoder().encodeToString(signin.getPassword().getBytes());
		
		signin.setPassword(encodedPassword);
		Admin findByNameAndPassword = repository.findByUserNameAndPassword(signin.getUserName(),
				signin.getPassword());
		if (findByNameAndPassword == null) {
			return ResponseEntity.badRequest().body("Invalid Credential");
		}
		ResponseEntity responseEntity = new ResponseEntity(signin,HttpStatus.ACCEPTED);
		return responseEntity;
		//return ResponseEntity.ok("User Login succefully");
	}
	
	@PostMapping("/upload")
	  public ResponseEntity<message> uploadFile(@RequestParam(value = "file") MultipartFile file) {
	    String message = "";
	    System.out.println("befor if");
	    if (CSVHelper.hasCSVFormat(file)) {
	      try {
	    	  System.out.println("befor file");
	    	  fileservice.save(file);
	    	  System.out.println("after file");
	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new message(message));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new message(message));
	      }
	    }

	    message = "Please upload a csv file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new message(message));
	  }

	  @GetMapping("/patients")
	  public ResponseEntity<List<Patient>> getPatients() {
	    try {
	      List<Patient> patientslist = fileservice.getPatients();

	      if (patientslist.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(patientslist, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @PostMapping("/update")
	  public Patient update(@Valid @RequestBody Patient patient1)
	  {
		  Optional<Patient> p1=prepo.findById(patient1.getPatientId());
		  Patient updatepatient=new Patient();
		  updatepatient.setPatientId(patient1.getPatientId());
		  updatepatient.setContactNumber(patient1.getContactNumber());
		  updatepatient.setPatientAddress(patient1.getPatientAddress());
		  updatepatient.setPatientemialId(patient1.getPatientemialId());
		  updatepatient.setPatientName(patient1.getPatientName());
		  updatepatient.setPatientdob(patient1.getPatientdob());
		  updatepatient.setPatientDrugName(patient1.getPatientDrugName());
		  updatepatient.setPatientDrugId(patient1.getPatientDrugId());
		  
		  return prepo.save(updatepatient);
	  }
	  
	  @GetMapping("/patientbyid/{patientId}")
	  public Object  getPatientyByid(@Valid @PathVariable("patientId") Long patientId){
		  
		  Optional<Patient> getpatient = prepo.findById(patientId);

	        return getpatient;
	    }
		  
			  
			  
	  
	  


}
