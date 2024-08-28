package p_20240828;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor

@Getter
@Setter
public class Calculator {
	int num1;
	int num2;
	
	public int add() {
		return num1+num2;
	}
	public int div() {
		return num1/num2;
	}
}
