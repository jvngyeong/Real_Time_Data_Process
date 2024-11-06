package springBootMVCShopping.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springBootMVCShopping.domain.OrderListDTO;
import springBootMVCShopping.domain.PaymentDTO;
import springBootMVCShopping.domain.PurchaseDTO;

@Repository
public class PurchaseRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace= "purchaseRepositorySql";
	String statement;	
//	public List<OrderListDTO> orderList(String memberNum){
//		statement = namespace + ".orderList";
//		return sqlSession.selectList(statement, memberNum);
//	}
	public String selectPurchaseNum() {
		statement = namespace + ".purchaseNum";
		return sqlSession.selectOne(statement);
	}
	public void purchaseInsert(PurchaseDTO dto) {
		statement = namespace + ".purchaseInsert";
		sqlSession.insert(statement, dto);
	}
	public void purchaseListInsert(Map<String, Object> map) {
		statement = namespace + ".purchaseListInsert";
		sqlSession.insert(statement, map);
	}
	public List<OrderListDTO> orderList(Map<String, String> map) {
		statement = namespace + ".orderList";
		return sqlSession.selectList(statement, map);
	}
	public PurchaseDTO purchaseSelectOne(String purchaseNum) {
		statement = namespace + ".purchaseSelectOne";
		return sqlSession.selectOne(statement, purchaseNum);
	}
	public void paymentInsert(PaymentDTO dto) {
		statement = namespace + ".paymentInsert";
		sqlSession.insert(statement, dto);
	}
}
