package board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.model.BoardDAO;
import board.model.BoardDTO;
import jakarta.servlet.http.HttpServletRequest;
@Service
public class BoardWriteService {
	@Autowired
	BoardDAO boardDAO;

	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		BoardDTO dto = new BoardDTO();
		dto.setBoardWriter(request.getParameter("boardWriter"));
		dto.setBoardSubject(request.getParameter("boardSubject"));
		dto.setBoardContent(request.getParameter("boardContent"));
		boardDAO.boardInsert(dto);
	}
}
