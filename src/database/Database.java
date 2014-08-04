package database;

import game.Game;

public interface Database {
	
	public Game[] getGames(String username);
	public Game selectGame(int gameID);
	public void saveGame(Game game);

}
