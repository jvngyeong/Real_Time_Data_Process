package jspMVCMisoShopping.model.dao;

import java.sql.SQLException;

import jspMVCMisoShopping.model.dto.AuthInfoDTO;

public class HelpDAO extends DataBaseInfo{
	public String idFind(AuthInfoDTO dto) {
		String memberId = null;
		con = getConnection();
		sql = "select member_id user_id from members where member_name = ? and member_email = ?";
		sql += " union ";
		sql += "select emp_id from employees where emp_name = ? and emp_email = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserName());
			pstmt.setString(2, dto.getUserEmail());
			pstmt.setString(3, dto.getUserName());
			pstmt.setString(4, dto.getUserEmail());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberId = rs.getString("user_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return memberId;
	}
	
	public String pwFind(AuthInfoDTO dto) {
		String memberPw = null;
		con = getConnection();
		sql = "select member_pw user_pw from members where member_id = ? and member_phone1 = ?";
		sql += " union ";
		sql += "select emp_pw from employees where emp_id = ? and emp_phone = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getPhone1());
			pstmt.setString(3, dto.getUserId());
			pstmt.setString(4, dto.getPhone1());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberPw = rs.getString("user_pw");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return memberPw;
	}
}
