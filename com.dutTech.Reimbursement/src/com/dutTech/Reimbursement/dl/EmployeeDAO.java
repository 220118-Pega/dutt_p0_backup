package com.dutTech.Reimbursement.dl;

import java.util.ArrayList;


import com.dutTech.Reimbursement.enums.Status;
import com.dutTech.Reimbursement.models.Employee;
import com.dutTech.Reimbursement.models.Ticket;

public class EmployeeDAO implements DAO<Employee,Integer>{

	@Override
	public Employee findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Employee> getTicketByEmployeeId(Integer employee_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Ticket> filterStatus(Status status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Employee newObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Employee newObject) {
		// TODO Auto-generated method stub
		
	}

}
