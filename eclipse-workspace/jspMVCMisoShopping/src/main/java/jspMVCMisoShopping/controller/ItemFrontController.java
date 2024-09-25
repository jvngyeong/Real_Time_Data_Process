package jspMVCMisoShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCMisoShopping.service.goods.GoodsDetailService;
import jspMVCMisoShopping.service.item.CartListService;
import jspMVCMisoShopping.service.item.CartMergeService;
import jspMVCMisoShopping.service.item.GoodsVisitCountService;
import jspMVCMisoShopping.service.item.GoodsWishItemService;

public class ItemFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/detailView.item")) {
			GoodsVisitCountService count = new GoodsVisitCountService();
			count.execute(req);
			GoodsDetailService action = new GoodsDetailService();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/item/detailView.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/wishItem.item")) {
			GoodsWishItemService action = new GoodsWishItemService();
			action.execute(req);
		}
		else if(command.equals("/cart.item")) {
			CartMergeService action = new CartMergeService();
			action.execute(req);
		}
		else if(command.equals("/cartList.item")) {
			CartListService action = new CartListService(req);
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/item/cartList.jsp");
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
