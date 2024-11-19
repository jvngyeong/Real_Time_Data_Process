package springBootMVCShopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBootMVCShopping.command.PurchaseCommand;
import springBootMVCShopping.repository.PurchaseRepository;
import springBootMVCShopping.service.purchase.GoodsBuyService;
import springBootMVCShopping.service.purchase.GoodsOrderService;
import springBootMVCShopping.service.purchase.IniPayReqService;
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
	
	@Autowired
	IniPayReqService iniPayReqService;
	@GetMapping("orderList")
	public String orderList(Model model, HttpSession session) {
		purchaseListService.execute(model, session, null);
		return "thymeleaf/purchase/orderList";
	}
	
	@GetMapping("purchaseList")
	public String purchaseList(Model model, HttpSession session) {
		purchaseListService.execute(model, session, null);
		return "thymeleaf/purchase/purchaseList";
	}
	
	@RequestMapping("goodsBuy")
	public String goodsBuy(String[] nums, HttpSession session, Model model, @RequestParam("buyQty")Integer buyQty) {
		goodsBuyService.execute(nums, session, model, buyQty);
		return "thymeleaf/purchase/goodsOrder";
	}
	
	@PostMapping("goodsOrder")
	public String goodsOrder(PurchaseCommand purchaseCommand, HttpSession session, Model model) {
		String purchaseNum = goodsOrderService.execute(purchaseCommand, session);
		return "redirect:paymentOk?purchaseNum="+purchaseNum;
	}
	
	@GetMapping("paymentOk")
	public String paymentOk(String purchaseNum, Model model) {
		try {
			iniPayReqService.execute(purchaseNum, model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "thymeleaf/purchase/payment";
	}
	
	@Autowired
	PurchaseRepository purchaseRepository;
	@GetMapping("paymentDel")
	public String paymentDel(String purchaseNum) {
		purchaseRepository.paymentDel(purchaseNum);
		return "redirect:orderList";
	}
	
	@GetMapping("purchaseOk")
	public String purchaseOk(String purchaseNum) {
		purchaseRepository.paymentStatusUpdate(purchaseNum);
		return "redirect:orderList";
	}
}
