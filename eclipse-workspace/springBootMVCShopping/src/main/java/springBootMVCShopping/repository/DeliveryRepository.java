package springBootMVCShopping.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeliveryRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace= "deliveryRepositorySql";
	String statement;

	public int deliveryUpdate(String purchaseNum, String deliveryNum) {
		statement = namespace + ".deliveryUpdate";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("purchaseNum", purchaseNum);
		map.put("deliveryNum", deliveryNum);
		return sqlSession.update(statement, map);
	}

	public int deliveryStatusUpdate(String purchaseNum) {
		statement = namespace + ".deliveryStatusUpdate";
		return sqlSession.update(statement, purchaseNum);
	}
}
