import java.awt.Color;

public enum Status {

	ACTIVE( Color.ORANGE, 0, "aktuell gestellte Frage"),
	CORRECT( Color.GREEN, +1, "richtig beantwortete Frage"), 
	WRONG( Color.RED, -1, "falsch beantwortete Frage"),
	PENDING( Color.WHITE, 0, "noch nicht gespielte/ausstehende Frage"),
	NO_ANSWER( Color.GRAY, 0, "Frage auf die ein anderer Spieler geantwortet hat");
	
	
	private Status(Color color, int points, String lable) {
		this.setColor(color);
		this.setPoints(points);
		this.setLable(lable);
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	private Color color;
	private int points;
	private String lable;
	
}
