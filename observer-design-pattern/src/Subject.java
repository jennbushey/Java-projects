/*
 * File Name: Subject.java
 * Assignment: ENSF 614 Lab 6 - Exercise D
 * Completed by: Jenn Bushey
 * Submission Date: November 10, 2023
 */

public interface Subject {
	public void register(Observer o);
	public void remove(Observer o);
	public void notifyObserver();
}
