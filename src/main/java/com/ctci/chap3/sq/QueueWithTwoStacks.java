package com.ctci.chap3.sq;

public class QueueWithTwoStacks {

	private Stack stack1 = new Stack();
	private Stack stack2 = new Stack();

	public void add(int value) {
		stack1.push(value);
	}

	public int delete() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	public int size() {
		return stack1.getSize() + stack2.getSize();
	}
}
