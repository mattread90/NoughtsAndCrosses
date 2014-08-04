package game;

public class InvalidSquareNumberException extends InvalidMoveException {
	private int squareNum;
	
	public InvalidSquareNumberException(int squareNum) {
		this.squareNum = squareNum;
	}
	
	public String getMessage() {
		return "Sorry, '" + squareNum + "' is not a valid square number. Please choose a square number between 1 and 9";
	}
}
