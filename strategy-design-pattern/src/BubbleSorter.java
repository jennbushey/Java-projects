import java.util.ArrayList;
/*
 * File Name: BubbleSorter.java
 * Assignment: ENSF 614 Lab 6 - Exercise B and C
 * Completed by: Jenn Bushey
 * Submission Date: November 10, 2023
 */

public class BubbleSorter<E extends Number & Comparable<E>> implements Sorter<E> {
	@Override
	public void sort(ArrayList<Item<E>> array) {
		for (int i = array.size() - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
				if (array.get(j).getItem().compareTo(array.get(j + 1).getItem()) > 0) {
					Item<E> temp = array.get(j);
					array.set(j, array.get(j + 1));
					array.set(j + 1, temp);
				}
			}
		}
	}
}
