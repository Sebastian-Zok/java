import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameTerm  extends JFrame implements GameClient {

	private String name;
	private Game game;
	private int remainingSeconds;
	public int points;
	private JLabel text;

	public GameTerm(String name, Game game) {
		super();
		this.name = name;
		this.game = game;
		
		
		this.setTitle(name);
		this.setSize(500, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.setLayout(new BorderLayout(5,5));
		JPanel questionNumbers = new JPanel();
		questionNumbers.setLayout(new GridLayout());
		
		for(int i = 0; i < game.getQuestionsCount(); i++) {
		questionNumbers.add(new QuestionNumberLabel(i));	
		}
		
		this.add(questionNumbers, BorderLayout.NORTH);
		text.setText(game.getQuestionpoolList().get(0).toString());
		this.add(text, BorderLayout.CENTER);
		
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(2,2));
		 List<Question> questionpoolList = game.getQuestionpoolList();
		for(Question question : questionpoolList) {
			JButton button = new JButton(question.getQuestionText());
			buttons.add(button);
		}
		
		this.add(buttons, BorderLayout.SOUTH);
		
	}

	@Override
	public String getPlayerName() {
		return this.name;
	}

	@Override
	public int getPoints() {
		if (points < 0) {
			return 0;
		}
		return points;
	}

	@Override
	public void setQuestion(int questionIndex, Question q) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRemainingSeconds(int seconds) {
		remainingSeconds = seconds;

	}

	@Override
	public void gameIsOver() {
		game.stopGame();
	}

	@Override
	public void setAnswerState(int questionIndex, Status status) {
		// TODO Auto-generated method stub

	}

}
