package springBootMVCShopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCShopping.domain.CartDTO;
import springBootMVCShopping.domain.GoodsCartDTO;

@Mapper
public interface CartMapper {
	public void cartMerge(CartDTO dto);

	public List<GoodsCartDTO> cartListSelect(String memberNum);

	public void checkQty(String goodsNum, String memberNum);

	public void goodsCartAdd(String goodsNum, String memberNum);
}
