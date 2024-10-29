package springBootMVCShopping.command;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class GoodsIpgoCommand {
     String ipgoNum;        // IPGO_NUM
     String goodsNum;       // GOODS_NUM
     LocalDateTime madeDate;    // MADE_DATE
     Integer ipgoPrice;  // IPGO_PRICE
     String empNum;         // EMP_NUM
     Integer ipgoQty;           // IPGO_QTY
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     Date ipgoDate;    // IPGO_DATE
}
