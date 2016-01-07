package com.ctci.chap4.trees;

import java.util.Iterator;

public interface Tree<E extends Comparable<E>> extends Iterable<E> {

	Position<E> root();

	Position<E> parent(Position<E> position) throws IllegalArgumentException;

	Iterable<Position<E>> children(Position<E> position) throws IllegalArgumentException;

	boolean isExternal(Position<E> position) throws IllegalArgumentException;

	boolean isInernal(Position<E> position) throws IllegalArgumentException;

	boolean isRoot(Position<E> position) throws IllegalArgumentException;

	boolean isEmpty();

	@Override
	public Iterator<E> iterator();

	Iterable<Position<E>> poistions();

	int numChildren(Position<E> position) throws IllegalArgumentException;

	int depth(Position<E> position);

	int height(Position<E> position);
	
	int height();

	Position<E> addRoot(E element) throws IllegalStateException;

	Position<E> addLeft(Position<E> position, E element) throws IllegalArgumentException;

	Position<E> addRight(Position<E> position, E element) throws IllegalArgumentException;

	void attach(Position<E> position, Tree<E> left, Tree<E> right) throws IllegalArgumentException;

	E set(Position<E> position, E newValue) throws IllegalArgumentException;

	E remove(Position<E> position) throws IllegalArgumentException;
	
}
