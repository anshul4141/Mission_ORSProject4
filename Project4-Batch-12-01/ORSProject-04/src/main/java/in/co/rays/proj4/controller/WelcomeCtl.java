package in.co.rays.proj4.controller;

import in.co.rays.proj4.model.BaseModel;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/WelcomeCtl")
public class WelcomeCtl extends BaseCtl {

	@Override
	protected String getView() {
		return ORSView.WELCOME_VIEW;
	}

	@Override
	protected BaseModel getModel() {
		return null;
	}

}
