import java.util.ArrayList;
/*
 * File Name: ThreeColumnTable_Observer.java
 * Assignment: ENSF 614 Lab 6 - Exercise D
 * Completed by: Jenn Bushey
 * Submission Date: November 10, 2023
 */
public class ThreeColumnTable_Observer implements Observer {
	ArrayList<Double> d;
	Subject data;

	public ThreeColumnTable_Observer(Subject d) {
		data = d;
		data.register(this);
	}

	@Override
	public void update(ArrayList<Double> observer) {
		this.d = observer;
		display();
	}

	/**
	 * Displays data values stored in data on the screen in three columns.
	 */
	public void display() {
		System.out.println("\nNotification to Three-Column Table Observer: Data Changed:");
		for (int i = 0; i < d.size(); i += 3) {
			for (int j = i; j < i + 3 && j < d.size(); j++)
				System.out.print(d.get(j) + "\t");
			System.out.println();
		}
	}
}
