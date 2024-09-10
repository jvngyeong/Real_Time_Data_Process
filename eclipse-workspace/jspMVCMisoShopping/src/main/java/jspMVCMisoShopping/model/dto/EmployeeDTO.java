package jspMVCMisoShopping.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeDTO {
	String empNum;
	String empId;
	String empPw;
	String empName;
	String empAddr;
	String empAddrDetail;
	int empPost;
	String empPhone;
	String empJumin;
	String empEmail;
	Date empHireDate;
	String empImage;
}
