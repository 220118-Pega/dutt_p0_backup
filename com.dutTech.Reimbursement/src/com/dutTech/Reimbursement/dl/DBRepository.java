package com.dutTech.Reimbursement.dl;

import java.util.ArrayList;

import com.dutTech.Reimbursement.models.Ticket;

public class DBRepository implements IRepo{
	
	private DAO<Ticket,Integer> ticketDAO;
	
	
	public DBRepository(DAO<Ticket,Integer> ticketDAO) {
		this.ticketDAO=ticketDAO;
	}

	@Override
	public ArrayList<Ticket> getTickets() {

		return ticketDAO.findAll();
	}

	@Override
	public Ticket getTicketById(int id) {

		return ticketDAO.findById(id);
	}

	@Override
	public void addTicket(Ticket newTicket) {
		
		ticketDAO.add(newTicket);
		
	}

	@Override
	public void updateTicket(Ticket newTicket) {
		
		ticketDAO.update(newTicket);
	}

}
