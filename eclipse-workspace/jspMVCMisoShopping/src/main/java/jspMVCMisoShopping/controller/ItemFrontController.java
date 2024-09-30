package jspMVCMisoShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCMisoShopping.model.dao.ItemDAO;
import jspMVCMisoShopping.service.goods.GoodsDetailService;
import jspMVCMisoShopping.service.item.CartItemsDeleteService;
import jspMVCMisoShopping.service.item.CartListService;
import jspMVCMisoShopping.service.item.CartMergeService;
import jspMVCMisoShopping.service.item.CartQtyDownService;
import jspMVCMisoShopping.service.item.GoodsItemService;
import jspMVCMisoShopping.service.item.GoodsOrderService;
import jspMVCMisoShopping.service.item.GoodsVisitCountService;
import jspMVCMisoShopping.service.item.GoodsWishItemService;
import jspMVCMisoShopping.service.item.INIstdPayPcReturn;
import jspMVCMisoShopping.service.item.IniPayReqService;
import jspMVCMisoShopping.service.item.PaymentDeleteService;
import jspMVCMisoShopping.service.item.PurchaseListService;

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
		else if(command.equals("/cartQtyDown.item")) {
			CartQtyDownService action = new CartQtyDownService(req);
			action.execute(req);
		}
		else if(command.equals("/cartItemsDel.item")) {
			CartItemsDeleteService action = new CartItemsDeleteService(req);
			action.execute(req);
			resp.sendRedirect("cartList.item");
		}
		else if(command.equals("/itemBuy.item")) {
			GoodsItemService action = new GoodsItemService(req);
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("item/goodsOrder.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/goodsOrder.item")) {
			GoodsOrderService action = new GoodsOrderService(req);
			String purchaseNum = action.execute(req);
			resp.sendRedirect("paymentOk.item?purchaseNum="+purchaseNum);
		}
		else if(command.equals("/paymentOk.item")) {
			IniPayReqService action1 = new IniPayReqService();
			try {
				action1.execute(req);
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher =
					req.getRequestDispatcher("item/payment.jsp");
			dispatcher.forward(req, resp);	
		}
		else if(command.equals("/purchaseList.item")) {
			PurchaseListService action = new PurchaseListService(req);
			action.execute(req);
			RequestDispatcher dispatcher 
					= req.getRequestDispatcher("item/purchaseList.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/INIstdpay_pc_return.item")) {
			INIstdPayPcReturn action = new INIstdPayPcReturn();
			action.execute(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("item/buyfinished.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/close.item")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("item/close.jsp");
			dispatcher.forward(req, resp);
		}
		else if(command.equals("/paymentDelete.item")) {
			PaymentDeleteService action = new PaymentDeleteService();
			action.execute(req);
			resp.sendRedirect("purchaseList.item");
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
