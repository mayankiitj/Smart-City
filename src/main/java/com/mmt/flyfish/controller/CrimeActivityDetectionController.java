package com.mmt.flyfish.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.flyfish.request.ActivityRequest;

@RestController
@RequestMapping(value = "/activity")
public class CrimeActivityDetectionController {
	
	
	@RequestMapping(value = "/push", method = RequestMethod.GET)
	@ResponseBody
	public void pushActivity(HttpServletRequest request, @RequestParam(name = "name") String name,@RequestParam(name = "latitude") double latitude,@RequestParam(name = "longitude") double longitude) {
		ActivityRequest activity = new ActivityRequest();
		activity.setName(name);
		activity.setLatitude(latitude);
		activity.setLongitude(longitude);
		if(activity.getName().equalsIgnoreCase("knife")) {
			System.out.println("calling police for possible threat at latitude and longitude "+activity.getLatitude()+" "+activity.getLongitude());
			
			
		}
		else {
			System.out.println("ignore");
		}
	}

}
