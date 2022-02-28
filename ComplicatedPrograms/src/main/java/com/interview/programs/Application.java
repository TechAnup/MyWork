package com.interview.programs;

import com.interview.programs.datastuctures.Stack;

public class Application {

	public static void main(String[] args) {

		Stack<String> strings = new Stack<String>("Anup");
		System.out.println(strings);
		System.out.println(strings.peek());
		strings.push("Adi");

		System.out.println(strings);

		System.out.println(strings.pop());

		System.out.println(strings);
	}
}
