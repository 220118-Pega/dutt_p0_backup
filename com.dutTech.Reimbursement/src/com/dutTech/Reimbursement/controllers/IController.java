package com.dutTech.Reimbursement.controllers;

import io.javalin.http.Handler;

public interface IController {
	
	Handler add();
	Handler getAll();
	Handler getById();
	Handler update();
	

}
