import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

public class SnatChatWindow extends JFrame implements SnatChatFrontend {

	private SnatChatRoom room;
	private Account account;
	private ChatMessagesComponent messages = new ChatMessagesComponent();
	private JTextField txtMsg = new JTextField();
	private JButton send = new JButton();

	public SnatChatWindow(SnatChatRoom room, Account account) {
		super(account.getName() + "(" + room.getRoomName() + ")");
		this.room = room;
		this.account = account;

		this.setLayout(new BorderLayout(5, 5));
		JLabel lblUsername = new JLabel(account.getName());
		lblUsername.setForeground(account.getColor());
		this.add(lblUsername, BorderLayout.NORTH);
		this.add(this.messages, BorderLayout.CENTER);

		JPanel panSouth = new JPanel(new GridLayout(2, 1, 5, 5));
		this.add(panSouth, BorderLayout.SOUTH);

		JPanel panRadio = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JRadioButton radioAvailable = new JRadioButton("Available");
		JRadioButton radioAway = new JRadioButton("Available");
		JRadioButton radioDnD = new JRadioButton("Available");

		ButtonGroup grp = new ButtonGroup();
		for (State state : State.values()) {
			JRadioButton btnRadio = new JRadioButton(state.getLabel());
			panRadio.add(btnRadio);
			grp.add(btnRadio);
			if (account.getState() == state) {
				btnRadio.setSelected(true);
			}

			btnRadio.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					room.sendMessage(
							String.format("State of user '%s' is now '%s'", account.getName(), state.getLabel()));
					account.setState(state);
				}
			});
		}

		
		
				
				ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (txtMsg.getText().equals("")) {
					JOptionPane.showMessageDialog(send, "Dear" + account.getName() + " please enter a message");
				} else {
					room.sendMessage(txtMsg.getText());
					txtMsg.setText("");
				}

			}
		};

		this.send.addActionListener(al);
		txtMsg.addActionListener(al);
		
		JPanel panText = new JPanel(new BorderLayout(5, 5));
		panText.add(this.txtMsg, BorderLayout.CENTER);
		panText.add(this.send, BorderLayout.EAST);

		panSouth.add(panRadio);
		panSouth.add(panText);
		this.pack();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	@Override
	public void receiveMessage(Message msg) {
		JLabel lbl = new JLabel(msg.getTransmitter().getName() + ": " + msg);
		lbl.setForeground(msg.getTransmitter().getColor());
		addLabelWithCountdown(lbl);
	}

	@Override
	public void receiveMessage(String text) {
		JLabel lbl = new JLabel(text);
		lbl.setForeground(Color.GRAY);
		addLabelWithCountdown(lbl);
	}

	@Override
	public Account getAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addLabelWithCountdown(JLabel lbl) {
		String org = lbl.getText();
		messages.add(lbl);

		Runnable r = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int value = 5;
				while (value >= 0) {
					lbl.setText(org + " [ " + value + " ]");
					try {
						Thread.sleep(1000l);
					} catch (Exception e) {
						e.printStackTrace();
					}
					value--;
				}
				messages.remove(lbl);
			}
		};

		new Thread(r).start();
	}

}
