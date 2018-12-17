package com.biomatiques.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biomatiques.model.LeaveManagement;
import com.biomatiques.repository.LeaveManagementRepository;

@Service
public class leaveManagementService {

	
	@Autowired
	LeaveManagementRepository leaveManagementRepository;
	
	public void addLeave(LeaveManagement leaveManagement) throws ParseException {
		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(leaveManagement.getDate1());
		Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(leaveManagement.getDate2());
		if (!(date1.compareTo(date2) > 0))
		leaveManagementRepository.save(leaveManagement);
	}

	public List<LeaveManagement> getAllLeave() {
		List<LeaveManagement> leaveList = new ArrayList<>();
        leaveManagementRepository.findAll().forEach(leaveList::add);
        return leaveList;
	}
	public List<LeaveManagement> getLeaveByEmpId(long empId) {
		List<LeaveManagement> leaveList = new ArrayList<>();
		leaveManagementRepository.findLeaveByEmpId(empId).forEach(leaveList::add);
		return leaveList;
	}
	
	 public void updateLeave(LeaveManagement leaveManagement) {
	    	leaveManagementRepository.save(leaveManagement);
	    }
	    public void deleteLeave(LeaveManagement leaveManagement) {
	     leaveManagement.setId(leaveManagementRepository.findId(leaveManagement.getEmpId(), leaveManagement.getDate1(),leaveManagement.getDate2()));
    	 leaveManagementRepository.delete(leaveManagement);
	    }
	    
    public LeaveManagement getLeaveByEmpIdDate(long empId,String date1,String date2) {
    	return leaveManagementRepository.findByEmpId(empId, date1, date2);
    }
}
