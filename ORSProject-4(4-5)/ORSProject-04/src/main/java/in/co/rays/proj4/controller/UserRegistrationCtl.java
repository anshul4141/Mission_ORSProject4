package in.co.rays.proj4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.util.ServletUtility;

@WebServlet(name = "UserRegistrationCtl", urlPatterns = { "/UserRegistrationCtl" })
public class UserRegistrationCtl extends BaseCtl {

	public static final String OP_SIGN_UP = "SignUp";

	@Override
	protected boolean validate(HttpServletRequest request) {
		System.out.println("in validate method");
		return false;
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		return super.populateBean(request);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do get method");
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do post method");
	}

	@Override
	protected String getView() {
		return ORSView.USER_REGISTRATION_VIEW;
	}

}
