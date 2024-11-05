package springBootMVCShopping.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
