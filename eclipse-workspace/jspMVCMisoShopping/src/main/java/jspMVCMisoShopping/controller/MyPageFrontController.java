package jspMVCMisoShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.service.employee.EmployeeDetailService;
import jspMVCMisoShopping.service.employee.EmployeeUpdateService;
import jspMVCMisoShopping.service.member.MemberDetailService;
import jspMVCMisoShopping.service.member.MemberUpdateService;
import jspMVCMisoShopping.service.user.EmployeePasswordService;
import jspMVCMisoShopping.service.user.MemberDropService;
import jspMVCMisoShopping.service.user.MemberPasswordService;

public class MyPageFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/memberMyPage.my")) {
			MemberDetailService action = new MemberDetailService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/myPage/memberMyPage.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/memberUpdate.my")){
			MemberDetailService action = new MemberDetailService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/myPage/myModify.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/memberModify.my")) {
			MemberUpdateService action = new MemberUpdateService();
			int i = action.execute(req);
			if (i == 1) {
				resp.sendRedirect("memberMyPage.my");
			}
			else {
				MemberDetailService action1 = new MemberDetailService();
				action1.execute(req);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/myPage/myModify.jsp");
				dispatcher.forward(req, resp);
			}
		}
		else if(command.equals("/userPwModify.my")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/myPage/myPwCon.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/memberPwModify.my")) {
			HttpSession session = req.getSession();
			AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
			String path = null;
			if(req.getParameter("memberPw").equals(auth.getUserPw())) {
				path = "/myPage/myNewPw.jsp";
			}
			else {
				req.setAttribute("errPw", "비밀번호가 틀렸습니다.");
				path = "/myPage/myPwCon.jsp";
			}
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/memberPwPro.my")) {
			MemberPasswordService action = new MemberPasswordService();
			int i = action.execute(req);
			if(i == 1) resp.sendRedirect("memberMyPage.my");
			else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/myPage/myPwCon.jsp");
				dispatcher.forward(req, resp);
			}
		}
		
		else if(command.equals("/memberDrop.my")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/myPage/memberDrop.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/memberDropOk.my")) {
			MemberDropService action = new MemberDropService();
			int i = action.execute(req);
			if(i == 1) {
				resp.sendRedirect("logout.login");
				HttpSession session = req.getSession();
				session.invalidate();
			}
			else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/myPage/memberDrop.jsp");
				dispatcher.forward(req, resp);
				req.setAttribute("errPw", "비밀번호가 틀렸습니다.");
			}
		}
		
		// 여기서부터 Employee MyPage
		else if(command.equals("/empMyPage.my")) {
			EmployeeDetailService action = new EmployeeDetailService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/myPage/empMyPage.jsp");
			dispatcher.forward(req, resp);
		}
		
		else if(command.equals("/empUpdate.my")) {
			EmployeeDetailService action = new EmployeeDetailService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/myPage/empMyModify.jsp");
			dispatcher.forward(req, resp);
		}
		
		else if(command.equals("/empModify.my")){
			EmployeeUpdateService action = new EmployeeUpdateService();
			int i = action.execute(req);
			if(i == 1) {
				resp.sendRedirect("empMyPage.my");
			}
			else {
				EmployeeDetailService action1 = new EmployeeDetailService();
				action1.execute(req);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/myPage/empMyModify.jsp");
				dispatcher.forward(req, resp);
			}
		}
		else if(command.equals("/empPwModify.my")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/myPage/empMyPwCon.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/empPwUpdate.my")) {
			HttpSession session = req.getSession();
			AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
			String path = null;
			if(req.getParameter("empPw").equals(auth.getUserPw())) {
				path = "/myPage/empNewPw.jsp";
			}
			else {
				req.setAttribute("errPw", "비밀번호가 일치하지 않습니다.");
				path = "/myPage/empMyPwCon.jsp";
			}
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/empNewPw.my")) {
			EmployeePasswordService action = new EmployeePasswordService();
			int i = action.execute(req);
			if(i == 1) {
				resp.sendRedirect("empMyPage.my");
			}
			else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/myPage/empNewPw.jsp");
				dispatcher.forward(req, resp);
			}
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
