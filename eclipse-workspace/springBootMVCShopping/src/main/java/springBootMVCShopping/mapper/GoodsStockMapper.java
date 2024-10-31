package springBootMVCShopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.domain.GoodsStockDTO;


@Mapper
public interface GoodsStockMapper {
	
	public GoodsStockDTO goodsStockSelectOne(String goodsNum);

	public int goodsVisitCountUpdate(String goodsNum);

	public void wishMerge(String memberNum, String goodsNum);

	public String wishCheck(String goodsNum, String memberNum);

	public List<GoodsDTO> wishListSelect(String memberNum);

}
