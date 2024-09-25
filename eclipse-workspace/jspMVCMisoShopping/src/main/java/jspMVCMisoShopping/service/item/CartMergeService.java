package jspMVCMisoShopping.service.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.ItemDAO;
import jspMVCMisoShopping.model.dao.MemberDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.CartDTO;

public class CartMergeService {

	public void execute(HttpServletRequest req) {
		String goodsNum = req.getParameter("goodsNum");
		Integer cartQty = Integer.parseInt(req.getParameter("cartQty"));
		
		HttpSession session = req.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberId = auth.getUserId();
		MemberDAO memDAO = new MemberDAO();
		String memberNum = memDAO.memberNumSelect(memberId);
		
		CartDTO dto = new CartDTO();
		dto.setGoodsNum(goodsNum);
		dto.setCartQty(cartQty);
		dto.setMemberNum(memberNum);
		
		ItemDAO dao = new ItemDAO();
		dao.cartMerge(dto);
	}

}
