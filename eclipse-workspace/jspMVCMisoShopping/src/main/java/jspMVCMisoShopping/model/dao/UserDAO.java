package jspMVCMisoShopping.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.MemberDTO;

public class UserDAO extends DataBaseInfo{	
	public void userInsert(MemberDTO dto) {
		con = getConnection();
		String memberNumSQL = "(select concat('mem_', nvl(max(substr(member_num, 5)), 100000) + 1) from members)";
		sql = "insert into members (MEMBER_NUM, MEMBER_NAME, MEMBER_ID, MEMBER_PW"
		         + ", MEMBER_ADDR, MEMBER_ADDR_DETAIL, MEMBER_POST"
		         + ", MEMBER_REGIST, GENDER, MEMBER_PHONE1, MEMBER_PHONE2"
		         + ", MEMBER_EMAIL, MEMBER_BIRTH) "
		         + " values("+memberNumSQL+", ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberName());
			pstmt.setString(2, dto.getMemberId());
			pstmt.setString(3, dto.getMemberPw());
			pstmt.setString(4, dto.getMemberAddr());
			pstmt.setString(5, dto.getMemberAddrDetail());
			pstmt.setInt(6, Integer.parseInt(dto.getMemberPost()));
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getMemberPhone1());
			pstmt.setString(9, dto.getMemberPhone2());
			pstmt.setString(10, dto.getMemberEmail());
			pstmt.setDate(11, new Date(dto.getMemberBirth().getTime()));
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 삽입되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public AuthInfoDTO loginSelect(String userId) {
		AuthInfoDTO dto = null;
		con = getConnection();
		sql = "select member_id user_id, member_pw user_pw, member_name user_name, member_email user_email, 'mem' grade";
		sql += " from members where member_id = ? union select emp_id, emp_pw, emp_name, emp_email, 'emp'";
		sql += " from employees where emp_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new AuthInfoDTO();
				dto.setUserId(rs.getString("user_id"));
				dto.setUserPw(rs.getString("user_pw"));
				dto.setUserName(rs.getString("user_name"));
				dto.setGrade(rs.getString("grade"));
				dto.setUserEmail(rs.getString("user_email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	public void close() {
		if(rs!=null)try {rs.close();}catch(Exception e) {}
		if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
		if(con!=null)try {con.close();}catch(Exception e) {}
	}
}
