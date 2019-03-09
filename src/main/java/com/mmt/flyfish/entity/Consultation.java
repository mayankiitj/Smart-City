package com.mmt.flyfish.entity;

import java.util.List;

/**
 * @author BABA HARI KISHAN
 *
 */
public class Consultation {

	int customerId;
	String consultationId;
	String doctorFirstName;
	String description;
	String doctorLastName;
	String doctorId;
	String disease;
	String suggestions;
	String date;
	int doctorRating;
	List<Medication> medicationList;

	public List<Medication> getMedicationList() {
		return medicationList;
	}

	public void setMedicationList(List<Medication> medicationList) {
		this.medicationList = medicationList;
	}

	public String getConsultationId() {
		return consultationId;
	}

	public void setConsultationId(String consultationId) {
		this.consultationId = consultationId;
	}

	public int getDoctorRating() {
		return doctorRating;
	}

	public void setDoctorRating(int doctorRating) {
		this.doctorRating = doctorRating;
	}

	public String getDoctorFirstName() {
		return doctorFirstName;
	}

	public void setDoctorFirstName(String doctorFirstName) {
		this.doctorFirstName = doctorFirstName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDoctorLastName() {
		return doctorLastName;
	}

	public void setDoctorLastName(String doctorLastName) {
		this.doctorLastName = doctorLastName;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	

}
