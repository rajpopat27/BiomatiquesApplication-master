package com.biomatiques.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biomatiques.model.Shift;
import com.biomatiques.service.ShiftService;

@RestController
public class ShiftController {
	
	 @Autowired
	    ShiftService shiftService;
	    
	    //GET Methods one and all employees
	    @RequestMapping(method = RequestMethod.GET, value = "/shift")
	    public List<Shift> getAllEmployees(){
	        return shiftService.getAllShifts();
	    }
	    
	    @RequestMapping(value="/shift/{id}",headers="Accept=application/json",method=RequestMethod.GET)
	    public Shift getEmployeeById(@PathVariable Long id) {
	    	return shiftService.getShiftById(id);
	    }
	    
	    //Add Method
	    @RequestMapping(value="/shift",headers="Accept=application/json",method=RequestMethod.POST)
	    public void addEmployee( @RequestBody Shift shift) {
	        shiftService.addShift(shift);
	    }
	    
	    //Update Method
	    @RequestMapping(value="/shift",headers="Accept=application/json",method=RequestMethod.PUT)
	    public void updateEmployee(@RequestBody Shift shift ) {
	        shiftService.updateShift(shift);
	    }
	    
	    //Delete Method
	    @RequestMapping(value="/shift/{id}",headers="Accept=application/json",method=RequestMethod.DELETE)
	    public void deleteEmployee( @PathVariable long id) {
	        shiftService.deleteShift(id);
	    }
}
