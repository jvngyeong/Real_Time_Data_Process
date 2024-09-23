package jspMVCMisoShopping.service.employee;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.EmployeeDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.EmployeeDTO;

public class EmployeeDetailService {
	public void execute(HttpServletRequest request) {
		EmployeeDAO dao = new EmployeeDAO();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empNum = request.getParameter("empNum");
		if(empNum == null) {
			HttpSession session = request.getSession();
			AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
			String empId = auth.getUserId();
			empNum = dao.employeeNumSelect(empId);
		}
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpNum(empNum);
		EmployeeDTO returnDTO = dao.employeeSelectOne(dto);
		request.setAttribute("dto", returnDTO);
	}
}
