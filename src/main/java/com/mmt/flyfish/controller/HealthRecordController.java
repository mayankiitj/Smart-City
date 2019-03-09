package com.mmt.flyfish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.flyfish.entity.Consultation;
import com.mmt.flyfish.response.ConsulationResponse;
import com.mmt.flyfish.response.HealthRecordResponse;
import com.mmt.flyfish.service.MedicalDocService;

@RestController
@RequestMapping(value = "/health")
public class HealthRecordController {

	@Autowired
	MedicalDocService medicalService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public HealthRecordResponse getList(@RequestParam(name = "customer") int customer) {
		HealthRecordResponse response = new HealthRecordResponse();
		 response.setResults(medicalService.getList(customer));
		 response.setSuccess(true);
		 return response;
	}

	@RequestMapping(value = "/consultation", method = RequestMethod.GET)
	@ResponseBody
	public ConsulationResponse getConsultationDetail(@RequestParam(name = "id") String consultationId) {
		
		ConsulationResponse resp = new ConsulationResponse();
		resp.setResults(medicalService.getConsultationDetail(consultationId));
		resp.setSuccess(true);
		return resp;
	}

}
