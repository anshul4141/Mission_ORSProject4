package in.co.rays.proj4.controller;

import java.io.IOException;

import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.UserModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import in.co.rays.proj4.util.ServletUtility;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ChangePasswordCtl extends BaseCtl<UserBean, UserModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("login"))) {
			request.setAttribute("login", "login is required");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("newPassword"))) {
			request.setAttribute("newPassword", "newPassword is required");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("oldPassword"))) {
			request.setAttribute("oldPassword", "oldPassword is required");
			pass = false;
		}

		return pass;
	}

	@Override
	protected UserBean populateBean(HttpServletRequest request) {

		UserBean bean = new UserBean();

		bean.setLogin(DataUtility.getString(request.getParameter("login")));
		bean.setPassword(DataUtility.getString(request.getParameter("oldPassword")));

		return bean;

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean bean = populateBean(request);
		UserModel model = getModel();

		bean = model.changePassword(request.getParameter("newPassword"), bean.getPassword(), bean.getLogin());

		if (bean != null) {
			ServletUtility.setSuccessMessage("your password has been changed check you emial", request);
		} else {
			ServletUtility.setErrorMessage("your email is incorect", request);
		}

		super.doPost(request, response);
	}

	@Override
	public UserModel getModel() {
		return new UserModel();
	}

	@Override
	public String getView() {
		return ORSView.CHANGE_PASSWORD_VIEW;
	}

}
