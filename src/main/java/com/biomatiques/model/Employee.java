package com.biomatiques.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Employee")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)

public class Employee implements Serializable{
   

	public Employee() {
       
    }
    
	    @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    @Column(name="employeeId")
    	private long id;
	    
	    @NotEmpty
		@JsonProperty("FirstName")	
        public String firstname;
		
	    @NotEmpty
		@JsonProperty("MiddleName")
        public String middlename;
		
	    @NotEmpty
		@JsonProperty("LastName")
        public String lastname;
		
	    @NotEmpty
		@JsonProperty("PhoneNumber")
	    @Pattern(regexp="(^$|[0-9]{10})")
        public String phoneno;
		
	    
		@JsonProperty("DateOfBirth")
		@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
		public Date dob;
        
	    @NotEmpty
		@JsonProperty("Address")
		public String address;
        
	    @NotEmpty
	    @JsonProperty("Pincode")
	    public String pincode;
	    
	    @NotEmpty
		@JsonProperty("State")
		public String state;
        
	    @NotEmpty
		@JsonProperty("Email")
		public String email;
        
	    
        @JsonProperty("LinkedinId")
        public String linkedinid;
        
        @NotEmpty
        @JsonProperty("BloodGroup")
        public String bloodgroup;
        
        @NotEmpty
        @JsonProperty("AadharNumber")
        public String aadharno;
        
        @Min(0)
        @JsonProperty("ExperienceYears")
        public Integer experience;
        
        @NotEmpty
        @JsonProperty("Department")
        public String department;
        
        @NotEmpty
        @JsonProperty("EmployeeType")
        public String employeetype;
        
        @NotEmpty
        @JsonProperty("EmployeePost")
        public String post;
        
        @NotEmpty
        @JsonProperty("ShiftName")
        public String shiftname;
        
        @Min(1000)
        @JsonProperty("Salary")
        public Long salary;
           
        @NotEmpty
        @JsonProperty("IrisId")
        @Lob       
        public byte[] irisId;
        
        
		@Column(nullable = false, updatable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @CreatedDate
	    private Date joinedAt;
	   
	    @Column(nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @LastModifiedDate
	    private Date updatedAt;
	    
        public long getId() {
    		return id;
    	}
        
        
		public byte[] getIrisId() {
			return irisId;
		}


		public void setIrisId(byte[] irisId) {
			this.irisId = irisId;
		}


		//1
        public String getFirstname() {
            return firstname;
        }
        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }
        
        //2
        public String getMiddlename() {
            return middlename;
        }
        public void setMiddlename(String middlename) {
            this.middlename = middlename;
        }
        
        //3
        public String getLastname() {
            return lastname;
        }
        public void setLastname(String lastname) {
            this.lastname = lastname;
        }
        
        //4
        public String getPhoneno() {
            return phoneno;
        }
        public void setPhoneno(String phoneno) {
            this.phoneno = phoneno;
        }
        
        //5
        public Date getDob() {
			return dob;
		}
		public void setDob(Date dob) {
			this.dob = dob;
		}
		
		//6
		public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address = address;
        }
        
        //7
        public String getState() {
            return state;
        }
        public void setState(String state) {
            this.state = state;
        }
        
        //8
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        
        //9
		public String getLinkedinid() {
			return linkedinid;
		}
		public void setLinkedinid(String linkedinid) {
			this.linkedinid = linkedinid;
		}
        //10
		public String getBloodgroup() {
			return bloodgroup;
		}
		public void setBloodgroup(String bloodgroup) {
			this.bloodgroup = bloodgroup;
		}
		//11
		public String getAadharno() {
			return aadharno;
		}
		public void setAadharno(String aadharno) {
			this.aadharno = aadharno;
		}
		//12
		public Integer getExperience() {
			return experience;
		}
		public void setExperience(Integer experience) {
			this.experience = experience;
		}
		//13
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		//14
		public String getEmployeetype() {
			return employeetype;
		}
		public void setEmployeetype(String employeetype) {
			this.employeetype = employeetype;
		}
		//15
		public String getPost() {
			return post;
		}
		public void setPost(String post) {
			this.post = post;
		}
		//16  
        public String getShiftname() {
			return shiftname;
		}
		public void setShiftname(String shiftname) {
			this.shiftname = shiftname;
		}
		//17
		public Long getSalary() {
			return salary;
		}
		public void setSalary(Long salary) {
			this.salary = salary;
		}
		
		//18
		public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		
		//19
		 public Date getJoinedAt() {
				return joinedAt;
			}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		//20	
		

		
}