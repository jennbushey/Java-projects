/**
 * The referee sets the board as well as the 'X' and 'O' players and runs the
 * game play.
 * 
 * <pre>
 * Course: ENSF 607 – Fall 2023 
 * Lab #: Lab 1 
 * Instructor: Tim Reimer 
 * Student Name: Jenn Bushey
 * Submission Date: September 29, 2023
 * </pre>
 */
public class Referee {

	/**
	 * The player playing with the 'X' mark.
	 */
	private Player xPlayer;

	/**
	 * The player playing with the 'O' mark.
	 */
	private Player oPlayer;

	/**
	 * The game board.
	 */
	private Board board;

	/**
	 * Calls the setOpponent method of class Player to set the opponents of the X-
	 * and O- players. Then, initiates the game by displaying the board, and calling
	 * the play method for the X-Player who is always the first player.
	 */
	public void runTheGame() {
		System.out.println("\nReferee started the game...\n");
		// set opponents
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		// initiates game
		setBoard(board);
		// display board
		board.display();
		// call play method for x-player
		xPlayer.play();
	}

	/**
	 * Sets the board to the specified game board.
	 * 
	 * @param board the current game board.
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * Sets the 'O' player to the specified player.
	 * 
	 * @param oPlayer is the player selected to have the 'O' mark
	 */
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}

	/**
	 * Sets the 'X' player to the specified player.
	 * 
	 * @param xPlayer is the player selected to have the 'X' mark
	 */
	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
	}

}
