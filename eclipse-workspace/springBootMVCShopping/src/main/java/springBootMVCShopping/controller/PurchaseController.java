package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.PurchaseCommand;
import springBootMVCShopping.service.purchase.GoodsBuyService;
import springBootMVCShopping.service.purchase.GoodsOrderService;
import springBootMVCShopping.service.purchase.PurchaseListService;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
	@Autowired
	PurchaseListService purchaseListService;
	
	@Autowired
	GoodsBuyService goodsBuyService;
	
	@Autowired
	GoodsOrderService goodsOrderService;
	
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
	
	@PostMapping("goodsBuy")
	public String goodsBuy(String[] nums, HttpSession session, Model model) {
		goodsBuyService.execute(nums, session, model);
		return "thymeleaf/purchase/goodsOrder";
	}
	
	@PostMapping("goodsOrder")
	public String goodsOrder(PurchaseCommand purchaseCommand, HttpSession session, Model model) {
		String purchaseNum = goodsOrderService.execute(purchaseCommand, session);
		return "thymeleaf/purchase/payment";
	}
}
