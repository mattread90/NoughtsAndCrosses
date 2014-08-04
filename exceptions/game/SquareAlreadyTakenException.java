package game;

public class SquareAlreadyTakenException extends InvalidMoveException  {
	
	private int squareNum;
	
	public SquareAlreadyTakenException(int squareNum) {
		this.squareNum = squareNum;
	}
	
	public String getMessage() {
		return "Square '" + squareNum + "' has already been taken.";
	}
	
}
