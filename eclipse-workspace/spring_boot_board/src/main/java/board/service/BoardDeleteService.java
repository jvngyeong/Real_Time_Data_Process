package board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.model.BoardDAO;
import jakarta.servlet.http.HttpServletRequest;
@Service
public class BoardDeleteService {
	@Autowired
	BoardDAO boardDAO;

	public void execute(HttpServletRequest request) {
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		boardDAO.boardDelete(boardNum);
	}
}
