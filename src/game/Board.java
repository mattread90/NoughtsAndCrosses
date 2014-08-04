package game;

public class Board {
	
	protected int[][] squares = new int[3][3];
	
	public Board() {
		clearBoard();
	}
	
	private void clearBoard() {
		for (int row = 0; row < squares.length; row++) {
			for (int column = 0; column < squares.length; column++) {
				squares[row][column] = 0;
			}
		}
	}
	
	public void setSquare(int squareNum, int playerNum) throws InvalidMoveException {
		if (squareNum < 1 || squareNum > 9) {
			throw new InvalidSquareNumberException(squareNum);
		}
		if (playerNum != 1 && playerNum != 2) {
			throw new InvalidPlayerException(playerNum);
		}
		
		int row = (squareNum - 1)/3;
		int column = (squareNum - 1) % 3;
		if (squares[row][column] != 0) {
			throw new SquareAlreadyTakenException(squareNum);
		}
		squares[row][column] = playerNum;
	}
	
	public boolean checkForLine() {
		int playerMarker;
		int row;
		int column;
		
		checkRows:
			for (row = 0; row < squares.length; row++) {
				playerMarker = squares[row][0];
				if (playerMarker == 0) continue;
				for (column = 1; column < squares.length; column++) {
					if (squares[row][column] != playerMarker) continue checkRows;
				}
				return true;
			}
		
		checkColumns:
			for (column = 0; column< squares.length; column++) {
				playerMarker = squares[0][column];
				if (playerMarker == 0) continue;
				for (row = 1; row < squares.length; row++) {
					if (squares[row][column] != playerMarker) continue checkColumns;
				}
				return true;
			}
		
		row = 0;
		column = 0;
		playerMarker = squares[row][column];
		checkLeftDiagonal:
			if (playerMarker != 0) {
				while (row < squares.length) {
					if (squares[row][column] != playerMarker) break checkLeftDiagonal;
					row++;
					column++;
				}
				return true;
			}
		
		row = 0;
		column = squares.length - 1;
		playerMarker = squares[row][column];
		checkRightDiagonal:
			if (playerMarker != 0) {
				while (row < squares.length) {
					if (squares[row][column] != playerMarker) break checkRightDiagonal;
					row++;
					column--;
				}
				return true;
			}
		
		return false;
	}
	
	public void printBoard() {
		StringBuilder s = new StringBuilder();
		s.append("\n");
		for (int row = 0; row < squares.length; row++) {
			for (int column = 0; column < squares.length; column++) {
				switch (squares[row][column]) {
					case 0:	s.append(" " + (3*row + (column + 1)) + " ");
							break;
					case 1: s.append(" o ");
							break;
					case 2: s.append(" x ");
							break;
				}
				if (column < squares.length - 1) {
					s.append("|");
				}
			}
			s.append("\n");
			if (row < squares.length - 1) {
				s.append("---+---+---\n");
			}
		}
		s.append("\n");
		System.out.println(s.toString());
	}

}
