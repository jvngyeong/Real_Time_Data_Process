package p_20240828;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inquire {
	int inqNum;
	String inqSubject;
	String inqKind;
	String inqContent;
	String inqAnswer;
}
