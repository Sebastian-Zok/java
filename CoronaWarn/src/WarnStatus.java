import java.awt.Color;

public enum WarnStatus {

	UNKNOWN("Unknown", new Color(175,175,175)), OK("Ok", new Color(100,200,100)), ALARM("Possible Encounter", new Color(255,100,100)), INFECTED("In quarantine", new Color(150,150,255));
	
	private String text;
	private Color color;
	
	private WarnStatus(String text, Color color) {
		this.setText(text);
		this.setColor(color);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
