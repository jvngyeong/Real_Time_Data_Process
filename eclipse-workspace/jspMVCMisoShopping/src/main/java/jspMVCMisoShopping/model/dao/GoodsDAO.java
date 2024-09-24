package jspMVCMisoShopping.model.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jspMVCMisoShopping.model.dto.GoodsDTO;

public class GoodsDAO extends DataBaseInfo{
	public List<GoodsDTO> goodsSelectAll() {
		List<GoodsDTO> list = new ArrayList<GoodsDTO>();
		con = getConnection();
		sql = "select GOODS_NUM, GOODS_NAME, GOODS_PRICE, GOODS_CONTENTS, VISIT_COUNT, GOODS_MAIN_IMAGE, "
				+ " GOODS_MAIN_STORE_IMAGE, GOODS_DETAIL_IMAGE, GOODS_DETAIL_STORE_IMAGE, EMP_NUM, "
				+ " GOODS_REGIST, UPDATE_EMP_NUM, GOODS_UPDATE_DATE from goods order by GOODS_NUM";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GoodsDTO dto = new GoodsDTO();
				dto.setGoodsNum(rs.getString("GOODS_NUM"));
				dto.setGoodsName(rs.getString("GOODS_NAME"));
				dto.setGoodsPrice(rs.getInt("GOODS_PRICE"));
				dto.setGoodsContent(rs.getString("GOODS_CONTENTS"));
				dto.setVisitCount(rs.getInt("VISIT_COUNT"));
				dto.setGoodsMainImage(rs.getString("GOODS_MAIN_IMAGE"));
				dto.setGoodsMainStoreImage(rs.getString("GOODS_MAIN_STORE_IMAGE"));
				dto.setGoodsDetailImage(rs.getString("GOODS_DETAIL_IMAGE"));
				dto.setGoodsDetailStoreImage(rs.getString("GOODS_DETAIL_STORE_IMAGE"));
				dto.setEmpNum(rs.getString("EMP_NUM"));
				dto.setGoodsRegist(rs.getDate("GOODS_REGIST"));
				dto.setUpdateEmpNum(rs.getString("UPDATE_EMP_NUM"));
				dto.setGoodsUpdateDate(rs.getDate("GOODS_UPDATE_DATE"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public String goodsAutoNum() {
		String goodsNum = null;
		con = getConnection();
		sql = "select concat('goods_', (nvl(max(substr(goods_num, 7)), 100000) + 1)) goodsNum from goods";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				goodsNum = rs.getString("goodsNum");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return goodsNum;
	}
	
	public void goodsInsert(GoodsDTO dto, String empNum) {
		con = getConnection();
		sql = "insert into goods(GOODS_NUM, GOODS_NAME, GOODS_PRICE, GOODS_CONTENTS, VISIT_COUNT, "
				+ "GOODS_MAIN_IMAGE, GOODS_MAIN_STORE_IMAGE, GOODS_DETAIL_IMAGE, GOODS_DETAIL_STORE_IMAGE, "
				+ "EMP_NUM, GOODS_REGIST, UPDATE_EMP_NUM, GOODS_UPDATE_DATE) "
				+ "values(?,?,?,?,0,?,?,?,?,'" + empNum + "',sysdate,'"+ empNum +"',sysdate)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setString(2, dto.getGoodsName());
			pstmt.setInt(3, dto.getGoodsPrice());
			pstmt.setString(4, dto.getGoodsContent());
			pstmt.setString(5, dto.getGoodsMainImage());
			pstmt.setString(6, dto.getGoodsMainStoreImage());
			pstmt.setString(7, dto.getGoodsDetailImage());
			pstmt.setString(8, dto.getGoodsDetailStoreImage());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행을 삽입했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public GoodsDTO goodsSelectOne(String goodsNum) {
		GoodsDTO dto = null;
		con = getConnection();
		sql = "select GOODS_NUM, GOODS_NAME, GOODS_PRICE, GOODS_CONTENTS, VISIT_COUNT, GOODS_MAIN_IMAGE, "
				+ " GOODS_MAIN_STORE_IMAGE, GOODS_DETAIL_IMAGE, GOODS_DETAIL_STORE_IMAGE, EMP_NUM, "
				+ "GOODS_REGIST, UPDATE_EMP_NUM, GOODS_UPDATE_DATE from goods where goods_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new GoodsDTO();
				dto.setGoodsNum(rs.getString("GOODS_NUM"));
				dto.setGoodsName(rs.getString("GOODS_NAME"));
				dto.setGoodsPrice(rs.getInt("GOODS_PRICE"));
				dto.setGoodsContent(rs.getString("GOODS_CONTENTS"));
				dto.setVisitCount(rs.getInt("VISIT_COUNT"));
				dto.setGoodsMainImage(rs.getString("GOODS_MAIN_IMAGE"));
				dto.setGoodsMainStoreImage(rs.getString("GOODS_MAIN_STORE_IMAGE"));
				dto.setGoodsDetailImage(rs.getString("GOODS_DETAIL_IMAGE"));
				dto.setGoodsDetailStoreImage(rs.getString("GOODS_DETAIL_STORE_IMAGE"));
				dto.setEmpNum(rs.getString("EMP_NUM"));
				dto.setGoodsRegist(rs.getDate("GOODS_REGIST"));
				dto.setUpdateEmpNum(rs.getString("UPDATE_EMP_NUM"));
				dto.setGoodsUpdateDate(rs.getDate("GOODS_UPDATE_DATE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	public void goodsUpdate(GoodsDTO dto) {
		con = getConnection();
		sql = "update goods set GOODS_NAME = ?, GOODS_PRICE = ?, GOODS_CONTENTS = ?, visit_count = ?, "
				+ "EMP_NUM = ?, GOODS_REGIST = ?, UPDATE_EMP_NUM = ?, GOODS_UPDATE_DATE = sysdate where GOODS_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsName());
			pstmt.setInt(2, dto.getGoodsPrice());
			pstmt.setString(3, dto.getGoodsContent());
			pstmt.setInt(4, dto.getVisitCount());
			pstmt.setString(5, dto.getEmpNum());
			pstmt.setDate(6, new Date(dto.getGoodsRegist().getTime()));
			pstmt.setString(7, dto.getUpdateEmpNum());
			pstmt.setString(8, dto.getGoodsNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public int goodsDelete(String goodsNum) {
		int i = 0;
		con = getConnection();
		sql = "delete from goods where GOODS_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 삭제되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return i;
	}
	
	public String goodsNameSelect(String goodsNum) {
		String goodsName = null;
		con = getConnection();
		sql = "select GOODS_NAME from goods where goods_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				goodsName = rs.getString("GOODS_NAME");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsName;
	}
}
