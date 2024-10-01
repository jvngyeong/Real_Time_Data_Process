package jspMVCMisoShopping.service.item;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.ItemDAO;

public class PurchasedService extends HttpServlet{
	public void execute(HttpServletRequest req) {
		String purchaseNum = req.getParameter("purchaseNum");
		ItemDAO dao = new ItemDAO();
		dao.purchaseStatusUpdate(purchaseNum, "purchased");
	}
}
