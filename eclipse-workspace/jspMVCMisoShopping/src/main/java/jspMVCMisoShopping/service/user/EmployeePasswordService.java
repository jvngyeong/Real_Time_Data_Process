package jspMVCMisoShopping.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.EmployeeDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;

public class EmployeePasswordService {
	public int execute(HttpServletRequest request) {
		String oldPw = request.getParameter("oldPw");
		String newPw = request.getParameter("newPw");
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		int i = 0;
		if(oldPw.equals(auth.getUserPw())) {
			i = 1;
			EmployeeDAO dao = new EmployeeDAO();
			dao.employeePwUpdate(newPw, auth.getUserId());
			auth.setUserPw(newPw);
		}
		else {
			request.setAttribute("errPw", "비밀번호가 일치하지 않습니다.");
		}
		return i;
	}
}
