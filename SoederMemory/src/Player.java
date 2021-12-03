import java.awt.Color;

public class Player {
	
	private String name;
	private int points;
	private PlayerStatus status;

	public Player(String name) {
		this.name = name;
		this.setPoints(0);
		this.status = PlayerStatus.WAITING;
	}
	
	private void addPoint() {
		this.setPoints(this.getPoints() + 1);
	}
	
	public void setStatus(PlayerStatus status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public PlayerStatus getStatus() {
		return status;
	}
	public Color getColor() {
		return status.getColor();
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
