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
public class GoodsWriteService {
	@Autowired
	GoodsMapper goodsMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(GoodsCommand goodsCommand, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		GoodsDTO goodsDTO = new GoodsDTO();
		BeanUtils.copyProperties(goodsCommand, goodsDTO);
		String empNum = employeeMapper.empNumSelect(auth.getUserId());
		goodsDTO.setEmpNum(empNum);
		goodsDTO.setUpdateEmpNum(empNum);
		goodsMapper.goodsInsert(goodsDTO);
	}
}
