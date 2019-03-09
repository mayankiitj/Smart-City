package com.mmt.flyfish.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "company")
@Entity
@Data
public class Company {

	@Column(name = "priority")
	private int priority;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "company_id")
	private int companyId;

	@Column(name = "name")
	private String name;

	@Column(name = "longitude")
	private double lng;

	@Column(name = "latitude")
	private double lat;

	@Column(name = "total_employee")
	private int employee;

	@Column(name = "unassigned_employee")
	private int unassignedEmployee;
	
	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	@JoinTable(name = "area_company_map", joinColumns = {
			@JoinColumn(name = "company_id", referencedColumnName = "company_id") }, inverseJoinColumns = {
					@JoinColumn(name = "area_id", referencedColumnName = "id") })
	private AreaSlot area;
}
