/**
 * The starting point of the text based Tic-Tac-Toe game.
 * 
 * Course: ENSF 607 – Fall 2023 
 * Lab #: Lab 2
 * Instructor: Tim Reimer 
 * Student Name: Jenn Bushey, Mehreen Akmal
 * Submission Date: October 6, 2023 
 */
abstract class Player {
	/**
	 * The first name of a Player.
	 */
	protected String name;

	/**
	 * The Tic-Tac-Toe game board.
	 */
	protected Board board;

	/**
	 * The game opponent for a player.
	 */
	protected Player opponent;

	/**
	 * The mark a player can be 'X' or 'O'.
	 */
	protected char mark;

	/**
	 * Constructs a Player object containing the name of the player and the 'X' or
	 * 'O' character assigned to them.
	 * 
	 * @param name is the players name
	 * @param mark is the mark assigned to the player 'X' or 'O'
	 */
	public Player(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}

	/**
	 * Calls method makeMove(), as long as methods xWin() and oWin(), and isFull()
	 * return false (If any of these conditions change (turns true), it announces
	 * that the game is over and either displays the name of the winner of the game
	 * or indicates that the game ended in a ‘tie’). Then, displays the board after
	 * each move, checks for the winner and then passes the turn to the other
	 * player.
	 */
	protected void play() {
		while (!board.xWins() && !board.oWins() && !board.isFull()) {
			makeMove();
			board.display();
			if (board.xWins() || board.oWins()) {
				System.out.println("\nTHE GAME IS OVER: " + name + " is the winner!");
				System.out.println("Game Ended...");
				break;
			} else if (board.isFull()) {
				System.out.println("THE GAME IS OVER: TIE");
				System.out.println("Game Ended...");
				break;
			}
			opponent.play();
		}
	}

	/**
	 * Asks the player to make a move by entering the row and column numbers, and
	 * puts a ‘X’ or ‘O’ mark on the board, by calling method addMark in class
	 * Board.
	 */
	protected void makeMove() {}


	/**
	 * Connects the opponent to the specified player.
	 * 
	 * @param player is the player. e.g. xPlayer's opponent is oPlayer
	 */
	protected void setOpponent(Player player) {
		this.opponent = player;
	}

	/**
	 * Sets the value of theBoard to the specified value.
	 * 
	 * @param theBoard is the game board.
	 */
	protected void setBoard(Board theBoard) {
		this.board = theBoard;
	}

}
