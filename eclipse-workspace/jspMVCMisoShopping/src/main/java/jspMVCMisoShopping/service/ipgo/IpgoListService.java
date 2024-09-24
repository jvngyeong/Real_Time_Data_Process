package jspMVCMisoShopping.service.ipgo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.IpgoDAO;
import jspMVCMisoShopping.model.dto.IpgoDTO;

public class IpgoListService {
	public void execute(HttpServletRequest req) {
		IpgoDAO dao = new IpgoDAO();
		List<IpgoDTO> list = dao.IpgoSelectAll();
		req.setAttribute("list", list);
	}
}
