package com.dutTech.Reimbursement.dl;

import java.util.ArrayList;

import com.dutTech.Reimbursement.models.Ticket;

public interface IRepo {
	
	ArrayList<Ticket>getTickets();
	Ticket getTicketById(int id);
	void addTicket(Ticket newTicket);
	void updateTicket(Ticket newTicket);

}
