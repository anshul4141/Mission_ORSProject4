package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.RoleBean;
import com.sunilos.p4.model.RoleModel;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/RoleListCtl")
public class RoleListCtl extends BaseListCtl<RoleBean, RoleModel> {

	@Override
	protected RoleBean populateBean(HttpServletRequest request) {
		RoleBean bean = new RoleBean();

		bean.setName(request.getParameter("name"));
		bean.setDescription(request.getParameter("description"));

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.ROLE_LIST_VIEW;
	}

	@Override
	protected String getView(String op) {

		return ORSView.ROLE_LIST_VIEW;
	}

	@Override
	protected RoleModel getModel() {
		return new RoleModel();
	}

}
