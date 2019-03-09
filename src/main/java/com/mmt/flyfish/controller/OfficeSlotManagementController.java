package com.mmt.flyfish.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.flyfish.request.SlotCreateRequest;
import com.mmt.flyfish.response.ResponseDTO;
import com.mmt.flyfish.service.OfficeSlotServiceImpl;

@RestController
@RequestMapping(value = "/slot")
public class OfficeSlotManagementController {

	@Autowired
	OfficeSlotServiceImpl officeService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO createSlot(HttpServletRequest request, @RequestBody @NotNull SlotCreateRequest slot) {
		ResponseDTO resp = new ResponseDTO();
		String error = officeService.createSlot(slot);

		if (error == null) {
			resp.setSuccess(true);
			resp.setMessage("employee successfully assigned to time slot");
		} else {
			resp.setSuccess(false);
			resp.setMessage(error);
		}

		return resp;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public ResponseDTO getSlot(HttpServletRequest request,@RequestParam(name="id")int companyId) {
		ResponseDTO resp = new ResponseDTO();
		String error = null;

		if (error == null) {
			resp.setSuccess(true);
			resp.setMessage("employee successfully assigned to time slot");
		} else {
			resp.setSuccess(false);
			resp.setMessage(error);
		}

		return resp;
	}

}
