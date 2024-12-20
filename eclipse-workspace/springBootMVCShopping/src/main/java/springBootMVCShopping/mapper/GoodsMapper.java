package springBootMVCShopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.domain.StartEndPageDTO;

@Mapper
public interface GoodsMapper {

	public void goodsInsert(GoodsDTO goodsDTO);

	public List<GoodsDTO> goodsSelectAll(StartEndPageDTO sepDTO);

	public GoodsDTO goodsSelectOne(String goodsNum);

	public int goodsUpdate(GoodsDTO dto);

	public void goodsDelete(@Param("goodsNums") String[] goodsNums);

	public int goodsCount(String searchWord);

	public List<GoodsDTO> goodsSelectList(String[] goodsNums);

	public List<GoodsDTO> goodsSelectList2(int startRow, int endRow);

	public List<GoodsDTO> goodsSelectAll2(StartEndPageDTO sepDTO);

}
