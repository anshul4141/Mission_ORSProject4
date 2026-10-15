package in.co.rays.proj4.controller;

import java.io.IOException;

import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import in.co.rays.proj4.util.MessageSource;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class LanguageFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		MessageSource messagesource = MessageSource.getInstance();

		String lang = DataUtility.getString(req.getParameter("lang"));
		if (DataValidator.isNotNull(lang)) {
			messagesource.setLocale(lang);
		}

		chain.doFilter(req, response);

	}

	@Override
	public void destroy() {

	}

}
