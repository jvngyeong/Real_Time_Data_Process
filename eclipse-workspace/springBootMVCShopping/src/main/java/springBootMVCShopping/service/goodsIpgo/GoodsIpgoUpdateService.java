package springBootMVCShopping.service.goodsIpgo;

import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.command.GoodsIpgoCommand;
import springBootMVCShopping.domain.GoodsIpgoDTO;
import springBootMVCShopping.mapper.EmployeeMapper;
import springBootMVCShopping.mapper.GoodsIpgoMapper;

@Service
public class GoodsIpgoUpdateService {
	@Autowired
	GoodsIpgoMapper goodsIpgoMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(GoodsIpgoCommand command) {
		GoodsIpgoDTO dto = new GoodsIpgoDTO();
		BeanUtils.copyProperties(command, dto);
		dto.setMadeDate(Timestamp.valueOf(command.getMadeDate()));
		goodsIpgoMapper.goodsIpgoUpdate(dto);
		
	}
}
