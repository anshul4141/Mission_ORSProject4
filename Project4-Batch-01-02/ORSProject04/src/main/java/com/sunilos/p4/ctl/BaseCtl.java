package com.sunilos.p4.ctl;

import java.io.IOException;

import com.sunilos.p4.bean.BaseBean;
import com.sunilos.p4.bean.UserBean;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.model.BaseModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.ServletUtility;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class BaseCtl<B extends BaseBean, M extends BaseModel> extends HttpServlet {

	public static final String OP_SAVE = "Save";
	public static final String OP_CANCEL = "Cancel";
	public static final String OP_DELETE = "Delete";
	public static final String OP_LIST = "List";
	public static final String OP_SEARCH = "Search";
	public static final String OP_VIEW = "View";
	public static final String OP_NEXT = "Next";
	public static final String OP_PREVIOUS = "Previous";
	public static final String OP_NEW = "New";
	public static final String OP_GO = "Go";
	public static final String OP_BACK = "Back";
	public static final String OP_LOG_OUT = "Logout";

	// controller error constants
	public static final String HAS_ERROR = "haserror";
	public static final String MESSAGE = "message";

	public static final String MSG_SUCCESS = "success";

	public static final String MSG_ERROR = "error";

	// check input data enter by user
	protected boolean validate(HttpServletRequest request) {
		return true;
	}

	// data loaded at the time of html page loaded
	protected void preload(HttpServletRequest request) {
	}

	// get data from view and set into the bean
	protected B populateBean(HttpServletRequest request) {
		return null;
	}

	// set common attribute like createdBy, modifiedBy, createdDateTime,
	// modifiedDateTime
	protected BaseBean populateDTO(BaseBean dto, HttpServletRequest request) {

		String createdBy = request.getParameter("createdBy");
		String modifiedBy = null;

		UserBean userbean = (UserBean) request.getSession().getAttribute("user");

		if (userbean == null) {
			// If record is created without login
			createdBy = "root";
			modifiedBy = "root";
		} else {
			modifiedBy = userbean.getLogin();
			// If record is created first time
			if ("null".equalsIgnoreCase(createdBy) || DataValidator.isNull(createdBy)) {
				createdBy = modifiedBy;
			}
		}
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);

		long cdt = DataUtility.getLong(request.getParameter("createdDatetime"));

		if (cdt > 0) {
			dto.setCreatedDatetime(DataUtility.getTimestamp(cdt));
		} else {
			dto.setCreatedDatetime(DataUtility.getCurrentTimestamp());
		}

		dto.setModifiedDatetime(DataUtility.getCurrentTimestamp());

		return dto;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Load the necessary preloaded data for displaying in an HTML form
		preload(request);

		String op = DataUtility.getString(request.getParameter("operation"));

		// Handle cancel operation
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(getView(op), request, response);
			return;
		}

		BaseBean bean = populateBean(request);

		// Perform validation if form is submitted using POST method
		if ("POST".equals(request.getMethod()) && !validate(request)) {
			ServletUtility.setBean(bean, request);
			ServletUtility.forwardPage(getView(), request, response);
			return;
		}

		try {
			super.service(request, response);
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
			ServletUtility.setBean(bean, request);
			ServletUtility.setErrorMessage(e.getMessage(), request);
			ServletUtility.forwardPage(getView(), request, response);
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = DataUtility.getString(request.getParameter("operation"));

		long id = DataUtility.getLong(request.getParameter("id"));

		if (id > 0 || op != null) {
			BaseBean bean = getModel().findByPk(id);
			ServletUtility.setBean(bean, request);
		}

		ServletUtility.forwardPage(getView(), request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get model

		long id = DataUtility.getLong(request.getParameter("id"));

		B bean = populateBean(request);

		// If primary key does exist then update the record of save the record
		if (id > 0) {
			getModel().update(bean);
			ServletUtility.setSuccessMessage("Data is successfully updated", request);
		} else {
			long pk = getModel().add(bean);
			ServletUtility.setSuccessMessage("Data is successfully saved", request);
			bean.setId(pk);
		}
		ServletUtility.setBean(bean, request);
		ServletUtility.forwardPage(getView(), request, response);

	}

	protected abstract String getView();

	protected abstract String getView(String op);

	protected abstract M getModel();
}