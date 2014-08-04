package game;

import java.util.Scanner;

public class Player {
	
	private int marker;
	private Scanner input = new Scanner(System.in);
	
	public Player(int marker) {
		this.marker = marker;
	}
	
	public void makeMove(Board board) {
		boolean successfulMove = false;
		while (!successfulMove) {
			int squareNum = input.nextInt();
			try {
				board.setSquare(squareNum, marker);
				successfulMove = true;
			} catch (InvalidMoveException e) {
				System.out.println(e.getMessage());
				System.out.println("Please try another move:");
			}
		}
	}
}
