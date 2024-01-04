import java.util.ArrayList;
/*
 * File Name: MyVector.java
 * Assignment: ENSF 614 Lab 6 - Exercise B and C
 * Completed by: Jenn Bushey
 * Submission Date: November 10, 2023
 */

public class MyVector<E extends Number & Comparable<E>> {
	private ArrayList<Item<E>> storageM;
	private Sorter<E> sorter;

	/**
	 * A constructor that receives only an integer argument, n, to allocate memory
	 * for an array with n elements.
	 * 
	 * @param n number of elements in an array
	 */
	public MyVector(int n) {
		this.storageM = new ArrayList<>(n);
	}

	/**
	 * A constructor that receives only an ArrayList object, arr, and makes storageM
	 * an exact copy of arr.
	 * 
	 * @param arr array list object to copy
	 */
	public MyVector(ArrayList<Item<E>> arr) {
		this.storageM = new ArrayList<>(arr.size());
		for (Item<E> item : arr) {
			storageM.add(item);
		}
	}

	/**
	 * Allows to add a new Item value to storageM.
	 * 
	 * @param value is a new Item value
	 */
	public void add(Item<E> value) {
		storageM.add(value);
	}

	/**
	 * Allows its private data member register with a an object that implements
	 * Sorter.
	 * 
	 * @param s sorter object to define sorter type
	 */
	public void setSortStrategy(Sorter<E> s) {
		sorter = s;
	}

	/**
	 * Allows sort method of any sorter object to be called.
	 */
	public void performSort() {
		sorter.sort(storageM);
	}

	/**
	 * Displays data values stored in storage on the screen in one line.
	 */
	public void display() {
		for (Item<E> item : storageM) {
			System.out.print(item.getItem() + " ");
		}
		System.out.println();
	}

}
