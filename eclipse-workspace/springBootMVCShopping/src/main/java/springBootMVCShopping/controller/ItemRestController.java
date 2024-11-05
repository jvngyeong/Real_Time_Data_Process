package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.service.item.CheckQtyService;
import springBootMVCShopping.service.item.GoodsCartAddService;
import springBootMVCShopping.service.item.GoodsCartDelsService;
import springBootMVCShopping.service.item.WishCheckService;
import springBootMVCShopping.service.item.WishMergeService;

@RestController
@RequestMapping("item")
public class ItemRestController {
	@Autowired
	WishMergeService wishMergeService;
	
	@Autowired
	WishCheckService wishCheckService;
	
	@Autowired
	CheckQtyService checkQtyService;
	
	@Autowired
	GoodsCartAddService goodsCartAddService;
	
	@Autowired
	GoodsCartDelsService goodsCartDelsService;
	
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
	
	@PostMapping("checkQty")
	public String checkQty(@RequestBody String goodsNum, HttpSession session) {
		System.out.println(goodsNum + "askdjdkjbWEKJV;wekvjn;WEJVNw;ekvjb");
		return checkQtyService.execute(goodsNum, session);
	}
	
	@PostMapping("goodsCartAdd")
	public String goodsCartAdd(String goodsNum, HttpSession session) {
		return goodsCartAddService.execute(goodsNum, session);
	}
	
	@PostMapping("cartDels")
	public String cartDels(@RequestBody String[] goodsNums, HttpSession session) {
		return goodsCartDelsService.execute(goodsNums, session);
	}
}
