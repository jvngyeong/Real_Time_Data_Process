package jspMVCMisoShopping.model.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jspMVCMisoShopping.model.dto.IpgoDTO;

public class IpgoDAO extends DataBaseInfo{
	public String ipgoAutoNum() {
		String ipgoNum = null;
		con = getConnection();
		sql = "select concat('ipgo_', nvl(max(substr(IPGO_NUM, 6)), 100000) + 1) ipgoNum from goods_ipgo";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ipgoNum = rs.getString("ipgoNum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return ipgoNum;
	}
	
	public void ipgoRegist(IpgoDTO dto) {
		con = getConnection();
		sql = "insert into goods_ipgo(GOODS_NUM, IPGO_NUM, IPGO_QTY, IPGO_DATE, MADE_DATE, "
				+ "IPGO_PRICE, EMP_NUM) values(?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setString(2, dto.getIpgoNum());
			pstmt.setInt(3, dto.getIpgoQty());
			pstmt.setDate(4, new Date(dto.getIpgoDate().getTime()));
			pstmt.setDate(5, new Date(dto.getMadeDate().getTime()));
			pstmt.setInt(6, dto.getIpgoPrice());
			pstmt.setString(7, dto.getEmpNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 삽입되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public List<IpgoDTO> IpgoSelectAll() {
		List<IpgoDTO> list = new ArrayList<IpgoDTO>();
		con = getConnection();
		sql = "select GOODS_NUM, IPGO_NUM, IPGO_QTY, IPGO_DATE, MADE_DATE, IPGO_PRICE, EMP_NUM from goods_ipgo order by IPGO_NUM asc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				IpgoDTO dto = new IpgoDTO();
				dto.setGoodsNum(rs.getString("GOODS_NUM"));
				dto.setIpgoNum(rs.getString("IPGO_NUM"));
				dto.setIpgoQty(rs.getInt("IPGO_QTY"));
				dto.setIpgoDate(rs.getDate("IPGO_DATE"));
				dto.setMadeDate(rs.getDate("MADE_DATE"));
				dto.setIpgoPrice(rs.getInt("IPGO_PRICE"));
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
	
	public IpgoDTO ipgoSelectOne(String ipgoNum) {
		IpgoDTO dto = null;
		con = getConnection();
		sql = "select GOODS_NUM, IPGO_NUM, IPGO_QTY, IPGO_DATE, MADE_DATE, IPGO_PRICE, EMP_NUM "
				+ "from goods_ipgo where IPGO_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ipgoNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new IpgoDTO();
				dto.setGoodsNum(rs.getString("GOODS_NUM"));
				dto.setIpgoNum(rs.getString("IPGO_NUM"));
				dto.setIpgoQty(rs.getInt("IPGO_QTY"));
				dto.setIpgoDate(rs.getDate("IPGO_DATE"));
				dto.setMadeDate(rs.getDate("MADE_DATE"));
				dto.setIpgoPrice(rs.getInt("IPGO_PRICE"));
				dto.setEmpNum(rs.getString("EMP_NUM"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	public void ipgoUpdate(IpgoDTO dto) {
		con = getConnection();
		sql = "update goods_ipgo set GOODS_NUM = ?, IPGO_QTY = ?, IPGO_DATE = ?, "
				+ "MADE_DATE = ?, IPGO_PRICE = ?, EMP_NUM = ? where IPGO_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setInt(2, dto.getIpgoQty());
			pstmt.setDate(3, new Date(dto.getIpgoDate().getTime()));
			pstmt.setDate(4, new Date(dto.getMadeDate().getTime()));
			pstmt.setInt(5, dto.getIpgoPrice());
			pstmt.setString(6, dto.getEmpNum());
			pstmt.setString(7, dto.getIpgoNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ipgoDelete(String ipgoNum) {
		con = getConnection();
		sql = "delete from goods_ipgo where IPGO_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ipgoNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 삭제되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
