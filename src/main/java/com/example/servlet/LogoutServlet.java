package com.example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

//	로깅을 예쁘게 나오게 하는 라이브러리
	static Log log = LogFactory.getLog(LogoutServlet.class);
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("########");
		log.info("doPost()");
		log.info("########");
		
		Cookie logout = new Cookie("login" , "hong");
		logout.setPath("/");
		logout.setMaxAge(0);
		
		response.addCookie(logout);
		
		response.sendRedirect("/index.jsp");
	}
	
}
