package jspMVCMisoShopping.service.employee;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.EmployeeDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.EmployeeDTO;

public class EmployeeUpdateService {
	public int execute(HttpServletRequest request) {
		EmployeeDAO dao = new EmployeeDAO();
		String empNum = request.getParameter("empNum");
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		if(empNum == null) {
			empNum = dao.employeeNumSelect(auth.getUserId());
		}
		
		EmployeeDTO dto = new EmployeeDTO();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		dto.setEmpNum(empNum);
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
		
		int i = 0;
		if(auth.getUserPw().equals(request.getParameter("empPw"))) {
			i = 1;
			dao.employeeUpdate(dto);
		}
		else {
			i = 0;
			request.setAttribute("errPw", "비밀번호가 틀렸습니다.");
		}
		
		return i;
	}
}
