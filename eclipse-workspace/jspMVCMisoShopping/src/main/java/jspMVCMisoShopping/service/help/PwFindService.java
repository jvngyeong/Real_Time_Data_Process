package jspMVCMisoShopping.service.help;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.HelpDAO;

public class PwFindService {
	public void execute(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String userPhone = request.getParameter("userPhone");
		HelpDAO dao = new HelpDAO();
		String grade = dao.userSearch(userId, userPhone);
		if(grade != null) {
			System.out.println(grade);
			String newPw = UUID.randomUUID().toString().substring(0, 8);
			dao.userPwUpdate(userId, newPw, grade);
			request.setAttribute("userPw", newPw);
			request.setAttribute("userId", userId);
		}

	}
}
