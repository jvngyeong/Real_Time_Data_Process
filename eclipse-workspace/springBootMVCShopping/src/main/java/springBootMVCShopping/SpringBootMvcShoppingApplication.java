package springBootMVCShopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import springBootMVCShopping.command.LoginCommand;
import springBootMVCShopping.service.EmailSendService;
import springBootMVCShopping.service.SMSMessageService;

@SpringBootApplication
@Controller
public class SpringBootMvcShoppingApplication {
	@Autowired
	EmailSendService emailSendService;
	
	@Autowired
	SMSMessageService sMSMessageService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcShoppingApplication.class, args);
	}

	@GetMapping("/")
	public String index(LoginCommand loginCommand) {
		return "thymeleaf/index";
	}
	
	@GetMapping("/mailling")
	public String mail() {
		return "thymeleaf/email";
	}
	
	@PostMapping("/mailling")
	public String mail(String fromEmail, String toEmail, String subject, String contents) {
		emailSendService.mailSend(fromEmail, toEmail, subject, contents);
		return "redirect:/";
	}
	
	@GetMapping("/smsSend")
	public String smsSend() {
		return "thymeleaf/sms";
	}
	
	@PostMapping("/smsSend")
	public String smsSend(String userPhone, String message) {
		sMSMessageService.smsSend(userPhone, "010-7146-1970", message);
		return "redirect:/";
	}
}
