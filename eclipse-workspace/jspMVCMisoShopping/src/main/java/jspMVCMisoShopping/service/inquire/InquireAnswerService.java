package jspMVCMisoShopping.service.inquire;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.InquireDAO;
import jspMVCMisoShopping.model.dto.InquireDTO;
import jspMVCMisoShopping.service.MemberAuthService;

public class InquireAnswerService extends MemberAuthService{
	public InquireAnswerService(HttpServletRequest req) {
		super(req); 
	}

	public void execute(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String inquireNum = req.getParameter("inquireNum");
		String inquireAnswer = req.getParameter("inquireAnswer");
		
		InquireDTO dto = new InquireDTO();
		dto.setInquireNum(Integer.parseInt(inquireNum));
		dto.setInquireAnswer(inquireAnswer);
		dto.setEmpNum(empNum);
		
		InquireDAO dao = new InquireDAO();
		dao.inquireReplyUpdate(dto);
	}
}
