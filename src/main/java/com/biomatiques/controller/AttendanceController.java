package com.biomatiques.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biomatiques.model.Attendance;
import com.biomatiques.service.AttendanceService;

@RestController
public class AttendanceController {

	@Autowired
	AttendanceService attendanceService;
	
	@RequestMapping(value="/attendance",method=RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<Void> addAttendance(@RequestBody byte[] irisId) throws ParseException, URISyntaxException {
 		if(attendanceService.addAttendance(irisId)==true) {
			 return ResponseEntity.created(new URI("done")).build();
		}
		else{
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@RequestMapping(value="/attendance",method=RequestMethod.GET)
	public List<Attendance> getAttendance() {
		return attendanceService.getAllAttendance();
	}
	
	@RequestMapping(value="/attendance/{employeeId}",method=RequestMethod.GET,headers="Accept=application/json")
	public List<Attendance> getAttendanceByEmployeeId(@PathVariable long employeeId) {
		return attendanceService.getAttendanceByEmployeeId(employeeId);
	}
	
	@RequestMapping(value="/attendance/employee/{firstName}",method=RequestMethod.GET,headers="Accept=application/json")
	public List<Attendance> getAttendanceByEmployeeFirstName(@PathVariable String firstName) {
		return attendanceService.getAttendanceByEmployeeFirstName(firstName);
	}
	
	@RequestMapping(value="/attendance/attended_date/{date}", method=RequestMethod.GET,headers="Accept=application/json")
		public List<Attendance> getAttendanceByDate(@PathVariable("date") String date){
			return attendanceService.getAttendanceByDate(date);
		}
	
	 
}
