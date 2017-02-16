package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebFilter("/admin/*")
public class LoginFilter implements Filter {

	static Log log = LogFactory.getLog(LoginFilter.class);
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest requst, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("##########");
		log.info("dofilter()");
		log.info("##########");
		
		HttpServletRequest req = (HttpServletRequest)requst;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		Cookie[] cookies = req.getCookies();
		
		boolean login = false;
		
//		cookie에 "login"이 있으면 login(변수)이 true
		for(Cookie c : cookies){
			String name = c.getName();
			if("login".equals(name))
				login = true;
		}
		
			
		if(login)
			chain.doFilter(requst, response);			
		else
			resp.sendRedirect("/login");
	}

	@Override
	public void destroy() {
		
	}



}
