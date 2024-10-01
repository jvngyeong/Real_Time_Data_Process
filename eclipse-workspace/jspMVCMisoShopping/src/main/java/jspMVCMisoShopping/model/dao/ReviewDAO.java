package jspMVCMisoShopping.model.dao;

import java.util.ArrayList;
import java.util.List;

import jspMVCMisoShopping.model.dto.ReviewDTO;

public class ReviewDAO extends DataBaseInfo{
	public void reviewInsert(ReviewDTO dto) {
		con = getConnection();
		sql = "merge into reviews r ";
		sql += "using (select goods_num, purchase_num from purchase_list where goods_num = ? and purchase_num = ?) p ";
		sql += "on (r.purchase_num = p.purchase_num and r.goods_num = p.goods_num) ";
		sql += " when matched then ";
		sql += " update set review_contents = ? ";
		sql += "when not matched then ";
		sql += "insert (review_num, goods_num, purchase_num, review_date, review_contents, member_id) ";
		sql += "values (review_seq.nextval, ?, ?, sysdate, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setString(2, dto.getPurchaseNum());
			pstmt.setString(3, dto.getReviewContent());
			pstmt.setString(4, dto.getGoodsNum());
			pstmt.setString(5, dto.getPurchaseNum());
			pstmt.setString(6, dto.getReviewContent());
			pstmt.setString(7, dto.getMemberId());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 MERGE 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void reviewSelectone(ReviewDTO dto) {
		con = getConnection();
		sql = "select review_contents ";
		sql += " from reviews where goods_num = ? and purchase_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setString(2, dto.getPurchaseNum());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setReviewContent(rs.getString("review_contents"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void reviewDelete(String reviewNum) {
		con = getConnection();
		sql = "delete from reviews where review_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reviewNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행을 삭제했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public List<ReviewDTO> reviewSelectAll(String goodsNum) {
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		con = getConnection();
		sql = "select review_num, goods_num, purchase_num, review_date, review_contents, member_id ";
		sql += " from reviews where goods_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setGoodsNum(rs.getString("goods_num"));
				dto.setPurchaseNum(rs.getString("purchase_num"));
				dto.setReviewContent(rs.getString("review_contents"));
				dto.setReviewDate(rs.getString("review_date"));
				dto.setMemberId(rs.getString("member_id"));
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
