package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import springBootMVCShopping.service.purchase.INIstdpayPcReturn;
import springBootMVCShopping.service.purchase.IniPayReqService;

@Controller
public class PaymentController {
	@Autowired
	INIstdpayPcReturn iNIstdpayPcReturn;
	
	@RequestMapping("INIstdpay_pc_return")
	public String payReturn(HttpServletRequest req){
		iNIstdpayPcReturn.execute(req);
		return "thymeleaf/purchase/buyfinished";
	}
	
	@RequestMapping("close")
	public String close() {
		return "thymeleaf/purchase/close";
	}
}
