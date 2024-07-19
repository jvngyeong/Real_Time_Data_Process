package p_20240717;

public class Ex01 {

	public static void main(String[] args) {
		int i1 = 10;
		int i2 = 20;
		int i3 = 30;
		//위처럼 하는 것 대신에 밑의 배열을 만듦.
		int[] i = new int[3];	//[0][0][0]
		i[0] = 10;		//[10][0][0]
		i[1] = 20;		//[10][20][0]
		Account[] acc = new Account[3];
		Account acc1 = new Account(10001, "이준경", 1000);
		Account acc2 = new Account(10001, "이준경", 1000);
		Account acc3 = new Account(10001, "이준경", 1000);
		acc[0] = new Account(10001, "이준경", 1000);		//[객체][null][null]
		acc[1] = new Account(10001, "이준경", 1000);		//[객체][객체][null]
		//배열의 초기값 : 정수 배열 0, 실수 배열 0.0, 부울 배열 false, 문자 blank
		//			  문자열을 포함한 나머지 배열 초기값 null
		for(int val : i) {				//i는 크기가 3인 배열인데, 2번째 인덱스까지만 초기화했지만, 
			System.out.println(val);	//int 배열은 초기값이 0이기 때문에 foreach문으로 각 인덱스를 순회해도 오류가 나지 않음.								
		}
		
		for(Account obj : acc) {		//하지만 정수, 실수, 부울, 문자를 제외한 나머지 배열은 초기값이 null이기 때문에,
			if(obj != null) {			//obj가 null이 아닐 때만 순회하도록 if문을 써준다.
				System.out.println(obj.accountNum);	
			}
			else break;
		}
	}

}
