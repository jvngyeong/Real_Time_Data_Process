package jspMVCMisoShopping.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class MemberDTO {
	String memberNum;
	String memberId;
	String memberPw;
	String memberName;
	String memberPhone1;
	String memberPhone2;
	String memberAddr;
	String memberAddrDetail;
	String memberPost;
	String gender;
	String memberEmail;
	int memberPoint;
	Date memberBirth;
	
	Date memberRegist;
}
