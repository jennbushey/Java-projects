import java.util.ArrayList;
/*
 * File Name: InsertionSorter.java
 * Assignment: ENSF 614 Lab 6 - Exercise B and C
 * Completed by: Jenn Bushey
 * Submission Date: November 10, 2023
 */
public class InsertionSorter<E extends Number & Comparable<E>> implements Sorter<E> {
	@Override
	public void sort(ArrayList<Item<E>> array) {
		for (int i = 1; i < array.size(); i++) {
			Item<E> temp = array.get(i);
			int j = i - 1;
			while (j > -1 && temp.getItem().compareTo(array.get(j).getItem()) < 0) {
				array.set(j + 1, array.get(j));
				array.set(j, temp);
				j--;
			}
		}
	}
}
