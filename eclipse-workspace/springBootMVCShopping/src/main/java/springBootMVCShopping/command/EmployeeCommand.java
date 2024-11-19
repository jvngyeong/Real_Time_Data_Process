package springBootMVCShopping.command;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmployeeCommand {
	String empNum;
	@NotEmpty(message = "아이디를 입력해주세요.")
	String empId;
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",
			message = "영문자와 숫자 그리고 특수문자가 포함된 8글자 이상")
	@NotEmpty(message = "비밀번호를 입력해주세요.")
	String empPw;
	
	@NotEmpty(message = "비밀번호 확인을 입력해주세요.")
	String empPwCon;
	
	@NotEmpty(message = "이름을 입력해주세요.")
	String empName;
	
	@NotEmpty(message = "주소를 입력해주세요.")
	String empAddr;
	String empAddrDetail;
	int empPost;
	
	@NotEmpty(message = "전화번호를 입력해주세요.")
	String empPhone;
	
	@NotEmpty(message = "주민번호를 입력해주세요.")
	String empJumin;
	
	@NotEmpty(message = "이메일을 입력해주세요.")
	String empEmail;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date empHireDate;
	String empImage;
	
	public boolean isEmpPwEqualsEmpPwCon() {
		return empPw.equals(empPwCon);
	}
	
	public void removeBlank() {
		this.empNum = this.empNum.trim();
		this.empId = this.empId.trim();
		this.empPw = this.empPw.trim();
		this.empName = this.empName.trim();
		this.empAddr = this.empAddr.trim();
		this.empAddrDetail = this.empAddrDetail.trim();
		this.empPhone = this.empPhone.trim();
		this.empJumin = this.empJumin.trim();
		this.empEmail = this.empEmail.trim();
	}
}
