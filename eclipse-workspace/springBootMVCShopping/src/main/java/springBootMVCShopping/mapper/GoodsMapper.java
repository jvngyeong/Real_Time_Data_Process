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

	public void goodsUpdate(GoodsDTO dto);

	public void goodsDelete(@Param("goodsNums") String[] goodsNums);

	public int goodsCount();

	public List<GoodsDTO> goodsSelectList(String[] goodsNums);

}
