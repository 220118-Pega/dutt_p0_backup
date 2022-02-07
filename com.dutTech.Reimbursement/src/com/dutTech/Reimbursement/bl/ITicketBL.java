package com.dutTech.Reimbursement.bl;

import java.util.ArrayList;

import com.dutTech.Reimbursement.models.Ticket;

public interface ITicketBL {
	
	void addTicket(Ticket ticket);
	
	ArrayList<Ticket> getTickets();
	
	Ticket getTicketById(int id);
	
	void updateTicket(Ticket ticket);

}
