import java.util.ArrayList;
/*
 * File Name: FiveRowsTable_Observer.java
 * Assignment: ENSF 614 Lab 6 - Exercise D
 * Completed by: Jenn Bushey
 * Submission Date: November 10, 2023
 */
public class FiveRowsTable_Observer implements Observer {
	ArrayList<Double> d;
	Subject data;

	public FiveRowsTable_Observer(Subject d) {
		data = d;
		data.register(this);
	}

	@Override
	public void update(ArrayList<Double> observer) {
		this.d = observer;
		display();
	}

	/**
	 * Displays data values stored in data on the screen in five rows.
	 */
	public void display() {
		System.out.println("\nNotification to Five-Rows Table Observer: Data Changed:");
		for (int i = 0; i < 5; i++) {
			for (int j = i; j < d.size(); j += 5)
				System.out.print(d.get(j) + "\t");
			System.out.println();
		}
	}
}
