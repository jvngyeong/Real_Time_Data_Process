package springBootMVCShopping.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springBootMVCShopping.command.CartCommand;
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

	@RequestMapping("cart")
	public @ResponseBody String cart(CartCommand cartCommand, HttpSession session) {
		return cartMergeService.execute(cartCommand, session);
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
	@GetMapping("buyItem")
	   public String buyItem(CartCommand cartCommand, HttpSession session, HttpServletResponse response) {
	      String result = cartMergeService.execute(cartCommand, session);
	      response.setContentType("text/html; charset=utf-8");
	      PrintWriter out;
	       if(result == "900") {
	         String str = "<script>"
	               + "alert('관리자는 구매할 수 없습니다.')"
	               + "location.href='/corner/detailView/"+cartCommand.getGoodsNum()+"';"
	               + "</script>";
	         try {
	            out = response.getWriter();
	            out.print(str);
	            out.close();
	         } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	         return "";
	      }else {
	         return "redirect:/purchase/goodsBuy?nums="+cartCommand.getGoodsNum()+"&buyQty="+cartCommand.getCartQty();
	      }
	   }
}
