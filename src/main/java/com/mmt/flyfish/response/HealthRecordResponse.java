package com.mmt.flyfish.response;

import java.util.List;

import com.mmt.flyfish.entity.Consultation;

import lombok.Data;

@Data
public class HealthRecordResponse extends ResponseDTO{

	private List<Consultation> results;
}
