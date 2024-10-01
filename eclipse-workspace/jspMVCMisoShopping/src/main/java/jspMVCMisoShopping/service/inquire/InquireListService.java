package jspMVCMisoShopping.service.inquire;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.InquireDAO;
import jspMVCMisoShopping.model.dto.InquireDTO;

public class InquireListService{
	public void execute(HttpServletRequest req) {
		String goodsNum = req.getParameter("goodsNum");
		InquireDAO dao = new InquireDAO();
		List<InquireDTO> list = dao.inquireSelectAll(goodsNum);
		req.setAttribute("newLine", "\n");
		req.setAttribute("list", list);
	}
}
