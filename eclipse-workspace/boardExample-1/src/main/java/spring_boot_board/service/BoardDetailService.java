package spring_boot_board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring_boot_board.domain.BoardDTO;
import spring_boot_board.mapper.BoardMapper;

@Service
public class BoardDetailService {
	@Autowired
	BoardMapper boardMapper;
	public void execute(String boardNum, Model model) {
		BoardDTO dto = boardMapper.boardSelectOne(boardNum);
		model.addAttribute("dto", dto);
	}
}
