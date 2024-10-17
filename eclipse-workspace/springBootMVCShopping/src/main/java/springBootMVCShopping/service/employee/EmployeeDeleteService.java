package springBootMVCShopping.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.mapper.AutoNumMapper;

@Service
public class EmployeeDeleteService {	
	@Autowired
	AutoNumMapper autoNumMapper;

	public void execute(String[] empNums) {
		autoNumMapper.numsDelete(empNums, "employees", "emp_num");
	}
}
