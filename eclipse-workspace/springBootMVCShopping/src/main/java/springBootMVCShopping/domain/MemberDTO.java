package springBootMVCShopping.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
@Alias("memberDTO")
public class MemberDTO {
	String memberNum;
	String memberName;
	String memberId;
	String memberPw;
	String memberAddr;
	String memberAddrDetail;
	String memberPost;
	String memberPhone1;
	String memberPhone2;
	String memberEmail;
	Date memberRegist;
	Date memberBirth;
	String gender;
	String memberPoint;
	String memberEmailConf;
}
