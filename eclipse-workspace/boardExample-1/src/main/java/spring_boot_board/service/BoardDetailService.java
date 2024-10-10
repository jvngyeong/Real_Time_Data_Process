package spring_boot_board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring_boot_board.command.BoardCommand;
import spring_boot_board.domain.BoardDTO;
import spring_boot_board.mapper.BoardMapper;

@Service
public class BoardDetailService {
	@Autowired
	BoardMapper boardMapper;
	public void execute(BoardCommand boardCommand, Model model) {
		String boardNum = boardCommand.getBoardNum();
		System.out.println(boardNum + "boardNUMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMm");
		BoardDTO dto = boardMapper.boardSelectOne(boardNum);
		model.addAttribute("dto", dto);
	}
}
