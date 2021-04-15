package com.promineotech.incidentReport.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employee_facility")
public class EmpAtFacility {

	private Long id;
	
	private Set<Facility> facilities;
	
	@JsonIgnore
	private Employee employee;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
 
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "empAtFacility",
	joinColumns = @JoinColumn(name = "empAtFacilitiesId", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "facilityId", referencedColumnName = "id"))
	//@ManyToMany(mappedBy = "empAtFacility")
	public Set<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(Set<Facility> facilities) {
		this.facilities = facilities;
	}

	@ManyToOne
	@JoinColumn(name = "employeeId")
	public Employee getEmployees() {
		return employee;
	}

	public void setEmployees(Employee employees) {
		this.employee = employees;
	}
	
}

