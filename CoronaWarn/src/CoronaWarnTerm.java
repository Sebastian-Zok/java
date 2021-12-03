import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;

public class CoronaWarnTerm extends JFrame implements CoronaWarnClient {

	private JPhone jPhone;
	private WarnStatus status;
	List<Token> allSeenTokens = new LinkedList<>();
	List<Token> ownTokens = new LinkedList<>();
	private Token actualToken;
	
	public JPanel south = new JPanel();
	JLabel lbl = new JLabel();

	public CoronaWarnTerm(JPhone jPhone) throws HeadlessException {
		super();
		this.jPhone = jPhone;
		this.status = WarnStatus.UNKNOWN;
		ownTokens = CoronaWarn.loadTokens(jPhone);
		actualToken = new Token();
		CoronaWarn.saveToken(jPhone, actualToken);

		this.setTitle(jPhone.getOwner());
		this.setSize(200, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new GridLayout(2,2));

		JPanel south = new JPanel();
		JLabel lbl = new JLabel(status.getText());
		lbl.setOpaque(true);
		lbl.setBackground(status.getColor());
		lbl.setHorizontalAlignment(JLabel.CENTER);
		south.add(lbl);
		this.add(south);

		JPanel north = new JPanel();
		north.setLayout(new GridLayout(5 , 1));
		JButton but1 = new JButton("New Token");
		JButton but2 = new JButton("Check for infections");
		JButton but3 = new JButton("Clear Tokens");
		JButton but4 = new JButton("Report infection");
		JLabel lbl2 = new JLabel("Seen Tokens: 0");
		lbl2.setToolTipText(actualToken.toString());

		but1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ownTokens.add(actualToken);
				actualToken = new Token();
				CoronaWarn.saveToken(jPhone, actualToken);
			}
		});
		
		but2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(CoronaWarnAPI.checkInfection(CoronaWarnTerm.this)) {
					status = WarnStatus.ALARM;
				}else {
					status = WarnStatus.OK;
				}
			}
		});
		
		but3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				allSeenTokens.clear();
				ownTokens.clear();
				CoronaWarn.clearTokenStore(jPhone);
				
				
				actualToken = new Token();
				ownTokens.add(actualToken);
				CoronaWarn.saveToken(jPhone, actualToken);
			}
		});
		
		but4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CoronaWarnAPI.reportInfection(CoronaWarnTerm.this);
				but1.setEnabled(false);
				but2.setEnabled(false);
				but3.setEnabled(false);
				but4.setEnabled(false);
				status = WarnStatus.INFECTED;
				updateStatus();
			}
		});

		north.add(but1);
		north.add(but2);
		north.add(but3);
		north.add(but4);
		north.add(lbl2);
		
		this.add(north);
		
		new Thread( new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (status != WarnStatus.INFECTED) {
					try {
						Thread.sleep(5000l);
					} catch (Exception e) {
						e.printStackTrace();
					}
					ownTokens.add(actualToken);
					actualToken = new Token();
					CoronaWarn.saveToken(jPhone, actualToken);
				}	
			}
		}).start();

	}
	
	
	public void updateStatus(){
		lbl.setText(status.getText());
		lbl.setBackground(status.getColor());
lbl.repaint();
		
	}

	
	@Override
	public Token getCurrentToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Token> getAllTokens() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Token> getAllSeenTokens() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void tokenReceived(Token token) {
		// TODO Auto-generated method stub

	}
	
	public JPanel getPanel() {
		return south;
	}

}
