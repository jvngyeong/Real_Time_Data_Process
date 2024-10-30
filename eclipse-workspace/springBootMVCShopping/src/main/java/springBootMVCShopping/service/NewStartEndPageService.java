package springBootMVCShopping.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.StartEndPageDTO;

@Service
public class NewStartEndPageService {
	public StartEndPageDTO execute(int page, int limit, String searchWord) {
	    int startRow = ((page - 1) * limit) + 1;
	    int endRow = startRow + limit - 1;

		StartEndPageDTO sepDTO = new StartEndPageDTO(startRow, endRow, searchWord);
		return sepDTO;
	}
	
	public void execute(Model model, int page, int count, int limit) {
	      int limitPage = 10;
	      int startPageNum = (int)((double) page / limitPage + 0.95 - 1) * limitPage + 1;
	      int endPageNum = startPageNum + limitPage - 1;
	      int maxPage = (int)((double)count / limit + 0.95);
	      if(endPageNum > maxPage) endPageNum = maxPage;
	      if(endPageNum == 0) endPageNum = 1;
	      model.addAttribute("startPageNum", startPageNum);
	      model.addAttribute("endPageNum", endPageNum);
	      model.addAttribute("maxPage", maxPage);
	}
}
