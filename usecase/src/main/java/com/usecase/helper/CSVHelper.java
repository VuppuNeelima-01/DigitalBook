package com.usecase.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.usecase.entity.Patient;

public class CSVHelper {
	public static String TYPE = "text/csv";
	  static String[] HEADERs = { "patientId", "patientName", "patientAddress", "patientdob","patientemialId","contactNumber","patientDrugId","patientDrugName" };
	  
	  public static boolean hasCSVFormat(MultipartFile file) {

		    if (!TYPE.equals(file.getContentType())) {
		      return false;
		    }

		    return true;
		  }
	  
	  public static List<Patient> csvToPatient(InputStream is) {
		  System.out.println("at csvhelper");
		    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		        CSVParser csvParser = new CSVParser(fileReader,
		            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
		    	 
		      List<Patient> patientlist = new ArrayList<Patient>();

		      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

		      for (CSVRecord csvRecord : csvRecords) {
		    	 
		    	  Patient patient = new Patient(
		    			  Long.parseLong(csvRecord.get("patientId")), 
		    			  csvRecord.get("patientName"),  
		    			  csvRecord.get("patientAddress"),
		    			  csvRecord.get("patientdob"), 
		    			csvRecord.get("patientemialId"), 
		    			Long.parseLong(csvRecord.get("contactNumber")), 
		    			  Integer.parseInt(csvRecord.get("patientDrugId")),
		    			  csvRecord.get("patientDrugName"));
		    	 // System.out.println(patient.getPatientId());
		    	 // System.out.println(patient.getPatientName());
		    	 // System.out.println(patient.getPatientAddress());
		    	  //System.out.println(patient.getPatientdob());
		    	  //System.out.println(patient.getEmailId());
		    	  
		    	 // list.forEach(System.out::println);
		    	  patientlist.add(patient);
		    	  
		    	  
		    	 
		      }
		     // patientlist.forEach(System.out::println);
		      return patientlist;
		      
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		    }
		  }

}
