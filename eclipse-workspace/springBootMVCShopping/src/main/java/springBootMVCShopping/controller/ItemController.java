package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.service.item.CartListService;
import springBootMVCShopping.service.item.CartMergeService;
import springBootMVCShopping.service.item.GoodsCartDelsService;
import springBootMVCShopping.service.item.GoodsDetailViewService;
import springBootMVCShopping.service.item.WishListService;

@Controller
@RequestMapping("item")
public class ItemController {
	@Autowired
	GoodsDetailViewService goodsDetailViewService;
	
	@Autowired
	CartMergeService cartMergeService;
	
	@Autowired
	CartListService cartListService;
	
	@Autowired
	WishListService wishListService;
	
	@Autowired
	GoodsCartDelsService goodsCartDelsService;
	
	@GetMapping("detailView/{goodsNum}")
	public String goodsInfo(@PathVariable("goodsNum") String goodsNum, Model model) {
		goodsDetailViewService.execute(goodsNum, model);
		return "thymeleaf/item/detailView";
	}
	
	@RequestMapping("cart")
	public @ResponseBody String cart(String goodsNum, Integer cartQty, HttpSession session) {
		cartMergeService.execute(goodsNum, cartQty, session);
		return "200";
	}
	
	@GetMapping("cartList")
	public String cartList(Model model, HttpSession session) {
		cartListService.execute(model, session);
		return "thymeleaf/item/cartList";
	}
	
	@GetMapping("wishList")
	public String wishList(Model model, HttpSession session) {
		wishListService.execute(model, session);
		return "thymeleaf/item/wishList";
	}
	@GetMapping("cartDel")
	public String cartDel(String[] goodsNum, HttpSession session) {
		goodsCartDelsService.execute(goodsNum, session);
		return "redirect:cartList";
	}
}
