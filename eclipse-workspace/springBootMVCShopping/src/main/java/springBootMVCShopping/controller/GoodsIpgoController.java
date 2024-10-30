package springBootMVCShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.GoodsIpgoCommand;
import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.domain.GoodsIpgoGoodsNameDTO;
import springBootMVCShopping.service.AutoNumService;
import springBootMVCShopping.service.goodsIpgo.GoodsIpgoDeleteService;
import springBootMVCShopping.service.goodsIpgo.GoodsIpgoDetailService;
import springBootMVCShopping.service.goodsIpgo.GoodsIpgoListService;
import springBootMVCShopping.service.goodsIpgo.GoodsIpgoService;
import springBootMVCShopping.service.goodsIpgo.GoodsIpgoUpdateService;
import springBootMVCShopping.service.goodsIpgo.GoodsListSearchService;

@Controller
@RequestMapping("goodsIpgo")
public class GoodsIpgoController {
	@Autowired
	AutoNumService autoNumService;

	@Autowired
	GoodsIpgoService goodsIpgoService;

	@Autowired
	GoodsIpgoListService goodsIpgoListService;

	@Autowired
	GoodsIpgoDetailService goodsIpgoDetailService;

	@Autowired
	GoodsIpgoUpdateService goodsIpgoUpdateService;

	@Autowired
	GoodsIpgoDeleteService goodsIpgoDeleteService;

	@Autowired
	GoodsListSearchService goodsListSearchService;

	@GetMapping("goodsIpgoList")
	public String goodsIpgoList(Model model) {
		goodsIpgoListService.execute(model);
		return "thymeleaf/goodsIpgo/goodsIpgoList";
	}

	@GetMapping("goodsIpgoForm")
	public String goodsIpgoForm(Model model) {
		String ipgoNum = autoNumService.execute("ipgo_", "ipgo_num", 6, "goods_ipgo");
		model.addAttribute("ipgoNum", ipgoNum);
		return "thymeleaf/goodsIpgo/goodsIpgoForm";
	}

	@PostMapping("goodsIpgoRegist")
	public @ResponseBody String goodsIpgoRegist(GoodsIpgoCommand command, HttpSession session) {
		goodsIpgoService.execute(command, session);
		// return "redirect:goodsIpgoList";
		return "200";
	}

	@GetMapping("goodsIpgoDetail")
	public String goodsIpgoDetail(@ModelAttribute(value = "ipgoNum") String ipgoNum,
			@ModelAttribute(value = "goodsNum") String goodsNum) {
		return "thymeleaf/goodsIpgo/goodsIpgoDetail";
	}

	@PostMapping("goodsIpgoDetail")
	public @ResponseBody GoodsIpgoGoodsNameDTO goodsIpgoDetail(String ipgoNum, String goodsNum, Model model) {
		GoodsIpgoGoodsNameDTO dto = goodsIpgoDetailService.execute(ipgoNum, goodsNum, model);
		return dto;
	}

	@GetMapping("goodsIpgoUpdate")
	public String goodsIpgoUpdate(String ipgoNum, String goodsNum, Model model) {
		goodsIpgoDetailService.execute(ipgoNum, goodsNum, model);
		return "thymeleaf/goodsIpgo/goodsIpgoUpdate";
	}

	@PostMapping("goodsIpgoModify")
	public String goodsIpgoModify(GoodsIpgoCommand command) {
		goodsIpgoUpdateService.execute(command);
		return "redirect:goodsIpgoDetail?ipgoNum=" + command.getIpgoNum() + "&goodsNum=" + command.getGoodsNum();
	}

	@GetMapping("goodsIpgoDelete")
	public String goodsIpgoDelete(String num) {
		goodsIpgoDeleteService.execute(num);
		return "redirect:goodsIpgoList";
	}

	@GetMapping("goodsItem")
	public String goodsItem() {
		return "thymeleaf/goodsIpgo/goodsItem";
	}

	@PostMapping("goodsList")
	public ModelAndView goodsList(Model model, int page, String searchWord) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");
		goodsListSearchService.execute(model, page, searchWord);
		return mav;
	}
}
