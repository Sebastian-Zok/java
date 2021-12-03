import java.util.*;

public class MemoryGame {

	private int rows;
	private int cols;
	static List<Player> players = new ArrayList();
	List<MemoryImages.MemoryImage> images = new LinkedList<>();
	
	public List<MemoryImages.MemoryImage> getImages() {
		return images;
	}

	public void setImages(List<MemoryImages.MemoryImage> images) {
		this.images = images;
	}

	private Player currentPlayer;

	public MemoryGame(List<Player> players, List<MemoryImages.MemoryImage> images, int rows, int cols) throws MemoryException {
		this.players = players;
		this.images = images;
		this.rows = rows;
		this.cols = cols;
		
		if(players.size() < 2) {
			throw new MemoryException("At least two players required");
		}
		
		int neededCards = rows * cols;
		neededCards = (neededCards % 2) == 0 ? neededCards : neededCards + 1 ;
		if(neededCards > images.size() * 2) {
			throw new MemoryException("Too few images available");
		}
		
		Random rand = new Random();

	    int numberOfElements = neededCards / 2;

	    for (int i = 0; i < numberOfElements; i++) {
	        int randomIndex = rand.nextInt(images.size());
	        //MemoryImages.MemoryImage randomElement = images.get(randomIndex);
	        images.remove(randomIndex);    
	    }
	
	}
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public static int getPlayersSize() {
		return players.size();
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
		this.currentPlayer.setStatus(PlayerStatus.ACTIVE);
	}
	
	public boolean isBlankRequired() {
		int neededCards = rows * cols;
		if ((neededCards % 2) == 0) { return false; };
		return true;
	}
	
	public void nextPlayer() {
		currentPlayer.setStatus(PlayerStatus.WAITING);
		int playerIndex = players.indexOf(currentPlayer);
		if(playerIndex < players.size()) {
			playerIndex++;
		}else {
			playerIndex = 0;											//###
		}
		
		currentPlayer = players.get(playerIndex);
		
	}
	
	

}
