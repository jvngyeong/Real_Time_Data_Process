package jspMVCMisoShopping.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.MemberDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;

public class MemberAuthService {
	protected HttpSession session;
	protected AuthInfoDTO auth;
	protected MemberDAO memDAO;
	protected String memberNum;
	
	public MemberAuthService(HttpServletRequest req) {
		session = req.getSession();
		auth = (AuthInfoDTO) session.getAttribute("auth");
		memDAO = new MemberDAO();
		memberNum = memDAO.memberNumSelect(auth.getUserId());
	}
}
