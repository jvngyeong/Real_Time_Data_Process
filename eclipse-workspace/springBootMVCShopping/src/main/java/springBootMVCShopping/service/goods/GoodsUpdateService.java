package springBootMVCShopping.service.goods;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.GoodsCommand;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.mapper.EmployeeMapper;
import springBootMVCShopping.mapper.GoodsMapper;

@Service
public class GoodsUpdateService {
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(GoodsCommand goodsCommand, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String empNum = employeeMapper.empNumSelect(auth.getUserId());
		GoodsDTO dto = new GoodsDTO();
		BeanUtils.copyProperties(goodsCommand, dto);
		dto.setUpdateEmpNum(empNum);
		goodsMapper.goodsUpdate(dto);
	}
}
