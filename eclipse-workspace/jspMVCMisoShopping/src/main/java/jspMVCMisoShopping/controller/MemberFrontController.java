package jspMVCMisoShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCMisoShopping.service.member.MemberListService;
import jspMVCMisoShopping.service.member.MemberWriteService;

public class MemberFrontController extends HttpServlet{
	protected void process(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/memberList.mem")) {
			MemberListService action = new MemberListService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/member/memberList.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/memberWrite.mem")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/member/memberForm.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/memberRegist.mem")) {
			MemberWriteService action = new MemberWriteService();
			action.execute(req);
			resp.sendRedirect("memberList.mem");
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
