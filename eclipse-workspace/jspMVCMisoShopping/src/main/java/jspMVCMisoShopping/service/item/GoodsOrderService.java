package jspMVCMisoShopping.service.item;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.ItemDAO;
import jspMVCMisoShopping.model.dto.PurchaseDTO;
import jspMVCMisoShopping.service.MemberAuthService;

public class GoodsOrderService extends MemberAuthService{

	public GoodsOrderService(HttpServletRequest req) {
		super(req);
	}

	public String execute(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String purchaseName = req.getParameter("purchaseName");
		String totalPaymentPrice = req.getParameter("totalPaymentPrice");
		String deliveryName = req.getParameter("deliveryName");
		String deliveryAddr = req.getParameter("deliveryAddr");
		String deliveryAddrDetail = req.getParameter("deliveryAddrDetail");
		String deliveryPost = req.getParameter("deliveryPost");
		String deliveryPhone = req.getParameter("deliveryPhone");
		String message = req.getParameter("message");
		//날짜를 이용해서 구매 번호를 생성
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String purchaseNum = sdf.format(new Date());

		PurchaseDTO dto = new PurchaseDTO();
		dto.setPurchaseName(purchaseName);
		dto.setDeliveryName(deliveryName);
		dto.setDeliveryAddr(deliveryAddr);
		dto.setDeliveryAddrDetail(deliveryAddrDetail);
		dto.setDeliveryPost(deliveryPost);
		dto.setDeliveryPhone(deliveryPhone);
		dto.setMessage(message);
		dto.setPurchasePrice(Long.parseLong(totalPaymentPrice));
		dto.setMemberNum(memberNum);
		dto.setPurchaseNum(purchaseNum);
		ItemDAO dao = new ItemDAO();
		dao.purchaseInsert(dto);
		String[] goodsNums = req.getParameter("goodsNums").split("-");
		for(String goodsNum : goodsNums) {
			dao.purchaseListInsert(purchaseNum, goodsNum, memberNum);
			dao.itemDelete(goodsNum, memberNum);
		}
		return purchaseNum;
	}
}
