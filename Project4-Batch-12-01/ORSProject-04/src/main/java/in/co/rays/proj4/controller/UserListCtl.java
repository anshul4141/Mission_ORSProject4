package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.UserModel;
import in.co.rays.proj4.util.DataUtility;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/UserListCtl")
public class UserListCtl extends BaseListCtl<UserBean, UserModel> {

	@Override
	protected UserBean populateBean(HttpServletRequest request) {
		UserBean bean = new UserBean();
		bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));
		bean.setLastName(DataUtility.getString(request.getParameter("lastName")));
		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.USER_LIST_VIEW;
	}

	@Override
	protected UserModel getModel() {
		return new UserModel();
	}

}
