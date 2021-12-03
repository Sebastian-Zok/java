import java.awt.Color;

public class Account {
	
	
	private String name;
	private State state;
	private Color color;
	
	public Account(String name) {
		this.setName(name);
		this.setState(State.AVAILABLE);
		this.setColor(new java.awt.Color((int) Math.random() * 200, (int) Math.random() * 200,(int) Math.random() * 200));	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	

}
