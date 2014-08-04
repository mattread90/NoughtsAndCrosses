package game;

public class InvalidPlayerException extends InvalidMoveException {
	
	private int playerNum;
	
	public InvalidPlayerException(int playerNum) {
		this.playerNum = playerNum;
	}
	
	public String getMessage() {
		return "'" + playerNum + "' is not a recognised player number. The game has not been set up correctly.";
	}
	
}
