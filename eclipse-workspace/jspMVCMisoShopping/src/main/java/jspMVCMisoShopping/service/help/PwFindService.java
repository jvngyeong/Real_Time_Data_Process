package jspMVCMisoShopping.service.help;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.HelpDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;

public class PwFindService {
	public void execute(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		AuthInfoDTO dto = new AuthInfoDTO();
		dto.setUserId(request.getParameter("userId"));
		dto.setPhone1(request.getParameter("userPhone"));
		HelpDAO dao = new HelpDAO();
		String userPw = dao.pwFind(dto);
		System.out.println(userPw);
		request.setAttribute("userPw", userPw);
		request.setAttribute("userId", userId);
	}
}
