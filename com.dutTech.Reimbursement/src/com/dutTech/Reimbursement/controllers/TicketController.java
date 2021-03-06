package com.dutTech.Reimbursement.controllers;



import com.dutTech.Reimbursement.bl.ITicketBL;
import com.dutTech.Reimbursement.enums.Reimbursement;
import com.dutTech.Reimbursement.enums.Status;
import com.dutTech.Reimbursement.models.Ticket;

import io.javalin.http.Handler;

public class TicketController implements IController{
	
	private ITicketBL ticketBL;
	
	public TicketController(ITicketBL ticketBL) {
		this.ticketBL=ticketBL;
	}
	

	@Override
	
	
	public Handler add() {

		return ctx ->{
			
			ticketBL.addTicket(ctx.bodyStreamAsClass(Ticket.class));
		};
	}

	
	@Override
	public Handler getAll() {

		return ctx ->{
			ctx.jsonStream(ticketBL.getTickets());
		};
	}

	
	
	@Override
	public Handler getById() {
		
		return ctx -> {
			int id = Integer.parseInt(ctx.pathParam("ticket_id"));
			try {
				ctx.jsonStream(ticketBL.getTicketById(id));
			}catch(NullPointerException e) {
				ctx.status(204);
			}
		};
	}

	
	
	@Override
	public Handler update() {

		return ctx->{
			ticketBL.updateTicket(ctx.bodyStreamAsClass(Ticket.class));
		};
	}

}
