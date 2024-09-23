package jspMVCMisoShopping.service.goods;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.EmployeeDAO;
import jspMVCMisoShopping.model.dao.GoodsDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.GoodsDTO;

public class GoodsRegistService {
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
		GoodsDAO dao = new GoodsDAO();
		HttpSession session = req.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String empId = auth.getUserId();
		EmployeeDAO empDAO = new EmployeeDAO();
		String empNum = empDAO.employeeNumSelect(empId);
		dao.goodsInsert(dto, empNum);
	}
}
