package jspMVCMisoShopping.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jspMVCMisoShopping.model.dto.EmployeeDTO;

public class EmployeeDAO extends DataBaseInfo{
	public void employeeInsert(EmployeeDTO dto) {
		con = getConnection();
		sql = "INSERT INTO EMPLOYEES(EMP_NUM, EMP_ID, EMP_PW, EMP_NAME, EMP_ADDR, ";
		sql += " EMP_ADDR_DETAIL, EMP_POST, EMP_PHONE, EMP_JUMIN, EMP_EMAIL, EMP_HIRE_DATE, EMP_IMAGE )";
		sql += " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmpNum());
			pstmt.setString(2, dto.getEmpId());
			pstmt.setString(3, dto.getEmpPw());
			pstmt.setString(4, dto.getEmpName());
			pstmt.setString(5, dto.getEmpAddr());
			pstmt.setString(6, dto.getEmpAddrDetail());
			pstmt.setInt(7, dto.getEmpPost());
			pstmt.setString(8, dto.getEmpPhone());
			pstmt.setString(9, dto.getEmpJumin());
			pstmt.setString(10, dto.getEmpEmail());
			pstmt.setDate(11, new Date(dto.getEmpHireDate().getTime()));
			pstmt.setString(12, dto.getEmpImage());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 삽입되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public String employeeAutoNum() {
		String empNum = null;
		con = getConnection();
		sql = "select concat('emp_', (nvl(substr(max(emp_num), 5), 100000) + 1)) from employees";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			empNum = rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empNum;
	}
	
	public List<EmployeeDTO> employeeSelectAll() {
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		EmployeeDTO dto = null;
		con = getConnection();
		sql = "select EMP_NUM, EMP_ID, EMP_PW, EMP_NAME, EMP_ADDR, EMP_ADDR_DETAIL, EMP_POST, EMP_PHONE, ";
		sql += " EMP_JUMIN, EMP_EMAIL, EMP_HIRE_DATE, EMP_IMAGE from employees";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new EmployeeDTO();
				dto.setEmpNum(rs.getString("EMP_NUM"));
				dto.setEmpId(rs.getString("EMP_ID"));
				dto.setEmpPw(rs.getString("EMP_PW"));
				dto.setEmpName(rs.getString("EMP_NAME"));
				dto.setEmpAddr(rs.getString("EMP_ADDR"));
				dto.setEmpAddrDetail(rs.getString("EMP_ADDR_DETAIL"));
				dto.setEmpPost(rs.getInt("EMP_POST"));
				dto.setEmpPhone(rs.getString("EMP_PHONE"));
				dto.setEmpJumin(rs.getString("EMP_JUMIN"));
				dto.setEmpEmail(rs.getString("EMP_EMAIL"));
				dto.setEmpHireDate(rs.getDate("EMP_HIRE_DATE"));
				dto.setEmpImage(rs.getString("EMP_IMAGE"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public EmployeeDTO employeeSelectOne(EmployeeDTO dto) {
		EmployeeDTO returnDTO = null;
		con = getConnection();
		sql = "select EMP_NUM, EMP_ID, EMP_PW, EMP_NAME, EMP_ADDR, EMP_ADDR_DETAIL, EMP_POST, EMP_PHONE, ";
		sql += " EMP_JUMIN, EMP_EMAIL, EMP_HIRE_DATE, EMP_IMAGE from employees where EMP_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmpNum());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				returnDTO = new EmployeeDTO();
				returnDTO.setEmpNum(rs.getString("EMP_NUM"));
				returnDTO.setEmpId(rs.getString("EMP_ID"));
				returnDTO.setEmpPw(rs.getString("EMP_PW"));
				returnDTO.setEmpName(rs.getString("EMP_NAME"));
				returnDTO.setEmpAddr(rs.getString("EMP_ADDR"));
				returnDTO.setEmpAddrDetail(rs.getString("EMP_ADDR_DETAIL"));
				returnDTO.setEmpPost(rs.getInt("EMP_POST"));
				returnDTO.setEmpPhone(rs.getString("EMP_PHONE"));
				returnDTO.setEmpJumin(rs.getString("EMP_JUMIN"));
				returnDTO.setEmpEmail(rs.getString("EMP_EMAIL"));
				returnDTO.setEmpHireDate(rs.getDate("EMP_HIRE_DATE"));
				returnDTO.setEmpImage(rs.getString("EMP_IMAGE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return returnDTO;
	}
	
	public void employeeUpdate(EmployeeDTO dto) {
		con = getConnection();
		sql = "update employees set EMP_ID = ?, EMP_PW = ?, EMP_NAME = ?, EMP_ADDR = ?, ";
		sql += " EMP_ADDR_DETAIL = ?, EMP_POST = ?, EMP_PHONE = ?, EMP_JUMIN = ?, EMP_EMAIL = ?, ";
		sql += " EMP_HIRE_DATE = ?, EMP_IMAGE = ? where EMP_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmpId());
			pstmt.setString(2, dto.getEmpPw());
			pstmt.setString(3, dto.getEmpName());
			pstmt.setString(4, dto.getEmpAddr());
			pstmt.setString(5, dto.getEmpAddrDetail());
			pstmt.setInt(6,  dto.getEmpPost());
			pstmt.setString(7, dto.getEmpPhone());
			pstmt.setString(8, dto.getEmpJumin());
			pstmt.setString(9, dto.getEmpEmail());
			pstmt.setDate(10, new Date(dto.getEmpHireDate().getTime()));
			pstmt.setString(11, dto.getEmpImage());
			pstmt.setString(12, dto.getEmpNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void employeeDelete(EmployeeDTO dto) {
		con = getConnection();
		sql = "delete from employees where EMP_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmpNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 삭제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public String employeeNumSelect(String empId) {
		String empNum = null;
		con = getConnection();
		sql = "select emp_num from employees where emp_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				empNum = rs.getString("emp_num");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return empNum;
	}
	
	public void employeePwUpdate(String newPw, String empId) {
		con = getConnection();
		sql = "update employees set emp_pw = ? where emp_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setString(2, empId);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void close() {
		if(rs != null) try {rs.close();} catch(Exception e) {}
		if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
		if(con != null) try {con.close();} catch(Exception e) {}
	}
}
