package jspMVCMisoShopping.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCMisoShopping.service.inquire.InquireListService;
import jspMVCMisoShopping.service.inquire.InquireWriteProService;

public class InquireFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		if(command.equals("/inquireList.inq")) {
			InquireListService action = new InquireListService();
			action.execute(req);
			String goodsNum = req.getParameter("goodsNum");
			req.setAttribute("goodsNum", goodsNum);
			RequestDispatcher dispatcher = req.getRequestDispatcher("inquire/inquireList.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/inquireWrite.inq")) {
			String goodsNum = req.getParameter("goodsNum");
			req.setAttribute("goodsNum", goodsNum);
			RequestDispatcher dispatcher = req.getRequestDispatcher("inquire/inquireForm.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/inquireWritePro.inq")) {
			InquireWriteProService action = new InquireWriteProService(req);
			action.execute(req);
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();
			String str = " <script type = 'text/javascript'>"
						+ "		opener.parent.inquire();"
						+ "		window.self.close();"
						+ " </script>";
			out.print(str);
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
