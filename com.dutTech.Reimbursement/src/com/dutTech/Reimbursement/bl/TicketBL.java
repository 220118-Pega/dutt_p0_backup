package com.dutTech.Reimbursement.bl;

import java.util.ArrayList;

import com.dutTech.Reimbursement.dl.IRepo;
import com.dutTech.Reimbursement.models.Ticket;

public class TicketBL implements ITicketBL{
	
	private IRepo repo;
	
	public TicketBL(IRepo repo){
		this.repo=repo;
	}

	@Override
	public void addTicket(Ticket ticket) {

		repo.addTicket(ticket);
	}

	@Override
	public ArrayList<Ticket> getTickets() {

		return repo.getTickets();
	}

	@Override
	public Ticket getTicketById(int id) {
		
		return repo.getTicketById(id);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		
		repo.updateTicket(ticket);
		
	}

}
