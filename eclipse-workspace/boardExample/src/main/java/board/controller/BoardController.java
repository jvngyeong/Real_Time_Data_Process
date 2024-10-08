package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import board.command.BoardCommand;
import board.service.BoardDeleteService;
import board.service.BoardDetailService;
import board.service.BoardListService;
import board.service.BoardUpdateService;
import board.service.BoardWriteService;


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
	@RequestMapping("boardList")
	public String boardList(BoardCommand boardCommand, Model model) {
		boardListService.execute(boardCommand, model);
		return "boardList";
	}
	
	@GetMapping("boardWrite")
	public String boardWrite() {
		return "boardForm";
	}
	
	@PostMapping("boardWrite")
	public String boardWrite(BoardCommand boardCommand) {
		boardWriteService.execute(boardCommand);
		return "redirect:boardList";
	}
	//@GetMapping(value = "boardDetail")
	//@GetMapping("boardDetail")
	@RequestMapping(value = "boardDetail", method = RequestMethod.GET)
	public String boardDetail(@RequestParam("boardNum") String boardNum, Model model) {
		//String boardNum = req.getParameter("boardNum");
		boardDetailService.execute(boardNum, model);
		return "boardDetail";
	}
	
	@GetMapping("boardModify")
	public String boardModify(@RequestParam("boardNum") String boardNum, Model model) {
		boardDetailService.execute(boardNum, model);
		return "boardUpdate";
	}
	
	@RequestMapping(value = "boardModify", method = RequestMethod.POST)
	public String boardUpdate(BoardCommand boardCommand) {
		boardUpdateService.execute(boardCommand);
		return "redirect:boardDetail?boardNum="+boardCommand.getBoardNum();
	}
	
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam("boardNum") Integer boardNum) {
		boardDeleteService.execute(boardNum);
		return "redirect:boardList";
	}
	
}
