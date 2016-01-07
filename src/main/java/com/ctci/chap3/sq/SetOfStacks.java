package com.ctci.chap3.sq;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks {

	private static final int INDIVIDUAL_STACK_LENGTH = 3;
	private int stackCounter = 0;
	private int top = -1;
	List<int[]> stacks = new ArrayList<int[]>();
	private int size = 0;

	public boolean isEmpty() {
		return size == 0;
	}

	public void push(int value) {
		top = (top == (INDIVIDUAL_STACK_LENGTH - 1)) ? 0 : top + 1;
		stackCounter = (top == 0) ? stackCounter + 1 : stackCounter;
		int[] stack = null;
		if (stacks.size() < stackCounter) {
			stack = new int[INDIVIDUAL_STACK_LENGTH];
			stacks.add(stack);
		} else {
			stack = stacks.get(stackCounter - 1);
		}
		stack[top] = value;
		size++;
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		int value = stacks.get(stackCounter - 1)[top];
		if (top == 0) {
			stacks.remove(stackCounter - 1);
			stackCounter--;
			if (stackCounter == 0) {
				top = -1;
			} else {
				top = INDIVIDUAL_STACK_LENGTH - 1;
			}
		} else {
			top--;
		}
		size--;
		return value;

	}

	public int size() {
		return size;
	}

	public int stacksSize() {
		return stackCounter;
	}

}
