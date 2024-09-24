package jspMVCMisoShopping.service.ipgo;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.IpgoDAO;

public class IpgoDeleteService {
	public void execute(HttpServletRequest req) {
		String ipgoNum = req.getParameter("ipgoNum");
		IpgoDAO dao = new IpgoDAO();
		dao.ipgoDelete(ipgoNum);
	}
}
