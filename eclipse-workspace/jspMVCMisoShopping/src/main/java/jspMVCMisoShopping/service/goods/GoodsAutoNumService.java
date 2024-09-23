package jspMVCMisoShopping.service.goods;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.GoodsDAO;

public class GoodsAutoNumService {
	public void execute(HttpServletRequest req) {
		GoodsDAO dao = new GoodsDAO();
		String num = dao.goodsAutoNum();
		req.setAttribute("maxNum", num);
	}
}
