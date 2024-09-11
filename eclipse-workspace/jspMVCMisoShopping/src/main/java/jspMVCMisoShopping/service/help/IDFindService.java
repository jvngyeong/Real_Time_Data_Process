package jspMVCMisoShopping.service.help;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.HelpDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;

public class IDFindService {
	public void execute(HttpServletRequest request) {
		HelpDAO dao = new HelpDAO();
		AuthInfoDTO dto = new AuthInfoDTO();
		dto.setUserName(request.getParameter("userName"));
		dto.setUserEmail(request.getParameter("userEmail"));
		String userId = dao.idFind(dto);
		System.out.println(userId);
		request.setAttribute("foundId", userId);
	}
}
