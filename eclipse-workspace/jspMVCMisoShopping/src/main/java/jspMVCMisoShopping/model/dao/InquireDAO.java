package jspMVCMisoShopping.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jspMVCMisoShopping.model.dto.InquireDTO;

public class InquireDAO extends DataBaseInfo{
	public void inquireInsert(InquireDTO dto) {
		con = getConnection();
		sql = "insert into inquire(INQUIRE_NUM, MEMBER_NUM, GOODS_NUM, INQUIRE_SUBJECT, INQUIRE_CONTENTS, ";
		sql += " INQUIRE_KIND, INQUIRE_DATE) ";
		sql += " values(review_seq.nextval, ?, ?, ?, ?, ?, sysdate)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberNum());
			pstmt.setString(2, dto.getGoodsNum());
			pstmt.setString(3, dto.getInquireSubject());
			pstmt.setString(4, dto.getInquireContents());
			pstmt.setString(5, dto.getInquireKind());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 삽입되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public List<InquireDTO> inquireSelectAll(String goodsNum) {
		List<InquireDTO> list = new ArrayList<InquireDTO>();
		con = getConnection();
		sql = "select INQUIRE_NUM, MEMBER_NUM, GOODS_NUM, INQUIRE_SUBJECT, INQUIRE_CONTENTS, INQUIRE_KIND, ";
		sql += " INQUIRE_DATE, INQUIRE_ANSWER, INQUIRE_ANSWER_DATE, EMP_NUM from inquire where goods_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				InquireDTO dto = new InquireDTO();
				dto.setInquireNum(rs.getInt("INQUIRE_NUM"));
				dto.setMemberNum(rs.getString("MEMBER_NUM"));
				dto.setGoodsNum(rs.getString("GOODS_NUM"));
				dto.setInquireSubject(rs.getString("INQUIRE_SUBJECT"));
				dto.setInquireContents(rs.getString("INQUIRE_CONTENTS"));
				dto.setInquireKind(rs.getString("INQUIRE_KIND"));
				dto.setInquireDate(rs.getDate("INQUIRE_DATE"));
				dto.setInquireAnswer(rs.getString("INQUIRE_ANSWER"));
				dto.setInquireAnswerDate(rs.getDate("INQUIRE_ANSWER_DATE"));
				dto.setEmpNum(rs.getString("EMP_NUM"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
}
