
//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 

/**
 * Tic-Tac-Toe game play logic. *
 * 
 * <pre>
 * Course: ENSF 607 – Fall 2023 
 * Lab #: Lab 1 
 * Instructor: Tim Reimer 
 * Student Name: Jenn Bushey
 * Submission Date: September 29, 2023
 * </pre>
 */
public class Board implements Constants {
	/**
	 * A 2D matrix representing the game board.
	 */
	private char theBoard[][];

	/**
	 * A counter to keep track of the number of filled spaces on the game board.
	 */
	private int markCount;

	/**
	 * Constructs a Board object with a 3 x 3 matrix filled with ' ' and sets the
	 * counter markCount to zero.
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/**
	 * Gets the current mark stored in a specified row and column of the board
	 * matrix.
	 * 
	 * @param row is the specified row index.
	 * @param col is the specified column index.
	 * @return the mark found at the row, column location in the board.
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * Compares the maximum markCount (9) to the current markCount.
	 * 
	 * @return true if the board is full. Otherwise returns false.
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * Compares the result of checkWinner for the mark 'X' to 1. xPlayer has won the
	 * game if the result is 1.
	 * 
	 * @return true if the result is 1. Otherwise returns false.
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Compares the result of checkWinner for the mark 'O' to 1. oPlayer has won the
	 * game if the result is 1.
	 * 
	 * @return true if the result is 1. Otherwise returns false.
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Displays the text-based game board in the console.
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * Adds the specified mark to the game board at the specified column and row
	 * indices on the game board.
	 * 
	 * @param row  is the row index on the game board.
	 * @param col  is the column index on the game board.
	 * @param mark is the playing player's mark.
	 */
	public void addMark(int row, int col, char mark) {

		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 * Clears the game board by setting all values in the game board matrix to ' '.
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * Checks to see if the specified mark has won the game by getting 3 marks
	 * aligned.
	 * 
	 * @param mark is the mark the specified player mark.
	 * @return 0 if the player has won, otherwise returns 1.
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * Displays text-based headers for the game board.
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * Displays the horizontal lines for the text-based game board.
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * Displays the vertical lines for the text-based game board.
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
