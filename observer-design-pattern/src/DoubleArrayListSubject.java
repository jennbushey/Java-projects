import java.util.ArrayList;
/*
 * File Name: DoubleArrayListSubject.java
 * Assignment: ENSF 614 Lab 6 - Exercise D
 * Completed by: Jenn Bushey
 * Submission Date: November 10, 2023
 */

public class DoubleArrayListSubject implements Subject {
	public ArrayList<Double> data;
	private ArrayList<Observer> observers;

	/**
	 * A default constructor that initializes its data members as needed. For
	 * example should create an empty list for its member called data.
	 * 
	 */
	public DoubleArrayListSubject() {
		this.data = new ArrayList<>(0);
		this.observers = new ArrayList<Observer>();
	}

	/**
	 * Method addData that allows a new Double data to be added to the list
	 */
	public void addData(Double item) {
		data.add(item);
		notifyObserver();
	}

	/**
	 * Method setData that allows changing the data at any element in the list
	 */
	public void setData(Double value, int index) {
		data.set(index, value);
		notifyObserver();
	}

	/**
	 * Method populate that populates the list with the data supplied by its
	 * argument of the function, which is an array of double.
	 */
	public void populate(double arr[]) {
		for (double a : arr) {
			data.add(a);
		}
	}

	/**
	 * Displays data values stored in data on the screen in one line.
	 */
	public void display() {
		for (Double item : data) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

	@Override
	public void register(Observer o) {
		observers.add(o);
		o.update(data);

	}

	@Override
	public void remove(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObserver() {
		for (int i = 0; i < observers.size(); i++) {
			Observer o = observers.get(i);
			o.update(data);
		}
	}

}
