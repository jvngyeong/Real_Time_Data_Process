package jspMVCMisoShopping.service.member;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.MemberDAO;

public class MemberAutoNumService {
	public void execute(HttpServletRequest req) {
		MemberDAO dao = new MemberDAO();
		String Num = dao.memberAutoNum();
		req.setAttribute("memberNum", Num);
	}
}
