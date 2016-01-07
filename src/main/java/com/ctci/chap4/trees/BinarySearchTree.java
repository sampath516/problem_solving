package com.ctci.chap4.trees;

public interface BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	public Position<E> addElement(E element);

	public Position<E> next(Position<E> position);

}
