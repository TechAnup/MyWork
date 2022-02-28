package com.interview.programs.datastuctures;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T> {

	private LinkedList<T> list = new LinkedList<>();

	public Stack() {
		// Create an empty stack
	}

	public Stack(T firstElement) {
		push(firstElement);
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void push(T firstElement) {
		list.addLast(firstElement);
	}

	/**
	 * Pop an element off the stack
	 * 
	 * @throws EmptyStackException
	 */
	public T pop() {
		if (isEmpty())
			throw new EmptyStackException();

		return list.removeLast();
	}

	/**
	 * Peek the top of the stack without removing an element
	 * 
	 * @throws EmptyStackException
	 */
	public T peek() {
		return list.peekLast();
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	@Override
	public String toString() {
		return "Stack [list=" + list + "]";
	}

}
