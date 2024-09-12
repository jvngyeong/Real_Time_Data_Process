package jspMVCMisoShopping.service.member;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.MemberDAO;
import jspMVCMisoShopping.model.dto.MemberDTO;

public class MemberDeleteService {
	public void execute(HttpServletRequest request) {
		MemberDTO dto = new MemberDTO();
		dto.setMemberNum(request.getParameter("memberNum"));
		MemberDAO dao = new MemberDAO();
		dao.memberDelete(dto.getMemberNum());
	}
}
