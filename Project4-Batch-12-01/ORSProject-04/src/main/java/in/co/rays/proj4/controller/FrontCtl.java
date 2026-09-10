package in.co.rays.proj4.controller;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import in.co.rays.proj4.util.ServletUtility;

@WebFilter("/ctl/*")
public class FrontCtl extends HttpFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession();

		if (session.getAttribute("user") == null) {
			ServletUtility.setErrorMessage("you session has been expired please re-login", req);
			ServletUtility.forward(ORSView.LOGIN_VIEW, req, res);
			return;
		}

		chain.doFilter(request, response); // call next filter/controller in the chain
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
