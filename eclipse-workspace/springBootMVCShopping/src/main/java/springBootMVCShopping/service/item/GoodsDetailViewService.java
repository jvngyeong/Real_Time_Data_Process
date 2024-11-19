package springBootMVCShopping.service.item;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.databind.ObjectMapper;

import springBootMVCShopping.domain.GoodsStockDTO;
import springBootMVCShopping.mapper.GoodsStockMapper;

@Service
public class GoodsDetailViewService {
	@Autowired
	GoodsStockMapper goodsStockMapper;
	public void execute(String goodsNum, Model model, HttpServletResponse response, boolean isFirstVisit) {
		GoodsStockDTO dto = goodsStockMapper.goodsStockSelectOne(goodsNum);
		if(isFirstVisit) {
			int i = goodsStockMapper.goodsVisitCountUpdate(goodsNum);
		}
		
		model.addAttribute("dto", dto);
		ObjectMapper mapper = new ObjectMapper();
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().print(mapper.writeValueAsString(dto));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
