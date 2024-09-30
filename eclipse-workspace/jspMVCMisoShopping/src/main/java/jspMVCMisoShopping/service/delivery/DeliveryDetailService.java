package jspMVCMisoShopping.service.delivery;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.DeliveryDAO;

public class DeliveryDetailService {
	public void execute(HttpServletRequest req) {
		String purchaseNum = req.getParameter("purchaseNum");
		req.setAttribute("purchaseNum", purchaseNum);
		DeliveryDAO dao = new DeliveryDAO();
		String deliveryNum = dao.deliveryNumSelectOne(purchaseNum);
		req.setAttribute("deliveryNum", deliveryNum);
	}
}
