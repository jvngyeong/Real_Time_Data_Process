package jspMVCMisoShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCMisoShopping.service.employee.EmployeeAutoNumService;
import jspMVCMisoShopping.service.employee.EmployeeDeleteService;
import jspMVCMisoShopping.service.employee.EmployeeDetailService;
import jspMVCMisoShopping.service.employee.EmployeeListService;
import jspMVCMisoShopping.service.employee.EmployeeRegistService;
import jspMVCMisoShopping.service.employee.EmployeeUpdateService;

public class EmployeeFrontController extends HttpServlet{
	public void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/employeeList.emp")) {
			EmployeeListService action = new EmployeeListService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/employee/employeeList.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/employeeWrite.emp")) {
			EmployeeAutoNumService action = new EmployeeAutoNumService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/employee/employeeForm.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/employeeRegist.emp")) {
			EmployeeRegistService action = new EmployeeRegistService();
			action.execute(req);
			resp.sendRedirect("employeeList.emp");
		}
		else if(command.equals("/employeeDetail.emp")) {
			EmployeeDetailService action = new EmployeeDetailService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/employee/employeeDetail.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/employeeModify.emp")) {
			EmployeeDetailService action = new EmployeeDetailService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/employee/employeeModify.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/employeeUpdate.emp")) {
			EmployeeUpdateService action = new EmployeeUpdateService();
			action.execute(req);
			resp.sendRedirect("employeeDetail.emp?empNum=" + req.getParameter("empNum"));
		}
		else if(command.equals("/employeeDelete.emp")) {
			EmployeeDeleteService action = new EmployeeDeleteService();
			action.execute(req);
			resp.sendRedirect("employeeList.emp");
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
