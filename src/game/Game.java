package game;


public class Game {
	
	private Board board;
	private Player player1;
	private Player player2;
	private int turnNumber = 0;
	
	public Game() {
		board = new Board();
		player1 = new Player(1);
		player2 = new Player(2);
	}
	
	public void gameLoop() {
		boolean gameOver = false;
		int playerToMove;
		board.printBoard();
		while (!gameOver) {
			playerToMove = (turnNumber++ % 2) + 1;
			System.out.println("Player " + playerToMove + ", it's your turn! Choose a square to make your move:");
			
			if (playerToMove == 1) {
				player1.makeMove(board);
			} else {
				player2.makeMove(board);
			}
			
			board.printBoard();
			if (thereIsAWinner()) {
				System.out.println("Congratulations player " + playerToMove + ", you won!");
				gameOver = true;
			} else if (turnNumber > 8) {
				System.out.println("No more moves available, it's a draw!");
				gameOver = true;
			}
		}
	}
	
	private boolean thereIsAWinner() {
		return board.checkForLine();
	}

}
