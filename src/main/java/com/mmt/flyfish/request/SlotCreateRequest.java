package com.mmt.flyfish.request;

import lombok.Data;

@Data
public class SlotCreateRequest {

	private int companyId;
	private int slot;
	private int employeeCount;
	private String time;

}
