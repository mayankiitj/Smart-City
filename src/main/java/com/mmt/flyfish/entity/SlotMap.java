package com.mmt.flyfish.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="slot_map")
@Data
public class SlotMap {

@Column(name = "slot_id")
private int slotId;

@Column(name = "area_id")
private int areaId;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id")
private int id;
	

}
