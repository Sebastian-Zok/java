package jBay;

import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.*;

public class BieterTerminal extends JFrame {

	private Bieter bieter;
	private Auktionshaus auktionshaus;

	public BieterTerminal(Bieter bieter, Auktionshaus auktionshaus) {
		super();
		this.bieter = bieter;
		this.auktionshaus = auktionshaus;

		this.setTitle(bieter.getFullName() + "'s Terminal");
		this.setSize(500, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new GridLayout(2, 1));
		String calender = java.util.Calendar.getInstance().getTime().toString();
		JLabel lab = new JLabel();
		
		new Thread( new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int value = 0;
				while (true) {
					String calender = java.util.Calendar.getInstance().getTime().toString();
					try {
						Thread.sleep(1000l);
					} catch (Exception e) {
						e.printStackTrace();
					}
					lab.setText(String.valueOf(calender));
				}	
			}
		}).start();
		
		this.add(lab);

		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(auktionshaus.getAuktionen().size(), 5));
		;
		int i = 0;
		while (i < auktionshaus.getAuktionen().size()) {

			final int ii = i;
			pane.add(new JLabel(auktionshaus.getAuktionen().get(i).getWare().getTitel()));
			pane.add(new JLabel(Double.toString(auktionshaus.getAuktionen().get(i).getPrice() + Auktion.increment)));
			if (auktionshaus.getAuktionen().get(i).getGebot() == null) {
				pane.add(new JLabel("--"));
			} else {
				pane.add(new JLabel(auktionshaus.getAuktionen().get(i).getGebot().getBieter().getFullName()));
			}
			pane.add(new JLabel(auktionshaus.getAuktionen().get(i).getEnd().getTime().toString()));
			JButton but = new JButton("Gebot");
			but.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (java.util.Calendar.getInstance().getTime()
							.after(auktionshaus.getAuktionen().get(ii).getEnd().getTime())) {
						JOptionPane.showMessageDialog(but, "Leider ist die Auktion vorbei");
					} else {
						double input = Double.parseDouble(JOptionPane.showInputDialog(but,
								"Bitte neues Gebot eingeben \n Mindestens "
										+ auktionshaus.getAuktionen().get(ii).getPrice() + "€",
								auktionshaus.getAuktionen().get(ii).getPrice()));

						if (auktionshaus.getAuktionen().get(ii).gebotAbgeben(new Gebot(input, bieter))) {
							JOptionPane.showMessageDialog(but, "Sie sind Höchstbietender");
							auktionshaus.updateTerminals();
						} else {
							JOptionPane.showMessageDialog(but, "Gebot zu niedrig!");
							logToFile(java.util.Calendar.getInstance().getTime().toString()+ "Gebot von " + bieter.getFullName()+" "+ auktionshaus.getAuktionen().get(ii).getWare() + " "+ auktionshaus.getAuktionen().get(ii).getPrice() );
						}
					}
				}
			});

			pane.add(but);
			this.add(pane);
			i++;
		}

		// auktionshaus.getAuktionen().forEach((temp) ->
		// this.add(new JLabel( auktion.getWare().getTitel()))
		// );
	}
	
	
	public void logToFile(String line) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("auktionen.txt", true));
			pw.println(line);
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
