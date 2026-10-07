package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.model.RoleModel;
import in.co.rays.proj4.util.DataUtility;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/RoleListCtl")
public class RoleListCtl extends BaseListCtl<RoleBean, RoleModel> {

	@Override
	protected RoleBean populateBean(HttpServletRequest request) {

		RoleBean bean = new RoleBean();

		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setDescription(DataUtility.getString(request.getParameter("description")));

		return bean;

	}

	@Override
	public RoleModel getModel() {
		return new RoleModel();
	}

	@Override
	public String getView() {
		return ORSView.ROLE_LIST_VIEW;
	}

}
