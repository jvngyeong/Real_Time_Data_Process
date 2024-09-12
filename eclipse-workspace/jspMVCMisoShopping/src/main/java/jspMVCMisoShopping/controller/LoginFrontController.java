package jspMVCMisoShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.service.login.UserLoginService;

public class LoginFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/login.login")) {
			UserLoginService action = new UserLoginService();
			int i = action.execute(req);
			if(i == 1) resp.sendRedirect(contextPath);
			else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
				dispatcher.forward(req, resp);
			}
		}
		else if(command.equals("/logout.login")) {
			HttpSession session = req.getSession();
			session.invalidate();	//모든 Session을 삭제
			resp.sendRedirect(contextPath);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doProcess(req, resp);
	}
}
