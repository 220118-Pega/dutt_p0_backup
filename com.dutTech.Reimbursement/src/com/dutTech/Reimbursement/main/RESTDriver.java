package com.dutTech.Reimbursement.main;

import com.dutTech.Reimbursement.bl.TicketBL;
import com.dutTech.Reimbursement.controllers.IController;
import com.dutTech.Reimbursement.controllers.TicketController;
import com.dutTech.Reimbursement.dl.DBRepository;
import com.dutTech.Reimbursement.dl.TicketDAO;
import com.dutTech.Reimbursement.utils.Router;

import io.javalin.Javalin;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;


public class RESTDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IController tController = new TicketController(
										new TicketBL(
												new DBRepository(
														new TicketDAO())));
		
		
		Javalin app = Javalin.create(config -> {
			config.registerPlugin(new OpenApiPlugin(getOpenApiOptions()));
		}).start(7000);
		Router router = new Router(app,tController);
		router.setUpEndPoints();
	}
	
	private static OpenApiOptions getOpenApiOptions() {
		Info applicationInfo = new Info().version("1.0").description("Reimbursement REST");
		return new OpenApiOptions(applicationInfo).path("/swagger-docs")
				.swagger(new SwaggerOptions("/swagger").title("Reimbursement API Docs"));
	}

	}

