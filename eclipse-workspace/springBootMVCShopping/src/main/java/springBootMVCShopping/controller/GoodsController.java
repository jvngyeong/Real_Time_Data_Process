package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.GoodsCommand;
import springBootMVCShopping.service.AutoNumService;
import springBootMVCShopping.service.goods.GoodsDeleteService;
import springBootMVCShopping.service.goods.GoodsDetailService;
import springBootMVCShopping.service.goods.GoodsListService;
import springBootMVCShopping.service.goods.GoodsUpdateService;
import springBootMVCShopping.service.goods.GoodsWriteService;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	AutoNumService autoNumService;
	
	@Autowired
	GoodsWriteService goodsWriteService;
	
	@Autowired
	GoodsListService goodsListService;
	
	@Autowired
	GoodsDetailService goodsDetailService;
	
	@Autowired
	GoodsUpdateService goodsUpdateService;
	
	@Autowired
	GoodsDeleteService goodsDeleteService;
	@GetMapping("goodsList")
	public String goodsList(Model model) {
		goodsListService.execute(model);
		return "thymeleaf/goods/goodsList";
	}
	
	@GetMapping("goodsWrite")
	public String goodsWrite(Model model) {
		String autoNum = autoNumService.execute("goods_", "goods_num", 7, "goods");
		model.addAttribute("autoNum", autoNum);
		return "thymeleaf/goods/goodsWrite";
	}
	
	@PostMapping("goodsRegist")
	public String goodsRegist(GoodsCommand goodsCommand, HttpSession session) {
		goodsWriteService.execute(goodsCommand, session);
		return "redirect:goodsList";
	}
	
	@GetMapping("goodsInfo")
	public String goodsInfo(String goodsNum, Model model) {
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsInfo";
	}
	
	@GetMapping("goodsUpdate")
	public String goodsUpdate(String goodsNum, Model model) {
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsModify";
	}
	
	@PostMapping("goodsModify")
	public String goodsModify(GoodsCommand goodsCommand, HttpSession session) {
		goodsUpdateService.execute(goodsCommand, session);
		return "redirect:goodsList";
	}
	
	@GetMapping("goodsDelete")
	public String goodsDelete(String goodsNum) {
		goodsDeleteService.execute(goodsNum);
		return "redirect:goodsList";
	}
}
