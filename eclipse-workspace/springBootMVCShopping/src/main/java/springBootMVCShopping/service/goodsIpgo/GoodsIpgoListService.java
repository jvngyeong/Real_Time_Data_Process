package springBootMVCShopping.service.goodsIpgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.mapper.GoodsIpgoMapper;

@Service
public class GoodsIpgoListService {
	@Autowired
	GoodsIpgoMapper goodsIpgoMapper;
	public void execute(Model model) {
		List<GoodsIpgoMapper> list = goodsIpgoMapper.goodsIpgoSelectList();
		model.addAttribute("list", list);
	}
}
