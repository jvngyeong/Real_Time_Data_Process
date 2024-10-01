package jspMVCMisoShopping.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jspMVCMisoShopping.model.dto.CartDTO;
import jspMVCMisoShopping.model.dto.CartListDTO;
import jspMVCMisoShopping.model.dto.PaymentDTO;
import jspMVCMisoShopping.model.dto.PurchaseDTO;
import jspMVCMisoShopping.model.dto.PurchaseInfoDTO;

public class ItemDAO extends DataBaseInfo{	
	public void wishItem(String memberNum, String goodsNum) {
		con = getConnection();
		sql = "insert into wish(MEMBER_NUM, GOODS_NUM, WISH_DATE) values(?, ?, sysdate)";
		
		sql = "merge into wish w "
				+ " using (select goods_num from goods where goods_num = ?) g"
				+ " on (w.goods_num = g.goods_num and member_num = ?)"
				+ " when MATCHED THEN "
				+ 	" update set WISH_DATE = sysdate "
				+ 	" delete where member_num = ? and goods_num = ? "
				+ " when NOT MATCHED THEN "
				+ 	" insert (MEMBER_NUM, GOODS_NUM, WISH_DATE) values(?, g.goods_num, sysdate)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			pstmt.setString(2, memberNum);
			pstmt.setString(3, memberNum);
			pstmt.setString(4, goodsNum);
			pstmt.setString(5, memberNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 삽입되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public int wishSelectOne(String memberNum, String goodsNum) {
		con = getConnection();
		sql = "select MEMBER_NUM, GOODS_NUM, WISH_DATE from wish where MEMBER_NUM = ? and GOODS_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			pstmt.setString(2, goodsNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}

	public void cartMerge(CartDTO dto) {
		con = getConnection();
		sql = "merge into cart c "
			+ " using (select GOODS_NUM from goods where GOODS_NUM = ?) g "
			+ " on (c.GOODS_NUM = g.GOODS_NUM and MEMBER_NUM = ?) "
			+ " WHEN MATCHED THEN "
			+ " update set CART_QTY = CART_QTY + ? "
			+ " WHEN NOT MATCHED THEN "
			+ " insert (MEMBER_NUM, GOODS_NUM, CART_DATE, CART_QTY) "
			+ " values (?, ?, sysdate, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setString(2, dto.getMemberNum());
			pstmt.setInt(3, dto.getCartQty());
			pstmt.setString(4, dto.getMemberNum());
			pstmt.setString(5, dto.getGoodsNum());
			pstmt.setInt(6, dto.getCartQty());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public List<CartListDTO> cartSelectList(String memberNum) {
		List<CartListDTO> list = new ArrayList<CartListDTO>();
		con = getConnection();
		sql = "select g.GOODS_NUM, GOODS_NAME, GOODS_PRICE, GOODS_MAIN_STORE_IMAGE, "
			+ " MEMBER_NUM, CART_QTY, CART_DATE, "
			+ " GOODS_PRICE * CART_QTY as TOTAL_PRICE "
			+ "from goods g join cart c "
			+ "on g.GOODS_NUM = c.GOODS_NUM "
			+ "where MEMBER_NUM = ? "
			+ "order by g.GOODS_NUM desc";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CartListDTO dto = new CartListDTO();
				dto.setGoodsNum(rs.getString(1));
				dto.setGoodsName(rs.getString("GOODS_NAME"));
				dto.setGoodsPrice(rs.getInt("GOODS_PRICE"));
				dto.setGoodsImage(rs.getString("GOODS_MAIN_STORE_IMAGE"));
				dto.setMemberNum(rs.getString("MEMBER_NUM"));
				dto.setCartQty(rs.getInt("CART_QTY"));
				dto.setCartDate(rs.getDate("CART_DATE"));
				dto.setTotalPrice(rs.getInt("TOTAL_PRICE"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public void itemQtyDownUpdate(String goodsNum, String memberNum) {
		con = getConnection();
		sql = "update cart set GOODS_NUM = ?, CART_QTY = CART_QTY - 1 "
				+ "where MEMBER_NUM = ? and GOODS_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			pstmt.setString(2, memberNum);
			pstmt.setString(3, goodsNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
	}

	public void itemDelete(String goodsNums, String memberNum) {
		con = getConnection();
		sql = "delete from cart where MEMBER_NUM = ? and GOODS_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			pstmt.setString(2, goodsNums);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 삭제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public CartListDTO itemSelectOne(String goodsNum, String memberNum) {
		CartListDTO dto = new CartListDTO();
		con = getConnection();
		sql = "select g.GOODS_NUM, GOODS_NAME, GOODS_PRICE, GOODS_MAIN_STORE_IMAGE, "
				+ " MEMBER_NUM, CART_QTY, CART_DATE, "
				+ " GOODS_PRICE * CART_QTY as TOTAL_PRICE "
				+ "from goods g join cart c "
				+ "on g.GOODS_NUM = c.GOODS_NUM "
				+ "where MEMBER_NUM = ? and g.GOODS_NUM = ? "
				+ "order by g.GOODS_NUM desc";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			pstmt.setString(2, goodsNum);
			rs = pstmt.executeQuery();
			rs.next();
			dto.setGoodsNum(rs.getString(1));
			dto.setGoodsName(rs.getString("GOODS_NAME"));
			dto.setGoodsPrice(rs.getInt("GOODS_PRICE"));
			dto.setGoodsImage(rs.getString("GOODS_MAIN_STORE_IMAGE"));
			dto.setMemberNum(rs.getString("MEMBER_NUM"));
			dto.setCartQty(rs.getInt("CART_QTY"));
			dto.setCartDate(rs.getDate("CART_DATE"));
			dto.setTotalPrice(rs.getInt("TOTAL_PRICE"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public void purchaseInsert(PurchaseDTO dto) {
		con = getConnection();
		sql = "insert into purchase(PURCHASE_NUM, PURCHASE_NAME, PURCHASE_DATE, PURCHASE_PRICE, MEMBER_NUM, "
				+ " DELIVERY_ADDR_DETAIL, DELIVERY_POST, DELIVERY_PHONE, MESSAGE, PURCHASE_STATUS, "
				+ " DELIVERY_NAME, DELIVERY_ADDR) "
				+ " values(?, ?, sysdate, ?, ?, ?, ?, ?, ?, '결제 대기중', ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPurchaseNum());
			pstmt.setString(2, dto.getPurchaseName());
			pstmt.setLong(3, dto.getPurchasePrice());
			pstmt.setString(4, dto.getMemberNum());
			pstmt.setString(5, dto.getDeliveryAddrDetail());
			pstmt.setString(6, dto.getDeliveryPost());
			pstmt.setString(7, dto.getDeliveryPhone());
			pstmt.setString(8, dto.getMessage());
			pstmt.setString(9, dto.getDeliveryName());
			pstmt.setString(10, dto.getDeliveryAddr());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 삽입되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void purchaseListInsert(String purchaseNum, String goodsNum, String memberNum) {
		con = getConnection();
		sql = "insert into purchase_list(GOODS_NUM, PURCHASE_NUM, PURCHASE_QTY, GOODS_UNIT_PRICE)"
				+ " select ?, ?, cart_qty, cart_qty * GOODS_PRICE"
				+ " from cart c join goods g"
				+ " on c.goods_num = g.goods_num"
				+ " where g.goods_num = ? and member_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			pstmt.setString(2, purchaseNum);
			pstmt.setString(3, goodsNum);
			pstmt.setString(4, memberNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 삽입되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	public List<PurchaseInfoDTO> purchaseItemSelect(String memberNum) {
	      List<PurchaseInfoDTO> list = new ArrayList<PurchaseInfoDTO>();
	      con = getConnection();
	      sql = "select g.goods_num , goods_name , goods_main_store_image";
	      sql += " ,p.purchase_num, purchase_status, purchase_price, member_num ";
	      sql += " ,APPLDATE, CONFIRMNUMBER ";
	      sql += " , delivery_num, delivery_status ";
	      sql += " , review_num ";
	      sql += " from goods g join purchase_list pl";
	      sql += " on g.goods_num = pl.goods_num join purchase p";
	      sql += " on pl.purchase_Num = p.purchase_Num left outer join payment pm";
	      sql += " on pm.purchase_num = p.purchase_num left outer join delivery d";
	      sql += " on d.purchase_num = p.purchase_num left outer join reviews r ";
	      sql += " on pl.purchase_num = r.purchase_num and r.goods_num = pl.goods_num";
	      if(memberNum != null) {
	    	  sql += " where member_num = ?";
	      }
	      sql += " order by p.purchase_num desc";
	      try {
	         pstmt = con.prepareStatement(sql);
	         if(memberNum != null) {
	        	 pstmt.setString(1, memberNum);
	         }
	         rs = pstmt.executeQuery();
	         while(rs.next()) {
	            PurchaseInfoDTO dto = new PurchaseInfoDTO();
	            dto.setGoodsNum(rs.getString(1));
	            dto.setGoodsName(rs.getString(2));
	            dto.setGoodsImage(rs.getString(3));
	            dto.setPurchaseNum(rs.getLong(4));
	            dto.setPurchaseStatus(rs.getString(5));
	            dto.setPurchasePrice(rs.getLong(6));
	            dto.setMemberNum(rs.getString(7));
	            dto.setApplDate(rs.getString("APPLDATE"));
	            dto.setConfirmNum(rs.getString("CONFIRMNUMBER"));
	            dto.setDeliveryNum(rs.getLong("delivery_num"));
	            dto.setDeliveryStatus(rs.getString("delivery_status"));
	            dto.setReviewNum(rs.getInt("review_num"));
	            list.add(dto);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         close();
	      }
	      return list;
	   }

	public PurchaseDTO purchaseSelectOne(String purchaseNum) {
	      PurchaseDTO dto = null;
	      con = getConnection();
	      sql = "select purchase_price, delivery_name, delivery_phone, purchase_name, member_num  from purchase where purchase_num = ?";
	      try {
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, purchaseNum);
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	            dto = new PurchaseDTO();
	            dto.setPurchasePrice(rs.getLong(1));
	            dto.setDeliveryName(rs.getString(2));
	            dto.setDeliveryPhone(rs.getString(3));
	            dto.setPurchaseName(rs.getString(4));
	            dto.setMemberNum(rs.getString(5));
	            
	         }
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         close();
	      }
	      return dto;
	   }

	public void paymentInsert(PaymentDTO dto) {
		con = getConnection();
		sql = "insert into payment(purchase_num, confirmNumber, cardNum, TID, totalPrice, "
				+ " resultMassage, payMathod, applDate, appTime) "
				+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPurchaseNum());
			pstmt.setString(2, dto.getConfirmNumber());
			pstmt.setString(3, dto.getCardNum());
			pstmt.setString(4, dto.getTid());
			pstmt.setString(5, dto.getTotalPrice());
			pstmt.setString(6, dto.getResultMessage());
			pstmt.setString(7, dto.getPayMethod());
			pstmt.setString(8, dto.getApplDate());
			pstmt.setString(9, dto.getApplTime());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 삽입되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void paymentDelete(String purchaseNum) {
		con = getConnection();
		sql = "delete from payment where purchase_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, purchaseNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 삭제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void purchaseStatusUpdate(String purchaseNum, String nowStatus) {
		con = getConnection();
		if(nowStatus.equals("payComplete")) {
			sql = "update purchase set purchase_status = '결제 완료' where purchase_num = ?";
		}
		else if(nowStatus.equals("purchased")) {
			sql = "update purchase set purchase_status = '구매 확정' where purchase_num = ?";
		}
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
