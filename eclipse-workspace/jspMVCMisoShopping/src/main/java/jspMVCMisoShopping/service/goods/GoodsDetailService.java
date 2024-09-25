package jspMVCMisoShopping.service.goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.GoodsDAO;
import jspMVCMisoShopping.model.dao.ItemDAO;
import jspMVCMisoShopping.model.dao.MemberDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.GoodsDTO;

public class GoodsDetailService {
	public void execute(HttpServletRequest req) {
		GoodsDAO dao = new GoodsDAO();
		String goodsNum = req.getParameter("goodsNum");
		GoodsDTO dto = dao.goodsSelectOne(goodsNum);
		req.setAttribute("dto", dto);
		
		HttpSession session = req.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		if(auth != null) {
			MemberDAO memDAO = new MemberDAO();
			String memberNum = memDAO.memberNumSelect(auth.getUserId());
			if(memberNum != null) {
				ItemDAO itemDAO = new ItemDAO();
				int i = itemDAO.wishSelectOne(memberNum, goodsNum);
				if(i == 1) {
					req.setAttribute("isTrue", "true");
				}
			}

		}
	}
}
