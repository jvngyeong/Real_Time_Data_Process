package springBootMVCShopping.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.domain.StartEndPageDTO;
import springBootMVCShopping.mapper.GoodsMapper;
import springBootMVCShopping.service.StartEndPageService;

@Service
public class GoodsListService {
	@Autowired
	GoodsMapper goodsMapper;
	
	@Autowired
	StartEndPageService startEndPageService;
	
	public void execute(Model model, int page, String searchWord) {
		StartEndPageDTO sepDTO = startEndPageService.execute(page, 3, searchWord);
		List<GoodsDTO> list = goodsMapper.goodsSelectAll(sepDTO);
		int count = goodsMapper.goodsCount(searchWord);
		startEndPageService.execute(page, 3, count, searchWord, list, model);
		model.addAttribute("list", list);
	}

}
