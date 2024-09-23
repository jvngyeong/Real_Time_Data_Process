package jspMVCMisoShopping.service.goods;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.EmployeeDAO;
import jspMVCMisoShopping.model.dao.GoodsDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.GoodsDTO;

public class GoodsUpdateService {
	public void execute(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		GoodsDTO dto = new GoodsDTO();
		dto.setGoodsNum(req.getParameter("goodsNum"));
		dto.setGoodsName(req.getParameter("goodsName"));
		dto.setGoodsPrice(Integer.parseInt(req.getParameter("goodsPrice")));
		dto.setGoodsContent(req.getParameter("goodsContent"));
		dto.setVisitCount(Integer.parseInt(req.getParameter("visitCount")));
		dto.setEmpNum(req.getParameter("empNum"));
		
		
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");	
		String goodsRegist = req.getParameter("goodsRegist");
		try {
			date = sdf.parse(goodsRegist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String formattedDate = sdf.format(date);
		java.sql.Date sqlDate = java.sql.Date.valueOf(formattedDate);
		dto.setGoodsRegist(sqlDate);
		
		HttpSession session = req.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String empId = auth.getUserId();
		EmployeeDAO empDAO = new EmployeeDAO();
		String lastEmpNum = empDAO.employeeNumSelect(empId);
		dto.setUpdateEmpNum(lastEmpNum);
		GoodsDAO dao = new GoodsDAO();
		dao.goodsUpdate(dto);
	}
}
