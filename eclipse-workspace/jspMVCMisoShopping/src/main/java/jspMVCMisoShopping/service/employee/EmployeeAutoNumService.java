package jspMVCMisoShopping.service.employee;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.EmployeeDAO;

public class EmployeeAutoNumService {
	public void execute(HttpServletRequest request) {
		EmployeeDAO dao = new EmployeeDAO();
		String num = dao.employeeAutoNum();
		request.setAttribute("empNum", num);
	}
}
