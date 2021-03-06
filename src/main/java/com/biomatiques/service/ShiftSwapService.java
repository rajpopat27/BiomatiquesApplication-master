package com.biomatiques.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biomatiques.model.ShiftPattern;
import com.biomatiques.repository.ShiftPatternRepository;
import com.biomatiques.service.EmployeeService;
import com.biomatiques.service.ShiftPatternService;

@Service
public class ShiftSwapService {

	@Autowired
	EmployeeService employeeService;
	@Autowired
	ShiftPatternService shiftPatternService;
	@Autowired
	ShiftPatternRepository shiftPatternRepository;
	
	int shiftEmp1,shiftEmp2,tempShiftEmp1,tempShiftEmp2;
	
	public void swapShift(long empId1,long empId2,String date) throws ParseException {
		ShiftPattern shiftPatternEmp1=shiftPatternRepository.findById(empId1);
		ShiftPattern shiftPatternEmp2=shiftPatternRepository.findById(empId2);
		 Date formattedDate=new SimpleDateFormat("dd/M/yyyy").parse(date);
		 String dayOfWeek = new SimpleDateFormat("EEEE").format(formattedDate).toLowerCase();
		 switch (dayOfWeek) { 
	        case "monday": 
	            shiftEmp1 = shiftPatternEmp1.getMonday();
	            shiftEmp2 = shiftPatternEmp2.getMonday();
	            tempShiftEmp1 = shiftEmp2;
	   		    tempShiftEmp2 = shiftEmp1;
	   		    shiftPatternEmp1.setMonday(tempShiftEmp1);
	   		    shiftPatternEmp2.setMonday(tempShiftEmp2);
	            
	            break; 
	        case "tuesday": 
	        	 shiftEmp1 = shiftPatternEmp1.getTuesday();
	             shiftEmp2 = shiftPatternEmp2.getTuesday();
	             tempShiftEmp1 = shiftEmp2;
	    		 tempShiftEmp2 = shiftEmp1;
	    		 shiftPatternEmp1.setTuesday(tempShiftEmp1);
	   		     shiftPatternEmp2.setTuesday(tempShiftEmp2);
	            break; 
	        case "wednesday": 
	        	 shiftEmp1 = shiftPatternEmp1.getWednesday();
	             shiftEmp2 = shiftPatternEmp2.getWednesday();
	             tempShiftEmp1 = shiftEmp2;
	    		 tempShiftEmp2 = shiftEmp1;
	    		 shiftPatternEmp1.setWednesday(tempShiftEmp1);
	   		     shiftPatternEmp2.setWednesday(tempShiftEmp2);
	            break; 
	        case "thursday": 
	        	shiftEmp1 = shiftPatternEmp1.getThursday();
	             shiftEmp2 = shiftPatternEmp2.getThursday();
	             tempShiftEmp1 = shiftEmp2;
	    		 tempShiftEmp2 = shiftEmp1;
	    		 shiftPatternEmp1.setThursday(tempShiftEmp1);
		   		    shiftPatternEmp2.setThursday(tempShiftEmp2);
	            break; 
	        case "friday": 
	        	shiftEmp1 = shiftPatternEmp1.getFriday();
	             shiftEmp2 = shiftPatternEmp2.getFriday();
	             tempShiftEmp1 = shiftEmp2;
	    		 tempShiftEmp2 = shiftEmp1;
	    		 shiftPatternEmp1.setFriday(tempShiftEmp1);
	   		     shiftPatternEmp2.setFriday(tempShiftEmp2);
	            break; 
	        case "saturday": 
	        	shiftEmp1 = shiftPatternEmp1.getSaturday();
	             shiftEmp2 = shiftPatternEmp2.getSaturday();
	             tempShiftEmp1 = shiftEmp2;
	    		 tempShiftEmp2 = shiftEmp1;
	    		 shiftPatternEmp1.setSaturday(tempShiftEmp1);
	   		     shiftPatternEmp2.setSaturday(tempShiftEmp2);
	            break; 
	        case "sunday": 
	        	shiftEmp1 = shiftPatternEmp1.getSunday();
	             shiftEmp2 = shiftPatternEmp2.getSunday();
	             tempShiftEmp1 = shiftEmp2;
	    		 tempShiftEmp2 = shiftEmp1;
	    		 shiftPatternEmp1.setSunday(tempShiftEmp1);
	   		     shiftPatternEmp2.setSunday(tempShiftEmp2);
	            break; 
	        default:
	            break; 
	        } 
		 
		shiftPatternRepository.save(shiftPatternEmp1);
		shiftPatternRepository.save(shiftPatternEmp2);
	}
}
