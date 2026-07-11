package com.sunilos.p4.ctl;

import com.sunilos.p4.model.BaseModel;

import jakarta.servlet.annotation.WebServlet;

/**
 * Welcome functionality Controller. Performs operation for Show Welcome page
 * 
 * @author Rays EdTech
 * @version 1.0
 * @Copyright (c) Rays EdTech
 */

@WebServlet("/WelcomeCtl")
public class WelcomeCtl extends BaseCtl {

	@Override
	protected String getView() {
		return ORSView.WELCOME_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.WELCOME_VIEW;
	}

	@Override
	protected BaseModel getModel() {
		return null;
	}

}