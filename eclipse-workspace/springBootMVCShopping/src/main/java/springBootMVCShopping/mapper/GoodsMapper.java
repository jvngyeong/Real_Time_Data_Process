package springBootMVCShopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCShopping.domain.GoodsDTO;

@Mapper
public interface GoodsMapper {

	public void goodsInsert(GoodsDTO goodsDTO);

	public List<GoodsDTO> goodsSelectAll();

	public GoodsDTO goodsSelectOne(String goodsNum);

	public void goodsUpdate(GoodsDTO dto);

	public void goodsDelete(String goodsNum);

}
