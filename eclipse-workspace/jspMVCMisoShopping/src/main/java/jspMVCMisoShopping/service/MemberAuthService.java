package jspMVCMisoShopping.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.EmployeeDAO;
import jspMVCMisoShopping.model.dao.MemberDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;

public class MemberAuthService {
	protected HttpSession session;
	protected AuthInfoDTO auth;
	protected MemberDAO memDAO;
	protected EmployeeDAO empDAO;
	protected String memberNum;
	protected String empNum;
	
	public MemberAuthService(HttpServletRequest req) {
		session = req.getSession();
		auth = (AuthInfoDTO) session.getAttribute("auth");
		memDAO = new MemberDAO();
		empDAO = new EmployeeDAO();
		try {
			memberNum = memDAO.memberNumSelect(auth.getUserId());
			empNum = empDAO.employeeNumSelect(auth.getUserId());
		}
		catch (Exception e) {
		}
	}
}
