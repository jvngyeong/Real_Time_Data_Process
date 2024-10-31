package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.service.item.WishCheckService;
import springBootMVCShopping.service.item.WishMergeService;

@RestController
@RequestMapping("item")
public class ItemRestController {
	@Autowired
	WishMergeService wishMergeService;
	
	@Autowired
	WishCheckService wishCheckService;
	
	@PostMapping("wish")
	public @ResponseBody String wish(String goodsNum, HttpSession session) {
		wishMergeService.execute(goodsNum, session);
		return "200";
	}
	
	@PostMapping("wishCheck")
	public @ResponseBody String wishCheck(String goodsNum, HttpSession session) {
		String i = wishCheckService.execute(goodsNum, session);
		return i;
	}
}
