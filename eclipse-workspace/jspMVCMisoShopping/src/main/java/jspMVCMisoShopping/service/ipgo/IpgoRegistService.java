package jspMVCMisoShopping.service.ipgo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.EmployeeDAO;
import jspMVCMisoShopping.model.dao.IpgoDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.IpgoDTO;

public class IpgoRegistService {
	public void execute(HttpServletRequest req) {
		IpgoDTO dto = new IpgoDTO();
		dto.setGoodsNum(req.getParameter("goodsNum"));
		dto.setIpgoNum(req.getParameter("ipgoNum"));
		dto.setIpgoQty(Integer.parseInt(req.getParameter("ipgoQty")));
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String ipgoDate = req.getParameter("ipgoDate");
		try {
			date = sdf.parse(ipgoDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String formattedDate = sdf.format(date);
		java.sql.Date sqlDate = java.sql.Date.valueOf(formattedDate);
		dto.setIpgoDate(sqlDate);
		date = null;
		String madeDate = req.getParameter("madeDate");
		try {
			date = sdf.parse(madeDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		formattedDate = sdf.format(date);
		sqlDate = java.sql.Date.valueOf(formattedDate);
		dto.setMadeDate(sqlDate);
		dto.setIpgoPrice(Integer.parseInt(req.getParameter("ipgoPrice")));
		HttpSession session = req.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		EmployeeDAO empDAO = new EmployeeDAO();
		String empNum = empDAO.employeeNumSelect(auth.getUserId());
		dto.setEmpNum(empNum);
		
		IpgoDAO dao = new IpgoDAO();
		dao.ipgoRegist(dto);
	}
}
