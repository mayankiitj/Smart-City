package com.mmt.flyfish.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@Table(name = "area_slot")
@Entity
@Data
public class AreaSlot {

	@Column(name = "start_lat")
	private double startLat;

	@Column(name = "start_long")
	private double startLong;

	@Column(name = "end_lat")
	private double endLat;

	@Column(name = "end_long")
	private double endLong;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity=Slot.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name="slot_map", 
		joinColumns = { @JoinColumn(name = "area_id", referencedColumnName="id") }, 
		inverseJoinColumns = { @JoinColumn(name = "slot_id", referencedColumnName="id") })
	private List<Slot> availableSlots;

	@Column(name = "total_slot")
	private int slots;

	@Column(name = "name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity=Company.class, fetch=FetchType.EAGER)
	@JoinTable(name="area_company_map", 
		joinColumns = { @JoinColumn(name = "area_id", referencedColumnName="id") }, 
		inverseJoinColumns = { @JoinColumn(name = "company_id", referencedColumnName="company_id") })
	private List<Company> company;
	

}
