package com.ctci.chap4.trees;

public class Result<P extends Position<?>> {

	private boolean binarySearchTree = false;
	private Position<?> previous;

	public Result(boolean empty, Position<?> previous) {
		this.binarySearchTree = empty;
		this.previous = previous;
	}



	public boolean isBinarySearchTree() {
		return binarySearchTree;
	}



	public void setBinarySearchTree(boolean binarySearchTree) {
		this.binarySearchTree = binarySearchTree;
	}



	public Position<?> getPrevious() {
		return previous;
	}

	public void setPrevious(Position<?> previous) {
		this.previous = previous;
	}

}
