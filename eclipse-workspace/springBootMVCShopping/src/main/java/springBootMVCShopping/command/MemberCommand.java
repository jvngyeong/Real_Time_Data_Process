package springBootMVCShopping.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MemberCommand {
	//자료형이 String이면 @NotEmpty와 @NotBlank를 사용할 수 있다.
	String memberNum;
	@NotEmpty(message = "이름을 입력해주세요.")
	String memberName;
	
	@NotEmpty(message = "ID를 입력해주세요.")
	String memberId;
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",
			message = "영문자와 숫자 그리고 특수문자가 포함된 8글자 이상")
	@NotEmpty(message = "패스워드를 입력해주세요.")
	String memberPw;
	
	@NotEmpty(message = "패스워드 확인을 입력해주세요.")
	String memberPwCon;
	
	@NotEmpty(message = "주소를 입력해주세요.")
	String memberAddr;
	
	String memberAddrDetail;
	
	@NotEmpty(message = "주소를 입력해주세요.")
	String memberPost;
	
	@NotEmpty(message = "전화번호를 입력해주세요.")
	@Size(min = 11, max = 23)
	String memberPhone1;
	
	@Size(min = 11, max = 23)
	String memberPhone2;
	
	String gender;
	
	@NotNull(message = "생년월일을 입력해주세요.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date memberBirth;
	
	@NotEmpty(message = "이메일을 입력해주세요.")
	String memberEmail;
	
	public boolean isMemberPwEqualMemberPwCon() {
		return memberPw.equals(memberPwCon);
	}
}
