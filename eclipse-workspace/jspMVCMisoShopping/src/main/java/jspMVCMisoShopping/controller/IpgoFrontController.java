package jspMVCMisoShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCMisoShopping.service.goods.GoodsListService;
import jspMVCMisoShopping.service.ipgo.IpgoAutoNumService;
import jspMVCMisoShopping.service.ipgo.IpgoDeleteService;
import jspMVCMisoShopping.service.ipgo.IpgoDetailService;
import jspMVCMisoShopping.service.ipgo.IpgoListService;
import jspMVCMisoShopping.service.ipgo.IpgoRegistService;
import jspMVCMisoShopping.service.ipgo.IpgoUpdateService;

public class IpgoFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/goodsIpgo.ipgo")) {
			IpgoAutoNumService action = new IpgoAutoNumService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/goodsIpgo/goodsIpgo.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/goodsItem.ipgo")) {
			GoodsListService action = new GoodsListService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/goodsIpgo/goodsItem.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/goodsIpgoList.ipgo")) {
			IpgoListService action = new IpgoListService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/goodsIpgo/goodsIpgoList.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/ipgoRegist.ipgo")) {
			IpgoRegistService action = new IpgoRegistService();
			action.execute(req);
			resp.sendRedirect("goodsIpgoList.ipgo");
		}
		else if(command.equals("/goodsIpgoDetail.ipgo")) {
			IpgoDetailService action = new IpgoDetailService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/goodsIpgo/goodsIpgoDetail.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/goodsIpgoUpdate.ipgo")) {
			IpgoDetailService action = new IpgoDetailService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/goodsIpgo/goodsIpgoUpdate.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/goodsIpgoModify.ipgo")) {
			IpgoUpdateService action = new IpgoUpdateService();
			action.execute(req);
			resp.sendRedirect("goodsIpgoDetail.ipgo?ipgoNum=" + req.getParameter("ipgoNum"));
		}
		else if(command.equals("/goodsIpgoDelete.ipgo")) {
			IpgoDeleteService action = new IpgoDeleteService();
			action.execute(req);
			resp.sendRedirect("goodsIpgoList.ipgo");
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
