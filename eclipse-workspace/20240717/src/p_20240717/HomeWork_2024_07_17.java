package p_20240717;

import java.util.Scanner;

public class HomeWork_2024_07_17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		1. 5명의 고객을 저장해야 한다. 고객정보는 회원번호:memberNum, 회원이름: memberName, 회원주소:memberAddr, 회원연락처:memberPhone, 회원생년월일:memberBirth , 회원성별:memberGender이다,
//		   객체를 생성한 후 5명의 회원 정보를 임의로 입력하시오.
		
		HomeWork_No1[] no1 = new HomeWork_No1[5];
		for(int i = 0; i<= 4; i++) {
			System.out.print("회원 번호를 입력하세요. = ");
			int memberNum = sc.nextInt();sc.nextLine();
			System.out.print("회원 이름을 입력하세요. = ");
			String memberName = sc.nextLine();
			System.out.print("회원 주소를 입력하세요. = ");
			String memberAddr = sc.nextLine();
			System.out.print("회원 연락처를 입력하세요. = ");
			String memberPhone = sc.nextLine();
			System.out.print("회원 생년원일을 입력하세요. = ");
			String memberBirth = sc.nextLine();
			System.out.print("회원 성별을 입력하세요. = ");
			String memberGender = sc.nextLine();
			no1[i] = new HomeWork_No1(memberNum, memberName, memberAddr, memberPhone, memberBirth, memberGender);
		}
		for(HomeWork_No1 obj : no1) {
			obj.print();
		}
		
//		2. 5개의 상품 정보를 입력해야 한다. 상품정보는 상품번호:goodsNum, 상품명:goodsName, 상품가격:goodsPrice, 상품상세정보: goodsContent이다.
//		  객체를 생성한 후 5개의 상품정보를 입의로 입력하시오.
		
		HomeWork_No2[] no2 = new HomeWork_No2[5];
		for(int i = 0; i<= 4; i++) {
			System.out.print("상품 번호를 입력하세요. = ");
			int goodsNum = sc.nextInt();sc.nextLine();
			System.out.print("상품 이름을 입력하세요. = ");
			String goodsName = sc.nextLine();
			System.out.print("상품 가격을 입력하세요. = ");
			int goodsPrice = sc.nextInt();sc.nextLine();
			System.out.print("상품 정보를 입력하세요. = ");
			String goodsContent = sc.nextLine();
			no2[i] = new HomeWork_No2(goodsNum, goodsName, goodsPrice, goodsContent);
		}
		for(HomeWork_No2 obj : no2) {
			obj.print();
		}
		
//		3. 투표를 진행하기 위해 후보자들의 정보를 입력하여야한다. 후보자 정보는 후보자번호:candidateNum, 후보자 이름:candidateName,  투표수: vote
//		   후보자3명과 투표수를 임의로 입력하세요.
		
		HomeWork_No3[] no3 = new HomeWork_No3[3];
		for(int i = 0; i<= 2; i++) {
			System.out.print("후보자 번호를 입력하세요. = ");
			int candidateNum = sc.nextInt();sc.nextLine();
			System.out.print("후보자 이름을 입력하세요. = ");
			String candidateName = sc.nextLine();
			System.out.print("투표 수를 입력하세요. = ");
			int vote = sc.nextInt();
			no3[i] = new HomeWork_No3(candidateNum, candidateName, vote);
		}
		for(HomeWork_No3 obj : no3) {
			obj.print();
		}

//		// setter/getter , 생성자
//		// 객체생성시 생성자를 이용하고 생성한 후 setter를 이용해서 멤버값을 변경하고 getter를 이용해서 맴버값을 출력
//		4. 결제정보를 저장하고 싶다. 결제정보는 승인번호:purchaseNum, 카드번호:cardnum, 결제금액:totalPrice
//		                                    결제일 : appldate , 결제시간:appltime
		
		HomeWork_No4 no4 = new HomeWork_No4(0, "0000-0000-0000-0000", 0000, "0000-00-00", "00:00");
		System.out.println(no4.getPurchaseNum());
		System.out.println(no4.getCardNum());
		System.out.println(no4.getTotalPrice());
		System.out.println(no4.getApplDate());
		System.out.println(no4.getApplTime());
		
		no4.setPurchaseNum(1);
		no4.setCardNum("1234-1234-1234-1234");
		no4.setTotalPrice(10000);
		no4.setApplDate("2024-07-17");
		no4.setApplTime("16:47");
		
		System.out.println(no4.getPurchaseNum());
		System.out.println(no4.getCardNum());
		System.out.println(no4.getTotalPrice());
		System.out.println(no4.getApplDate());
		System.out.println(no4.getApplTime());
		
