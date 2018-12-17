package com.biomatiques.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biomatiques.model.ShiftPattern;
import com.biomatiques.service.ShiftPatternService;

@RestController
public class ShiftPatternController {

	@Autowired
    ShiftPatternService shiftPatternService;
    
    //GET Methods one and all employees
    @RequestMapping(method = RequestMethod.GET, value = "/shiftPattern")
    public List<ShiftPattern> getAllShiftPattern(){
        return shiftPatternService.getAllShiftPattern();
    }
    
    @RequestMapping(value="/shiftPattern/{id}",headers="Accept=application/json",method=RequestMethod.GET)
    public ShiftPattern getShiftPatternById(@PathVariable Long id) {
    	return shiftPatternService.getShiftPatternById(id);
    }
    
    //Add Method
    @RequestMapping(value="/shiftPattern",headers="Accept=application/json",method=RequestMethod.POST)
    public void addShiftPattern( @RequestBody ShiftPattern shift) {
        shiftPatternService.addShiftPattern(shift);
    }
    
    //Update Method
    @RequestMapping(value="/shiftPattern",headers="Accept=application/json",method=RequestMethod.PUT)
    public void updateShiftPattern(@RequestBody ShiftPattern shift ) {
    		shiftPatternService.updateShiftPattern(shift);
    }
    
    //Delete Method
    @RequestMapping(value="/shiftPattern/{id}",headers="Accept=application/json",method=RequestMethod.DELETE)
    public void deleteShiftPAttern( @PathVariable long id) {
        shiftPatternService.deleteShiftPattern(id);
    }
}
