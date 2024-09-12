package jspMVCMisoShopping.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jspMVCMisoShopping.model.dto.MemberDTO;

public class MemberDAO extends DataBaseInfo{
	public void memberInsert(MemberDTO dto) {
		con = getConnection();
		sql = " insert into members (MEMBER_NUM, MEMBER_NAME, MEMBER_ID, MEMBER_PW"
		         + "                , MEMBER_ADDR, MEMBER_ADDR_DETAIL, MEMBER_POST"
		         + "                  , MEMBER_REGIST, GENDER, MEMBER_PHONE1, MEMBER_PHONE2"
		         + "                  , MEMBER_EMAIL, MEMBER_BIRTH, MEMBER_POINT ) "
		         + " values( ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ? )";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberNum());
			pstmt.setString(2, dto.getMemberName());
			pstmt.setString(3, dto.getMemberId());
			pstmt.setString(4, dto.getMemberPw());
			pstmt.setString(5, dto.getMemberAddr());
			pstmt.setString(6, dto.getMemberAddrDetail());
			pstmt.setString(7, dto.getMemberPost());
			pstmt.setString(8, dto.getGender());
			pstmt.setString(9, dto.getMemberPhone1());
			pstmt.setString(10, dto.getMemberPhone2());
			pstmt.setString(11, dto.getMemberEmail());
			pstmt.setDate(12, new Date(dto.getMemberBirth().getTime()));
			pstmt.setInt(13, 0);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 삽입되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public List<MemberDTO> memberSelectAll() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		con = getConnection();
		sql = " select MEMBER_NUM, MEMBER_NAME, MEMBER_ID, MEMBER_PW, MEMBER_ADDR, MEMBER_ADDR_DETAIL, MEMBER_POST";
		sql += ", MEMBER_REGIST, GENDER, MEMBER_PHONE1, MEMBER_PHONE2";
		sql += ", MEMBER_EMAIL, MEMBER_BIRTH, MEMBER_POINT, MEMBER_EMAIL_CONF from members";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setGender(rs.getString("GENDER"));
				dto.setMemberAddr(rs.getString("MEMBER_ADDR"));
				dto.setMemberAddrDetail(rs.getString("MEMBER_ADDR_DETAIL"));
				dto.setMemberBirth(rs.getDate("MEMBER_BIRTH"));
				dto.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				dto.setMemberId(rs.getString("MEMBER_ID"));
				dto.setMemberName(rs.getString("MEMBER_NAME"));
				dto.setMemberNum(rs.getString("MEMBER_NUM"));
				dto.setMemberPhone1(rs.getString("MEMBER_PHONE1"));
				dto.setMemberPhone2(rs.getString("MEMBER_PHONE2"));
				dto.setMemberPost(rs.getString("MEMBER_POST"));
				dto.setMemberPw(rs.getString("MEMBER_PW"));
				dto.setMemberRegist(rs.getDate("MEMBER_REGIST"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public String memberAutoNum() {
	      con = getConnection();
	      sql = " select concat('mem_' ,nvl(substr(max(member_num), 5), 100000) + 1) from members ";
	      String memberNum = null;
	      try {
	         pstmt = con.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         rs.next();
	         memberNum = rs.getString(1);
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         close();
	      }
	      return memberNum;
	   }
	   
	
	public MemberDTO memberSelectOne(String memberNum) {
		MemberDTO returnDTO = null;
		con = getConnection();
		sql = " select MEMBER_NUM, MEMBER_NAME, MEMBER_ID, MEMBER_PW, MEMBER_ADDR, MEMBER_ADDR_DETAIL, MEMBER_POST";
		sql += ", MEMBER_REGIST, GENDER, MEMBER_PHONE1, MEMBER_PHONE2";
		sql += ", MEMBER_EMAIL, MEMBER_BIRTH, MEMBER_POINT, MEMBER_EMAIL_CONF from members where MEMBER_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				returnDTO = new MemberDTO();
				returnDTO.setMemberNum(rs.getString("MEMBER_NUM"));
				returnDTO.setMemberName(rs.getString("MEMBER_NAME"));
				returnDTO.setMemberId(rs.getString("MEMBER_ID"));
				returnDTO.setMemberPw(rs.getString("MEMBER_PW"));
				returnDTO.setMemberAddr(rs.getString("MEMBER_ADDR"));
				returnDTO.setMemberAddrDetail(rs.getString("MEMBER_ADDR_DETAIL"));
				returnDTO.setMemberPost(rs.getString("MEMBER_POST"));
				returnDTO.setMemberRegist(rs.getDate("MEMBER_REGIST"));
				returnDTO.setGender(rs.getString("GENDER"));
				returnDTO.setMemberPhone1(rs.getString("MEMBER_PHONE1"));
				returnDTO.setMemberPhone2(rs.getString("MEMBER_PHONE2"));
				returnDTO.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				returnDTO.setMemberBirth(rs.getDate("MEMBER_BIRTH"));
				returnDTO.setMemberPoint(rs.getInt("MEMBER_POINT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnDTO;
	}
	
	public void memberUpdate(MemberDTO dto) {
		con = getConnection();
		sql = "update members set MEMBER_NAME = ?, MEMBER_ID = ?, MEMBER_PW = ?, MEMBER_ADDR = ?, ";
		sql += " MEMBER_ADDR_DETAIL = ?, MEMBER_POST = ?, GENDER = ?, MEMBER_PHONE1 = ?, ";
		sql += " MEMBER_PHONE2 = ?, MEMBER_EMAIL = ?, MEMBER_BIRTH = ? where MEMBER_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberName());
			pstmt.setString(2, dto.getMemberId());
			pstmt.setString(3, dto.getMemberPw());
			pstmt.setString(4, dto.getMemberAddr());
			pstmt.setString(5, dto.getMemberAddrDetail());
			pstmt.setString(6, dto.getMemberPost());
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getMemberPhone1());
			pstmt.setString(9, dto.getMemberPhone2());
			pstmt.setString(10, dto.getMemberEmail());
			pstmt.setDate(11, new Date(dto.getMemberBirth().getTime()));
			pstmt.setString(12, dto.getMemberNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 수정되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void memberDelete(String memberNum) {
		con = getConnection();
		sql = "delete from members where member_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 삭제되었습니다.");
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

	public String memberNumSelect(String memberId) {
		String memberNum = null;
		con = getConnection();
		sql = " select member_num from members ";
		sql += " where member_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			rs.next();
			memberNum = rs.getString("member_num");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return memberNum;
	}
	
	public void memberPwUpdate(String newPw, String userId) {
		con = getConnection();
		sql = "update members set member_pw = ? where member_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setString(2, userId);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
