package springBootMVCShopping.service.goodsIpgo;

import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.GoodsIpgoCommand;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.GoodsIpgoDTO;
import springBootMVCShopping.mapper.EmployeeMapper;
import springBootMVCShopping.mapper.GoodsIpgoMapper;
@Service
public class GoodsIpgoService {
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	GoodsIpgoMapper goodsIpgoMapper;
	public void execute(GoodsIpgoCommand command, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String empId = auth.getUserId();
		String empNum = employeeMapper.empNumSelect(empId);
		GoodsIpgoDTO dto = new GoodsIpgoDTO();
		BeanUtils.copyProperties(command, dto);
		dto.setEmpNum(empNum);
		dto.setMadeDate(Timestamp.valueOf(command.getMadeDate()));
		goodsIpgoMapper.goodsIpgoInsert(dto);
	}
}
