package p_20240828;

public class Ex07 {
	public static void main(String[] args) {
		int i = 10;
		String[] memberNums = {"miso_1", "miso_2", "miso_3"};
		int[] memberAges = {15, 16, 17};
		String[] memberNames = {"이숭무", "김찬중", "이상희"};
		
		Member member1 = new Member();
		member1.memberAge = 20;
		member1.memberHeight = 180;
		member1.memberName = "이숭무";
		member1.memberNum = "miso_1";
		
		Member member2 = new Member("miso_2", 16, 170, "김찬중");
	}
}
