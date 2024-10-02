package jspMVCMisoShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.UserDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.service.goods.GoodsListService;

public class MainFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/")) {
			GoodsListService action = new GoodsListService();
			action.execute(req);
			Cookie[] cookies = req.getCookies();
			if(cookies != null && cookies.length > 0) {
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("storeId")) {
						req.setAttribute("sid", cookie.getValue());
					}
					if(cookie.getName().equals("keepLogin")) {
						UserDAO dao = new UserDAO();
						HttpSession session = req.getSession();
						AuthInfoDTO auth = dao.loginSelect(cookie.getValue());
						session.setAttribute("auth", auth);
					}
				}
			}
			RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
			dispatcher.forward(req, resp);
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
