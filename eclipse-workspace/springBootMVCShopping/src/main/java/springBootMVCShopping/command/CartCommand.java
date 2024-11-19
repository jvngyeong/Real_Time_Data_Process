package springBootMVCShopping.command;

import java.util.Date;

import lombok.Data;

@Data
public class CartCommand {
	String memberNum;
	String goodsNum;
	Date cartDate;
	Integer cartQty;
	Integer cartNum;
}
