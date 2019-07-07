package com.in28minutes.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Override 
	public boolean shouldFilter() {
		// should this filter be executed or not for every request
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// real logic for interception
		// details of request
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		// indicate when should be filtering happen(before or after request executions
		// or else only for error n exception
		return "pre";
	}

	@Override
	public int filterOrder() {
		// set priority if there are multiple filter

		return 1;
	}

}
