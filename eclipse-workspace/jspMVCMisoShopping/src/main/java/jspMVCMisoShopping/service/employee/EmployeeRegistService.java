package jspMVCMisoShopping.service.employee;



import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.EmployeeDAO;
import jspMVCMisoShopping.model.dto.EmployeeDTO;

public class EmployeeRegistService {
	public void execute(HttpServletRequest request) {
		EmployeeDTO dto = new EmployeeDTO();
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
		
		//자바에서 문자열을 날짜로 형변환
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String hireDate = request.getParameter("empHireDate"); // yyyy-mm-dd
		try {
				date = sdf.parse(hireDate);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		dto.setEmpHireDate(date);
		dto.setEmpImage(request.getParameter("empImage"));
		EmployeeDAO dao = new EmployeeDAO();
		dao.employeeInsert(dto);
	}
}
