package com.dutTech.Reimbursement.utils;

import com.dutTech.Reimbursement.models.Ticket;

import io.javalin.plugin.openapi.dsl.OpenApiBuilder;

import io.javalin.plugin.openapi.dsl.OpenApiDocumentation;

public class DocumentationFactory {
	
	public static OpenApiDocumentation getDoc(String endPoint) {
		
		switch(endPoint) {
		
		case"addTicket":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Tickets");
			}).body(Ticket.class).result("201");
			
		case"updateTicket":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Tickets");
			}).body(Ticket.class).result("201");
			
		case"getTickets":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Tickets");
			}).jsonArray("200",Ticket.class);
			
		case"getTicketById":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Tickets");
			}).json("200",Ticket.class);
			
		default:
			return null;
		
		}
	}

}
