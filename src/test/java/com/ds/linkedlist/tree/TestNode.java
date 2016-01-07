package com.ds.linkedlist.tree;

public class TestNode<E> {

	private E value;
	private int numChildren = 0;

	public TestNode(E value, int numChildren) {
		this.value = value;
		this.numChildren = numChildren;
	}

	public E getElement() {
		return value;
	}

	public int numChildren() {
		return numChildren;
	}

}
