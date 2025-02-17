package com.alacriti.HealthCare.utility;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alacriti.HealthCare.Service.AppointmentsService;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebFilter(urlPatterns = "/*")
public class Filters implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(AppointmentsService.class);
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		logger.info("Incoming Request: " + httpRequest.getMethod() + " " + httpRequest.getRequestURI());

		chain.doFilter(request, response);

		logger.info("Outgoing Response: HTTP Status " + httpResponse.getStatus());

	}

}
