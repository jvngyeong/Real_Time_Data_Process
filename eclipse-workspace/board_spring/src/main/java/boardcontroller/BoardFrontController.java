package boardcontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import boardService.BoardDeleteService;
import boardService.BoardDetailService;
import boardService.BoardUpdateService;
import boardService.BoardWriteService;

@Controller
public class BoardFrontController{
	@RequestMapping("boardList.com")
	public String boardList(HttpServletRequest req) {
		BoardDeleteService action = new BoardDeleteService();
		action.execute(req);
		return "boardList";
	}
	
	@RequestMapping("boardWrite.com")
	public String boardWrite() {
		return "boardForm";
	}
	
	@RequestMapping("boardDetail.com")
	public String boardDetail(HttpServletRequest req) {
		BoardDetailService action = new BoardDetailService();
		action.execute(req);
		return "boardDetail";
	}
	
	@GetMapping("boardModify.com")
	public String boardModify(HttpServletRequest req) {
		BoardDetailService action = new BoardDetailService();
		action.execute(req);
		return "boardUpdate";
	}
	
	@RequestMapping("boardDelete.com")
	public String boardDelete(HttpServletRequest req) {
		BoardDeleteService action = new BoardDeleteService();
		action.execute(req);
		return "redirect:boardList.com";
	}
	
	@PostMapping("boardWrite.com")
	public String boardWrite(HttpServletRequest req) {
		BoardWriteService action = new BoardWriteService();
		action.execute(req);
		return "redirect:boardList.com";
	}
	
	@PostMapping("boardModify.com")
	public String postBoardModify(HttpServletRequest req) {
		BoardUpdateService action = new BoardUpdateService();
		action.execute(req);
		return "redirect:boardDetail.com?boardNum="+req.getParameter("boardNum");
	}
}
