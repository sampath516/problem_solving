package com.ctci.chap4.trees;

import java.util.List;
import java.util.Set;

public interface BinaryTree<E extends Comparable<E>> extends Tree<E> {
	Position<E> left(Position<E> position) throws IllegalArgumentException;

	Position<E> right(Position<E> position) throws IllegalArgumentException;

	Position<E> sibling(Position<E> position) throws IllegalArgumentException;

	List<Position<E>> inOrder();

	List<Position<E>> preOrder();

	List<Position<E>> postOrder();

	boolean isBalanced();

	boolean isBinarySearchTree();

	boolean isBinarySearchTree_v1();

	List<List<Position<E>>> elementsByDepth();
	
	boolean subTree(BinaryTree<E> subTree);
	
	int size();
	
	Set<List<Position<E>>> pathsWithSum(int sum);

}
