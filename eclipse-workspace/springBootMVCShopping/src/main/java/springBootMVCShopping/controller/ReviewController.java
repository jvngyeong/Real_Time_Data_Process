package springBootMVCShopping.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.ReviewDTO;
import springBootMVCShopping.repository.ReviewRepository;

@Controller
@RequestMapping("review")
public class ReviewController {
	@Autowired
	ReviewRepository reviewRepository;
	
	@RequestMapping(value = "goodsReview", method = RequestMethod.GET)
	public String goodsReview(String goodsNum, String purchaseNum, Model model) {
		ReviewDTO dto = new ReviewDTO();
		dto.setGoodsNum(goodsNum);
		dto.setPurchaseNum(purchaseNum);
		ReviewDTO reviewDTO = reviewRepository.reviewSelectOne(dto);
		String reviewContents = reviewDTO.getReviewContents();
		dto.setReviewContents(reviewContents);
		model.addAttribute("dto", dto);
		return "thymeleaf/review/goodsReview";
	}
	
	@RequestMapping("reviewWrite")
	public String reviewWrite(ReviewDTO dto, HttpSession session) {
		ReviewDTO reviewDTO = reviewRepository.reviewSelectOne(dto);
		String reviewContents = reviewDTO.getReviewContents();
		String reviewMemberId = reviewDTO.getMemberId();
		String goodsNum = reviewDTO.getGoodsNum();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String authMemberId = auth.getUserId();
		dto.setMemberId(authMemberId);
		if(reviewContents == null && reviewMemberId == null && goodsNum == null) {
			reviewRepository.reviewInsert(dto);
		}
		reviewRepository.reviewUpdate(dto);
		return "redirect:/purchase/orderList";
	}
	
	@PostMapping("reviewList")
    public ResponseEntity<Map<String, Object>> reviewList(@RequestBody Map<String, String> map) {
        String goodsNum = map.get("goodsNum");
        System.out.println(goodsNum + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        List<ReviewDTO> list = reviewRepository.goodsReviewList(goodsNum);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("reviews", list);
        return ResponseEntity.ok(response);
    }
}
