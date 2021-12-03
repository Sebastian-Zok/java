import javax.swing.Icon;

public enum State {
AVAILABLE("Available"), AWAY("Away"), DND("Do not disturb"); 
	
	private String label;
	
	private State(String x) {
		this.label = x;
	}

	String getLabel() {
		// TODO Auto-generated method stub
		return label;
	}
}
