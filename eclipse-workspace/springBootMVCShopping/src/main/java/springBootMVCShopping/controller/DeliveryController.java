package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.repository.DeliveryRepository;
import springBootMVCShopping.service.delivery.DeliveryInsertService;
import springBootMVCShopping.service.purchase.PurchaseListService;

@Controller
@RequestMapping("delivery")
public class DeliveryController {
	@Autowired
	PurchaseListService purchaseListService;
	
	@Autowired
	DeliveryInsertService deliveryInsertService;
	
	@Autowired
	DeliveryRepository deliveryRepository;
	
	@GetMapping("deliveryRegist")
	public String deliveryRegist(String purchaseNum, Model model, HttpSession session) {
		purchaseListService.execute(model, session, purchaseNum);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/delivery/deliveryRegist";
	}
	
	@PostMapping("deliveryRegist")
	public String deliveryRegist(String purchaseNum, String deliveryNum) {
		deliveryInsertService.execute(purchaseNum, deliveryNum);
		return "redirect:deliveryRegist?purchaseNum="+purchaseNum;
	}
	
	@GetMapping("deliveryStatus")
	public String deliveryStatus(String purchaseNum) {
		deliveryRepository.deliveryStatusUpdate(purchaseNum);
		return "redirect:/purchase/purchaseList";
	}
}
