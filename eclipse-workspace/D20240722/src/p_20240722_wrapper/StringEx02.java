package p_20240722_wrapper;

public class StringEx02 {
	public static void main(String[] args) {
		String str1 = "이숭무";
		String str2 = new String("이숭무");
		if(str1 == str2) {
			System.out.println("같다");
		}
		else {
			System.out.println("다르다");
		}
		if(str1.equals(str2)) {
			System.out.println("같다");
		}
		else {
			System.out.println("다르다");
		}
		
		String javaStr = "java";
		String androidStr = "android";
		System.out.println(javaStr + androidStr);
		String result = javaStr.concat(androidStr);
		System.out.println(result);
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		
		//문자열에서 문자 추출
		System.out.println(androidStr);
		char ch = androidStr.charAt(2);
		String subStr = "자바웹프로그래밍";
		char ch1 = subStr.charAt(2);
		System.out.println(ch);
		System.out.println(ch1);
		
		//자르기
		result = subStr.substring(2, (3+3));
		System.out.println(result);
		
		//크기
		System.out.println(subStr.length());

		//subStr에서 마지막 글자를 가져오시오.
		System.out.println(subStr.charAt(subStr.length()-1));
		
		//문자열이 가진 고유의 번호 index를 가져오기
		int idx = subStr.indexOf('프');
		System.out.println(idx);
		
		//'프'부터 3글자 출력
		System.out.println(subStr.substring(3));
		
		//문자열 변경
		//"자바웹프로그래밍"을 "java웹프로그래밍"으로 바꿔보자
		result = subStr.replace("자바", "java");
		System.out.println(result);
		
		//양쪽 공백 지우기
		String UserId = "     userid입니다    ";
		result = UserId.trim();
		System.out.println(result);
		
		int i = 10;
		result = String.valueOf(i);
	}
}
