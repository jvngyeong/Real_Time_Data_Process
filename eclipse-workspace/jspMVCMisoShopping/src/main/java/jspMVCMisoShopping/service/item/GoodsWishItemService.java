package jspMVCMisoShopping.service.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.ItemDAO;
import jspMVCMisoShopping.model.dao.MemberDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;

public class GoodsWishItemService {
	public void execute(HttpServletRequest req) {
		String goodsNum = req.getParameter("goodsNum");
		
		HttpSession session = req.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberId = auth.getUserId();
		MemberDAO memDAO = new MemberDAO();
		String memberNum = memDAO.memberNumSelect(memberId);
		
		ItemDAO dao = new ItemDAO();
		dao.wishItem(memberNum, goodsNum);
	}
}
