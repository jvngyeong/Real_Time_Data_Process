package jspMVCMisoShopping.service.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.ItemDAO;
import jspMVCMisoShopping.model.dto.PurchaseInfoDTO;
import jspMVCMisoShopping.service.MemberAuthService;

public class PurchaseListService extends MemberAuthService{
	public PurchaseListService(HttpServletRequest req) {
		super(req);
	}

	public void execute(HttpServletRequest req) {
		ItemDAO dao = new ItemDAO();
		List<PurchaseInfoDTO> list = dao.purchaseItemSelect(memberNum);
		req.setAttribute("list", list);
	}
}
