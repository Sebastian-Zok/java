
public class Message {

	private String text;
	private Account transmitter;

	public Message(String text, Account transmitter) {
		this.setText(text);
		this.setTransmitter(transmitter);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Account getTransmitter() {
		return transmitter;
	}

	public void setTransmitter(Account transmitter) {
		this.transmitter = transmitter;
	}

	public static String rot13(String msg) {
		char[] msgChars = msg.toCharArray();

		for (int i = 0; i < msgChars.length; i++) {
			char c = msgChars[i];
			if (c >= 'A' && c <= 'M' || c >= 'a' && c <= 'm') {
				msgChars[i] += 13;
			} else {
				msgChars[i] -= 13;
			}
		}
		
		return new String(msgChars);	}
}