package springBootMVCShopping.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.mapper.GoodsMapper;

@Service
public class MainGoodsListService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(Model model, Integer page) {
		int limit = 6; //
		int startRow = ((page - 1) * limit) + 1;
		int endRow = startRow + limit - 1;
		List<GoodsDTO> list = goodsMapper.goodsSelectList2(startRow, endRow);
		int count = goodsMapper.goodsCount("");
		int maxPage = (int)((double)count/limit + 0.95);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("list", list);
	}
}
