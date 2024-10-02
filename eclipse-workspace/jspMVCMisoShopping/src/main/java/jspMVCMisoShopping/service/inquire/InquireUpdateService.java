package jspMVCMisoShopping.service.inquire;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.InquireDAO;
import jspMVCMisoShopping.model.dto.InquireDTO;

public class InquireUpdateService{
	public void execute(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String inquireNum = req.getParameter("inquireNum");
		String inquireSubject = req.getParameter("inquireSubject");
		String inquireContent = req.getParameter("inquireContent");
		String queryType = req.getParameter("queryType");
		
		InquireDTO dto = new InquireDTO();
		dto.setInquireNum(Integer.parseInt(inquireNum));
		dto.setInquireSubject(inquireSubject);
		dto.setInquireContents(inquireContent);
		dto.setInquireKind(queryType);
		
		InquireDAO dao = new InquireDAO();
		dao.inquireUpdate(dto);
	}
}
