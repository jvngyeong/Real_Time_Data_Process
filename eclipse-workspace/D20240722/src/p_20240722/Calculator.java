package p_20240722;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Calculator {
	int first;
	int second;
	int result;
	
	public int add() {
		return first + second;
	}
	public int div() {
		return first / second;
	}
}
