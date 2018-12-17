package com.biomatiques.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "attendance")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"attendedDate"},
        allowGetters = true)

public class Attendance {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date attendedDate;
	
	@Column
	private long employeeId;
	
	@Column
	private String employeeFirstName;
	
	@Column
	private String employeeLastName;
	
//	@ManyToOne
//	Employee employee;

	/*@OneToOne
	@JoinColumn(name="Employee_ID")
	private Employee employeeId;
	@OneToOne
	@JoinColumn(name="Employee_First_Name")
	private Employee employeeFirstName;
*/

	public Long getId() {
		return id;
	}
	
	public Date getAttendedDate() {
		return attendedDate;
	}
	
	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
		

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}


}
