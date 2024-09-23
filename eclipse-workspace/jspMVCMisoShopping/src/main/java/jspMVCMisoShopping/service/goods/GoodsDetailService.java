package jspMVCMisoShopping.service.goods;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.GoodsDAO;
import jspMVCMisoShopping.model.dto.GoodsDTO;

public class GoodsDetailService {
	public void execute(HttpServletRequest req) {
		GoodsDAO dao = new GoodsDAO();
		String goodsNum = req.getParameter("goodsNum");
		System.out.println(req.getParameter("goodsNum"));
		GoodsDTO dto = dao.goodsSelectOne(goodsNum);
		req.setAttribute("dto", dto);
	}
}
