 /*
 * Course: ENSF 607 – Fall 2023 
 * Lab #: Lab 2
 * Instructor: Tim Reimer 
 * Student Name: Jenn Bushey, Mehreen Akmal
 * Submission Date: October 6, 2023
 */ 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player{

	public HumanPlayer(String name, char mark) {
		super(name, mark);
	}

	@Override
	protected void play() {
		super.play();
	}

	/**
	 * Asks the player to make a move by entering the row and column numbers, and
	 * puts a ‘X’ or ‘O’ mark on the board, by calling method addMark in class
	 * Board.
	 */
	@Override
	protected void makeMove() {
		int row, col;
		BufferedReader stdin;
		stdin = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("\n" + name + ", what row should our next " + mark + " be placed in? ");
		while (true) {
			try {
				row = Integer.parseInt(stdin.readLine().trim());
				while (row > 2 || row < 0) {
					System.out.print("Please try again: ");
					row = Integer.parseInt(stdin.readLine().trim());
				}
				break;
			} catch (IOException e) {
				System.out.print("Please try again: ");
			} catch (NumberFormatException e) {
				System.out.print("Please try again: ");
			}
		}
		System.out.print("\n" + name + ", what column should our next " + mark + " be placed in? ");
		while (true) {
			try {
				col = Integer.parseInt(stdin.readLine().trim());
				while (col > 2 || col < 0) {
					System.out.print("Please try again: ");
					col = Integer.parseInt(stdin.readLine().trim());
				}
				break;
			} catch (IOException e) {
				System.out.print("Please try again: ");
			} catch (NumberFormatException e) {
				System.out.print("Please try again: ");
			}
		}
		board.addMark(row, col, mark);
	}

}
