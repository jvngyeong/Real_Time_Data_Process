package jspMVCMisoShopping.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.MemberDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.MemberDTO;

public class MemberDetailService {
	public void execute(HttpServletRequest request) {
		MemberDAO dao = new MemberDAO();
		String memberNum = request.getParameter("memberNum");
		if(memberNum == null) {
			HttpSession session = request.getSession();
			AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
			String memberId = auth.getUserId();
			memberNum = dao.memberNumSelect(memberId);
		}
		MemberDTO attDTO = dao.memberSelectOne(memberNum);
		request.setAttribute("attDTO", attDTO);
	}
}
