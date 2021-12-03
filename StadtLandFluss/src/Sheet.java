import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Sheet extends JFrame {

	private Player player;
	private Game game;
	
	JButton start = new JButton("Start");
	JButton stop = new JButton("Stop");
	
	JPanel centerPane = new JPanel();


	public Sheet(Player player, Game game) throws HeadlessException {
		super();
		this.player = player;
		this.game = game;

		this.setTitle(player.getName());
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(3, 2));
		pane.add(new JLabel("Punkte"));
		pane.add(new JLabel(String.valueOf(player.getPoints())));
		pane.add(new JLabel("Verbleibende Sekunden"));
		pane.add(new JLabel(String.valueOf(game.getTime())));
		pane.add(new JLabel("Anfangsbuchstabe"));
		pane.add(new JLabel(String.valueOf(game.getLetter())));
		
		
		this.add(pane, BorderLayout.NORTH);
		

		
		this.add(centerPane, BorderLayout.CENTER);

		JPanel pane2 = new JPanel();
		pane2.setLayout(new GridLayout(1, 2));
		stop.setEnabled(false);

		
		pane2.add(start);
		pane2.add(stop);
		this.add(pane2, BorderLayout.SOUTH);


		
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				game.setLetter(game.createFirstCharacter());
				game.startGame();
				stop.setEnabled(true);
				start.setEnabled(false);
			}
		});

		stop.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				game.stopGame(player);
				stop.setEnabled(false);
				start.setEnabled(true);
			}
		});

	
		
	}
	
	public JPanel getCenterPane() {
		return centerPane;
	}
	
	public void toggleStart() {
		if(start.isEnabled()) {
		start.setEnabled(false);
		}else {
			start.setEnabled(true);
		}
	}
	
	public void toggleStop() {
		if(stop.isEnabled()) {
		stop.setEnabled(false);
		}else {
			stop.setEnabled(true);
		}
	}
	

}
