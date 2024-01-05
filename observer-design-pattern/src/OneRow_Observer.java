import java.util.ArrayList;
/*
 * File Name: OneRow_Observer.java
 * Assignment: ENSF 614 Lab 6 - Exercise D
 * Completed by: Jenn Bushey
 * Submission Date: November 10, 2023
 */
public class OneRow_Observer implements Observer {
	ArrayList<Double> d;
	Subject data;

	public OneRow_Observer(Subject d) {
		data = d;
		data.register(this);
	}

	@Override
	public void update(ArrayList<Double> observer) {
		this.d = observer;
		display();
	}

	/**
	 * Displays data values stored in data on the screen in one row.
	 */
	public void display() {
		System.out.println("\nNotification to One-Row Observer: Data Changed:");
		for (int j = 0; j < d.size(); j++)
			System.out.print(d.get(j) + " ");
		System.out.println();
	}
}
