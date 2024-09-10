package jspMVCMisoShopping.service.employee;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.EmployeeDAO;
import jspMVCMisoShopping.model.dto.EmployeeDTO;

public class EmployeeDeleteService {
	public void execute(HttpServletRequest request) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpNum(request.getParameter("empNum"));
		EmployeeDAO dao = new EmployeeDAO();
		dao.employeeDelete(dto);
	}
}
