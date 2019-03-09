package com.mmt.flyfish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmt.flyfish.entity.ParkingLot;
import com.mmt.flyfish.repository.DatabaseConnection;



@Service
public class BackendSystems {
	
	@Autowired
	DatabaseConnection dbc ;
	
	 public boolean authorize(String userName, String password){
		 
		 dbc.authorize(userName, password);
		 
		 return true;		 
	 }
	 
	 public List<ParkingLot> getSlots(double latitude, double longitude){
		 
		 List<ParkingLot> list = dbc.getAvailableSlots(latitude, longitude);
		 
		 return list;
		 		  
	 }
	 
	 public boolean bookParkingLot(double latitude, double longitude, int userId){
		 
		 boolean success = dbc.bookSlot(latitude, longitude, userId);
		 
		 return success; 
			
	 }
	 
	 public int removeParkingLot(double latitude, double longitude, int userId){
		 
		 int price = dbc.freeSlot(latitude, longitude);
		 
		 return price;
			
	 }
	
	
	
}
