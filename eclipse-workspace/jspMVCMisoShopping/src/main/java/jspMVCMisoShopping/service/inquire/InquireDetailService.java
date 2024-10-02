package jspMVCMisoShopping.service.inquire;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.InquireDAO;
import jspMVCMisoShopping.model.dto.InquireDTO;

public class InquireDetailService extends HttpServlet{
	public void execute(HttpServletRequest req) {
		String inquireNum = req.getParameter("inquireNum");
		InquireDAO dao = new InquireDAO();
		InquireDTO dto = new InquireDTO();
		dto.setInquireNum(Integer.parseInt(inquireNum));
		dao.inquireSelectOne(dto);
		req.setAttribute("dto", dto);
	}
}
