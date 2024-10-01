package jspMVCMisoShopping.service.inquire;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.InquireDAO;
import jspMVCMisoShopping.model.dto.InquireDTO;
import jspMVCMisoShopping.service.MemberAuthService;

public class InquireWriteProService extends MemberAuthService{
	public InquireWriteProService(HttpServletRequest req) {
		super(req);
	}

	public void execute(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String goodsNum = req.getParameter("goodsNum");
		String queryType = req.getParameter("queryType");
		String inquireSubject = req.getParameter("inquireSubject");
		String inquireContent = req.getParameter("inquireContent");
		
		InquireDTO dto = new InquireDTO();
		dto.setGoodsNum(goodsNum);
		dto.setInquireKind(queryType);
		dto.setInquireSubject(inquireSubject);
		dto.setInquireContents(inquireContent);
		dto.setMemberNum(memberNum);
		InquireDAO dao = new InquireDAO();
		dao.inquireInsert(dto);
	}
}
