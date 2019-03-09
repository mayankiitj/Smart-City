package com.mmt.flyfish.response;

import java.util.List;

import com.mmt.flyfish.entity.ParkingLot;

import lombok.Data;

@Data
public class SlotResponse extends ResponseDTO{
	private List<ParkingLot> results;
}
