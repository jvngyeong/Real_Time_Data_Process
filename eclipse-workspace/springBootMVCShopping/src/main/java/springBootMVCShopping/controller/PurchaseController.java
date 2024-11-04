package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.service.purchase.PurchaseListService;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
	@Autowired
	PurchaseListService purchaseListService;
	
	@GetMapping("orderList")
	public String orderList(Model model, HttpSession session) {
		purchaseListService.execute(model, session);
		return "thymeleaf/purchase/orderList";
	}
	
	@GetMapping("purchaseList")
	public String purchaseList(Model model, HttpSession session) {
		purchaseListService.execute(model, session);
		return "thymeleaf/purchase/purchaseList";
	}
}
