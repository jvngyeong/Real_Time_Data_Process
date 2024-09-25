package jspMVCMisoShopping.service.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.ItemDAO;
import jspMVCMisoShopping.model.dto.CartListDTO;
import jspMVCMisoShopping.service.MemberAuthService;

public class CartListService extends MemberAuthService{

	public CartListService(HttpServletRequest req) {
		super(req);
	}

	public void execute(HttpServletRequest req) {
		ItemDAO dao = new ItemDAO();
		List<CartListDTO> list = dao.cartSelectList(memberNum);
		req.setAttribute("list", list);
	}
}
