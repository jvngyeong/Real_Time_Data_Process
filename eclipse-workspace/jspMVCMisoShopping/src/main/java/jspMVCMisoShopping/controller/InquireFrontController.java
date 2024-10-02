package jspMVCMisoShopping.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCMisoShopping.model.dao.InquireDAO;
import jspMVCMisoShopping.service.inquire.InquireAnswerService;
import jspMVCMisoShopping.service.inquire.InquireDetailService;
import jspMVCMisoShopping.service.inquire.InquireListService;
import jspMVCMisoShopping.service.inquire.InquireUpdateService;
import jspMVCMisoShopping.service.inquire.InquireWriteProService;

public class InquireFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		if(command.equals("/inquireList.inq")) {
			InquireListService action = new InquireListService(req);
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
		else if(command.equals("/inquireUpdate.inq")) {
			InquireDetailService action = new InquireDetailService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("inquire/inquireUpdate.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/inquireModify.inq")) {
			InquireUpdateService action = new InquireUpdateService();
			action.execute(req);
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();
			String str = " <script type = 'text/javascript'>"
						+ "		opener.parent.inquire();"
						+ "		window.self.close();"
						+ " </script>";
			out.print(str);
		}
		else if(command.equals("/inquireDelete.inq")) {
			String inquireNum = req.getParameter("inquireNum");
			InquireDAO dao = new InquireDAO();
			dao.inquireDelete(inquireNum);
		}
		else if(command.equals("/inquire.inq")) {
			InquireListService action = new InquireListService(req);
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("inquire/inquireListEmp.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/inquireAnswer.inq")) {
			InquireDetailService action = new InquireDetailService();
			action.execute(req);
			req.setAttribute("newLine", "\n");
			RequestDispatcher dispatcher = req.getRequestDispatcher("inquire/inquireAnswer.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/inquireRepleUpdate.inq")) {
			InquireAnswerService action = new InquireAnswerService(req);
			action.execute(req);
			resp.sendRedirect("inquire.inq");
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
