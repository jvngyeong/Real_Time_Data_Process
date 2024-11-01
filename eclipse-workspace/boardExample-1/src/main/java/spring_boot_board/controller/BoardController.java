package spring_boot_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import spring_boot_board.command.BoardCommand;
import spring_boot_board.service.BoardDeleteService;
import spring_boot_board.service.BoardDetailService;
import spring_boot_board.service.BoardListService;
import spring_boot_board.service.BoardUpdateService;
import spring_boot_board.service.BoardWriteService;

@Controller
public class BoardController {
	@Autowired
	BoardWriteService boardWriteService;

	@Autowired
	BoardListService boardListService;

	@Autowired
	BoardDetailService boardDetailService;

	@Autowired
	BoardUpdateService boardUpdateService;

	@Autowired
	BoardDeleteService boardDeleteService;

	@GetMapping("boardList")
	public String boardList(Model model) {
		boardListService.execute(model);
		return "thymeleaf/board/boardList";
	}

	@GetMapping("boardWrite")
	public String boardWrite() {
		return "thymeleaf/board/boardWrite";
	}

	@PostMapping("boardWrite")
	public String boardWrite(BoardCommand boardCommand) {
		boardWriteService.execute(boardCommand);
		return "redirect:boardList";
	}

	@GetMapping("boardDetail")
	public String boardDetail(BoardCommand boardCommand, Model model) {
		boardDetailService.execute(boardCommand, model);
		return "thymeleaf/board/boardDetail";
	}

	@GetMapping("boardModify")
	public String boardModify(BoardCommand boardCommand, Model model) {
		boardDetailService.execute(boardCommand, model);
		return "thymeleaf/board/boardModify";
	}

	@PostMapping("boardUpdate")
	public String boardUpdate(BoardCommand boardCommand) {
		boardUpdateService.execute(boardCommand);
		return "redirect:boardDetail?boardNum=" + boardCommand.getBoardNum();
	}

	@GetMapping("boardDelete")
	public String boardDelete(BoardCommand boardCommand) {
		boardDeleteService.execute(boardCommand);
		return "redirect:boardList";
	}
}
