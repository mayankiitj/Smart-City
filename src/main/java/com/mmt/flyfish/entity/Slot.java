package com.mmt.flyfish.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "office_slot")
@Data
public class Slot {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int slotId;

	@Column(name = "num_slots")
	private int availableSlots;

	@Column(name = "time")
	private String time;
}
