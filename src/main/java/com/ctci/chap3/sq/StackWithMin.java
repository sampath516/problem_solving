package com.ctci.chap3.sq;

public class StackWithMin {

	private static final int STACK_SIZE = 10;
	private Element[] elements = new Element[STACK_SIZE];
	private int size = 0;
	private int top = -1;

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == STACK_SIZE;
	}

	public int size() {
		return size;
	}

	public void push(int value) {
		if (isFull()) {
			throw new RuntimeException("Stack is Full");
		}
		Element element = new Element(value);
		if (size > 0 && elements[top].min < value) {
			element.min = elements[top].min;
		}
		elements[++top] = element;
		size++;
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		size--;
		return elements[top--].value;
	}

	public int min() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		return elements[top].min;
	}

	private static class Element {
		int value;
		int min;

		public Element(int value) {
			this.value = value;
			this.min = value;
		}
	}

}
