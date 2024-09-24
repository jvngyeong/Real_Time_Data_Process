package jspMVCMisoShopping.service.ipgo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.IpgoDAO;
import jspMVCMisoShopping.model.dto.IpgoDTO;

public class IpgoUpdateService {
	public void execute(HttpServletRequest req) {
		IpgoDTO dto = new IpgoDTO();
		dto.setIpgoNum(req.getParameter("ipgoNum"));
		dto.setGoodsNum(req.getParameter("goodsNum"));
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
		
		dto.setIpgoQty(Integer.parseInt(req.getParameter("ipgoQty")));
		String madeDate = req.getParameter("madeDate");
		try {
			date = sdf.parse(madeDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedDate = sdf.format(date);
		sqlDate = java.sql.Date.valueOf(formattedDate);
		dto.setMadeDate(sqlDate);
		
		dto.setIpgoPrice(Integer.parseInt(req.getParameter("ipgoPrice")));
		dto.setEmpNum(req.getParameter("empNum"));
		IpgoDAO dao = new IpgoDAO();
		dao.ipgoUpdate(dto);
	}
}
