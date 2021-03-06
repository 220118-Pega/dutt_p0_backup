package com.dutTech.Reimbursement.models;

import java.time.LocalDateTime;

import com.dutTech.Reimbursement.enums.Reimbursement;
import com.dutTech.Reimbursement.enums.Status;

public class Ticket {
	int id;
	double amount;
	Status status;
	Reimbursement category;
	String description;
	LocalDateTime ticket_time = LocalDateTime.now();
	int employee_id;
	
	
	public Ticket() {
		
	}
	
	
	
	public Ticket(Status status, Reimbursement category, String description) {
		super();
		this.status = status;
		this.category = category;
		this.description = description;
	}



	public Ticket(Status status, double amount, Reimbursement category, String description, LocalDateTime ticket_time) {
		this.status=status;
		this.amount=amount;
		this.category=category;
		this.description=description;
		this.ticket_time=ticket_time;
	}
	
	public Ticket(Status status, double amount, Reimbursement category, String description, LocalDateTime ticket_time, int id) {
		this.status=status;
		this.amount=amount;
		this.category=category;
		this.description=description;
		this.ticket_time=LocalDateTime.now();
		this.id=id;
	}
	
	public Ticket(Status status, double amount, Reimbursement category, String description, LocalDateTime ticket_time, int id,int employee_id) {
		this(status,amount,category,description,ticket_time,id);
		this.employee_id=employee_id;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Reimbursement getCategory() {
		return category;
	}

	public void setCategory(Reimbursement category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTicket_time() {
		return ticket_time;
	}

	public void setTicket_time(LocalDateTime ticket_time) {
		this.ticket_time = ticket_time;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", amount=" + amount + ", status=" + status + ", category=" + category
				+ ", description=" + description + ", ticket_time=" + ticket_time + ", employee_id=" + employee_id
				+ "]";
	}
	
	
	

}
