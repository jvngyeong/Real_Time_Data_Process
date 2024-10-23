package springBootMVCShopping.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class GoodsCommand {
	String goodsNum;
	int goodsPrice;
	String goodsContents;
	int visitCount;
	String goodsMainImage;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date goodsUpdateDate;
	String goodsDetailImage;
	String goodsDetailStoreImage;
	String empNum;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date goodsRegist;
	String updateEmpNum;
	String goodsName;
	String goodsMainStoreImage;
}	
