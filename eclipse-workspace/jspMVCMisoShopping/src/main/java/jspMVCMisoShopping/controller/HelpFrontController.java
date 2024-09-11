package jspMVCMisoShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCMisoShopping.service.help.IDFindService;
import jspMVCMisoShopping.service.help.PwFindService;

public class HelpFrontController extends HttpServlet{
	protected void process(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/idInquiry.help")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/help/findId.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/idFind.help")) {
			IDFindService action = new IDFindService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/help/findIdOk.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/pwInquiry.help")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/help/findPw.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/findPwOk.help")) {
			PwFindService action = new PwFindService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/help/findPwOk.jsp");
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
