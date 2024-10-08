package spring_boot_board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring_boot_board.domain.BoardDTO;
import spring_boot_board.mapper.BoardMapper;

@Service
public class BoardListService {
	@Autowired
	BoardMapper boardMapper;
	public void execute(Model model) {
		List<BoardDTO> list = boardMapper.boardSelectAll();
		model.addAttribute("list", list);
	}
}
