package com.usecase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long patientId;
	@Column
	private String patientName;
	@Column
	private String patientAddress;
	@Column
	private String patientdob;
	@Column
	private String patientemialId;
	@Column
	private Long contactNumber;
	@Column
	private int patientDrugId;
	@Column
	private String patientDrugName;
	public Patient()
	{
		
	}
	public Patient(Long patientId,String patientName,String patientAddress,String patientdob,String patientemialId,Long contactNumber,int patientDrugId,String patientDrugName)
	{
		this.patientId=patientId;
		this.patientName=patientName;
		this.patientAddress=patientAddress;
		this.patientdob=patientdob;
		this.patientemialId=patientemialId;
		this.contactNumber=contactNumber;
		this.patientDrugId=patientDrugId;
		this.patientDrugName=patientDrugName;
	}
	
	@Override
	  public String toString() {
	    return " [patientId=" + patientId + ", patientName=" + patientName + ", patientAddress=" + patientAddress + ", "
	    		+ "patientdob=" + patientdob + ",patientemialId=" + patientemialId + ",contactNumber="+contactNumber+","
	    				+ "patientDrugId="+patientDrugId+",patientDrugName="+patientDrugName+"]";
	  }

}
