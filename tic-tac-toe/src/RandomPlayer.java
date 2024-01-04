 /*
 * Course: ENSF 607 – Fall 2023 
 * Lab #: Lab 2
 * Instructor: Tim Reimer 
 * Student Name: Jenn Bushey, Mehreen Akmal
 * Submission Date: October 6, 2023
 */ 
public class RandomPlayer extends Player implements Constants {

	public RandomPlayer(String name, char mark) {
		super(name, mark);
	}

	@Override
	protected void play() {
		super.play();
	}

	@Override
	protected void makeMove() {
		int lo = 0;
		int hi = 2;
		int row, col;

		RandomGenerator random = new RandomGenerator();

		do {
			row = random.discrete(lo, hi);
			col = random.discrete(lo, hi);
		} while (board.getMark(row, col) != SPACE_CHAR);

		System.out.println();

		board.addMark(row, col, mark);
	}
}