package p_20240710;

public class HomeWork_2024_07_10 {

	public static void main(String[] args) {
		//0. 반복이 10번 수행이 되는 동안 "이쓰앰님을 전적으로 믿으셔야합니다."를 출력하시오.
		System.out.println("----- 0번 문제 답 ----- ");
		for(int i = 1; i <= 10; i++) {
			System.out.println("이쓰앰님을 전적으로 믿으셔야합니다.");
		}
		//1. for문에 있는 변수 i가 초기값 10을 가지고 있으며 10회를 반복할 때 변수 i를 2씩 증가시킨후 더한 값 출력되도록 하시오.
		System.out.println("\n----- 1번 문제 답 ----- ");
		int result_1 = 0;
		for(int i = 10; i <= 19; i += 2) {
			result_1 += i;
		}
		System.out.println(result_1);
		
		//2. for문에 있는 변수 i가 초기값 20을 가지고 있으며 10회를 반복할 때 변수 i를 2씩 감시킨 후 더한 값 출력되도록 하시오.
		System.out.println("\n----- 2번 문제 답 ----- ");
		int result_2 = 0;
		for(int i = 20; i >= 11; i -= 2) {
			result_2 += i;
		}
		System.out.println(result_2);
		//3. 구구단 6단 중 홀수 곱만 출력하시오.
		System.out.println("\n----- 3번 문제 답 ----- ");
		for(int gop = 1; gop <= 9; gop++) {
			if(gop % 2 != 0) {
				System.out.println("6 * " + gop + " = " + 6 * gop);
			}
		}
		//4.  for문을 이용해서 구구단 7단을 출력하되 홀수만을 출력하고 for문안에 있는 변수는 반복하는 용도로만 사용한다. 
		System.out.println("\n----- 4번 문제 답 ----- ");
		int gop_4 = 1;
		for (int i = 1; i <= 9; i++) {
			if(gop_4 % 2 != 0) {
				System.out.println("7 * " + gop_4 + " = " + 7 * gop_4);
			}
			gop_4++;
		}
		
		//5. 구구단 6단 중 홀수 곱만 출력할 때 continue 이용할 것
		System.out.println("\n----- 5번 문제 답 ----- ");
		int gop_5 = 0;
		while(true) {
			if(gop_5 >= 10) {
				break;
			}
			gop_5++;
			if(gop_5 % 2 == 0) {
				continue;
			}
			System.out.println("6 * " + gop_5 + " = " + 6 * gop_5);
		}
		//6. int rnd = (int)(Math.random() * 9)+1;을 이용하여 1부터 rnd만큼 구구단의 8단을 출력하시오.
		System.out.println("\n----- 6번 문제 답 ----- ");
		int rnd = (int)(Math.random() * 9)+1;
		for(int i = 1; i <= rnd; i++) {
			System.out.println("8 * " + i + " = " + 8 * i);
		}
		/*
		7. 각각의 변수가 아래와 같을 때 
		    int x = 1;
		    int z = 10;
		    int g = 4;
		x는 초기값 z는 반복의 조건이고 g는 증가값으로 반복문을 만드시오
		*/
		System.out.println("\n----- 7번 문제 답 ----- ");
	    int x = 1;
	    int z = 10;
	    int g = 4;
	    int repeat = 1;
	    for(int i = x; i <= z; i+=g) {
	    	System.out.println(repeat + "번 반복 중..");
	    	repeat++;
	    }
		/*
		8. 아래와 같이 출력되게 하세요.
		6단 시작
		6 * 4= 24
		6 * 5= 30
		6 * 6= 36
		6단 끝
		7단 시작
		7 * 4= 28
		7 * 5= 35
		7 * 6= 42
		7단 끝
		*/
		System.out.println("\n----- 8번 문제 답 ----- ");
		int startDan_8 = 6;
		int endDan_8 = 7;
		int startGop_8 = 4;
		int endGop_8 = 6;
		for(int i = startDan_8; i <= endDan_8; i++) {
			System.out.println(i+"단 시작");
			for(int j = startGop_8; j <= endGop_8; j++) {
				System.out.println(i + " * " + j + " = " + i*j);
			}
			System.out.println(i+"단 끝");
		}
		/*
		9. 아래와 같이 출력되게 하시오.
		6단 시작
		6 * 4= 24         6 * 5= 30         6 * 6= 36
		6단 끝
		7단 시작
		7 * 4= 28         7 * 5= 35         7 * 6= 42
		7단 끝
		*/
		System.out.println("\n----- 9번 문제 답 ----- ");
		int startDan_9 = 6;
		int endDan_9 = 7;
		int startGop_9 = 4;
		int endGop_9 = 6;
		for(int i = startDan_9; i <= endDan_9; i++) {
			System.out.println(i+"단 시작");
			for(int j = startGop_9; j <= endGop_9; j++) {
				System.out.print(i + " * " + j + "= " + i*j + "         ");
			}
			System.out.println("\n" + i+"단 끝");
		}
		/*
		10. 반복문을 사용하여 아래 와 같이 출력결과가 나오게 하세요.
		<table border='1'>
		<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
		<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
		<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
		<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
		</table>
		*/
		System.out.println("\n----- 10번 문제 답 ----- ");
		System.out.println("<table border='1'>");
		for(int i = 0; i<= 4; i++) {
			System.out.print("<tr>");
			for(int j = 1; j<= 4; j++) {
				System.out.print("<td> " + j + " </td>");
			}
			System.out.print("\n");
		}
		System.out.println("</table>");
		/*
		11. int rnd1 = (int)(Math.random() * 45)+1;코드를 사용해서 rnd1값을 6개씩 5번출력되게 하세요.
		(단, 중복값 허용)
		 */
		System.out.println("\n----- 11번 문제 답 ----- ");
		for(int j = 1; j<= 5; j++) {
			for(int i = 1; i <= 6; i++) {
				int rnd1 = (int)(Math.random() * 45)+1;
				System.out.print(rnd1 + "  ");
			}
			System.out.println("\n");
		}

		//12. 6단을 출력할 때 3곱부터 8곱까지만 출력하시오.
		System.out.println("\n----- 12번 문제 답 ----- ");
		int startGop_12 = 3;
		int endGop_12 = 8;
		for(int i = startGop_12; i <= endGop_12; i++) {
			System.out.println("6 * " + i + " = " + 6 * i);
		}
		//13. 1부터 45중 랜덤수 6개만 가지고 오시오 (복원 추출, 중복 허용)
		System.out.println("\n----- 13번 문제 답 ----- ");
		for(int i = 1; i <= 6; i++) {
			int rnd1 = (int)(Math.random() * 45) + 1;
			System.out.print(rnd1 + "  ");
		}

		/*
		 14. i는 1부터 15까지 1씩 증가하여야 하며 y는 1000 부터 10씩 감소 할때만 만복이 이루어져야 한다.
		 이 때 "자바는 나의 사랑"이라는 문구가 출력되도록 하시오.
		 */
		System.out.println("\n\n----- 14번 문제 답 ----- ");
		for(int i = 1, y = 1000; i <= 15 && y > 0 ; i++, y-=10) {
			System.out.println("자바는 나의 사랑");
		}
	}

}
