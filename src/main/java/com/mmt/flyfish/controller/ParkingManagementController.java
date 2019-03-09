package com.mmt.flyfish.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.flyfish.response.ParkingExitResponse;
import com.mmt.flyfish.response.ResponseDTO;
import com.mmt.flyfish.response.SlotResponse;
import com.mmt.flyfish.service.BackendSystems;

@RestController
@RequestMapping(value="/parking")
public class ParkingManagementController {
	@Autowired
	private BackendSystems backend;
	
	@RequestMapping(value="/book")
	public ResponseDTO bookSlot(HttpServletRequest request, @RequestParam(name = "userId") int userId,@RequestParam(name = "latitude") double latitude,@RequestParam(name = "longitude") double longitude) {
		ResponseDTO response = new ResponseDTO();
		backend.bookParkingLot(latitude, longitude, userId);
		return response;
	}
	
	@RequestMapping(value="/slots")
	public ResponseDTO getSlots(HttpServletRequest request,@RequestParam(name = "latitude") double latitude,@RequestParam(name = "longitude") double longitude) {
		SlotResponse response = new SlotResponse();
		response.setResults(backend.getSlots(latitude, longitude));
		response.setSuccess(true);
		return response;
	}
	
	@RequestMapping(value="/remove")
	public ParkingExitResponse getSlots(HttpServletRequest request,@RequestParam(name = "userId") int userId, @RequestParam(name = "latitude") double latitude,@RequestParam(name = "longitude") double longitude) {
		ParkingExitResponse response = new ParkingExitResponse();
		response.setSuccess(true);
		response.setPrice(backend.removeParkingLot(latitude, longitude, userId));
		return response;
	}
	
	
}
