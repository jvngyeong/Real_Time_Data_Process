package jspMVCMisoShopping.service.delivery;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.DeliveryDAO;

public class DeliveryWriteService {
	public void execute(HttpServletRequest req) {
		String purchaseNum = req.getParameter("purchaseNum");
		String deliveryNum = req.getParameter("deliveryNum");
		
		DeliveryDAO dao = new DeliveryDAO();
		dao.deliveryInsert(purchaseNum, deliveryNum);
	}
}
