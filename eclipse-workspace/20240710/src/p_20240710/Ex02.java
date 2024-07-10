package p_20240710;

public class Ex02 {

	public static void main(String[] args) {
		//제어문 : 조건문 / 반복문
		// 	 조건문 : if, switch
		//	 반복문 : for, while, do ~ while
		
		/* -단일 if문 예시-
		
		  if(조건식) { 		//조건식에는 Boolean 값이 오거나, 결과가 Boolean인 식이 와야함.
			명령문		 	//true일 때 실행될 코드를 작성
		  }
		  
		*/
		
		/* -if ~ else문 예시-
		  
		   if(조건식){
		   	명령문 : true일 때 실행되는 명령
		   }else{
		  	 명령문 : false일 때 실행되는 명령
		   }
		   
		*/
		
		int money = 1500;
		if(money >= 1450) {
			System.out.println("버스를 타고 가세요.");
		}
		
		money = 1000;
		if(money >= 1450) {
			System.out.println("버스를 타고 가세요.");
		}
		else {
			System.out.println("걸어서 가세요.");
		}
	}

}
