package jspMVCMisoShopping.model.dao;

import java.sql.SQLException;

public class DeliveryDAO extends DataBaseInfo{
	public void deliveryInsert(String purchaseNum, String deliveryNum) {
		con = getConnection();
		sql = "merge into delivery d ";
		sql += "using(select purchase_num from purchase where purchase_num = ?) p ";
		sql += "on (d.purchase_num = p.purchase_num ) ";
		sql += "when matched then ";
		sql += "update set delivery_num = ? ";
		sql += "when not matched then ";
		sql += "insert (purchase_num, delivery_num, delivery_date, delivery_status) ";
		sql += "values (p.purchase_num, ?, sysdate, '배송 중')";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, purchaseNum);
			pstmt.setString(2, deliveryNum);
			pstmt.setString(3, deliveryNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행을 수정했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
	}

	public String deliveryNumSelectOne(String purchaseNum) {
		String deliveryNum = null;
		con = getConnection();
		sql = "select delivery_num from delivery where purchase_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, purchaseNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				deliveryNum = rs.getString("delivery_num");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return deliveryNum;
	}

	public void deliveryStatusUpdate(String purchaseNum) {
		con = getConnection();
		sql = "update delivery set DELIVERY_STATUS = '배송 완료' where purchase_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, purchaseNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행을 수정했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
