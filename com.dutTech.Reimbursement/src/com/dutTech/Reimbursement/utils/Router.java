package com.dutTech.Reimbursement.utils;

import com.dutTech.Reimbursement.controllers.IController;

import io.javalin.Javalin;
import io.javalin.plugin.openapi.dsl.OpenApiBuilder;

public class Router {
	
	private Javalin app;
	private IController ticketController;
	
	
	public Router(Javalin app, IController ticketController) {
		this.app=app;
		this.ticketController=ticketController;
	}
	
	
	public void setUpEndPoints() {
		
		app.get("/tickets", OpenApiBuilder.documented(DocumentationFactory.getDoc("getTickets"), ticketController.getAll()));
		app.get("/ticket/{ticket_id}", OpenApiBuilder.documented(DocumentationFactory.getDoc("getTicketById"), ticketController.getById()));
		app.post("/tickets", OpenApiBuilder.documented(DocumentationFactory.getDoc("addTicket"), ticketController.add()));
		app.put("/ticket/{ticket_id}", OpenApiBuilder.documented(DocumentationFactory.getDoc("updateTicket"), ticketController.update()));
		
	}

}
