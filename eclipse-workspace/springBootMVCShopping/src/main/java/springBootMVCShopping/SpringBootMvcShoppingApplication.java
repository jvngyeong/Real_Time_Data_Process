package springBootMVCShopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootMVCShopping.command.LoginCommand;

@SpringBootApplication
@Controller
public class SpringBootMvcShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcShoppingApplication.class, args);
	}

	@GetMapping("/")
	public String index(LoginCommand loginCommand) {
		return "thymeleaf/index";
	}
	
	@RequestMapping("/mailling")
	public String mail() {
		return "thymeleaf/email";
	}
}
