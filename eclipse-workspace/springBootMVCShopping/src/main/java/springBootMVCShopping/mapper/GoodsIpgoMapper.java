package springBootMVCShopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import springBootMVCShopping.domain.GoodsIpgoDTO;
import springBootMVCShopping.domain.GoodsIpgoGoodsNameDTO;

@Mapper
public interface GoodsIpgoMapper {

	public void goodsIpgoInsert(GoodsIpgoDTO dto);

	public List<GoodsIpgoMapper> goodsIpgoSelectList();

	public GoodsIpgoGoodsNameDTO ipgoGoodsSelectOne(
			@Param(value = "ipgoNum")String ipgoNum, 
			@Param(value = "goodsNum")String goodsNum);

	public void goodsIpgoUpdate(GoodsIpgoDTO dto);

	public void ipgoGoodsNumDelete(String num);

}
