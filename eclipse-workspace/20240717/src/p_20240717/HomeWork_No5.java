package p_20240717;

public class HomeWork_No5 {
	int reviewNum;
	double score;
	String reviewDate;
	String reviewContent;

	public HomeWork_No5() {
	}

	public HomeWork_No5(int reviewNum, double score, String reviewDate, String reviewContent) {
		this.reviewNum = reviewNum;
		this.score = score;
		this.reviewDate = reviewDate;
		this.reviewContent = reviewContent;
	}

	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getReviewNum() {
		return reviewNum;
	}

	public double getScore() {
		return score;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public String getReviewContent() {
		return reviewContent;
	}
}
