package jspMVCMisoShopping.model.dto;

import java.util.Date;

import lombok.Data;
@Data
public class InquireDTO {
	int inquireNum;
	String memberNum;
	String goodsNum;
	String inquireSubject;
	String inquireContents;
	String inquireKind;
	Date inquireDate;
	String inquireAnswer;
	Date inquireAnswerDate;
	String empNum;
}
