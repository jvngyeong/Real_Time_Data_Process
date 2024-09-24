package jspMVCMisoShopping.service.ipgo;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.IpgoDAO;

public class IpgoAutoNumService {
	public void execute(HttpServletRequest req) {
		IpgoDAO dao = new IpgoDAO();
		String ipgoNum = dao.ipgoAutoNum();
		req.setAttribute("ipgoNum", ipgoNum);
	}
}
