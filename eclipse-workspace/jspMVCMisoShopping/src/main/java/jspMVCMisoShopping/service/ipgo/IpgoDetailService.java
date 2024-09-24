package jspMVCMisoShopping.service.ipgo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.GoodsDAO;
import jspMVCMisoShopping.model.dao.IpgoDAO;
import jspMVCMisoShopping.model.dto.IpgoDTO;

public class IpgoDetailService {
	public void execute(HttpServletRequest req) {
		IpgoDAO dao = new IpgoDAO();
		String ipgoNum = req.getParameter("ipgoNum");
		IpgoDTO dto = dao.ipgoSelectOne(ipgoNum);
		GoodsDAO goodsDAO = new GoodsDAO();
		String goodsName = goodsDAO.goodsNameSelect(dto.getGoodsNum());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		String madeDate = sdf.format(dto.getMadeDate());
		req.setAttribute("dto", dto);
		req.setAttribute("goodsName", goodsName);
		req.setAttribute("madeDate", madeDate);
	}
}
