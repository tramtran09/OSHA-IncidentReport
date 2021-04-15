package com.promineotech.incidentReport.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Facility {

	private Long id;
	private String name;
	private String address;
	private String state;
	private String city; 
	private String zip;
	
	private Set<EmpAtFacility> empAtFacility;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@ManyToOne
	@JoinColumn(name = "employeeId")
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employees) {
		this.employee = employees;
	}
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "empAtFacility",
//	joinColumns = @JoinColumn(name = "facilityId", referencedColumnName = "id"),
//	inverseJoinColumns = @JoinColumn(name = "empAtFacilityId", referencedColumnName = "id"))
	@ManyToMany(mappedBy = "facilities")
	public Set<EmpAtFacility> getEmpAtFacility() {
		return empAtFacility;
	}
	public void setEmpAtFacility(Set<EmpAtFacility> empAtFacility) {
		this.empAtFacility = empAtFacility;
	}
}
