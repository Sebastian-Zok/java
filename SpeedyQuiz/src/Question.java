import java.util.LinkedList;
import java.util.List;

public class Question {
	

	private String questionText;
	private String[] answers = new String[4];
	private int index;
	
	public Question(String questionText, String[] answers, int index) {
		super();
		this.questionText = questionText;
		this.answers = answers;
		this.index = index;
	}	
	
	
	
	
	
	
	
	
	
	
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	
	
}