//		5. 리뷰정보를 저장하고 싶다. 리뷰정보는 리뷰번호:reviewNum, 별점:score, 리뷰등록:reviewDate
//		                                     리뷰내용:reviewContent
		
		HomeWork_No5 no5 = new HomeWork_No5(0, 0.0, "0000-00-00", "0이에요");
		System.out.println(no5.getReviewNum());
		System.out.println(no5.getScore());
		System.out.println(no5.getReviewDate());
		System.out.println(no5.getReviewContent());
		
		no5.setReviewNum(1);
		no5.setScore(5.0);
		no5.setReviewDate("2024-07-17");
		no5.setReviewContent("너무 좋아요");
		
		System.out.println(no5.getReviewNum());
		System.out.println(no5.getScore());
		System.out.println(no5.getReviewDate());
		System.out.println(no5.getReviewContent());
		
//		6. 상담정보를 저장싶다. 상담정보는 상담 번호:inquireNum, 상담종류 : inquireKind,
//		                                 상담 제목:inquireSubject, 상담내용:inquireContent
//		                                  상담일 : inquireDate , 답변:inquireAnswer
//		                                  답변일:inquireAnswerDate
		
		HomeWork_No6 no6 = new HomeWork_No6(0, "종류0", "주제0", "내용0", "상담일0", "답변0", "답변일0");
		System.out.println(no6.getInquireNum());
		System.out.println(no6.getInquireKind());
		System.out.println(no6.getInquireSubject());
		System.out.println(no6.getInquireContent());
		System.out.println(no6.getInquireDate());
		System.out.println(no6.getInquireAnswer());
		System.out.println(no6.getInquireAnswerDate());
		
		no6.setInquireNum(1);
		no6.setInquireKind("종류1");
		no6.setInquireSubject("주제1");
		no6.setInquireContent("내용1");
		no6.setInquireDate("상담일1");
		no6.setInquireAnswer("답변1");
		no6.setInquireAnswerDate("답변일1");
		
		System.out.println(no6.getInquireNum());
		System.out.println(no6.getInquireKind());
		System.out.println(no6.getInquireSubject());
		System.out.println(no6.getInquireContent());
		System.out.println(no6.getInquireDate());
		System.out.println(no6.getInquireAnswer());
		System.out.println(no6.getInquireAnswerDate());
		
//		7. 상품입고 : 입고번호:ipgoNum, 상품번호:goodsNum, 입고수량:ipgoQty, 입고일:ipgoDate
//		             상품제조일:madeDate, 입고금액:ipgoPrice, 상품금액:goodsPrice
		HomeWork_No7 no7 = new HomeWork_No7(0, 0, 0, "입고일0", "상품제조일0", 0, 0);
		System.out.println(no7.getIpgoNum());
		System.out.println(no7.getGoodsNum());
		System.out.println(no7.getIpgoQty());
		System.out.println(no7.getIpgoDate());
		System.out.println(no7.getMadeDate());
		System.out.println(no7.getIpgoPrice());
		System.out.println(no7.getGoodsPrice());
		
		no7.setIpgoNum(1);
		no7.setGoodsNum(1);
		no7.setIpgoQty(1);
		no7.setIpgoDate("입고일1");
		no7.setMadeDate("상품제조일1");
		no7.setIpgoPrice(1);
		no7.setGoodsPrice(1);
		
		System.out.println(no7.getIpgoNum());
		System.out.println(no7.getGoodsNum());
		System.out.println(no7.getIpgoQty());
		System.out.println(no7.getIpgoDate());
		System.out.println(no7.getMadeDate());
		System.out.println(no7.getIpgoPrice());
		System.out.println(no7.getGoodsPrice());
	}

}
