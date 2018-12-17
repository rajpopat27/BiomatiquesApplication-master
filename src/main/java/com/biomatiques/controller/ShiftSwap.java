package com.biomatiques.controller;

import java.net.URI;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biomatiques.service.ShiftSwapService;

@RestController
public class ShiftSwap {

	@Autowired
	ShiftSwapService shiftSwapService;
	@RequestMapping(value="/shiftSwap",method=RequestMethod.GET,headers="Accept=application/json")
	public void swqpShift(@RequestParam("emp1") long emp1,
						  @RequestParam("emp2") long emp2,
						  @RequestParam("date") String date) throws ParseException{
 		shiftSwapService.swapShift(emp1, emp2, date);
	}
}
