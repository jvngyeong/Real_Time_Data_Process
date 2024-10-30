package springBootMVCShopping.service.goodsIpgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.domain.StartEndPageDTO;
import springBootMVCShopping.mapper.GoodsMapper;
import springBootMVCShopping.service.NewStartEndPageService;

@Service
public class GoodsListSearchService {
	@Autowired
	GoodsMapper goodsMapper;
	
	@Autowired
	NewStartEndPageService newStartEndPageService;
	public List<GoodsDTO> execute(Model model, int page, String searchWord) {
		int limit = 3;
		StartEndPageDTO sepDTO = newStartEndPageService.execute(page, limit, searchWord);
		List<GoodsDTO> list = goodsMapper.goodsSelectAll2(sepDTO);
		int count = goodsMapper.goodsCount(searchWord);
		newStartEndPageService.execute(model, page, count, limit);
		model.addAttribute("list", list);
		return list;
	}
}
