package jspMVCMisoShopping.service.delivery;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.DeliveryDAO;

public class DeliveryModifyService {
	public void execute(HttpServletRequest req) {
		String purchaseNum = req.getParameter("purchaseNum");
		DeliveryDAO dao = new DeliveryDAO();
		dao.deliveryStatusUpdate(purchaseNum);
	}
}
