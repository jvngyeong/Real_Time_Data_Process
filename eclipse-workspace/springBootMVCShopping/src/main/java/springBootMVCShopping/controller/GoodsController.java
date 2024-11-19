package springBootMVCShopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBootMVCShopping.command.GoodsCommand;
import springBootMVCShopping.service.AutoNumService;
import springBootMVCShopping.service.StartEndPageService;
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
	
	@Autowired
	StartEndPageService startEndPageService;
	
	@RequestMapping("goodsList")
	public String goodsList(Model model, @RequestParam(value="page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "searchWord", required = false, defaultValue = "") String searchWord) {
		goodsListService.execute(model, page, searchWord);
		return "thymeleaf/goods/goodsList";
	}
	
	@GetMapping("goodsForm")
	public String goodsForm() {
		return "thymeleaf/goods/goodsForm";
	}

	@RequestMapping("goodsWrite")
	public String goodsWrite(Model model) {
		String autoNum = autoNumService.execute("goods_", "goods_num", 7, "goods");
		model.addAttribute("autoNum", autoNum);
		GoodsCommand goodsCommand = new GoodsCommand();
		model.addAttribute("goodsCommand", goodsCommand);
		return "thymeleaf/goods/goodsWrite";
	}
	
	@RequestMapping("goodsRegist")
	public String goodsRegist(@Validated GoodsCommand goodsCommand, BindingResult result, 
			HttpSession session) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsWrite";
		}
		goodsWriteService.execute(goodsCommand, session);
		return "thymeleaf/goods/goodsRedirect";
	}
	
	@GetMapping("goodsInfo")
	public String goodsInfo(String goodsNum, Model model) {
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsInfo";
	}
	
	@GetMapping("goodsUpdate")
	public String goodsUpdate(String goodsNum, Model model, HttpSession session) {
		session.removeAttribute("fileList");
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsModify";
	}
	
	@PostMapping("goodsModify")
	public String goodsModify(GoodsCommand goodsCommand, HttpSession session) {
		goodsUpdateService.execute(goodsCommand, session);
		return "redirect:goodsInfo?goodsNum="+goodsCommand.getGoodsNum();
	}
	
	@GetMapping("goodsDelete")
	public String goodDelete(String[] goodsNum) {
		goodsDeleteService.execute(goodsNum);
		return "redirect:goodsList";
	}
	
	@PostMapping("goodsDelete")
	public String goodsDelete(@RequestParam("nums") String[] goodsNums) {
		goodsDeleteService.execute(goodsNums);
		return "redirect:goodsList";
	}
}
