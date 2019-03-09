package com.mmt.flyfish.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmt.flyfish.entity.Consultation;
import com.mmt.flyfish.repository.MedicalDocDao;

@Service
public class MedicalDocService {
	
	@Autowired
	MedicalDocDao dbc ;
	
	 public boolean authorize(String userName, String password){
		 
		 dbc.authorize(userName, password);
		 
		 return true;		 
	 }
	 
	 public List<Consultation> getList(int Customerkey){
		 
		 List<Consultation> list = new ArrayList<Consultation>();
		 
		 list = dbc.getConsultationList(Customerkey);
		 
		 return list;		 
	 }
	 
	 public Consultation getConsultationDetail(String consultationId){
		 
		 Consultation cObj = dbc.getTreatmentDetail(consultationId);
		 
		 return cObj;
			
	 }
	
	
	
}
