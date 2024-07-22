package p_20240722;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public abstract class CalculatorAbstract {	// 추상 클래스
	int first;
	int second;
	
	public int add() {
		return first + second;
	}
	public abstract int div();	// 추상 메서드
}
