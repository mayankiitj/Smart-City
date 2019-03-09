package com.mmt.flyfish.response;

import com.mmt.flyfish.entity.Consultation;

import lombok.Data;

@Data
public class ConsulationResponse extends ResponseDTO{
	private Consultation results;
}
