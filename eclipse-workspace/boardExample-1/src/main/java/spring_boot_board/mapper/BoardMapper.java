package spring_boot_board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import spring_boot_board.domain.BoardDTO;

@Mapper
public interface BoardMapper {

	public void boardInsert(BoardDTO dto);

	public List<BoardDTO> boardSelectAll();

	public BoardDTO boardSelectOne(String boardNum);

	public void boardUpdate(BoardDTO dto);
	
	public void boardDelete(String boardNum);
	
}
