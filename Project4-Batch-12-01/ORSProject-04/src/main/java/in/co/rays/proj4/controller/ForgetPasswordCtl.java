package in.co.rays.proj4.controller;

import java.io.IOException;

import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.UserModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import in.co.rays.proj4.util.ServletUtility;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ForgetPasswordCtl")
public class ForgetPasswordCtl extends BaseCtl<UserBean, UserModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("login"))) {
			request.setAttribute("login", "login is required");
			pass = false;
		} else if (!DataValidator.isEmail(request.getParameter("login"))) {
			request.setAttribute("login", "login is not in valid formate");
			pass = false;
		}

		return pass;

	}

	@Override
	protected UserBean populateBean(HttpServletRequest request) {
		UserBean bean = new UserBean();
		bean.setLogin(DataUtility.getString(request.getParameter("login")));
		return bean;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserModel model = getModel();
		UserBean bean = populateBean(request);

		bean = model.forgotPassword(bean.getLogin());

		if (bean != null) {
			ServletUtility.setSuccessMessage("forgot password successfully check your mail", request);
		} else {
			ServletUtility.setErrorMessage("something went wrong please verify you emial again", request);
		}

		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		return ORSView.FORGET_PASSWORD_VIEW;
	}

	@Override
	protected UserModel getModel() {
		return new UserModel();
	}

}
