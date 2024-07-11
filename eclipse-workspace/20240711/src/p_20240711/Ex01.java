package p_20240711;

public class Ex01 {

	public static void main(String[] args) {
		//20240710 수요일 숙제 리뷰
		//0번 해답
		for(int i = 0; i < 10; i++) {
			System.out.println("이쓰앰님을 전적으로 믿으셔야합니다.");
		}
		int i = 0;
		while(i < 10) {
			System.out.println("이쓰앰님을 전적으로 믿으셔야합니다.");
			i++;
		}
		
		//1번 해답
		int sum = 0;
		for(i = 10; i < 20; i+=2) {
			sum += i;
		}
		System.out.println(sum);
		
		//2번 해답
		sum = 0;
		for(i = 20; i > 10; i-=2) {
			sum += i;
		}
		System.out.println(sum);
		
		//3번 해답
		for(i = 1; i <= 9; i++) {
			if(i % 2 != 0) {
				System.out.println("6 * " + i + " = " + 6 * i);
			}
		}
		
		i = 1;
		while(i <= 9) {
			if(i % 2 != 0) {
				System.out.println("6 * " + i + " = " + 6 * i);
			}
			i++;
		}
		
		//4번 해답
		int gop = 1;
		for(i = 0; i < 9; i++) {
			if(gop % 2 != 0) {
				System.out.println("7 * " + gop + " = " + 7 * gop);
			}
			gop++;
		}
		
		for(i = 0, gop = 1; i <= 9; i++, gop++) {
			if(gop % 2 != 0) {
				System.out.println("7 * " + gop + " = " + 7 * gop);
			}
		}
		
		//5번 해답
		i = 0;
		while(i <= 9) {
			i++;
			if(i % 2 == 0) {
				continue;
			}
			System.out.println("6 * " + i + " = " + 6 * i);
		}
		
		for(i = 1; i <= 9; i++) {
			if(i % 2 == 0) {
				continue;
			}
			System.out.println("6 * " + i + " = " + 6 * i);
		}
		
		//6번 해답
		int rnd = (int)(Math.random() * 9) + 1;
		for(i = 1; i <= rnd; i++) {
			System.out.println("8 * " + i + " = " + 8 * i);
		}
		
		//7번 해답
		int x = 1;
		int z = 10;
		int g = 4;
		for(i = 1; i <= 10; i += g) {
			System.out.println(i);
		}
		
		//8번 해답
		for(int dan = 6; dan <= 7; dan++) {
			System.out.println(dan + "단 시작");
			for(gop = 4; gop <= 6; gop++) {
				System.out.println(dan + " * " + gop + " = " + dan * gop);
			}
			System.out.println(dan + "단 끝");
		}
		
		//9번 해답
		int startDan_9 = 6;
		int endDan_9 = 7;
		int startGop_9 = 4;
		int endGop_9 = 6;
		for(i = startDan_9; i <= endDan_9; i++) {
			System.out.println(i+"단 시작");
			for(int j = startGop_9; j <= endGop_9; j++) {
				System.out.print(i + " * " + j + "= " + i*j + "         ");
			}
			System.out.println("\n" + i+"단 끝");
		}
		
		//10번 해답
		System.out.println("<table>");
		for(int tr = 0; tr < 4; tr++) {
			System.out.println("<tr>");
			for(int td = 0; td < 4; td++) {
				System.out.print("<td> " + (td + 1) + " </td>");
			}
			System.out.print("</tr>");
		}
		System.out.println("</table>");
		
		//11번 해답
		for(int cnt = 1; cnt <= 5; cnt++) {
			for(int q = 1; q <= 6; q++) {
				int rnd1 = (int)(Math.random() * 45) + 1;
				System.out.print(rnd1 + "\t");
			}
			System.out.println();
		}
		
		//12번 해답
		for(gop = 3; gop <= 8; gop++) {
			System.out.println("6 * " + gop + " = " + 6 * gop);
		}
		
		//13번 해답
		for(int cnt = 1; cnt <= 6; cnt++) {
			int rnd1 = (int)(Math.random() * 45) + 1;
			System.out.println(rnd1 + "\t");
		}
		
		//14번 해답
		for(int i1 = 1, y = 1000; i1 <= 15 && y >= 0; i1++, y-=10) {
			System.out.println("자바는 나의 사랑");
		}
	}

}
