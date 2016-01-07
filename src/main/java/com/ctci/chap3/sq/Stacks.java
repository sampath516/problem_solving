package com.ctci.chap3.sq;

public class Stacks {

	public enum StackNo {
		One, Two, Three
	};

	private static final int STACK_LENGTH = 10;
	private int[] elements = new int[STACK_LENGTH];
	private int size = 0;
	private int st1 = STACK_LENGTH;
	private int st2 = -1;
	private int st3 = st2;

	public boolean isEmpty(StackNo stackNo) {
		boolean result = false;
		switch (stackNo) {
		case One:
			result = st1 == STACK_LENGTH;
			break;
		case Two:
			result = st2 == -1;
			break;
		case Three:
			result = st2 == st3;
			break;
		default:
			throw new RuntimeException("Illegal Stack number");

		}
		return result;
	}

	public int getSize(StackNo stackNo) {
		int result = 0;
		switch (stackNo) {
		case One:
			result = STACK_LENGTH - st1;
			break;
		case Two:
			result = st2 + 1;
			break;
		case Three:
			result = st3 - st2;
			break;
		default:
			throw new RuntimeException("Illegal Stack number");
		}
		return result;
	}

	public void push(StackNo stackNo, int element) {
		if (size >= STACK_LENGTH) {
			throw new RuntimeException("Stack is full");
		}
		switch (stackNo) {
		case One:
			elements[--st1] = element;
			break;
		case Two:
			if (st3 > st2) {
				moveStack3Forward();
			} else {
				st3++;
			}
			elements[++st2] = element;
			break;
		case Three:
			elements[++st3] = element;
			break;
		default:
			throw new RuntimeException("Illegal Stack number");
		}
		size++;
	}

	public int pop(StackNo stackNo) {
		if (isEmpty(stackNo)) {
			throw new RuntimeException("Stack is empty");
		}
		int result = 0;
		switch (stackNo) {
		case One:
			result = elements[st1++];
			break;
		case Two:
			result = elements[st2];
			if (st3 > st2) {
				moveStack3Backward();
			} 
			st3--;
			st2--;
			break;
		case Three:
			result = elements[st3--];
			break;
		default:
			throw new RuntimeException("Illegal Stack number");
		}
		size--;
		return result;
	}

	private void moveStack3Backward() {
		for (int i = st2; i < st3; i++) {
			elements[i] = elements[i + 1];
		}
	}

	private void moveStack3Forward() {
		for (int i = st3 + 1; i > st2; i--) {
			elements[i] = elements[i + 1];
		}

	}

}
