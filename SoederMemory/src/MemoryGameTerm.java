import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

public class MemoryGameTerm extends JFrame {

	List<MemoryImages.MemoryImage> images = new LinkedList<>();

	public MemoryGameTerm(MemoryGame game) {
		this.setTitle();
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new BorderLayout(5, 5));

		JPanel top = new JPanel();
		top.setLayout(new GridLayout(MemoryGame.getPlayersSize(), 1, 1, 3));

		Iterator<Player> iterator = game.players.iterator();
		while (iterator.hasNext()) {
			Player player = iterator.next();
			JLabel lable = new JLabel(player.getName() + " (" + player.getPoints() + ")");
			lable.setForeground(player.getColor());
			System.out.println(player.getColor());
			top.add(lable);
		}

		this.add(top, BorderLayout.NORTH);

		JPanel field = new JPanel();
		field.setLayout(new GridLayout(game.getCols(), game.getRows()));

		

		int size = game.getImages().size();
		images = game.getImages();
		boolean blank = false;

		Random rand = new Random();

		for (int i = 0; i < size; i++) {
			images.add(images.get(i));
		}
		
		if (!((size % 2) == 0)) {
			size++;
			blank = true;
		}
		
		for (int i = 0; i <= size * 2 + 1; i++) {
			JToggleButton but = new JToggleButton();
			but.setIcon(MemoryImages.getBackside());
			int randomIndex = rand.nextInt(size);
			size--;
			if(blank && randomIndex == size * 2 + 1) {
				but.setSelectedIcon(MemoryImages.getBackside());
			}else {
				but.setSelectedIcon(images.get(randomIndex).getImage());
			images.remove(randomIndex);   			
			}
			field.add(but);
		}
		this.add(field);
	}
	
	
	private void addTitleWithCountdown() {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int value = 0;
				while (true) {
					value++;
					try {
						Thread.sleep(1000l);
					} catch (Exception e) {
						e.printStackTrace();
					}
					this.setTitle(value);
				}	
			}
		};
		new Thread(r).start();
	}
}