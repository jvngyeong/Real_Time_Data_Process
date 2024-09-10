package jspMVCMisoShopping.service.employee;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.EmployeeDAO;
import jspMVCMisoShopping.model.dto.EmployeeDTO;

public class EmployeeDetailService {
	public void execute(HttpServletRequest request) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpNum(request.getParameter("empNum"));
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO returnDTO = dao.employeeSelectOne(dto);
		request.setAttribute("dto", returnDTO);
	}
}
