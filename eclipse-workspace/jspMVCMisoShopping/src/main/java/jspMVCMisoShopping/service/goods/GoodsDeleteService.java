package jspMVCMisoShopping.service.goods;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.GoodsDAO;

public class GoodsDeleteService {
	public void execute(HttpServletRequest req) {
		String goodsNum = req.getParameter("goodsNum");
		GoodsDAO dao = new GoodsDAO();
		dao.goodsDelete(goodsNum);
	}
}
