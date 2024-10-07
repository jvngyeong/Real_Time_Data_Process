package board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import board.service.BoardDeleteService;
import board.service.BoardDetailService;
import board.service.BoardListService;
import board.service.BoardUpdateService;
import board.service.BoardWriteService;

@Controller
public class BoardFrontController {
	@Autowired
	BoardListService boardListService;
	@Autowired
	BoardDetailService boardDetailService;
	@Autowired
	BoardDeleteService boardDeleteService;
	@Autowired
	BoardWriteService boardWriteService;
	@Autowired
	BoardUpdateService boardUpdateService;

	@GetMapping("boardList.miso")
	public String boardList(HttpServletRequest req) {
		boardListService.execute(req);
		return "boardList";
		// JSP에서 Dispatcher를 사용해서 한 주소 이동을 return으로 대신함!!
	}

	@GetMapping("boardWrite.miso")
	public String boardWrite() {
		return "boardForm";
	}

	// Get과 Post 방식을 둘 다 사용 가능한 RequestMapping!!
	@RequestMapping("boardDetail.miso")
	public String boardDetail(HttpServletRequest req) {
		boardDetailService.execute(req);
		return "boardDetail";
	}

	@GetMapping("boardModify.miso")
	public String boardModify(HttpServletRequest req) {
		boardDetailService.execute(req);
		return "boardUpdate";
	}

	@GetMapping("boardDelete.miso")
	public String boardDelete(HttpServletRequest req) {
		boardDeleteService.execute(req);
		return "redirect:boardList.miso";
	}

	@PostMapping("boardWrite.miso")
	public String boardWrite(HttpServletRequest req) {
		boardWriteService.execute(req);
		return "redirect:boardList.miso";
	}

	@PostMapping("boardModify.miso")
	public String boardModify2(HttpServletRequest req) {
		boardUpdateService.execute(req);
		return "redirect:boardDetail.miso?boardNum=" + req.getParameter("boardNum");
	}
}
