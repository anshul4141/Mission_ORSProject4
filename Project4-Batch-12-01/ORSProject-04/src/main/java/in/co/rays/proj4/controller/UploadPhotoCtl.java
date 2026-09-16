package in.co.rays.proj4.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.model.RoleModel;
import in.co.rays.proj4.model.UserModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import in.co.rays.proj4.util.PropertyReader;
import in.co.rays.proj4.util.ServletUtility;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/ctl/uploadphoto")
@MultipartConfig
public class UploadPhotoCtl extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RoleModel model = new RoleModel();
		try {
			List l = model.list();
			request.setAttribute("roleList", l);
		} catch (ApplicationException e) {
		}

		super.service(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id = DataUtility.getLong(request.getParameter("id"));

		UserModel model = new UserModel();
		UserBean bean = null;

		try {
			bean = model.findByPK(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String photoPath = PropertyReader.getValue("photoPath");

		// User photo available
		if (bean != null && DataValidator.isNotNull(bean.getPhoto())) {

			File file = new File(photoPath, bean.getPhoto());

			if (file.exists()) {

				response.setContentType(getServletContext().getMimeType(file.getName()));

				InputStream in = new java.io.FileInputStream(file);
				OutputStream out = response.getOutputStream();

				byte[] buffer = new byte[4096];
				int bytes;

				while ((bytes = in.read(buffer)) != -1) {
					out.write(buffer, 0, bytes);
				}

				in.close();
				out.close();

				return;
			}
		}

		// Default photo
		InputStream in = getServletContext().getResourceAsStream("/img/logo.png");

		response.setContentType("image/png");

		OutputStream out = response.getOutputStream();

		byte[] buffer = new byte[4096];
		int bytes;

		while ((bytes = in.read(buffer)) != -1) {
			out.write(buffer, 0, bytes);
		}

		in.close();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id = DataUtility.getLong(request.getParameter("id"));
		String view = request.getParameter("view");
		UserModel model = new UserModel();
		UserBean bean = model.findByPK(id);

		// Get uploaded photo
		Part part = request.getPart("photo");

		if (part == null || part.getSize() == 0) {
			ServletUtility.setBean(bean, request);
			ServletUtility.setErrorMessage("Photo is required", request);
			ServletUtility.forward(getView(), request, response);
			return;
		}

		String fileName = part.getSubmittedFileName();

		System.out.println("image name: " + fileName);

		String photoPath = PropertyReader.getValue("photoPath");

		System.out.println("folder path: " + photoPath);

		File folder = new File(photoPath);

		if (!folder.exists()) {
			folder.mkdirs();
		}

		File destFile = new File(folder, fileName);

		InputStream input = part.getInputStream();
		FileOutputStream output = new FileOutputStream(destFile);

		byte[] buffer = new byte[4096];
		int bytesRead;

		while ((bytesRead = input.read(buffer)) != -1) {
			output.write(buffer, 0, bytesRead);
		}

		input.close();
		output.close();

		try {

			model.updatePhoto(id, fileName);

			System.out.println("Photo uploaded successfully: " + fileName);

		} catch (ApplicationException e) {
			e.printStackTrace();
			ServletUtility.setErrorMessage("Photo upload failed", request);
			ServletUtility.forward(getView(), request, response);
			return;
		}

		if ("profile".equals(view)) {
			response.sendRedirect("MyProfileCtl");
		} else {
			response.sendRedirect("UserCtl?id=" + id);
		}
	}

	public String getView() {
		return ORSView.USER_VIEW;
	}
}