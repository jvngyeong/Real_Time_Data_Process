package jspMVCMisoShopping.service.review;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.ReviewDAO;
import jspMVCMisoShopping.model.dto.ReviewDTO;

public class ReviewDetailService extends HttpServlet{
	public void execute(HttpServletRequest req) {
		String purchaseNum = req.getParameter("purchaseNum");
		String goodsNum = req.getParameter("goodsNum");
		ReviewDAO dao = new ReviewDAO();
		ReviewDTO dto = new ReviewDTO();
		dto.setGoodsNum(goodsNum);
		dto.setPurchaseNum(purchaseNum);
		dao.reviewSelectone(dto);
		req.setAttribute("dto", dto);
	}
}
