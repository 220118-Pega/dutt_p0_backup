package com.dutTech.Reimbursement.dl;

import java.util.ArrayList;

import com.dutTech.Reimbursement.enums.Status;
import com.dutTech.Reimbursement.models.Ticket;

public interface DAO<T,K> {
	T findById(K id);
	ArrayList<T>findAll();
	ArrayList<T>getTicketByEmployeeId(K employee_id);
	ArrayList<Ticket> filterStatus(Status status);
	void add(T newObject);
	void update(T newObject);
}

