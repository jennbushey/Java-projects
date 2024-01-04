import java.util.ArrayList;
/*
 * File Name: Sorter.java
 * Assignment: ENSF 614 Lab 6 - Exercise B
 * Completed by: Jenn Bushey
 * Submission Date: November 10, 2023
 */

public interface Sorter<E extends Number & Comparable<E>> {

	void sort(ArrayList<Item<E>> storageM);
}