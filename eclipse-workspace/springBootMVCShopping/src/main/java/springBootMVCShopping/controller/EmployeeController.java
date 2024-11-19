package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBootMVCShopping.command.EmployeeCommand;
import springBootMVCShopping.service.AutoNumService;
import springBootMVCShopping.service.employee.EmployeeDeleteService;
import springBootMVCShopping.service.employee.EmployeeDetailService;
import springBootMVCShopping.service.employee.EmployeeListService;
import springBootMVCShopping.service.employee.EmployeeUpdateService;
import springBootMVCShopping.service.employee.EmployeeWriteService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	EmployeeWriteService employeeWriteService;
	
	@Autowired
	AutoNumService autoNumService;
	
	@Autowired
	EmployeeListService employeeListService;
	
	@Autowired
	EmployeeDetailService employeeDetailService;
	
	@Autowired
	EmployeeUpdateService employeeUpdateService;
	
	@Autowired
	EmployeeDeleteService employeeDeleteService;

	
	@GetMapping("employeeList")
	public String list(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "searchWord", required = false) String searchWord) {
		employeeListService.execute(model, page, searchWord);
		return "thymeleaf/employee/employeeList";
	}
	
	@GetMapping("employeeWrite")
	public String write(Model model, EmployeeCommand employeeCommand) {
		String autoNum = autoNumService.execute("emp_", "emp_num", 5, "employees");
		employeeCommand.setEmpNum(autoNum);
		model.addAttribute("employeeCommand", employeeCommand);
		return "thymeleaf/employee/employeeWrite";
	}
	
	@PostMapping("employeeWrite")
	public String write(@Validated EmployeeCommand employeeCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/employee/employeeWrite";
		}
		if(!employeeCommand.isEmpPwEqualsEmpPwCon()) {
			System.out.println("1093ty17025712nbkdhbjjsDFHB");
			result.rejectValue("empPwCon", "EmployeeCommand.empPwCon", "비밀번호와 비밀번호 확인이 다릅니다.");
			return "thymeleaf/employee/employeeWrite";
		}
		employeeWriteService.execute(employeeCommand);
		return "redirect:employeeList";

	}
	
	@GetMapping("employeeDetail")
	public String detail(String empNum, Model model) {
		employeeDetailService.execute(empNum, model);
		return "thymeleaf/employee/employeeDetail";
	}
	
	@GetMapping("employeeModify")
	public String modify(String empNum, Model model) {
		employeeDetailService.execute(empNum, model);
		return "thymeleaf/employee/employeeModify";
	}
	
	@PostMapping("employeeUpdate")
	public String update(EmployeeCommand employeeCommand) {
		employeeUpdateService.execute(employeeCommand);
		return "redirect:employeeDetail?empNum=" + employeeCommand.getEmpNum();
	}
	
	@RequestMapping("employeesDelete")
	public String deleteList(@RequestParam("nums") String[] empNums) {
		if(empNums.length >= 1) {
			employeeDeleteService.execute(empNums);
		}
		return "redirect:employeeList";
	}
}
