 /*
 * Course: ENSF 607 – Fall 2023 
 * Lab #: Lab 2
 * Instructor: Tim Reimer 
 * Student Name: Jenn Bushey, Mehreen Akmal
 * Submission Date: October 6, 2023
 */ 
public class BlockingPlayer extends RandomPlayer {

	public BlockingPlayer(String name, char mark) {
		super(name, mark);
	}

	@Override
	protected void makeMove() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				// test if blocking
				if (board.getMark(row, col) == SPACE_CHAR) {
					if (testForBlocking(row, col)) {
						System.out.println();
						board.addMark(row, col, mark);
						return;
					}
				}
			}
		}
		// no blocking needed, call RandomPlayer make move.
		super.makeMove();
	}

	protected boolean testForBlocking(int row, int col) {
		// return true if there is a situation that needs to be blocked.
		int result = 0;
		// check horizontal
		if (result == 0) {
			for (int i = 0; i < 3; i++) {
				if (board.getMark(row, i) != mark && board.getMark(row, i) != SPACE_CHAR) {
					result++;
				}
			}
			if (result == 2) {
				return true;
			}
			result = 0;
		}

		// check vertical 
		if (result == 0) {
			for (int i = 0; i < 3; i++) {
				if (board.getMark(i, col) != mark && board.getMark(i, col) != SPACE_CHAR) {
					result++;
				}
			}
			if (result == 2) {
				return true;
			}
			result = 0; 
		}

		// check RHF 
		if (result == 0 && row == col) {
			for (int i = 0; i < 3; i++) {
				if (board.getMark(i, i) != mark && board.getMark(i, i) != SPACE_CHAR) {
					result++;
				}
			}
			if (result == 2) {
				return true;
			}
			result = 0;
		}

		// check LHF
		if (result == 0 && col == (3 - 1 - row)) {
			for (int i = 0; i < 3; i++) {
				if (board.getMark(i, 3 - 1 - i) != mark && board.getMark(i, 3 - 1 - i) != SPACE_CHAR) {
					result++;
				}
			}
			if (result == 2) {
				return true;
			}
		}
		return false;
	}

}
