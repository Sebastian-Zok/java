import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Game {

	private char letter;
	private List<String> choosenColumnTopics = new LinkedList();
	private int min, max;

	private int time;
	private boolean running;

	private List<Sheet> sheets = new LinkedList<>();

	public Game(int min, int max, int time) {
		super();
		this.min = min;
		this.max = max;
		this.time = time;

		if (!(min >= 3)) {
			this.min = 3;
		}
		if (!(max >= min)) {
			this.max = this.min;
		}
	}

	public void register(Sheet sheet) {
		this.sheets.add(sheet);
	}

	public void startGame() {
		this.letter = createFirstCharacter();
		this.choosenColumnTopics = createColumns(min, max);
		for(Sheet sheet: sheets) {
			sheet.toggleStop();
			sheet.toggleStart();
			sheet.getCenterPane().removeAll();
			
			for(String word: choosenColumnTopics) {
				sheet.getCenterPane().setLayout(new GridLayout(choosenColumnTopics.size(), 3));
				sheet.getCenterPane().add(new JLabel(word));
				sheet.getCenterPane().add(new JTextField());
				sheet.getCenterPane().add(new JLabel("0"));
			}

		}
		
		
	}

	public List<String> words = new LinkedList<>();
	
	public void stopGame(Player player) {
		
	
		for(Sheet sheet: sheets) {
			
			
			for(Component component :sheet.getCenterPane().getComponents()){
				if(component instanceof JTextField) {
					String word = ((JTextField) component).getText();
					words.add(word);
				}
				
			}
			sheet.toggleStop();
			sheet.toggleStart();
		}
		
		
		
	}


	public int checkWord(String word) {

		boolean points20, points10, points5, points0;
		return 0;
	}

	public List<String> createColumns(int min, int max) {
		List<String> columns = new LinkedList();
		columns.add("CITY");
		columns.add("COUNTRY");
		columns.add("RIVER");
		Random rand = new Random();
		int r = rand.nextInt(max - min);

		while (columns.size() != r + 3) {
			for (ColumnType type : ColumnType.values()) {
				String s = type.name();
				if (columns.contains(s)) {
					// DO nothing
				} else {
					columns.add(s);
				}
			}
		}

		return columns;

	}

	public char createFirstCharacter() {
		Random rand = new Random();
		int r = rand.nextInt(26);
		char a = 'A';
		a += r;
		return a;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;

	}
}
