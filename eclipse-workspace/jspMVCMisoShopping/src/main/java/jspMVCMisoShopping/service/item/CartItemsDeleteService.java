package jspMVCMisoShopping.service.item;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.ItemDAO;
import jspMVCMisoShopping.service.MemberAuthService;

public class CartItemsDeleteService extends MemberAuthService{
	public CartItemsDeleteService(HttpServletRequest req) {
		super(req);
	}

	public void execute(HttpServletRequest req) {
		String goodsNums = req.getParameter("goodsNums");
		String[] goodsNumbers = goodsNums.split("-");
		ItemDAO dao = new ItemDAO();
		for(String goodsNum : goodsNumbers) {
			dao.itemDelete(goodsNum, memberNum);
		}
	}
}
