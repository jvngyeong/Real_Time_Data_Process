package p_20240717;

public class HomeWork_No3 {
	int candidateNum;
	String candidateName;
	int vote;

	public HomeWork_No3(int candidateNum, String candidateName, int vote) {
		this.candidateNum = candidateNum;
		this.candidateName = candidateName;
		this.vote = vote;
	}
	
	public void print() {
		System.out.println(candidateNum);
		System.out.println(candidateName);
		System.out.println(vote);
	}
}
