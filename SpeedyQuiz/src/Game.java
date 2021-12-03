import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JOptionPane;

public class Game {

	private List<GameClient> frontends = new LinkedList<>();

	private Set<Question> questionpool = new HashSet<>();
	private int amount;
	private boolean running = false;
	private List<Question> questionpoolList = new LinkedList<>();
	private int index = 0;
	private int time;

	public Game(List<Question> questionpool, int amount) throws GameException {
		super();
		this.questionpoolList =  questionpool;
		this.amount = amount;

		if (questionpool.size() < amount) {
			throw new GameException();
		}

		do {
			Random rand = new Random();
			int i = rand.nextInt(questionpool.size());
			this.questionpool.add(questionpool.get(i));
		} while (this.questionpool.size() < amount);
	}

	public List<Question> getQuestionpoolList() {
		return questionpoolList;
	}

	public void setQuestionpoolList(List<Question> questionpoolList) {
		this.questionpoolList = questionpoolList;
	}

	public void registerClient(GameClient client) {
		if(!running) {
		frontends.add(client);
		}
		
	}

	public int getQuestionsCount() {
		return this.questionpool.size();
	}

	public void startGame() {
		running = true;
	}

	
	public void answerSelected(GameClient client, int index) {
		if(index == questionpoolList.get(index).getIndex()) {
			client.setAnswerState(index, Status.CORRECT);
		}else {
			client.setAnswerState(index, Status.WRONG);
		}
		
		for(GameClient clientF : frontends) {
			if(client != clientF) {
				clientF.setAnswerState(index, Status.NO_ANSWER);
			}
		}
		
		index++;
		if(index > questionpool.size()) {
			stopGame();
		}

	}
	
	
	public void stopGame() {
		running = false;
		
		for(GameClient term: frontends)           {
					}
	}
	
}
