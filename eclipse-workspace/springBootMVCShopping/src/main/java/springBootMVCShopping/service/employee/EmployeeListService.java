package springBootMVCShopping.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.EmployeeDTO;
import springBootMVCShopping.domain.StartEndPageDTO;
import springBootMVCShopping.mapper.EmployeeMapper;
import springBootMVCShopping.service.StartEndPageService;

@Service
public class EmployeeListService {
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	StartEndPageService startEndPageService;
	public void execute(Model model, int page, String searchWord) {
		int limit = 3;
		StartEndPageDTO sepDTO = startEndPageService.execute(page, 3, searchWord);
		
		List<EmployeeDTO> list = employeeMapper.employeeSelectList(sepDTO);
		int count = employeeMapper.employeeCount();
		startEndPageService.execute(page, limit, count, searchWord, list, model);
		model.addAttribute("list", list);
	}
}
