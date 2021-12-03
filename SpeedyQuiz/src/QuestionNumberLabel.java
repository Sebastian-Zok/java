import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuestionNumberLabel extends JLabel {

	public QuestionNumberLabel(int i) {
		super();
		this.state = Status.PENDING;
		this.setText(String.valueOf(i));
		this.setOpaque(true);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setBackground(state.getColor());

	}

	private Status state;

}
