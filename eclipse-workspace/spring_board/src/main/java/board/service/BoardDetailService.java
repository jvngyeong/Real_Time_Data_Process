package board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import board.model.BoardDAO;
import board.model.BoardDTO;

public class BoardDetailService {
	@Autowired
	BoardDAO boardDAO;
	public void execute(HttpServletRequest request) {
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		BoardDTO dto = boardDAO.BoardSelectOne(boardNum);
		request.setAttribute("dto", dto);
	}
	
}
