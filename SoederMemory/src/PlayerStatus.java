import java.awt.Color;

public enum PlayerStatus {
ACTIVE("Active", Color.ORANGE), WAITING("Waiting", Color.BLACK), FINISHED("Finished", Color.GRAY); 
	
	private String label;
	private Color c;
	
	private PlayerStatus(String x, Color c) {
		this.label = x;
		this.c = c;
	}

	String getLabel() {
		// TODO Auto-generated method stub
		return label;
	}

	public Color getColor() {
		return c;
	}

	public void setColor(Color c) {
		this.c = c;
	}
}
