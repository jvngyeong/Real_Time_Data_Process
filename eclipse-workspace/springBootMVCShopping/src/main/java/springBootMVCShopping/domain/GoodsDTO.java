package springBootMVCShopping.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Alias("goodsDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class GoodsDTO {
	String goodsNum;
	Integer goodsPrice;
	String goodsContents;
	Integer visitCount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date goodsUpdateDate;
	String empNum;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date goodsRegist;
	String updateEmpNum;
	String goodsName;
	
	//DB에 파일명을 저장하기 위해
	String goodsMainImage;
	String goodsMainStoreImage;
	String goodsDetailImage;
	String goodsDetailStoreImage;
}
