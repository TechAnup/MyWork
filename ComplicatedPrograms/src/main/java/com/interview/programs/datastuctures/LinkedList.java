package com.interview.programs.datastuctures;

public class LinkedList {

	private Node head;

	public LinkedList(int data) {
		this.head.data = head.data;
	}

	class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public void push(int element) {
		Node newNode = new Node(element);
		newNode.next = this.head;
		head = newNode;
	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList(7);

		System.out.println(list.head.data);

	}

}
