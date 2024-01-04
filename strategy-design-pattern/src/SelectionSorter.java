import java.util.ArrayList;
/*
 * File Name: Sorter.java
 * Assignment: ENSF 614 Lab 6 - Exercise C
 * Completed by: Jenn Bushey
 * Submission Date: November 10, 2023
 */
public class SelectionSorter<E extends Number & Comparable<E>> implements Sorter<E> {

	@Override
	public void sort(ArrayList<Item<E>> array) {
		for (int i = 0; i < array.size(); i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.size(); j++) {
				if (array.get(j).getItem().compareTo(array.get(minIndex).getItem())<0) {
					minIndex = j;
				}
			}
			if (i != minIndex) {				
				Item<E> temp = array.get(i);
				array.set(i, array.get(minIndex));
				array.set(minIndex, temp);
			}
		}
	}
}