package in.co.rays.proj4.controller;

import java.io.IOException;
import java.util.List;

import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.model.BaseModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.ServletUtility;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class BaseListCtl<B extends BaseBean, M extends BaseModel> extends BaseCtl<B, M> {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		M model = getModel();
		B bean = populateBean(request);
		int pageNo = 1;
		int pageSize = 5;

		List<B> list = model.search(bean, pageNo, pageSize);
		List<B> nextList = model.search(bean, pageNo + 1, pageSize);

		request.setAttribute("nextList", nextList);
		ServletUtility.setList(list, request);
		ServletUtility.setPageNo(pageNo, request);
		ServletUtility.setPageSize(pageSize, request);

		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = DataUtility.getString(request.getParameter("operation"));
		M model = getModel();
		B bean = populateBean(request);
		int pageNo = 1;
		int pageSize = 5;

		if (OP_DELETE.equalsIgnoreCase(op)) {
			String[] ids = request.getParameterValues("ids");
			if (ids != null && ids.length > 0) {
				for (String id : ids) {
					model.delete(DataUtility.getInt(id));
					ServletUtility.setSuccessMessage("record deleted successfully", request);
				}
			} else {
				ServletUtility.setErrorMessage("select at least one record to delete", request);
			}
		}

		if (OP_NEXT.equalsIgnoreCase(op)) {
			pageNo = DataUtility.getInt(request.getParameter("pageNo"));
			pageNo++;
		}

		if (OP_PREVIOUS.equalsIgnoreCase(op)) {
			pageNo = DataUtility.getInt(request.getParameter("pageNo"));
			pageNo--;
		}

		List<B> list = model.search(bean, pageNo, pageSize);
		List<B> nextList = model.search(bean, pageNo + 1, pageSize);

		request.setAttribute("nextList", nextList);
		ServletUtility.setList(list, request);
		ServletUtility.setPageNo(pageNo, request);
		ServletUtility.setPageSize(pageSize, request);

		ServletUtility.forward(getView(), request, response);

	}

}
