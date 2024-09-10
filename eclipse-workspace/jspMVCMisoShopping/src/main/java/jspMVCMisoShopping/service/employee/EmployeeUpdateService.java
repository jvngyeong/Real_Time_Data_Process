package jspMVCMisoShopping.service.employee;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.EmployeeDAO;
import jspMVCMisoShopping.model.dto.EmployeeDTO;

public class EmployeeUpdateService {
	public void execute(HttpServletRequest request) {
		EmployeeDTO dto = new EmployeeDTO();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		dto.setEmpNum(request.getParameter("empNum"));
		dto.setEmpId(request.getParameter("empId"));
		dto.setEmpPw(request.getParameter("empPw"));
		dto.setEmpName(request.getParameter("empName"));
		dto.setEmpAddr(request.getParameter("empAddr"));
		dto.setEmpAddrDetail(request.getParameter("empAddrDetail"));
		dto.setEmpPost(Integer.parseInt(request.getParameter("empPost")));
		dto.setEmpPhone(request.getParameter("empPhone"));
		dto.setEmpJumin(request.getParameter("empJumin"));
		dto.setEmpEmail(request.getParameter("empEmail"));
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String hireDate = request.getParameter("empHireDate");
		try {
			date = sdf.parse(hireDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dto.setEmpHireDate(date);
		dto.setEmpImage(request.getParameter("empImage"));
		EmployeeDAO dao = new EmployeeDAO();
		dao.employeeUpdate(dto);
	}
}
