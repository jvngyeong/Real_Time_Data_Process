package jspMVCMisoShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCMisoShopping.service.user.IDCheckService;
import jspMVCMisoShopping.service.user.UserRegistService;

public class UserFrontController extends HttpServlet{
	protected void process(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/userAgree.nhn")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/user/userAgree.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/userWrite.nhn")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/user/userWrite.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/userRegist.nhn")) {
			UserRegistService action = new UserRegistService();
			action.execute(req);
			resp.sendRedirect("index.jsp");
		}
		else if(command.equals("/idCheck.nhn")) {
			IDCheckService action = new IDCheckService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/user/idCheck.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		process(req, resp);
	}
}
