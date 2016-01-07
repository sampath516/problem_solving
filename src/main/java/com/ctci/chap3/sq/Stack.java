package com.ctci.chap3.sq;

public class Stack {

	private int[] elements = new int[100];
	private int size = 0;
	private int top = -1;

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void push(int element) {
		if (getSize() >= 100) {
			throw new RuntimeException("Stack is full");
		}
		elements[++top] = element;
		size++;
	}

	public int pop() {
		if (getSize() <= 0) {
			throw new RuntimeException("Stack is empty");
		}
		int temp = elements[top--];
		size--;
		return temp;
	}

}
