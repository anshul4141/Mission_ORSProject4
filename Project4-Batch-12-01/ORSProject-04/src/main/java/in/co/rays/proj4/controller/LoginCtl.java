package in.co.rays.proj4.controller;

import java.io.IOException;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.RoleModel;
import in.co.rays.proj4.model.UserModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import in.co.rays.proj4.util.ServletUtility;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginCtl")
public class LoginCtl extends BaseCtl<UserBean, UserModel> {

	public static final String OP_SIGN_IN = "SignIn";

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("login"))) {
			pass = false;
			request.setAttribute("login", "login is required");
		}
		if (DataValidator.isNull(request.getParameter("password"))) {
			pass = false;
			request.setAttribute("login", "password is required");
		}

		return pass;
	}

	@Override
	protected UserBean populateBean(HttpServletRequest request) {

		UserBean bean = new UserBean();

		bean.setLogin(DataUtility.getString(request.getParameter("login")));
		bean.setPassword(DataUtility.getString(request.getParameter("password")));

		return bean;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = DataUtility.getString(request.getParameter("operation"));

		if (op != null) {
			HttpSession session = request.getSession();
			session.invalidate();
			ServletUtility.setSuccessMessage("user logout successfully", request);
		}

		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = DataUtility.getString(request.getParameter("operation"));
		HttpSession session = request.getSession();

		UserBean bean = populateBean(request);

		if (OP_SIGN_IN.equalsIgnoreCase(op)) {
			UserModel m = getModel();
			bean = m.authenticate(bean.getLogin(), bean.getPassword());

			if (bean != null) {
				session.setAttribute("user", bean);
				RoleModel rmodel = new RoleModel();
				RoleBean rbean = rmodel.findByPK(bean.getRoleId());
				if (rbean != null) {
					session.setAttribute("role", rbean.getName());
				}
				ServletUtility.redirect(ORSView.WELCOME_CTL, request, response);
				return;
			} else {
				ServletUtility.setErrorMessage("Invalid login or password", request);
			}
		}

		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		return ORSView.LOGIN_VIEW;
	}

	@Override
	protected UserModel getModel() {
		return new UserModel();
	}

}
