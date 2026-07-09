package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.RoleBean;
import com.sunilos.p4.model.RoleModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/RoleCtl")
public class RoleCtl extends BaseCtl<RoleBean, RoleModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("name"))) {
			pass = false;
			request.setAttribute("name", "role name is required");
		}

		if (DataValidator.isNull(request.getParameter("description"))) {
			pass = false;
			request.setAttribute("description", "description is required");
		}

		return pass;

	}

	@Override
	protected RoleBean populateBean(HttpServletRequest request) {
		RoleBean bean = new RoleBean();

		bean.setName(request.getParameter("name"));
		bean.setDescription(request.getParameter("description"));
		bean.setId(DataUtility.getLong(request.getParameter("id")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.ROLE_VIEW;
	}

	@Override
	protected String getView(String op) {
		if (OP_CANCEL.equalsIgnoreCase(op) || OP_DELETE.equalsIgnoreCase(op)) {
			return ORSView.ROLE_LIST_CTL;
		} else {
			return ORSView.ROLE_VIEW;
		}
	}

	@Override
	protected RoleModel getModel() {
		return new RoleModel();
	}

}
