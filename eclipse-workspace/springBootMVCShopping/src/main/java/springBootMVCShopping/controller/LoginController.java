package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springBootMVCShopping.service.IdCheckService;

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	IdCheckService idCheckService;
	// ajax를 사용할 때, Spring 방식
	// 원래 Controller에서는 html이나 jsp의 주소를 return 해야하지만, ResponseBody를 사용하면 Text 값을 return 가능
	@PostMapping("userIdCheck")
	public @ResponseBody Integer userIdCheck(String userId) {
		return idCheckService.execute(userId);
	}
}
