package spring_boot_board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_boot_board.command.BoardCommand;
import spring_boot_board.mapper.BoardMapper;

@Service
public class BoardDeleteService {
	@Autowired
	BoardMapper boardMapper;
	public void execute(BoardCommand boardCommand) {
		String boardNum = boardCommand.getBoardNum();
		boardMapper.boardDelete(boardNum);
	}
}
